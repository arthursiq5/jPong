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
    /**
     * inicia o jogo
     */
    public void init(AdministradorDeEstados administradorDeEstados);
    
    /**
     * atualiza o jogo
     */
    public void update();
    
    /**
     * renderiza a tela
     * @param grafico
     */
    public void render(Graphics grafico);
    
    /**
     * evento de tecla pressionada
     * @param codigo
     */
    public void KeyPressed(int codigo);
    
    /**
     * evento de soltar a tecla
     * @param codigo 
     */
    public void KeyReleased(int codigo);
}
