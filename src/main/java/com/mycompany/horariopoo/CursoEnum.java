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
    TERCERO(2),
    CUARTO(4);
    
    final int curso;
    
    CursoEnum(int curso){
        this.curso = curso;
    }
} 
