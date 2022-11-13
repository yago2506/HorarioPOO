/*
 * Enunciado Proyecto I de Programación Orientada a Objetos.
 *
 * Proyecto: HorarioPOO
 * Fecha: Octubre 2022
 *
 */

package com.mycompany.horariopoo;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author inigo.sanchez
 */
public class HorarioPOO_enunciado {

    public static final int DURACION_CLASES = 2;
    
    public static void main(String[] args) throws Exception {
        HorarioAsignaturas horarioAsignaturas = new HorarioAsignaturas("ciencia de datos",Semestre.OTOÑO ,CursoEnum.TERCERO); //aqui falta el semestre para el metodo, va mal                                 
        
        
        System.out.println("Las horas lectivas de su curso son " 
                + String.valueOf(horarioAsignaturas.calculaHoras(DURACION_CLASES)));                
    }
    
    private static void mostrarMenu(HorarioAsignaturas horarioAsig) {
   
        
        //PRUEBA
        HorarioAsignaturas horarioPrueba = new HorarioAsignaturas();
        System.out.println(horarioPrueba.toString());
                
        //CIENCIA DE DATOS
        HorarioAsignaturas horarioAsignaturas = new HorarioAsignaturas("ciencia de datos",Semestre.OTOÑO ,CursoEnum.TERCERO); //aqui falta el semestre para el metodo, va mal        
        horarioAsignaturas.inscripcionAsignatura(505201, "Estadística II", DiaSemanaEnum.LUNES, 10);
        horarioAsignaturas.inscripcionAsignatura(505201, "Estadística II", "P", DiaSemanaEnum.LUNES, 12);
        horarioAsignaturas.inscripcionAsignatura(505201, "Estadística II", "P", DiaSemanaEnum.MIERCOLES, 8);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de Genética", DiaSemanaEnum.MARTES, 10);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de Genética", DiaSemanaEnum.MARTES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemanaEnum.MIERCOLES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemanaEnum.MIERCOLES, 15);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", "P", DiaSemanaEnum.VIERNES, 8);
        horarioAsignaturas.inscripcionAsignatura(505204, "Programación Orientada a Objetos", DiaSemanaEnum.LUNES, 8);
        horarioAsignaturas.inscripcionAsignatura(505205, "Ecuaciones Diferenciales Ordinarias", DiaSemanaEnum.JUEVES, 19);        
        System.out.println(horarioAsignaturas.toString());
        
        try
        {
            horarioAsignaturas.comprobarIncompatibilidades();    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        
        
    }
}
