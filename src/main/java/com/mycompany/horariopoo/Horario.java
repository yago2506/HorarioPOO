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

    private DiaSemana dia;
    private int hora;

    public Horario(DiaSemana dia, int hora) {
        ArrayList horas = new ArrayList<>(Arrays.asList(8, 10, 12, 15, 17, 19));
        try {
            if (!horas.contains(hora)) {
                
                throw new Exception("-- La asignatura no ha podido inscribirse. El horario " + hora + " no es valido.");
            }
            else{
                this.dia = dia;
                this.hora = hora;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String toString() {
        return "Horario{DiaSemana=%s,Hora=%d}".formatted(dia, hora);
    }

    public int getHora() {
        return hora;
    }

    public DiaSemana getDia() {
        return dia;
    }

}
