/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author yago2
 */
public class Horario {
    private DiaSemanaEnum Dia;
    private int Hora;
    
    
    public Horario(DiaSemanaEnum dia, int hora){    
            ArrayList horas = new ArrayList<>(Arrays.asList(8,10,12,15,17,19));
            try
            {
                Dia = dia;
                Hora = hora;                    
                if(!horas.contains(hora))
                {
                    throw new Exception("Asignatura con horario incompatible. Introduzca una hora adecuada");
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            
        }

    @Override
    public String toString() {
        return "Horario{" + "Dia=" + Dia + ", Hora=" + Hora + '}';
    }

    public int getHora() {
        return Hora;
    }
    
    
        
        
    
    
    
}
