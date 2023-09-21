package Repositorios;

import DTO.EstudianteDTO.EstudianteDTO;
import DTO.EstudianteDTO.EstudianteLibretaDTO;
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
    public EstudianteLibretaDTO obtenerEstudiantePorLibreta(int libreta) {
        try (EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager()) {
            TypedQuery<EstudianteLibretaDTO> query = em.createQuery(
                    "SELECT NEW DTO.EstudianteDTO.EstudianteLibretaDTO(e.nombre,e.apellido,e.estudianteId.libretaUniversitaria)"
                            +" FROM Estudiante e WHERE e.estudianteId.libretaUniversitaria = :libreta", EstudianteLibretaDTO.class);
            query.setParameter("libreta", libreta);

            // Realiza la consulta y obtén el resultado
            EstudianteLibretaDTO estudiante = query.getSingleResult();

            return estudiante;
        } catch (Exception e) {
            System.out.println("No existe un alumno con libreta: "+libreta);
            // Manejar el caso en el que no se encuentra ningún estudiante con ese número de libreta
            return null;
        }
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes(String criterioOrdenamiento) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        String jpql = "SELECT NEW DTO.EstudianteDTO.EstudianteDTO(e.nombre,e.apellido,e.estudianteId.libretaUniversitaria,e.estudianteId.dni) FROM Estudiante e";


        if ("nombre".equals(criterioOrdenamiento)) {
            jpql += " ORDER BY e.nombre";
        } else if ("apellido".equals(criterioOrdenamiento)) {
            jpql += " ORDER BY e.apellido";
        } else if ("dni".equals(criterioOrdenamiento)) {
            jpql += " ORDER BY e.estudianteId.dni";
        }

        TypedQuery<EstudianteDTO> query = em.createQuery(jpql, EstudianteDTO.class);

        return query.getResultList();
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantesPorGenero(String genero) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();

        TypedQuery<EstudianteDTO> query = em.createQuery("SELECT NEW DTO.EstudianteDTO.EstudianteDTO(e.nombre,e.apellido,e.estudianteId.libretaUniversitaria,e.estudianteId.dni) FROM Estudiante e WHERE e.genero= :genero", EstudianteDTO.class);
        query.setParameter("genero",genero);

        return query.getResultList();
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {

    }

    @Override
    public void eliminarEstudiante(int dni) {

    }
}
