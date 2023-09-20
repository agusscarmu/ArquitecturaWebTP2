package Entidades;
import jakarta.persistence.*;
@Entity
public class InscripcionCarrera {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
            @JoinColumn(name = "dni", referencedColumnName = "dni"),
            @JoinColumn(name = "libretaUniversitaria", referencedColumnName = "libretaUniversitaria")
    })
    private Estudiante estudiante;


    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "carrera")
    private Carrera carrera;

    private int antiguedad;
    private boolean graduado;


    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}