package Interfaces;

import java.util.List;

import DTO.EstudianteDTO.EstudianteDTO;
import DTO.InscripcionCarreraDTO.CarreraReporteDTO;
import Entidades.InscripcionCarrera;

public interface InscripcionCarreraRepository {

    // Método para guardar una inscripción a carrera en la base de datos
    void agregarInscripcionCarrera(InscripcionCarrera inscripcion);
    void agregarInscripcionCarrera(String csv);
    // Método para obtener una inscripción a carrera por su ID
    InscripcionCarrera obtenerInscripcionCarreraPorId(int id);

    // Método para obtener todas las inscripciones a carrera
    List<InscripcionCarrera> obtenerTodasLasInscripcionesCarrera();

    List<EstudianteDTO> obtenerListaFiltrada(String ciudad, int idCarrera);

    // Método para actualizar la información de una inscripción a carrera
    void actualizarInscripcionCarrera(InscripcionCarrera inscripcion);

    List<CarreraReporteDTO> obtenerReporte();

    // Método para eliminar una inscripción a carrera de la base de datos
    void eliminarInscripcionCarrera(int id);
}
