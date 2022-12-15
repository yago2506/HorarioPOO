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
    private LocalDate fecha;
    private int ponderacion;

    public Examen(int codigo, LocalDate fecha, int ponderacion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.ponderacion = ponderacion;
    }

    public Examen(int codigo, int ponderacion) { //tiene que fijarlo en dos meses a partir del dia actual
        this.codigo = codigo;
        this.ponderacion = ponderacion;
        this.fecha = LocalDate.now().plusMonths(2);
    }

    public int getCodigo() {
        return codigo;
    }

    public String toString() {
        return "Examen {Codigo asignatura=%d ,Fecha=%s ,ponderacion nota final=%d }".formatted(codigo, fecha.toString(), ponderacion);
    }

}
