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
    
    /**
     * 
     * @param titulo 
     */
    public Display(String titulo){
        this.frame = new JFrame(titulo);
        this.frame.setLocationRelativeTo(null); // a posição da janela não é atrelada a nenhum objeto da tela
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // se clicar em "exit", fecha a aplicação inteira
        this.frame.setVisible(true);
    }
}
