package es.ieslosmontecillos.AppAgendaBK.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="USUARIOS")

public class Usuario implements Serializable
{
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 20)
    private String password;
    @Basic
    @Column(name = "USERNAME", nullable = false, length = 20)
    private String username;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
