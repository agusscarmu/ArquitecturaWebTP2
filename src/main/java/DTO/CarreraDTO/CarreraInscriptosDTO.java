package DTO.CarreraDTO;

import java.io.Serializable;

public class CarreraInscriptosDTO implements Serializable {
    private String nombre;
    private Long cantidadInscriptos;
    private int duracion;

    public CarreraInscriptosDTO(String nombre, Long cantidadInscriptos, int duracion) {
        this.nombre = nombre;
        this.cantidadInscriptos = cantidadInscriptos;
        this.duracion = duracion;
    }


    public String getNombre() {
        return nombre;
    }


    public Long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public int getDuracion() {
        return duracion;
    }


    @Override
    public String toString() {
        return nombre + ", duracion: "+duracion+", inscriptos: "+cantidadInscriptos+"\n";
    }
}
