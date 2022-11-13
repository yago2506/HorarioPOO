/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;


/**
 *
 * @author yago2
 */
public class Asignatura {
    
    private int ID;
    private String Nombre;
    private String Tipo; //esto quiza se puede hacer con un int 1 y 0
    
    
    public Asignatura(int numero, String nombre, String tipo)
    {              
        ID = numero;
        Nombre = nombre;
        Tipo = tipo;                    
    }
        
    @Override
    public String toString(){
        return "ID: %s\nNombre: %s\nTipo: %s\n".formatted(ID,Nombre,Tipo);
    }
    
}
