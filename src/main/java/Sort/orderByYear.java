package Sort;

import DTO.InscripcionCarreraDTO.CarreraReporteDTO;

import java.util.Comparator;

public class orderByYear implements Comparator<CarreraReporteDTO> {
    @Override
    public int compare(CarreraReporteDTO o1, CarreraReporteDTO o2) {
        return o1.getAnio()-o2.getAnio();
    }
}
