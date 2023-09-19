import Entidades.Carrera;
import Fabrica.MyEntityManagerFactory;
import Helper.HelperCSV;
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

        HelperCSV helper = new HelperCSV();
        helper.InsertarCSV("estudiante.csv", "carrera.csv");
//        EstudianteRepository er = new EstudianteRepositoryImpl();
//        System.out.println(er.obtenerTodosLosEstudiantes("dni").toString());
//        System.out.println("-----------------------------");
//        System.out.println(er.obtenerEstudiantePorLibreta(584));


    }
}