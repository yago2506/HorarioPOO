/*
 * Proyecto I de ProgramaciÃ³n Orientada a Objetos.
 * RecuperaciÃ³n.
 *
 * Proyecto: HorarioPOO
 * Fecha: Nobriembre 2022
 *
 */
package com.mycompany.horariopoo;

import static com.mycompany.horariopoo.HorarioAsignaturas.inscripcionAsignatura;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author inigo.sanchez
 */
public class HorarioPOO {

    public static final int DURACION_CLASES = 2;

    enum Semestre {
        OTOÑO,
        PRIMAVERA
    }

    public static void main(String[] args) {

        // Creando un horario de asignaturas por defecto y mostrando el resultado
        HorarioAsignaturas horarioAsignaturasPrueba = new HorarioAsignaturas();
        horarioAsignaturasPrueba.mostrarInformacionBasica();

        // Creando un horario de asignaturas de Ciencia de Datos
        String grado = "Grado en Ingenieria de Ciencia de Datos";
        HorarioAsignaturas horarioAsignaturas = new HorarioAsignaturas(grado, CursoEnum.CUARTO, Semestre.OTOÑO);
        horarioAsignaturas.mostrarInformacionBasica();

        horarioAsignaturas.inscripcionAsignatura(505201, "EstadÃ­stica II", DiaSemana.LUNES, 10);
        horarioAsignaturas.inscripcionAsignaturaPractica(505201, "EstadÃ­stica II", DiaSemana.LUNES, 12, 100, "Grupo Laboratorio 1");
        horarioAsignaturas.inscripcionAsignaturaPractica(505201, "EstadÃ­stica II", DiaSemana.MIERCOLES, 8, 100, "Grupo Laboratorio 1");
        horarioAsignaturas.inscripcionExamen(505201, LocalDate.parse("2022-12-16"), 25);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de GenÃ©tica", DiaSemana.MARTES, 10);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de GenÃ©tica", DiaSemana.MARTES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemana.MIERCOLES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemana.MIERCOLES, 15);
        horarioAsignaturas.inscripcionAsignaturaPractica(505203, "Algoritmia", DiaSemana.VIERNES, 8, 120, "Grupo Laboratorio 2");
        horarioAsignaturas.inscripcionAsignatura(505204, "ProgramaciÃ³n Orientada a Objetos", DiaSemana.LUNES, 8);
        horarioAsignaturas.inscripcionExamen(505204, LocalDate.parse("2022-12-18"), 50);
        horarioAsignaturas.inscripcionAsignatura(505205, "Ecuaciones Diferenciales Ordinarias", DiaSemana.JUEVES, 19);
        System.out.println("-- Forzando una inscripcciÃ³n de examen dentro de dos meses a partir de la fecha de hoy.");
        horarioAsignaturas.inscripcionExamen(505205, 100);
        // Horas validas, 8,10,12,15,17,19. Esta asignatura no se puede inscribir.
        horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO valido", DiaSemana.JUEVES, 18);

        try {
            horarioAsignaturas.comprobarIncompatibilidades();
            System.out.println();
            System.out.println("-- Forzando un horario incompatible.");
            horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO compatible", DiaSemana.LUNES, 8);
            horarioAsignaturas.comprobarIncompatibilidades();
        } catch (Exception ex) {
            System.err.println("-- El horario es incompatible." + ex);
        }

        //DespuÃ©s de las inscripciones muestro la informaciÃ³n bÃ¡sica de nuevo.
        horarioAsignaturas.mostrarInformacionBasica();

        // Mostrar Horario: Sin parametros, se muestra el horario al completo (Teorico y Practico) + Examenes.
        horarioAsignaturas.mostrarHorario();
        boolean soloPractico = true;
        horarioAsignaturas.mostrarHorario(soloPractico);

        // CÃ¡lculo de las horas lectivas segÃºn nÃºmero de asignaturas inscritas.
        System.out.println("Las horas lectivas de su curso son "
                + String.valueOf(horarioAsignaturas.calculaHoras(DURACION_CLASES)));

