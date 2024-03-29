/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.estados;

import io.github.arthursiq5.input.KeyManager;
import io.github.arthursiq5.utils.Constantes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author arthur
 */
public class Level1Estado implements Estado {
    private Rectangle bola = new Rectangle(Constantes.LARGURA_DA_TELA.getCentro() - 5, Constantes.ALTURA_DA_TELA.getCentro() - 5, 10, 10);
    private Rectangle p1 = new Rectangle(0, 0, 10, 50);
    private Rectangle p2 = new Rectangle(Constantes.LARGURA_DA_TELA.getValor() - 10, 0, 10, 50);
    private int movex = 1;
    private int movey = 1;

    @Override
    public void init(AdministradorDeEstados administradorDeEstados) {
        this.start();
    }
    
    public void start() {
        this.bola.x = Constantes.LARGURA_DA_TELA.getCentro() - 5;
        this.bola.y = Constantes.ALTURA_DA_TELA.getCentro() - 5;  
        
        Random r = new Random();
        this.movex = (r.nextInt(2) == 0) ? 1: -1;
    }

    @Override
    public void update() {
        this.moveBola();
        this.moveRaquetes();
    }
    
    public void moveRaquetes() {
        if (KeyManager.w) this.p1.y -= 8;
        if (KeyManager.s) this.p1.y += 8;
        if (KeyManager.up) this.p2.y -= 8;
        if (KeyManager.down) this.p2.y += 8;
        this.limitesPlayers();
    }

    @Override
    public void render(Graphics grafico) {
        grafico.setColor(Color.BLACK);
        grafico.fillRect(0, 0, Constantes.LARGURA_DA_TELA.getValor(), Constantes.ALTURA_DA_TELA.getValor());
        
        this.desenhaBola(grafico);
        grafico.fillRect(this.p1.x, this.p1.y, this.p1.width, this.p1.height);
        grafico.fillRect(this.p2.x, this.p2.y, this.p2.width, this.p2.height);
    }
    
    private void moveBola() {
        this.bola.x += this.movex;
        this.bola.y += this.movey;
        this.limitesBola();
    }
    
    private void desenhaBola(Graphics grafico) {
        grafico.setColor(Color.WHITE);
        grafico.fillRect(this.bola.x, this.bola.y, this.bola.width, this.bola.height);
    }
    
    private void limitesBola() {
        if (this.bola.x >= Constantes.LARGURA_DA_TELA.getValor() || this.bola.x <= 0) {
            this.start();
        }
        
        if ((this.bola.y + 15) >= Constantes.ALTURA_DA_TELA.getValor() || (this.bola.y - 5) <= 0) {
            this.movey *= -1;
        }
    }
    
    private void limitesPlayers() {
        if (this.p1.y < 0)
            this.p1.y = 0;
        if (this.p1.y > (Constantes.ALTURA_DA_TELA.getValor() - this.p1.height))
            this.p1.y = Constantes.ALTURA_DA_TELA.getValor() - this.p1.height;
        if (this.p2.y < 0)
            this.p2.y = 0;
        if (this.p2.y > (Constantes.ALTURA_DA_TELA.getValor() - this.p2.height))
            this.p2.y = Constantes.ALTURA_DA_TELA.getValor() - this.p2.height;
    }

    @Override
    public void KeyPressed(int codigo) {
        
    }

    @Override
    public void KeyReleased(int codigo) {
        
    }
    
}
