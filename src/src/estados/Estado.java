/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.estados;

import java.awt.Graphics;

/**
 *
 * @author arthur
 */
public interface Estado {
    public void init();
    
    public void update();
    
    public void render(Graphics g);
}
