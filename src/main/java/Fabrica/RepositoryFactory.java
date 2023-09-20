package Fabrica;

public class RepositoryFactory {
    private static RepositoryFactory instancia;

    private RepositoryFactory(){}

    public RepositoryFactory getInstancia(){
        if(instancia==null){
            instancia = new RepositoryFactory();
        }
        return instancia;
    }


}
