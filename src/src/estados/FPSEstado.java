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
public class FPSEstado implements Estado{

    private long now;
    private long lastTime = System.nanoTime();
    private double timer = 0;
    private int tick = 0;
    private int t = 0;
    
    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        now = System.nanoTime();
        this.timer += this.now - this.lastTime;
        this.lastTime = this.now;
        this.tick++;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(
            0, 
            0, 
            Constantes.LARGURA_DA_TELA.getValor(), 
            Constantes.ALTURA_DA_TELA.getValor()
        );
        if(this.timer >= 1000000000){
            this.t = this.tick;
            this.tick = 0;
            this.timer = 0;
        }
        g.setColor(Color.WHITE);
        Font fonte = new Font("Serif", Font.PLAIN, 12);
        g.setFont(fonte);
        
        String mensagem = "FPS: " + t;
        g.drawString(mensagem, 20, 20);
    }
    
}
