package Repositorios;

import DTO.EstudianteDTO.EstudianteDTO;
import DTO.InscripcionCarreraDTO.CarreraReporteDTO;
import Entidades.InscripcionCarrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.InscripcionCarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
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
    public List<CarreraReporteDTO> obtenerReporte() {
        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();
        List<CarreraReporteDTO> lista = new ArrayList<>();
        try {
            for(int y=1990;y<2024;y++) {
                TypedQuery<CarreraReporteDTO> query = em.createQuery(
                        "SELECT NEW DTO.InscripcionCarreraDTO.CarreraReporteDTO(c.nombre, YEAR(i.fechaInscripcion), COUNT(i), COUNT(e)) " +
                                "FROM InscripcionCarrera c " +
                                "LEFT JOIN c.inscripciones i " +
                                "LEFT JOIN c.egresados e " +
                                "GROUP BY c.nombre, YEAR(i.fechaInscripcion) " +
                                "ORDER BY c.nombre ASC, YEAR(i.fechaInscripcion) ASC", CarreraReporteDTO.class);

                lista.addAll(query.getResultList());
            }
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public void eliminarInscripcionCarrera(int id) {

    }
}
