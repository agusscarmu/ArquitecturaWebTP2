package Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    private int dni;
    private int libretaUniversitaria;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;

    @OneToMany(mappedBy = "estudiante")
    private List<InscripcionCarrera> inscripciones;
}
