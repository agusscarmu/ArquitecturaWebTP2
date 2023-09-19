package Repositorios;

import Entidades.Carrera;
import Entidades.Estudiante;
import Fabrica.MyEntityManagerFactory;
import Interfaces.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
            em.close();
        }
    }

    @Override
    public void agregarEstudiante(String csv) throws IOException {

    }

    @Override
    public Estudiante obtenerEstudiantePorLibreta(int libreta) {
        try (EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager()) {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :libreta", Estudiante.class);
            query.setParameter("libreta", libreta);

            // Realiza la consulta y obtén el resultado
            Estudiante estudiante = query.getSingleResult();

            return estudiante;
        } catch (Exception e) {
            // Manejar el caso en el que no se encuentra ningún estudiante con ese número de libreta
            return null;
        }
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes(String criterioOrdenamiento) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        String jpql = "SELECT e FROM Estudiante e ORDER BY ";


        if ("nombre".equals(criterioOrdenamiento)) {
            jpql += "e.nombre";
        } else if ("apellido".equals(criterioOrdenamiento)) {
            jpql += "e.apellido";
        } else if ("dni".equals(criterioOrdenamiento)) {
            jpql += "e.dni";
        } else {
            jpql = "SELECT e FROM Estudiante e";
        }

        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);

        return query.getResultList();
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {

    }

    @Override
    public void eliminarEstudiante(int dni) {

    }
}
