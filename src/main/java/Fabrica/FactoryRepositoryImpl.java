package Fabrica;

import Interfaces.CarreraRepository;
import Interfaces.EstudianteRepository;
import Interfaces.FactoryRepository;
import Interfaces.InscripcionCarreraRepository;
import Repositorios.CarreraRespositoryImpl;
import Repositorios.EstudianteRepositoryImpl;
import Repositorios.InscripcionCarreraRepositoryImpl;

public class FactoryRepositoryImpl implements FactoryRepository {
    private static FactoryRepositoryImpl instancia;
    private final CarreraRepository cr;
    private final EstudianteRepository er;
    private final InscripcionCarreraRepository icr;

    private FactoryRepositoryImpl(){
        cr=new CarreraRespositoryImpl();
        er=new EstudianteRepositoryImpl();
        icr=new InscripcionCarreraRepositoryImpl();
    }

    public static FactoryRepositoryImpl getInstancia(){
        if(instancia==null){
            instancia = new FactoryRepositoryImpl();
        }
        return instancia;
    }


    @Override
    public CarreraRepository getCarreraRepository() {
        return cr;
    }

    @Override
    public EstudianteRepository getEstudianteRepository() {
        return er;
    }

    @Override
    public InscripcionCarreraRepository getInscripcionCarreraRepository() {
        return icr;
    }
}
