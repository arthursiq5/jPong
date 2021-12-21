/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author arthur
 */
public class KeyManager implements KeyListener {
    private boolean[] keys = new boolean[256];
    public static boolean w;
    public static boolean s;
    public static boolean up;
    public static boolean down;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() > 255) return;
        
        this.keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() > 255) return;
        
        this.keys[e.getKeyCode()] = false;
    }
    
    public void update() {
        KeyManager.w = this.keys[KeyEvent.VK_W];
        KeyManager.s = this.keys[KeyEvent.VK_S];
        KeyManager.up = this.keys[KeyEvent.VK_UP];
        KeyManager.down = this.keys[KeyEvent.VK_DOWN];
    }
    
}
