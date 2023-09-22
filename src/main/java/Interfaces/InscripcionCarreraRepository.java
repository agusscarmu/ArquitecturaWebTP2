package Interfaces;

import java.util.List;

import DTO.EstudianteDTO.EstudianteDTO;
import DTO.InscripcionCarreraDTO.CarreraReporteDTO;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.InscripcionCarrera;

public interface InscripcionCarreraRepository {


    void agregarInscripcionCarrera(InscripcionCarrera inscripcion);
    void agregarInscripcionCarrera(String csv);

    InscripcionCarrera obtenerInscripcionCarreraPorId(int id);

    void matricularEstudiante(Estudiante estudiante, Carrera carrera);

    //En caso que sea necesario re-matricular un estudiante a una carrera (y sea necesario poner el año de inscripcion)
    void matricularEstudiante(Estudiante estudiante, Carrera carrera, int anioInscripcion);


    List<InscripcionCarrera> obtenerTodasLasInscripcionesCarrera();

    List<EstudianteDTO> obtenerListaFiltrada(String ciudad, int idCarrera);


    void actualizarInscripcionCarrera(InscripcionCarrera inscripcion);

    List<CarreraReporteDTO> obtenerReporte();


    void eliminarInscripcionCarrera(int id);
}
