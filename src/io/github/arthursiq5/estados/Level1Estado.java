/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.estados;

import io.github.arthursiq5.utils.Constantes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author arthur
 */
public class Level1Estado implements Estado {
    private Rectangle bola = new Rectangle(Constantes.LARGURA_DA_TELA.getCentro() - 5, Constantes.ALTURA_DA_TELA.getCentro() - 5, 10, 10);

    @Override
    public void init(AdministradorDeEstados administradorDeEstados) {
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics grafico) {
        grafico.setColor(Color.BLACK);
        grafico.fillRect(0, 0, Constantes.LARGURA_DA_TELA.getValor(), Constantes.ALTURA_DA_TELA.getValor());
        
        grafico.setColor(Color.WHITE);
        grafico.fillRect(this.bola.x, this.bola.y, this.bola.width, this.bola.height);
    }

    @Override
    public void KeyPressed(int codigo) {
        
    }

    @Override
    public void KeyReleased(int codigo) {
        
    }
    
}
