package Repositorios;

import Entidades.Carrera;
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

            // Primero, verifica si la entidad Carrera está en estado "managed" o "detached".
            Carrera carrera = inscripcion.getCarrera();
            if (!em.contains(carrera)) {
                // Si la entidad Carrera está en estado "detached", vuelva a cargarla.
                carrera = em.merge(carrera); // Fusiona la entidad Carrera con la sesión actual
                inscripcion.setCarrera(carrera); // Actualiza la referencia en InscripcionCarrera
            }

            // Ahora, persiste la entidad InscripcionCarrera.
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
