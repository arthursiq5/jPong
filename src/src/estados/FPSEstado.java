/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.estados;

import java.awt.Color;
import java.awt.Graphics;
import src.utils.Constantes;

/**
 *
 * @author arthur
 */
public class FPSEstado implements Estado{

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        
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
    }
    
}
