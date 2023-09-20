package Interfaces;


import Entidades.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface EstudianteRepository{

    // Método para guardar un estudiante en la base de datos
    void agregarEstudiante(Estudiante estudiante);
    void agregarEstudiante(String csv) throws IOException;

    // Método para obtener un estudiante por su número de DNI
    Estudiante obtenerEstudiantePorLibreta(int libreta);

    // Método para obtener todos los estudiantes
    List<Estudiante> obtenerTodosLosEstudiantes(String criterioOrdenamiento);

    List<Estudiante> obtenerTodosLosEstudiantesPorGenero(String genero);

    // Método para actualizar la información de un estudiante
    void actualizarEstudiante(Estudiante estudiante);

    // Método para eliminar un estudiante de la base de datos
    void eliminarEstudiante(int dni);
}
