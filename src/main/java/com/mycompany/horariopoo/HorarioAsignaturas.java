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
    private Semestre Epoca; 
    private CursoEnum Año;
    private HashMap Horario_has;
    
    public HorarioAsignaturas(String curso, Semestre epoca, CursoEnum año){ //aqui falta por añadir el semestre pero no me deja meterlo bien
        Curso = curso; 
        Año = año;
        Epoca = epoca;
        Horario_has = new HashMap<Asignatura, Horario>();
    }
    
    public HorarioAsignaturas()
    {
        Curso = null;
        Año = null;
        Epoca = null;
        Horario_has = new HashMap<Asignatura, Horario>();
    }
    
    public void inscripcionAsignatura(int ID,String Nombre,String Tipo,DiaSemanaEnum Dia,int Hora){
        Asignatura a = new Asignatura(ID,Nombre,Tipo);
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h);        
    }
    
    public void inscripcionAsignatura(int ID,String Nombre,DiaSemanaEnum Dia,int Hora){
        Asignatura a = new Asignatura(ID,Nombre,"Teoria");
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h); 
    }
    
    public void mostrarHorario()
    { 
        Horario_has.forEach((key, value)->
        {                                                
            System.out.println(key.toString());
        });
    }

    @Override
    public String toString() {
        return "HorarioAsignaturas{" + "Curso=" + Curso + ", Epoca=" + Epoca + ", A\u00f1o=" + Año + '}';
    }
    
    
}
