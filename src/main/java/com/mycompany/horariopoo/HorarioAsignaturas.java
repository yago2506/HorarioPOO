/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yago2
 */
public class HorarioAsignaturas {
    private String Curso;
    private String Epoca;
    private String Año;
    
    public HorarioAsignaturas(String curso, String epoca, String año){
        Curso = curso;
        Epoca = epoca;
        Año = año;
    }
    
    public void IncripcionAsignatura(int ID,String Nombre,String Tipo,String Dia,String Hora){
        Asignatura a = new Asignatura(ID,Nombre,Tipo);
        Horario h = new Horario(Dia,Hora);
        HashMap<Asignatura, Horario> Horario_has = new HashMap<>();//crea el objeto
        Horario_has.put(a, h); //añade  
        System.out.println("el hash:"+Horario_has.get(a));    
    }
}
