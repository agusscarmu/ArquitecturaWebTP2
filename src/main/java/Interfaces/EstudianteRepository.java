package Interfaces;


import DTO.EstudianteDTO.EstudianteDTO;
import DTO.EstudianteDTO.EstudianteLibretaDTO;
import Entidades.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface EstudianteRepository{


    void agregarEstudiante(Estudiante estudiante);
    void agregarEstudiante(String csv) throws IOException;

    void altaEstudiante(int dni, int libreta, String nombre, String apellido, int edad, String genero, String ciudad);

    EstudianteLibretaDTO obtenerEstudiantePorLibreta(int libreta);


    List<EstudianteDTO> obtenerTodosLosEstudiantes(String criterioOrdenamiento);
    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    List<EstudianteDTO> obtenerTodosLosEstudiantesPorGenero(String genero);


    void actualizarEstudiante(Estudiante estudiante);


    void eliminarEstudiante(int dni);
}
