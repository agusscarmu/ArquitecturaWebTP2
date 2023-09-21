package DTO.EstudianteDTO;

public class EstudianteLibretaDTO {
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

    @Override
    public String toString() {
        return nombre+", "+apellido+", libreta: "+libreta+"\n";
    }
}
