/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.estados;

/**
 *
 * @author arthur
 */
public class AdministradorDeEstados {
    private final int numeroDeEstados = 2;
    private Estado[] estados = new Estado[numeroDeEstados];
    private int estadoAtual = 0;
    
    public void setState(int estado){
        this.estadoAtual = estado;
    }
}
