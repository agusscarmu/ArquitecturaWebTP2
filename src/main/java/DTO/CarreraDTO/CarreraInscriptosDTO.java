package DTO.CarreraDTO;

public class CarreraInscriptosDTO {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(Long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return nombre + ", duracion: "+duracion+", inscriptos: "+cantidadInscriptos+"\n";
    }
}
