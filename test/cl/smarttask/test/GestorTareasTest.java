package cl.smarttask.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.smarttask.modelo.Tarea;
import cl.smarttask.modelo.TareaNormal;
import cl.smarttask.modelo.TareaUrgente;
import cl.smarttask.negocio.GestorTareas;

public class GestorTareasTest {

    private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    void testAgregarTarea() {
        int id = gestor.generarId();
        Tarea tarea = new TareaNormal(id, "Tarea de prueba", 3);
        gestor.agregarTarea(tarea);

        List<Tarea> tareas = gestor.listarTareas();
        assertEquals(1, tareas.size());
        assertEquals("Tarea de prueba", tareas.get(0).getNombre());
    }

    @Test
    void testListarTareasVacia() {
        List<Tarea> tareas = gestor.listarTareas();
        assertTrue(tareas.isEmpty());
    }

    @Test
    void testMarcarComoCompletada() {
        int id = gestor.generarId();
        Tarea tarea = new TareaUrgente(id, "Tarea urgente", 5);
        gestor.agregarTarea(tarea);

        boolean resultado = gestor.marcarComoCompletada(id);
        assertTrue(resultado);

        Tarea encontrada = gestor.buscarPorId(id);
        assertNotNull(encontrada);
        assertTrue(encontrada.isCompletado());
    }

    @Test
    void testMarcarComoCompletadaIdInexistente() {
        boolean resultado = gestor.marcarComoCompletada(999);
        assertFalse(resultado);
    }

    @Test
    void testEliminarTarea() {
        int id = gestor.generarId();
        Tarea tarea = new TareaNormal(id, "Eliminar esta tarea", 2);
        gestor.agregarTarea(tarea);

        boolean eliminado = gestor.eliminarTarea(id);
        assertTrue(eliminado);
        assertNull(gestor.buscarPorId(id));
    }

    @Test
    void testListarTareasCompletadas() {
        int id1 = gestor.generarId();
        int id2 = gestor.generarId();

        Tarea t1 = new TareaNormal(id1, "Tarea 1", 1);
        Tarea t2 = new TareaUrgente(id2, "Tarea 2", 4);

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);

        gestor.marcarComoCompletada(id2);

        List<Tarea> completadas = gestor.listarTareasCompletadas();
        assertEquals(1, completadas.size());
        assertEquals("Tarea 2", completadas.get(0).getNombre());
    }
}