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
        String csvFilePath = System.getProperty("user.dir") + "/"+csv;
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for(CSVRecord row: parser) {
            Carrera carrera = new Carrera(row.get("nombre"),Integer.parseInt(row.get("duracion")));
            agregarCarrera(carrera);
        }
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
