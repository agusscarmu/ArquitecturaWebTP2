package DTO.EstudianteDTO;

public class EstudianteDTO {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLibreta() {
        return libreta;
    }

    public void setLibreta(int libreta) {
        this.libreta = libreta;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+", libreta: "+libreta+", dni: "+dni+"\n";
    }
}
