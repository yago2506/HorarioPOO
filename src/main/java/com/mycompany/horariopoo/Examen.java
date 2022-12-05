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
    private int porcentaje;
    
    public Examen(int ID,LocalDate fecha, int porcentaje){
        codigo = ID;
        Fecha = fecha;
        porcentaje = porcentaje;
    }
    
    public Examen(int ID, int porcentaje){ //tiene que fijarlo en dos meses a partir del dia actual
        codigo = ID;
        porcentaje = porcentaje;
        Fecha = LocalDate.now().plusMonths(2);
    }
    
    
}
