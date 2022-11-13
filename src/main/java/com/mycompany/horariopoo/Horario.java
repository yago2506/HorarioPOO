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
    private String Dia;
    private String Hora;
    
    public Horario(String dia,String hora){
        Dia = dia;
        Hora = hora;
    }
    
    public void mostrar(){
        System.out.println(this.Dia);
        System.out.println(this.Hora);
    }
}
