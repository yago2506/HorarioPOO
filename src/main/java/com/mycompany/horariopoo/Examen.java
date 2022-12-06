/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;
import java.time.LocalDate;
/**
 *
 * @author yago2
 */
public class Examen {
    private int codigo;
    private LocalDate Fecha;
    private int Porcentaje;
    
    public Examen(int ID,LocalDate fecha, int porcentaje){
        codigo = ID;
        Fecha = fecha;
        Porcentaje = porcentaje;
    }
    
    public Examen(int ID, int porcentaje){ //tiene que fijarlo en dos meses a partir del dia actual
        codigo = ID;
        Porcentaje = porcentaje;
        Fecha = LocalDate.now().plusMonths(2);
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String texto(){
        return "Examen {Codigo asignatura=%d ,Fecha=%s ,porcentaje nota final=%d }".formatted(codigo,Fecha.toString(),Porcentaje);
    }
    
    
}
