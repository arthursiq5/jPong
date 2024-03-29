/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.arthursiq5.estados;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author arthur
 */
public class AdministradorDeEstados implements KeyListener{
    private final int numeroDeEstados = 3;
    private Estado[] estados;
    private int estadoAtual = 0;
    
    /**
     * @param numeroDeEstados
     */
    public AdministradorDeEstados() {
        this.estados = new Estado[this.numeroDeEstados];
        this.estados[0] = new MenuEstado();
        this.estados[this.estadoAtual].init(this);
        this.estados[1] = new FPSEstado();
        this.estados[2] = new Level1Estado();
    }
    
    /**
     * set current state
     * @param estado application state
     */
    public void setState(int estado){
        this.estadoAtual = estado;
        this.estados[this.estadoAtual].init(this); // inicializando estado
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
    
    /**
     * returns current state of application
     * @return Estado
     */
    public Estado getEstado(){
        return this.estados[this.estadoAtual];
    }

    @Override
    public void keyTyped(KeyEvent evento) {
        // Não oferece suporte 
    }

    @Override
    public void keyPressed(KeyEvent evento) {
        this.estados[this.estadoAtual].KeyPressed(evento.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        this.estados[estadoAtual].KeyReleased(evento.getKeyCode());
    }
}
