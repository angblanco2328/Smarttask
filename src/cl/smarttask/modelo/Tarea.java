package cl.smarttask.modelo;

public abstract class Tarea {
    private int id;
    private String nombre;
    private int prioridad;
    private boolean completado;

    public Tarea(int id, String nombre, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "ID: " + id +
               " | Tipo: " + getTipo() +
               " | Nombre: " + nombre +
               " | Prioridad: " + prioridad +
               " | Completada: " + (completado ? "Sí" : "No");
    }
}