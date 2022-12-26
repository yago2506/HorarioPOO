/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;

import com.mycompany.horariopoo.HorarioPOO.Semestre;
//import com.sun.jdi.Value;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;

/* edit yago 24/11 prueba git
 */
/**
 *
 * @author yago2
 */
public class HorarioAsignaturas {

    private String grado;
    private Semestre epoca;
    private CursoEnum año;
    static public HashMap<Asignatura, Horario> horario;
    private ArrayList<Examen> examenes;
//   HashMap<Asignatura, Horario> Horario_has = new HashMap<Asignatura, Horario>();

    public HorarioAsignaturas(String grado, CursoEnum año, Semestre epoca) //constuctor con parametros dados
    {
        this.grado = grado;
        this.año = año;
        this.epoca = epoca;
        this.horario = new HashMap<Asignatura, Horario>();
        this.examenes = new ArrayList<Examen>();
    }

    public HorarioAsignaturas() //el constructor por defecto (sin parametros)
    {
        grado = "Grado en Ingeniería Informática";
        año = CursoEnum.PRIMERO;
        epoca = Semestre.OTOÑO;
        horario = new HashMap<Asignatura, Horario>();
        examenes = new ArrayList<>();
    }

    public void inscripcionAsignatura(int id, String nombre, DiaSemana dia, int hora) //inscripcion de asignaturas con parametros dados
    {
        
        Asignatura a = new Asignatura(id, nombre);
        Horario h = new Horario(dia, hora);
        if (h.getHora()!=0)
            horario.put(a, h);
    }

    public static void inscripcionAsignatura() //inscripcion de asignatura (sin parametros; hay que preguntarle al usuario por ellos)
    {
        Scanner sc = new Scanner(System.in);
        int id;
        String nombre;
        String dia;
        DiaSemana diaSemana = DiaSemana.LUNES; //valor por defecto es lunes. luego se cambiará
        int hora;

        
        System.out.println("Introduce ID: ");
        id = Integer.parseInt(sc.next());

        System.out.println("Introduce nombre:");
        nombre = sc.next();
        
        System.out.println("Introduce dia: ");        
        System.out.println("""
                           1 - LUNES
                           2 - MARTES
                           3 - MIERCOLES
                           4 - JUEVES
                           5 - VIERNES
                           6 - SABADO
                           7 - DOMINGO
                           ---->
                           """);
        dia = sc.next();
        switch (dia) {
            case "1" ->
                diaSemana = DiaSemana.LUNES;
            case "2" ->
                diaSemana = DiaSemana.MARTES;
            case "3" ->
                diaSemana = DiaSemana.MIERCOLES;
            case "4" ->
                diaSemana = DiaSemana.JUEVES;
            case "5" ->
                diaSemana = DiaSemana.VIERNES;
            case "6" ->
                diaSemana = DiaSemana.SABADO;
            case "7" ->
                diaSemana = DiaSemana.DOMINGO;
            default -> {
            }
        }

        System.out.println("Introduce hora: ");
        hora = Integer.parseInt(sc.next());

        Asignatura a = new Asignatura(id, nombre);
        Horario h = new Horario(diaSemana, hora);

        horario.put(a, h);
    }

    public void inscripcionAsignaturaPractica(int ID, String Nombre, DiaSemana Dia, int Hora, int aula, String GrupoLab) //inscripcion de asignatura practica con parametros dados
    {
        AsignaturaPractica a = new AsignaturaPractica(ID, Nombre, aula, GrupoLab);
        Horario h = new Horario(Dia, Hora);
        horario.put(a, h);
    }

    public void inscripcionExamen(int ID, LocalDate fecha, int porcentaje) {
        for (int i = 0; i < examenes.size(); i++) {
            if (ID == examenes.get(i).getCodigo()) {
                System.out.println("No se puede inscribir este examen ya que ya hay un examen para esta asignatura de codigo: " + ID);
                return;
            }
        }
        Examen exam = new Examen(ID, fecha, porcentaje);
        examenes.add(exam);
        System.out.println("-- El examen ha sido inscrito");
    }

    public void inscripcionExamen(int ID, int porcentaje) {
        for (int i = 0; i < examenes.size(); i++) {
            if (ID == examenes.get(i).getCodigo()) {
                System.out.println("-- No se puede inscribir este examen ya que ya hay un examen para esta asignatura de codigo: " + ID);
                return;
            }
        }
        Examen exam = new Examen(ID, porcentaje);
        examenes.add(exam);
        System.out.println("-- El examen ha sido inscrito.");
    }

    public void mostrarHorario() //muestra todas las clases + examenes            
    {
        if(horario.isEmpty())
        {
            System.out.println("-- El horario esta vacio, no hay ninguna asignatura inscrita");
        }
        else
        {
            System.out.println("\nSe va a mostrar el horario teórico del curso,examenes incluidos");
            horario.forEach((key, value)->
            {
                System.out.println(key.toString()+value.toString());
            });

            System.out.println("\n-----------------------------------------------\n");
            System.out.println("Los examenes son los siguientes:");
            mostrarExamenes();
        }
    }

    public void mostrarHorario(boolean valor) //muestra solo los practicos + examenes
    {
        if(horario.isEmpty())
        {
            System.out.println("El horario esta vacio");
        }
        else
        {
            if (valor == true) { // si es true muestra tambien los 
                for (Asignatura a : horario.keySet()) {
                    if (a instanceof AsignaturaPractica) {
                        System.out.println(a.toString() + horario.get(a).getDia() + horario.get(a).getHora());
                    }
                }
            }
        }

        mostrarExamenes();

    }

