package DTO.EstudianteDTO;

import java.io.Serializable;

public class EstudianteLibretaDTO implements Serializable {
    private String nombre,apellido;
    private int libreta;

    public EstudianteLibretaDTO(String nombre, String apellido, int libreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.libreta = libreta;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public int getLibreta() {
        return libreta;
    }


    @Override
    public String toString() {
        return nombre+", "+apellido+", libreta: "+libreta+"\n";
    }
}
