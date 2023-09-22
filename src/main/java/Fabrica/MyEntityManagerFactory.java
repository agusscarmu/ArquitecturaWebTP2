package Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManagerFactory {
    private final EntityManagerFactory emf;

    private MyEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("integrador2");
    }

    private static class SingletonHelper {
        private static final MyEntityManagerFactory INSTANCE = new MyEntityManagerFactory();
    }

    public static MyEntityManagerFactory getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

