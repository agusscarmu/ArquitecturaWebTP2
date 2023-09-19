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

    public Estudiante(int dni, int libretaUniversitaria, String nombre, String apellido, int edad, String genero, String ciudad){
        this.dni=dni;
        this.libretaUniversitaria=libretaUniversitaria;
        this.nombre=nombre;
        this.apellido=apellido;
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
        this.ciudad=ciudad;
    }
}
