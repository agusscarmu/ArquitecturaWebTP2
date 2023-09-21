package DTO.InscripcionCarreraDTO;

public class CarreraReporteDTO {
    private String nombreCarrera;
    private int anio;
    private long inscriptos;
    private long egresados;

    public CarreraReporteDTO(String nombreCarrera, int anio, long inscriptos, long egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public long getEgresados() {
        return egresados;
    }

    public void setEgresados(long egresados) {
        this.egresados = egresados;
    }
}
