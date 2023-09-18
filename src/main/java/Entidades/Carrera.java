package Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<InscripcionCarrera> inscripciones;

}
