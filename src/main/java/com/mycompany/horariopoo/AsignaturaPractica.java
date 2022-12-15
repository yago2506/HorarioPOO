/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;

/**
 *
 * @author yago2
 */
public class AsignaturaPractica extends Asignatura {

    private int aula;
    private String GrupoLab;

    public AsignaturaPractica(int numero, String nombre, int aula, String GrupoLab) {
        super(numero, nombre);
        this.aula = aula;
        this.GrupoLab = GrupoLab;
    }

    public String toString() {
        return "Asignatura Practica {Codigo=%s ,Nombre=%s ,aula=%d ,GrupoLaboratoria=%s}".formatted(super.getId(), super.getNombre(), aula, GrupoLab);
    }
}
