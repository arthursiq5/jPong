/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class Display {
    private JFrame frame;
    private Canvas canvas; // responsável por renderizar a tela do jogo
    
    /**
     * 
     * @param titulo 
     * @param largura 
     * @param altura 
     */
    public Display(String titulo, int largura, int altura){
        // inicializando objetos
        this.canvas = new Canvas();
        this.frame = new JFrame(titulo);
        
        // define o tamanho da tela do jogo
        this.canvas.setPreferredSize(new Dimension(largura, altura));
        this.canvas.setMaximumSize(new Dimension(largura, altura));
        this.canvas.setMinimumSize(new Dimension(largura, altura));
        
        this.frame.add(this.canvas); // passando canvas pro objeto
        this.frame.pack(); // puxa os dados de tamanho do componente interno
        
        this.frame.setLocationRelativeTo(null); // a posição da janela não é atrelada a nenhum objeto da tela
        this.frame.setResizable(Boolean.FALSE); // não pode ser redimensionada pelo usuário
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // se clicar em "exit", fecha a aplicação inteira
        this.frame.setVisible(Boolean.TRUE); // visível ao usuário
    }
    
    /**
     * @return BufferStrategy
     */
    public BufferStrategy getBufferStrategy(){
        return this.canvas.getBufferStrategy();
    }
    
    /**
     * cria o CufferStrategy
     */
    public void createBufferStrategy(){
        this.canvas.createBufferStrategy(3);
    }
}
