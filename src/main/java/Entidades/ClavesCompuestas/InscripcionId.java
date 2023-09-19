package Entidades.ClavesCompuestas;

import Entidades.Carrera;
import Entidades.Estudiante;
import jakarta.persistence.*;

import java.io.Serializable;

//@Embeddable
//public class InscripcionId implements Serializable {
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumns({
//            @JoinColumn(name = "dni", referencedColumnName = "dni"),
//            @JoinColumn(name = "libretaUniversitaria", referencedColumnName = "libretaUniversitaria")
//    })
//    private Estudiante estudiante;
//
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "fk_carrera")
//    private Carrera carrera;
//
//    public InscripcionId(Estudiante estudiante, Carrera carrera) {
//        this.estudiante = estudiante;
//        this.carrera = carrera;
//    }
//
//    public InscripcionId() {
//
//    }
//
//    public Estudiante getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(Estudiante estudiante) {
//        this.estudiante = estudiante;
//    }
//
//    public Carrera getCarrera() {
//        return carrera;
//    }
//
//    public void setCarrera(Carrera carrera) {
//        this.carrera = carrera;
//    }
//}
