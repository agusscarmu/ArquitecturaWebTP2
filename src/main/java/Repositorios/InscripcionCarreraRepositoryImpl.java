package Repositorios;

import Entidades.InscripcionCarrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.InscripcionCarreraRepository;
import jakarta.persistence.EntityManager;

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
    public void actualizarInscripcionCarrera(InscripcionCarrera inscripcion) {

    }

    @Override
    public void eliminarInscripcionCarrera(int id) {

    }
}
