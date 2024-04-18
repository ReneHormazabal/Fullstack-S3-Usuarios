package ejercicioa.ejercicioa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "usuarioSeq", sequenceName = "usuarios_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSeq")
    @Column(name = "id")
    private int id;

    @NotBlank(message = "nombre es obligatorio")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "email es obligatorio")
    @Email(message = "formato de email incorrecto")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "password es obligatorio")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "direccion es obligatorio")
    @Column(name = "direccion")
    private String direccion;
    
    @NotBlank(message = "roles es obligatorio")
    @Column(name = "roles")
    private String roles;

    // Constructor
    public User(int id, String nombre, String email, String direccion, String roles) {
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

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRoles(String roles){
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
