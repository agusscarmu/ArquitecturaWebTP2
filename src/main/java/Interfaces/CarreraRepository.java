package Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DTO.CarreraDTO.CarreraInscriptosDTO;
import Entidades.Carrera;

public interface CarreraRepository {


    void agregarCarrera(Carrera carrera);
    void agregarCarrera(String csv) throws IOException;


    Carrera obtenerCarreraPorId(int id);

    List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos();


    List<Carrera> obtenerTodasLasCarreras();

    void actualizarCarrera(Carrera carrera);

    void eliminarCarrera(int id);
}
