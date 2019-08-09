/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import src.utils.Constantes;

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
    
    @Override
    public void init() {
        this.fontePrincipal = new Font("Dialog", Font.PLAIN, 48);
        this.fonteOpcoes    = new Font("Dialog", Font.PLAIN, 24);
        this.nomeDoJogo = "PONG";
        this.opcaoSelecionada = 0;
    }

    @Override
    public void update() {
        
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
    }

    @Override
    public void KeyPressed(int codigo) {
        
    }

    @Override
    public void KeyReleased(int codigo) {
        
    }
    
}
