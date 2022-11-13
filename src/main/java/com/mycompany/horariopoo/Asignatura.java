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
        if(tipo=="P")
            
            Tipo = "Practico"; 
        else
            Tipo = "Teorico";
    }

    public String dar_tipo(){
        return this.Tipo;
    }

    @Override
    public String toString(){
        return "Asignatura{Codigo=%s,Nombre=%s,Tipo=%s}".formatted(ID,Nombre,Tipo);
    }

}



