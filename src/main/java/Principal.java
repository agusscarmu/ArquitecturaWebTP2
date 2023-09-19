import Entidades.Carrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.CarreraRepository;
import Interfaces.EstudianteRepository;
import Repositorios.CarreraRespositoryImpl;
import Repositorios.EstudianteRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException {
//        CarreraRepository cr = new CarreraRespositoryImpl();
////
////        cr.agregarCarrera("carrera.csv");
//
//        Carrera carrera = new Carrera("Verdulero", 2);
//        cr.agregarCarrera(carrera);

        EstudianteRepository er = new EstudianteRepositoryImpl();

        er.agregarEstudiante("estudiante.csv");
    }
}