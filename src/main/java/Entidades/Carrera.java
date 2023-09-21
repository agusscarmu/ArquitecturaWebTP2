package Entidades;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    private int id;
    private String nombre;

    private int duracion;
    @OneToMany(mappedBy = "carrera")
    private List<InscripcionCarrera> inscripciones;

    public Carrera(int id, String nombre, int duracion){
        this.id=id;
        this.nombre=nombre;
        this.duracion=duracion;
        this.inscripciones = new LinkedList<>();
    }

    public Carrera() {
        this.inscripciones = new LinkedList<>();
    }

    public void addInscripcion(InscripcionCarrera inscripcion){
        if(!inscripciones.contains(inscripcion)){
            inscripciones.add(inscripcion);
        }
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

    public List<InscripcionCarrera> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionCarrera> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
