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
        Horario_has = new HashMap<Asignatura, Horario>();//crea el objeto hash
    }
    
    public void IncripcionAsignatura(int ID,String Nombre,String Tipo,DiaSemanaEnum Dia,int Hora){
        Asignatura a = new Asignatura(ID,Nombre,Tipo);
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h); //añade  
        // a partir de aqui son pruebas
//        h.mostrar();
//        a.mostrar();
//        System.out.println("el hash:"+Horario_has.get(a));  //esto deberai de printear la direccion del objeto h ya que accede a traves de la clave a(funciona)  
//        System.out.println("a:"+a);
//        System.out.println("h:"+h);
    }
    
    public void mostrarHorario()
    { 
        Horario_has.forEach((Asignatura key, Horario value)->
        {                                    
            System.out.println("es instaceof key");
//            key.mostrar(); // no entiendo porque si es clase asignatura no me deja usar su metodo            
            System.out.println(key.toString());
//            System.out.println("mostrarhorario");   
//            System.out.println(key+" = "+value);
        });
    }
}
