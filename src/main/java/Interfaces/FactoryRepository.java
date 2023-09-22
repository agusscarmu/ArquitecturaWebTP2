package Interfaces;

public interface FactoryRepository {

    CarreraRepository getCarreraRepository();
    EstudianteRepository getEstudianteRepository();
    InscripcionCarreraRepository getInscripcionCarreraRepository();
}
