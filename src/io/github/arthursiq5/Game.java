/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.arthursiq5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.github.arthursiq5.display.Display;
import io.github.arthursiq5.estados.AdministradorDeEstados;
import io.github.arthursiq5.input.KeyManager;
import io.github.arthursiq5.utils.Constantes;

/**
 *
 * @author arthur
 */
public class Game implements Runnable{
    private Thread thread;
    private Display display;
    private boolean running;
    private AdministradorDeEstados administrador;
    private KeyManager keyManager;

    public Game() {
        this.running = false;
        this.administrador = new AdministradorDeEstados();
        this.keyManager = new KeyManager();
        this.display = new Display(
            "Pong", 
            Constantes.LARGURA_DA_TELA.getValor(), //largura
            Constantes.ALTURA_DA_TELA.getValor() // altura
        );
        this.display.setKeyListener(this.administrador);
        this.display.setKeyListener(this.keyManager);
    }

    @Override
    public void run() { // executada paralelamente ao código
        this.init(); // inicializa os estados do jogo
        
        // definido cálculo de tempo (60 vezes por segundo)
        double timePerTick = 1000000000 / Constantes.FPS_JOGO.getValor();
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(this.running){
            
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            
            // cada vez que passar 1 segundo, execute
            if (delta >= 1) {
                this.update(); // atualiza os estados
                this.render(); // renderiza a tela
                delta--;
            }
        }
    }
    
    public synchronized void start(){
        if(this.thread != null) return;// se a thread não for vazia, encerre
        this.thread = new Thread(this);
        
        this.running = true;
        
        this.thread.start();
        
    }
    
    public synchronized void stop(){
        if(this.thread == null) return;
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() {
        
    }

    /**
     * update game
     */
    private void update() {
        if(this.administrador.getEstado() == null) return;
        this.administrador.update();
        this.keyManager.update();
    }
    
    /**
     * render game
     * @access private
     * 
     */
    private void render() {
        BufferStrategy buffer = this.display.getBufferStrategy();
        if(buffer == null){
            this.display.createBufferStrategy();
            buffer = this.display.getBufferStrategy();
        }
        
        Graphics pintura = buffer.getDrawGraphics(); // ferramenta de pintura do pacote awt
        pintura.clearRect(
            0, 
            0, 
            Constantes.LARGURA_DA_TELA.getValor(), 
            Constantes.ALTURA_DA_TELA.getValor()
        );
        if(this.administrador.getEstado() != null)
            this.administrador.render(pintura);
        
        pintura.dispose(); //disponibiliza a ferramenta de pintura para outros serviços
        buffer.show(); // mostra as alterações na tela
    }
    
    
}
