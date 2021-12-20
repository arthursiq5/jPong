/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.arthursiq5.estados;

/**
 *
 * @author arthur
 */
public enum IndiceEstados {
    MENU(0),
    FPS(1);
    
    private final int codigoDoEstado;
    
    private IndiceEstados(int codigoDoEstado){
        this.codigoDoEstado = codigoDoEstado;
    }
    
    public int getCodigo(){
        return this.codigoDoEstado;
    }
}
