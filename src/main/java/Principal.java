import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.InscripcionCarrera;
import Fabrica.MyEntityManagerFactory;
import Helper.HelperCSV;
import Interfaces.CarreraRepository;
import Interfaces.EstudianteRepository;
import Interfaces.InscripcionCarreraRepository;
import Repositorios.CarreraRespositoryImpl;
import Repositorios.EstudianteRepositoryImpl;
import Repositorios.InscripcionCarreraRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException {
//
        HelperCSV helper = new HelperCSV();
        helper.InsertarCSV("estudiante.csv", "carrera.csv");
//
//        Estudiante estudiante = new Estudiante(41724302, 200, "Agustin", "Carmu", 24, "Masculino", "Olavarria");
//        Carrera carrera = new Carrera();
//        carrera.setDuracion(6);
//        carrera.setNombre("Medicina");
//
//        InscripcionCarrera inscripcion = new InscripcionCarrera();
//        inscripcion.setEstudiante(estudiante);
//        inscripcion.setCarrera(carrera);
//        inscripcion.setGraduado(false);
//        inscripcion.setAntiguedad(5);
//
//        CarreraRepository cr = new CarreraRespositoryImpl();
//        EstudianteRepository er = new EstudianteRepositoryImpl();
//        InscripcionCarreraRepository icr = new InscripcionCarreraRepositoryImpl();
//
//        cr.agregarCarrera(carrera);
//        er.agregarEstudiante(estudiante);
//        icr.agregarInscripcionCarrera(inscripcion);

//        EstudianteRepository er = new EstudianteRepositoryImpl();
//        System.out.println(er.obtenerTodosLosEstudiantes("dni").toString());
//        System.out.println("-----------------------------");
//        System.out.println(er.obtenerEstudiantePorLibreta(584));


    }
}