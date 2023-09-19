package Repositorios;

import Entidades.Carrera;
import Entidades.Estudiante;
import Fabrica.MyEntityManagerFactory;
import Interfaces.EstudianteRepository;
import jakarta.persistence.EntityManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    @Override
    public void agregarEstudiante(Estudiante estudiante) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Maneja la excepción o relánzala según tus necesidades
        } finally {
            em.close();
        }
    }

    @Override
    public void agregarEstudiante(String csv) throws IOException {
        String csvFilePath = System.getProperty("user.dir") + "/"+csv;
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for(CSVRecord row: parser) {
            Estudiante estudiante = new Estudiante(Integer.parseInt(row.get("dni")),Integer.parseInt(row.get("libreta")),row.get("nombre"),row.get("apellido"),Integer.parseInt(row.get("edad")),row.get("genero"),row.get("ciudad"));
            agregarEstudiante(estudiante);
        }
    }

    @Override
    public Estudiante obtenerEstudiantePorDNI(int dni) {
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return null;
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {

    }

    @Override
    public void eliminarEstudiante(int dni) {

    }
}
