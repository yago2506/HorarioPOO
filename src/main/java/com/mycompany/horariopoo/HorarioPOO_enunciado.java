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
    
    enum Semestre {
        OTOÑO,
        PRIMAVERA
    }

    public static void main(String[] args) throws Exception {

        // Creando un horario de asignaturas por defecto y mostrando el resultado
        HorarioAsignaturas horarioAsignaturasPrueba = new HorarioAsignaturas();
        horarioAsignaturasPrueba.mostrarInformacionBasica();

        // Creando un horario de asignaturas de Ciencia de Datos
        String grado = "Grado en Ingenieria de Ciencia de Datos";
        HorarioAsignaturas horarioAsignaturas = new HorarioAsignaturas(grado, CursoEnum.CUARTO, Semestre.OTOÑO);
        horarioAsignaturas.mostrarInformacionBasica();

           
        // Incluyendo los horarios teóricos "T" y prácticos "P" de las asignaturas
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
        // Horas validas, 8,10,12,15,17,19. Esta asignatura no se puede inscribir.
        horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO valido", DiaSemanaEnum.JUEVES, 18);
            
        try {
            horarioAsignaturas.comprobarIncompatibilidades();
            System.out.println();
            System.out.println("-- Forzando un horario incompatible.");
            horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO compatible", DiaSemanaEnum.LUNES, 8);
            horarioAsignaturas.comprobarIncompatibilidades();
        } catch (Exception ex) {
            System.err.println("-- El horario es incompatible."+ex);
        }

        // Mostrar el horario en dos variantes, al completo y práctico.
        horarioAsignaturas.mostrarHorario();
        horarioAsignaturas.mostrarHorario("P");
          
        // Cálculo de las horas lectivas según número de asignaturas inscritas.
        System.out.println("Las horas lectivas de su curso son " 
                + String.valueOf(horarioAsignaturas.calculaHoras(DURACION_CLASES)));
        
        // Se muestra el menu con opciones
        mostrarMenu(horarioAsignaturas);
    }
    
    private static void mostrarMenu(HorarioAsignaturas horarioAsig) {
 
 
 
 
    }
}
