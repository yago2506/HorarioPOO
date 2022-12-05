/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* edit yago 24/11 prueba git
*/

/**
 *
 * @author yago2
 */
public class HorarioAsignaturas 
{
    final private String Curso;
    final private SemestreEnum Epoca; 
    final private CursoEnum Año;
//   final private HashMap Horario_has;  (esta creo que habia que borrarla pero no estoy 100% seguro, de momento la comento)
    
    public HorarioAsignaturas(String curso, CursoEnum año, SemestreEnum epoca){ //aqui falta por añadir el semestre pero no me deja meterlo bien
       Curso = curso; 
       Año = año;
       Epoca = epoca;
       HashMap<Asignatura, Horario> Horario_has = new HashMap<Asignatura, Horario>();
    }
    
    public HorarioAsignaturas()
    {
        Curso = null;
        Año = null;
        Epoca = null;
        HashMap<Asignatura, Horario> Horario_has = new HashMap<Asignatura, Horario>();
    }
    
    public void inscripcionAsignatura(int ID,String Nombre,DiaSemanaEnum Dia,int Hora){
        Asignatura a = new Asignatura(ID,Nombre);
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h); 
    }
    
    public void inscripcionAsignaturaPractica(int ID,String Nombre, DiaSemanaEnum Dia, int Hora, int aula, String GrupoLab){
        AsignaturaPractica a = new AsignaturaPractica(ID,Nombre,aula,GrupoLab);
        Horario h = new Horario(Dia,Hora);   
    }
    
    public void inscripcionExamen(int ID,LocalDate fecha,int porcentaje){
        Examen exam = new Examen(ID,fecha,porcentaje);
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


