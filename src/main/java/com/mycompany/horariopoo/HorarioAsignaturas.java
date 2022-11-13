/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public HorarioAsignaturas(String curso, CursoEnum año, Semestre epoca){ //aqui falta por añadir el semestre pero no me deja meterlo bien
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
    
    public void mostrarHorario(String tipo)
    { 
        if(tipo.equals("P"))
        {
            Horario_has.forEach((Asignatura key, Horario value)->
            {                                                
                if(key.dar_tipo().equals("Practico"))
                {
                    System.out.println(key.toString()+value.toString());
                }
            });
        }
        else
        {
            mostrarHorario();
        }        
    }
    
    public void mostrarHorario()
    { 
        Horario_has.forEach((key, value)->
        {
            System.out.println(key.toString()+value.toString());
        });
    }
    
    
    
    public void comprobarIncompatibilidades() throws Exception
    {
                
    }

    public String mostrarInformacionBasica() {
        return "HorarioAsignaturas{" + "Curso=" + Curso + ", Epoca=" + Epoca + ", A\u00f1o=" + Año + '}';
    }
    
    public int calculaHoras(int DURACION_CLASES)
    {
        return (Horario_has.size())*DURACION_CLASES;
    }
    
    
    
}


