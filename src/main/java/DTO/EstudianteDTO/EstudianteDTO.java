package DTO.EstudianteDTO;

import java.io.Serializable;

public class EstudianteDTO implements Serializable {
    private String nombre,apellido;
    private int libreta,dni;

    public EstudianteDTO(String nombre, String apellido, int libreta, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.libreta = libreta;
        this.dni = dni;
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


    public int getDni() {
        return dni;
    }


    @Override
    public String toString() {
        return nombre+", "+apellido+", libreta: "+libreta+", dni: "+dni+"\n";
    }
}
