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
public class AdministradorDeEstados {
    private final int numeroDeEstados;
    private Estado[] estados;
    private int estadoAtual = 0;
    
    /**
     * @param numeroDeEstados
     */
    public AdministradorDeEstados(int numeroDeEstados) {
        this.numeroDeEstados = numeroDeEstados;
        this.estados = new Estado[this.numeroDeEstados];
    }
    
    /**
     * set current state
     * @param estado application state
     */
    public void setState(int estado){
        this.estadoAtual = estado;
        this.estados[this.estadoAtual].init(); // inicializando estado
    }
    
    /**
     * update current state
     */
    public void update(){
        this.estados[this.estadoAtual].update();
    }
    
    /**
     * render state
     * @param pintura draw in screen
     */
    public void render(Graphics pintura){
        this.estados[this.estadoAtual].render(pintura);
    }
}
