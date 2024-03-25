package ejercicioa.ejercicioa.classes;

import java.util.List;

public class User {
    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private List<Rol> roles;

    // Constructor
    public User(int id, String nombre, String email, String direccion, List<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.roles = roles;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Rol> getRoles() {
        return roles;
    }
}
