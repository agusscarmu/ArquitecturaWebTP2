package Repositorios;

import DTO.CarreraDTO.CarreraInscriptosDTO;
import Entidades.Carrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.CarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CarreraRespositoryImpl implements CarreraRepository {
    @Override
    public void agregarCarrera(Carrera carrera) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(carrera);
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
    public void agregarCarrera(String csv) throws IOException {

    }


    @Override
    public Carrera obtenerCarreraPorId(int id) {
        return null;
    }

    @Override
    public List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos() {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();

        try {
            TypedQuery<CarreraInscriptosDTO> query = em.createQuery(
                    "SELECT NEW DTO.CarreraDTO.CarreraInscriptosDTO(c.nombre, COUNT(i), c.duracion) " +
                            "FROM Carrera c " +
                            "LEFT JOIN c.inscripciones i " +
                            "GROUP BY c.nombre " +
                            "ORDER BY COUNT(i) DESC", CarreraInscriptosDTO.class);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Carrera> obtenerTodasLasCarreras() {
        return null;
    }

    @Override
    public void actualizarCarrera(Carrera carrera) {

    }

    @Override
    public void eliminarCarrera(int id) {

    }
}
