/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.arthursiq5.estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import io.github.arthursiq5.utils.Constantes;

/**
 *
 * @author arthur
 */
public class MenuEstado implements Estado {
    private Font fontePrincipal;
    private Font fonteOpcoes;
    private String nomeDoJogo;
    private String[] opcoes = {"START", "HELP", "EXIT"};
    private int opcaoSelecionada;
    private AdministradorDeEstados administradorDeEstados;
    private int x = 0;
    private int y = 0;
    private int movex = 1;
    private int movey = 1;
    
    @Override
    public void init(AdministradorDeEstados administradorDeEstados) {
        this.fontePrincipal = new Font("Dialog", Font.PLAIN, 48);
        this.fonteOpcoes    = new Font("Dialog", Font.PLAIN, 24);
        this.nomeDoJogo = "PONG";
        this.opcaoSelecionada = 0;
        this.administradorDeEstados = administradorDeEstados;
    }

    @Override
    public void update() {
        this.x += movex;
        this.y += movey;
    }

    @Override
    public void render(Graphics grafico) {
        int largura = Constantes.LARGURA_DA_TELA.getValor();
        int altura = Constantes.ALTURA_DA_TELA.getValor();
        grafico.setColor(Color.BLACK);
        grafico.fillRect(
                0, 
                0, 
                largura, 
                altura
        );
        grafico.setColor(Color.WHITE);
        grafico.setFont(this.fontePrincipal);
        grafico.drawString(
                this.nomeDoJogo, 
                (int) (largura/2.5), 
                (int) altura/3
        );
        
        grafico.setFont(this.fonteOpcoes);
        for (int i = 0; i < this.opcoes.length; i++) {
            grafico.setColor(Color.WHITE);
            if(i == this.opcaoSelecionada){
                grafico.setColor(Color.YELLOW);
            }
            grafico.drawString(
                this.opcoes[i], 
                (int) (largura/2) - grafico.getFontMetrics().stringWidth(this.opcoes[i]), 
                (int) (altura * (0.75)) + (grafico.getFontMetrics(this.fonteOpcoes).getHeight() * i)
            );
        }
        this.animacaoDeFundo(grafico);
    }
    
    private void animacaoDeFundo(Graphics grafico) {
        grafico.setColor(Color.WHITE);
        grafico.fillRect(this.x, this.y, 15, 15);
        
        this.limitesParaAnimacaoDeFundo();
    }
    
    private void limitesParaAnimacaoDeFundo() {
        if (this.x >= Constantes.LARGURA_DA_TELA.getValor() || this.x <= 0) {
            this.movex *= -1;
        }
        
        if (this.y >= Constantes.ALTURA_DA_TELA.getValor() || this.y <= 0) {
            this.movey *= -1;
        }
    }

    @Override
    public void KeyPressed(int codigo) {
        
    }

    @Override
    public void KeyReleased(int codigo) {
        if(codigo == KeyEvent.VK_W){
            this.cima();
        }
        
        if(codigo == KeyEvent.VK_S){
            this.baixo();
        }
        
        if(codigo == KeyEvent.VK_ENTER){
            this.seleciona();
        }
    }
    
    private void cima() {
        this.opcaoSelecionada--;
        if (this.opcaoSelecionada < 0) {
            this.opcaoSelecionada = this.opcoes.length -1;
        }
    }
    
    private void baixo() {
        this.opcaoSelecionada++;
        if (this.opcaoSelecionada > (this.opcoes.length -1)) {
            this.opcaoSelecionada = 0;
        }
    }

    private void seleciona() {
        switch(this.opcaoSelecionada){
            case 0:
                administradorDeEstados.setState(IndiceEstados.FPS.getCodigo());
                break;
            case 1:
                break;
            case 2:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "A opção selecionada não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
