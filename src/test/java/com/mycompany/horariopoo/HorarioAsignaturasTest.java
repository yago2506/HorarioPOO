/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.horariopoo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yago2
 */
public class HorarioAsignaturasTest {
    
    public HorarioAsignaturasTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of inscripcionAsignatura method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testInscripcionAsignatura_5args() {
        System.out.println("inscripcionAsignatura");
        int ID = 0;
        String Nombre = "";
        String Tipo = "";
        DiaSemanaEnum Dia = null;
        int Hora = 0;
        HorarioAsignaturas instance = new HorarioAsignaturas();
        instance.inscripcionAsignatura(ID, Nombre, Tipo, Dia, Hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inscripcionAsignatura method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testInscripcionAsignatura_4args() {
        System.out.println("inscripcionAsignatura");
        int ID = 0;
        String Nombre = "";
        DiaSemanaEnum Dia = null;
        int Hora = 0;
        HorarioAsignaturas instance = new HorarioAsignaturas();
        instance.inscripcionAsignatura(ID, Nombre, Dia, Hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarHorario method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testMostrarHorario_String() {
        System.out.println("mostrarHorario");
        String tipo = "";
        HorarioAsignaturas instance = new HorarioAsignaturas();
        instance.mostrarHorario(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarHorario method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testMostrarHorario_0args() {
        System.out.println("mostrarHorario");
        HorarioAsignaturas instance = new HorarioAsignaturas();
        instance.mostrarHorario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarIncompatibilidades method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testComprobarIncompatibilidades() throws Exception {
        System.out.println("comprobarIncompatibilidades");
        HorarioAsignaturas instance = new HorarioAsignaturas();
        instance.comprobarIncompatibilidades();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformacionBasica method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testMostrarInformacionBasica() {
        System.out.println("mostrarInformacionBasica");
        HorarioAsignaturas instance = new HorarioAsignaturas();
        String expResult = "";
        String result = instance.mostrarInformacionBasica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaHoras method, of class HorarioAsignaturas.
     */
    @org.junit.jupiter.api.Test
    public void testCalculaHoras() {
        System.out.println("calculaHoras");
        int DURACION_CLASES = 0;
        HorarioAsignaturas instance = new HorarioAsignaturas();
        int expResult = 0;
        int result = instance.calculaHoras(DURACION_CLASES);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
