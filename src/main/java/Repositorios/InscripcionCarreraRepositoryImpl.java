package Repositorios;

import DTO.EstudianteDTO.EstudianteDTO;
import Entidades.InscripcionCarrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.InscripcionCarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class InscripcionCarreraRepositoryImpl implements InscripcionCarreraRepository {
    @Override
    public void agregarInscripcionCarrera(InscripcionCarrera inscripcion) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(inscripcion);
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
    public void agregarInscripcionCarrera(String csv) {

    }

    @Override
    public InscripcionCarrera obtenerInscripcionCarreraPorId(int id) {
        return null;
    }

    @Override
    public List<InscripcionCarrera> obtenerTodasLasInscripcionesCarrera() {
        return null;
    }

    @Override
    public List<EstudianteDTO> obtenerListaFiltrada(String ciudad, int idCarrera) {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();

        TypedQuery<EstudianteDTO> query = em.createQuery("SELECT NEW DTO.EstudianteDTO.EstudianteDTO(e.nombre,e.apellido,e.estudianteId.libretaUniversitaria,e.estudianteId.dni) FROM InscripcionCarrera i"
                +" INNER JOIN Estudiante e ON e = i.estudiante"
                +" WHERE e.ciudad = :ciudad AND i.carrera.id = :idCarrera", EstudianteDTO.class);
        query.setParameter("ciudad",ciudad);
        query.setParameter("idCarrera",idCarrera);

        return query.getResultList();
    }

    @Override
    public void actualizarInscripcionCarrera(InscripcionCarrera inscripcion) {

    }

    @Override
    public void eliminarInscripcionCarrera(int id) {

    }
}
