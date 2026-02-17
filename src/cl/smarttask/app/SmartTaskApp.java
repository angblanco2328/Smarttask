package cl.smarttask.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cl.smarttask.modelo.Tarea;
import cl.smarttask.modelo.TareaNormal;
import cl.smarttask.modelo.TareaUrgente;
import cl.smarttask.negocio.GestorTareas;

public class SmartTaskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        boolean salir = false;

        System.out.println("=== SmartTask - Gestor de Tareas ===");

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Listar tareas completadas");
            System.out.println("4. Marcar tarea como completada");
            System.out.println("5. Eliminar tarea");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine();
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        agregarTarea(scanner, gestor);
                        break;
                    case 2:
                        listarTareas(gestor);
                        break;
                    case 3:
                        listarTareasCompletadas(gestor);
                        break;
                    case 4:
                        marcarComoCompletada(scanner, gestor);
                        break;
                    case 5:
                        eliminarTarea(scanner, gestor);
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo de SmartTask. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void agregarTarea(Scanner scanner, GestorTareas gestor) {
        System.out.print("Ingrese nombre de la tarea: ");
        String nombre = scanner.nextLine();

        int prioridad = 0;
        while (true) {
            try {
                System.out.print("Ingrese prioridad (1-5): ");
                prioridad = scanner.nextInt();
                scanner.nextLine();
                if (prioridad < 1 || prioridad > 5) {
                    System.out.println("La prioridad debe estar entre 1 y 5.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }

        int tipo = 0;
        while (true) {
            try {
                System.out.print("Tipo de tarea (1 = Normal, 2 = Urgente): ");
                tipo = scanner.nextInt();
                scanner.nextLine();
                if (tipo != 1 && tipo != 2) {
                    System.out.println("Debe seleccionar 1 o 2.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }

        int id = gestor.generarId();
        Tarea tarea = (tipo == 1)
                ? new TareaNormal(id, nombre, prioridad)
                : new TareaUrgente(id, nombre, prioridad);

        gestor.agregarTarea(tarea);
        System.out.println("Tarea agregada con éxito. ID asignado: " + id);
    }

    private static void listarTareas(GestorTareas gestor) {
        List<Tarea> tareas = gestor.listarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            System.out.println("=== Tareas ===");
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }
    }

    private static void listarTareasCompletadas(GestorTareas gestor) {
        List<Tarea> tareas = gestor.listarTareasCompletadas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            System.out.println("=== Tareas Completadas ===");
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }
    }

    private static void marcarComoCompletada(Scanner scanner, GestorTareas gestor) {
        try {
            System.out.print("Ingrese el ID de la tarea a completar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean resultado = gestor.marcarComoCompletada(id);
            if (resultado) {
                System.out.println("Tarea marcada como completada.");
            } else {
                System.out.println("No se encontró la tarea o ya estaba completada.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.nextLine();
        }
    }

    private static void eliminarTarea(Scanner scanner, GestorTareas gestor) {
        try {
            System.out.print("Ingrese el ID de la tarea a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean resultado = gestor.eliminarTarea(id);
            if (resultado) {
                System.out.println("Tarea eliminada correctamente.");
            } else {
                System.out.println("No se encontró la tarea con ese ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.nextLine();
        }
    }
}