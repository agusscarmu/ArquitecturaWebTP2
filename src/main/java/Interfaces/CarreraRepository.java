package Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DTO.CarreraDTO.CarreraInscriptosDTO;
import Entidades.Carrera;

public interface CarreraRepository {

    // Método para guardar una carrera en la base de datos
    void agregarCarrera(Carrera carrera);
    void agregarCarrera(String csv) throws IOException;

    // Método para obtener una carrera por su ID
    Carrera obtenerCarreraPorId(int id);

    List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos();

    // Método para obtener todas las carreras
    List<Carrera> obtenerTodasLasCarreras();

    // Método para actualizar la información de una carrera
    void actualizarCarrera(Carrera carrera);

    // Método para eliminar una carrera de la base de datos
    void eliminarCarrera(int id);
}
