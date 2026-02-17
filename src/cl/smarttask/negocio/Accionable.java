package cl.smarttask.negocio;

import java.util.List;
import cl.smarttask.modelo.Tarea;

public interface Accionable {

    void agregarTarea(Tarea tarea);

    List<Tarea> listarTareas();

    List<Tarea> listarTareasCompletadas();

    boolean marcarComoCompletada(int id);

    boolean eliminarTarea(int id);

    Tarea buscarPorId(int id);
}