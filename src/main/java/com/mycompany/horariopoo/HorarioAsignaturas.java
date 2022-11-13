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
//    private Semestre Epoca; // no se porque la clase semestre no la detecta, creo que es por estar dentro de la ejecucion principal pero no se como cambiar eso sin cambiar nada de ese codigo
    private CursoEnum Año;
    private HashMap Horario_has;
    
    public HorarioAsignaturas(String curso, CursoEnum año){ //aqui falta por añadir el semestre pero no me deja meterlo bien
        Curso = curso; 
        Año = año;
        Horario_has = new HashMap<Asignatura, Horario>();//crea el objeto hash
    }
    
    public void IncripcionAsignatura(int ID,String Nombre,String Tipo,DiaSemanaEnum Dia,String Hora){
        Asignatura a = new Asignatura(ID,Nombre,Tipo);
        Horario h = new Horario(Dia,Hora);
        Horario_has.put(a, h); //añade  
        h.mostrar();
        a.mostrar();
        System.out.println("el hash:"+Horario_has.get(a));  //esto deberai de printear la direccion del objeto h ya que accede a traves de la clave a(funciona)  
        System.out.println("a:"+a);
        System.out.println("h:"+h);
    }
}
