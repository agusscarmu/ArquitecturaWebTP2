package Repositorios;

import DTO.EstudianteDTO.EstudianteDTO;
import DTO.InscripcionCarreraDTO.CarreraReporteDTO;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.InscripcionCarrera;
import Fabrica.FactoryRepositoryImpl;
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
            throw e;
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
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera) {
        InscripcionCarrera iC = new InscripcionCarrera();
        iC.setEstudiante(estudiante);
        iC.setCarrera(carrera);
        iC.setAnioInscripcion(java.time.LocalDate.now().getYear());
        iC.setAntiguedad(0);
        iC.setGraduado(iC.getAntiguedad()>carrera.getDuracion());
        estudiante.addInscripcion(iC);
        carrera.addInscripcion(iC);
        FactoryRepositoryImpl.getInstancia().getEstudianteRepository().agregarEstudiante(estudiante);
        FactoryRepositoryImpl.getInstancia().getCarreraRepository().agregarCarrera(carrera);

        agregarInscripcionCarrera(iC);
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera, int anioInscripcion) {
        InscripcionCarrera iC = new InscripcionCarrera();
        iC.setEstudiante(estudiante);
        iC.setCarrera(carrera);
        iC.setAnioInscripcion(anioInscripcion);

        int antiguedad = java.time.LocalDate.now().getYear() - anioInscripcion;
        iC.setGraduado(antiguedad>carrera.getDuracion());

        // Si la suma de la duración de la carrera y el año de inscripción es mayor que la fecha actual
        if (iC.isGraduado()) {
            iC.setAntiguedad(carrera.getDuracion());
        } else {
            iC.setAntiguedad(antiguedad);
        }

        estudiante.addInscripcion(iC);
        carrera.addInscripcion(iC);
        FactoryRepositoryImpl.getInstancia().getEstudianteRepository().agregarEstudiante(estudiante);
        FactoryRepositoryImpl.getInstancia().getCarreraRepository().agregarCarrera(carrera);

        agregarInscripcionCarrera(iC);
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
            for(int y=1990;y<java.time.LocalDate.now().getYear()+1;y++) {
                TypedQuery<CarreraReporteDTO> query = em.createQuery(
                        "SELECT NEW DTO.InscripcionCarreraDTO.CarreraReporteDTO(c.nombre, :y, " +
                                "(SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.anioInscripcion = :y), " +
                                "(SELECT COUNT(i) FROM InscripcionCarrera i WHERE i.carrera = c AND i.graduado = true AND (i.anioInscripcion + i.antiguedad) = :y)) " +
                                "FROM Carrera c", CarreraReporteDTO.class);


                query.setParameter("y", y);
                if(!query.getResultList().isEmpty()){
                    lista.addAll(query.getResultList()); //EL ERROR INDICA ESTA LINEA
                }
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
