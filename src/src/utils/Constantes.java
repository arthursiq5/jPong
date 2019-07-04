/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utils;

/**
 * collection of system´s constants
 * @author arthur
 */
public enum Constantes {
    /**
     * @var LARGURA_DA_TELA
     * width
     */
    LARGURA_DA_TELA(800),
    /**
     * @var ALTURA_DA_TELA
     * height
     */
    ALTURA_DA_TELA(600),
    FPS_JOGO(60);
    
    int valor;

    /**
     * set value to enumerator
     * @param valor 
     */
    private Constantes(int valor) {
        this.valor = valor;
    }
    
    /**
     * return value of constant
     * @return valor
     */
    public int getValor(){
        return this.valor;
    }
    
    
}
