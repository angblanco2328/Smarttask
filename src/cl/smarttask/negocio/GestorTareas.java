package cl.smarttask.negocio;

import java.util.ArrayList;
import java.util.List;

import cl.smarttask.modelo.Tarea;

public class GestorTareas implements Accionable {

    private List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.siguienteId = 1;
    }

    public int generarId() {
        return siguienteId++;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public List<Tarea> listarTareas() {
        return new ArrayList<>(tareas);
    }

    @Override
    public List<Tarea> listarTareasCompletadas() {
        List<Tarea> completadas = new ArrayList<>();
        for (Tarea t : tareas) {
            if (t.isCompletado()) {
                completadas.add(t);
            }
        }
        return completadas;
    }

    @Override
    public boolean marcarComoCompletada(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null && !tarea.isCompletado()) {
            tarea.setCompletado(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            return tareas.remove(tarea);
        }
        return false;
    }

    @Override
    public Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}