    public void mostrarInformacionBasica() {
        System.out.println("---------------------------------------------");
        System.out.println("-- Estudios de grado " + grado);
        System.out.println("-- Es el " + año + " curso.");
        System.out.println("-- Semestre de " + epoca);
        System.out.println("---------------------------------------------");
        System.out.println("-- El numero de asignaturas que conforman el horario son: " + horario.size());
        System.out.println("-- El numero de examanes fijados hasta el momento son: " + examenes.size());
        System.out.println("---------------------------------------------\n");
    }

    public void comprobarIncompatibilidades() throws Exception {
        if(horario.isEmpty())
        {
            System.out.println("No hay asignaturas!!!");
        }
        else
        {
            ArrayList<String> auxiliarValue = new ArrayList<String>();
            for (Map.Entry<Asignatura, Horario> entry : horario.entrySet()) {
                for (int i = 0; i < auxiliarValue.size(); i++) {
                    if (auxiliarValue.get(i).equals(entry.getValue().toString())) {
                        throw new Exception("-- El horario NO es compatible porque el " + entry.getValue().getDia() + " a las " + entry.getValue().getHora() + " hay dos clases.");
                    }
                }
                auxiliarValue.add(entry.getValue().toString());
                if (auxiliarValue.size() == horario.size()) {
                    System.out.println("-- El horario SI es compatible");
                }
            }
        }
    }

    public void eliminarAsignatura(int codigoAsignatura) {
        ArrayList<Asignatura> auxiliar = new ArrayList<Asignatura>();
        if (horario.isEmpty()) {
            System.out.println("No has introducido ninguna asignatura aun, el horario esta vacio");
        } else {
            boolean encontrada = false;
            for (Asignatura a : horario.keySet()) {
                if (codigoAsignatura == a.getId()) {
                    encontrada = true;                    
                    auxiliar.add(a);  
                }
            }
            if (!encontrada) {
                System.out.println("La asignatura introducia no se encuentra en el horario");
            }
            else{
                for (int i = 0; i < auxiliar.size(); i++) {
                    horario.remove(auxiliar.get(i));
                    System.out.printf("Se elimina la asignatura -- %s \n", auxiliar.get(i).toString());
                }
            //eliminar examen
            encontrada = false;
            for(Examen examen : examenes)
            {
                if(examen.getCodigo() == codigoAsignatura)
                {
                    encontrada = true;
                    examenes.remove(examen);
                    System.out.printf("Se elimina el examen --%s \n", examen.toString());
                    break;
                }
            }
            if(!encontrada){
                    System.out.println("No se ha podido eliminar el examen con código de asignatura %d dado que no existe el examen".formatted(codigoAsignatura));
                    }
            }

        }

    }

    public int calculaHoras(int DURACION_CLASES) {
        int clasesPracticas=0;
        for (Asignatura a : horario.keySet()) {
            if (a instanceof AsignaturaPractica) {
                clasesPracticas = clasesPracticas + 1;
                }
            }
        return (horario.size()) * DURACION_CLASES + clasesPracticas;

    }

    public void vaciar() {
        grado = "Grado en Ingeniería Informática";
        año = CursoEnum.PRIMERO;
        epoca = Semestre.OTOÑO;
        horario = new HashMap<Asignatura, Horario>();
        examenes = new ArrayList<>();
    }
    
    public void mostrarExamenes()
    {
        if(examenes.isEmpty())
        {
            System.out.println("No hay examenes");
        }
        else
        {
            System.out.printf("\n---------------------------------------\n");
            for(Examen examen : examenes)
            {
                System.out.println(examen.toString());
            }
            System.out.printf("---------------------------------------\n");
        }
    }
    public void añadirExamen() throws Exception
    {
        //preguntar al usuario por la info y añadirlo a examenes
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------< AÑADIR EXAMENES >---------------");
        System.out.println("Sabes la fecha del examen?\nY(yes)/n(no)");
        String decision = sc.next();
        
        System.out.println("Introduce el codigo de la asignatura del examen");
        int codigoExamen = Integer.parseInt(sc.next());
        for(Examen examen : examenes)
        {
            if(examen.getCodigo() == codigoExamen)
            {
                System.out.println("Ya hay un examen con el codigo que has introducido!!");
                return;                
            }
        }
        System.out.println("Sobre 100, cuanto vale el examen respecto a la nota final?");
        int ponderacion = Integer.parseInt(sc.next());        
                
        if(decision.equals("Y")) //introducimos examen con fecha
        {
            System.out.println("Cuando es? Formato: YYYY-MM-DD");
            String fecha = sc.next();
            Examen examenAñadir = new Examen(codigoExamen, LocalDate.parse(fecha), ponderacion);
            examenes.add(examenAñadir);
        }
        else if(decision.equals("n")) //inroducimos examen sin fecha
        {
            Examen examenAñadir = new Examen(codigoExamen, ponderacion);
            examenes.add(examenAñadir);
        }
        else
        {
            System.out.println("Vuelva a introducir la respuesta! Y/n");
        }            
    }
    
    public void eliminarExamen(int codigo)
    {
        if(examenes.isEmpty())
        {
            System.out.println("No hay examenes!!");
        }
        else
        {    
            boolean encontrado = false;
            for(Examen examen : examenes)
            {
                if(examen.getCodigo() == codigo)
                {
                    encontrado = true;
                    examenes.remove(examen);
                    System.out.printf("El examen %s ha sido eliminado", examen.toString());
                    break;
                }
            }
            if(!encontrado)
            {
                System.out.println("El codigo introducido no corresponde a ningun examen");
            }
        }
    }
    public void eliminarExamen()
    {
        Scanner sc = new Scanner(System.in);
        mostrarExamenes();
        System.out.println("Que examen quieres eliminar? (Introduce el codigo de la asignatura");
        int eliminarCodigo = Integer.parseInt(sc.next());
        eliminarExamen(eliminarCodigo);
    }
}
