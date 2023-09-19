package Repositorios;

import Entidades.Carrera;
import Fabrica.MyEntityManagerFactory;
import Interfaces.CarreraRepository;
import jakarta.persistence.EntityManager;
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
