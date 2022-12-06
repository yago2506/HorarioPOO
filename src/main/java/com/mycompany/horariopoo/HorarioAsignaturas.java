/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;
import com.mycompany.horariopoo.HorarioPOO.Semestre;
import com.sun.jdi.Value;
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
    final private Semestre Epoca; 
    final private CursoEnum Año;
   final private HashMap<Asignatura, Horario> Horario_has;  //(esta creo que habia que borrarla pero no estoy 100% seguro, de momento la comento)
    final private ArrayList<Examen> examenes;
   //HashMap<Asignatura, Horario> Horario_has = new HashMap<Asignatura, Horario>();
   
    public HorarioAsignaturas(String curso, CursoEnum año, Semestre epoca){ 
       Curso = curso; 
       Año = año;
       Epoca = epoca;
       Horario_has = new HashMap<Asignatura, Horario>();
       examenes = new ArrayList<Examen>();
    }
    
    public HorarioAsignaturas() //el constructor vacio
    {
        Curso = "Grado en Ingeniería Informática";
        Año = CursoEnum.PRIMERO;
        Epoca = Semestre.OTOÑO;
        Horario_has = new HashMap<Asignatura, Horario>();
        examenes = new ArrayList<Examen>();
    }
    
    public void inscripcionAsignatura(int ID,String Nombre,DiaSemanaEnum Dia,int Hora){
        Asignatura a = new Asignatura(ID,Nombre);
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h); 
    }
    
    public void inscripcionAsignaturaPractica(int ID,String Nombre, DiaSemanaEnum Dia, int Hora, int aula, String GrupoLab){
        AsignaturaPractica a = new AsignaturaPractica(ID,Nombre,aula,GrupoLab);
        Horario h = new Horario(Dia,Hora);   
        Horario_has.put(a, h);
    }
    
    public void inscripcionExamen(int ID,LocalDate fecha,int porcentaje){
        for (int i = 0; i < examenes.size(); i++) {
                if(ID==examenes.get(i).getCodigo())
                {
                    System.out.println("No se puede inscribir este examen ya que ya hay un examen para esta asignatura de codigo: "+ ID);
                    return;
                }
            }
        Examen exam = new Examen(ID,fecha,porcentaje);
        examenes.add(exam);
        System.out.println("-- El examen ha sido inscrito");
    }
    
    public void inscripcionExamen(int ID,int porcentaje){
        for (int i = 0; i < examenes.size(); i++) {
                if(ID==examenes.get(i).getCodigo())
                {
                    System.out.println("-- No se puede inscribir este examen ya que ya hay un examen para esta asignatura de codigo: "+ ID);
                    return;
                }
            }
        Examen exam = new Examen(ID,porcentaje);
        examenes.add(exam);
        System.out.println("-- El examen ha sido inscrito.");
    }
    
    public void mostrarHorario() //muestra todas las clases + examenes
    { 
        System.out.println("\nSe va a mostrar el horario teórico del curso,examenes incluidos");
        Horario_has.forEach((key, value)->
        {
            System.out.println(key.texto()+value.texto());
        });
        
        System.out.println("\n-----------------------------------------------\n");
        System.out.println("Los examenes son los siguientes:");
        for (int i = 0; i < examenes.size(); i++) {
            System.out.println(examenes.get(i).texto());
        }
    }
    
    public void mostrarHorario(boolean valor) //muestra solo los practicos
    { 
        if (valor == true){
            System.out.println("\nSe va a mostrar el horario practico del curso, examenes incluidos");
            Horario_has.forEach((key, value)->
            {
                if(key instanceof AsignaturaPractica)
                    System.out.println(key.texto()+value.texto());
            });
            System.out.println("\n-----------------------------------------------\n");
            System.out.println("Los examenes son los siguientes:");
            for (int i = 0; i < examenes.size(); i++) {
                System.out.println(examenes.get(i).texto());
            }
        }
    }

    public void mostrarInformacionBasica() {
        System.out.println("---------------------------------------------");
        System.out.println("-- Estudios de grado " + Curso);
        System.out.println("-- Es el " + Año + " curso.");
        System.out.println("-- Semestre de " + Epoca);
        System.out.println("---------------------------------------------");
        System.out.println("-- El numero de asignaturas que conforman el horario son: " + Horario_has.size());
        System.out.println("-- El numero de examanes fijados hasta el momento son: " + examenes.size());
        System.out.println("---------------------------------------------\n");     
    }
    
    public void comprobarIncompatibilidades() throws Exception
    {
        ArrayList<String> auxiliarValue = new ArrayList<String>();
        for (Map.Entry<Asignatura, Horario> entry : Horario_has.entrySet()) {
            for (int i = 0; i < auxiliarValue.size(); i++) {
                if(auxiliarValue.get(i).equals(entry.getValue().texto())){                   
                    throw new Exception("-- El horario NO es compatible porque el " + entry.getValue().getDia() + " a las " + entry.getValue().getHora() + " hay dos clases.");
                }
            }
            auxiliarValue.add(entry.getValue().texto());
            if(auxiliarValue.size()==Horario_has.size())
                System.out.println("-- El horario SI es compatible");
        } 
    }
    
    public int calculaHoras(int DURACION_CLASES)
    {
        return (Horario_has.size())*DURACION_CLASES;
    }
}


