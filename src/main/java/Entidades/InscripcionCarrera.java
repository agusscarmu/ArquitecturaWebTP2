package Entidades;
import jakarta.persistence.*;
@Entity
public class InscripcionCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int antiguedad;
    private boolean graduado;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_estudiante")
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_carrera")
    private Carrera carrera;
}
