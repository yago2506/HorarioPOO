/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;

/**
 *
 * @author yago2
 */
public class Horario {
    private DiaSemanaEnum Dia;
    private int Hora;
    
    public Horario(DiaSemanaEnum dia, int hora){
        Dia = dia;
        Hora = hora;
    }
    
    public void mostrar(){
        System.out.println("Dia:"+this.Dia);
        System.out.println("Hora:"+this.Hora);
    }
}
