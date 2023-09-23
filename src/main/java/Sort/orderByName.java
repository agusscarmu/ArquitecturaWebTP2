package Sort;

import DTO.InscripcionCarreraDTO.CarreraReporteDTO;

import java.util.Comparator;

public class orderByName implements Comparator<CarreraReporteDTO> {
    @Override
    public int compare(CarreraReporteDTO o1, CarreraReporteDTO o2) {
        return o1.getNombreCarrera().compareTo(o2.getNombreCarrera());
    }
}
