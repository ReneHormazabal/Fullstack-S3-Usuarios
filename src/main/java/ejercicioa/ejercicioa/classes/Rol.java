package ejercicioa.ejercicioa.classes;

public class Rol{
    private int id;
    private String descripcion;

    // Constructor
    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

}