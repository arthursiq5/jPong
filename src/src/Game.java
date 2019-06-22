/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.display.Display;
import src.utils.Constantes;

/**
 *
 * @author arthur
 */
public class Game {
    private Display display;

    public Game() {
        this.display = new Display(
            "Pong", 
            Constantes.LARGURA_DA_TELA.getValor(), //largura
            Constantes.ALTURA_DA_TELA.getValor() // altura
        );
    }
    
    
}