        // Se muestra el menu con opciones
        mostrarMenu(horarioAsignaturas);
    }

    private static void mostrarMenu(HorarioAsignaturas horarioAsignaturas) {
        try{
            Scanner sc = new Scanner(System.in);
            String eleccion = "";
            while (!eleccion.equals("8")) {

                System.out.println("\n-------------------------------------");
                System.out.println("1. Introduce una asignatura.\n2. Elimina una asignatura.\n3. Comprueba incompatibilidad del Horario.\n4. Gestion de examenes.\n5. Muestra el horario completo\n6. Calcula Horas. \n7. Vacia el horario.\n8. Salir del menu.");
                System.out.println("-------------------------------------\nEscribe una de las opciones");
                eleccion = sc.nextLine();
                switch (eleccion){
                    case "1" -> {
                        System.out.println("Has seleccionado la opcion 1. Inscribir asignatura");

                        inscripcionAsignatura();
                        break;
                    }
                    case "2" -> {
                        System.out.println("Has seleccionado la opción 2. Eliminar asignatura por codigo.");
                        System.out.println("NOTA: si la asignatura tiene examen definido, este será eliminado también.");
                         
                        horarioAsignaturas.mostrarHorario();
                        System.out.println("Indique el codigo numérico de la asignatura que desea eliminar del horario.");
                        int codigoAsignatura = Integer.parseInt(sc.next());
                        horarioAsignaturas.eliminarAsignatura(codigoAsignatura);
                        break;                   
                    }
                    case "3" -> {
                        System.out.println("Has seleccionado la opcion 3. Comprueba incompatibilidad del Horario.\n");
                        try {
                            horarioAsignaturas.comprobarIncompatibilidades();
                        } catch (Exception e) {
                            System.err.println(" -- El horario es incompatible." + e); // cuenta el numero de clases que hay ese dia
                        }
                    }
                    case "4" -> {

                        //gestion examenes
                        String decisionExamen = "";
                        while (true) {
                            System.out.println("\nQue quieres hacer con los examenes? ");
                            System.out.println("""
                                               1 - Añadir examen (solo uno por asignatura)
                                               2 - Eliminar examen (introducir codigo de asignatura)
                                               3 - Consultar examenes 
                                               4 - Salir""");
                            decisionExamen = sc.next();
                            switch (decisionExamen) {
                                case "1" -> {
                                    try {
                                        horarioAsignaturas.añadirExamen();
                                    } catch (Exception e) //se crea una excepcion si ya hay un examen con ese codigo
                                    {
                                        System.out.println(e.getMessage());
                                    }

                                }
                                case "2" ->
                                    horarioAsignaturas.eliminarExamen();
                                case "3" ->
                                    horarioAsignaturas.mostrarExamenes();
                                case "4" -> {
                                    break;
                                }
                                default ->
                                    System.out.println("Introduce numeros del 1 al 4!!");
                            }
                        }

                    }
                    case "5" -> {
                        System.out.println("Has seleccionado la opcion 5. Muestra el horario completo.\n");
                        horarioAsignaturas.mostrarHorario();
                    }
                    case "6" -> {
                        System.out.println("Has seleccionado la opcion 6. Calcula Horas.");
                        System.out.printf("\nLas horas lectivas de su curso son: %d", horarioAsignaturas.calculaHoras(DURACION_CLASES));

                    }
                    case "7" -> {
                        System.out.println("Has seleccionado la opcion 7. Vaciar el horario.\n");
                        horarioAsignaturas.vaciar();
                        System.out.println("El horario ha sido vaciado.");
                    }
                    case "8" -> {
                        break;
                    }
//                    default ->
//                        System.out.println("Solo numeros entre 1 y 8 ambos inclusive");
                }
            }
        }
        catch(NumberFormatException ex){  
            System.out.println("error letra");
            System.err.println("Invalid string in argumment");
            mostrarMenu(horarioAsignaturas);
        }
    }
}
