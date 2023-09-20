package Entidades.ClavesCompuestas;

import Entidades.Carrera;
import Entidades.Estudiante;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class InscripcionId implements Serializable {
    private int dni;
    private int libretaUniversitaria;
    private int id;

    public InscripcionId(int dni, int libretaUniversitaria, int id){
        this.dni=dni;
        this.libretaUniversitaria=libretaUniversitaria;
        this.id=id;
    }
    public InscripcionId() {

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(int libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
