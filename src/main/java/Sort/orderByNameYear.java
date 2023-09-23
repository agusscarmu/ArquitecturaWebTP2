package Sort;

import DTO.InscripcionCarreraDTO.CarreraReporteDTO;

import java.util.Comparator;

public class orderByNameYear implements Comparator<CarreraReporteDTO> {

    private Comparator<CarreraReporteDTO>c1;
    private Comparator<CarreraReporteDTO>c2;
    public orderByNameYear(){
        this.c1 = new orderByName();
        this.c2 = new orderByYear();
    }
    @Override
    public int compare(CarreraReporteDTO o1, CarreraReporteDTO o2) {
        int c= c1.compare(o1, o2);
        if(c!=0){
            return c;
        }else{
            return c2.compare(o1, o2);
        }
    }
}
