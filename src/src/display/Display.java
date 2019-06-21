/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.display;

import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class Display {
    private JFrame frame;
    
    public Display(String titulo){
        this.frame = new JFrame(titulo);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
}
