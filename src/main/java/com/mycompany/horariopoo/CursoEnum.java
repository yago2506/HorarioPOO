/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;

/**
 *
 * @author yago2
 */
public enum CursoEnum {
    PRIMERO(1),
    SEGUNDO(2),
    TERCERO(3),
    CUARTO(4);
    
    //esto de los parentesis y el constructor era para probar unas cosas pero no se muy bien aun como va, se pueden poner como variables a cada 
    //  valor pero luego no se muy bien como podrian facilitarnos las cosas ni trabajar con ellos
    final int curso;
    
    CursoEnum(int curso){
        this.curso = curso;
    }
} 
