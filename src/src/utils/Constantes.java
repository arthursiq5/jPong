/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utils;

/**
 *
 * @author arthur
 */
public enum Constantes {
    LARGURA_DA_TELA(800),
    ALTURA_DA_TELA(600);
    
    int valor;

    /**
     * 
     * @param valor 
     */
    private Constantes(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    
}
