import Entidades.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
        EntityManager em = emf.createEntityManager();

        List<Carrera> c = (List<Carrera>) em.createQuery("FROM Carrera").getResultList();

        System.out.println("Hay "+c.size() +" carreras ");
    }
}