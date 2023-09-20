package Helper;

import Entidades.Carrera;
import Entidades.ClavesCompuestas.InscripcionId;
import Entidades.Estudiante;
import Entidades.InscripcionCarrera;
import Interfaces.CarreraRepository;
import Interfaces.EstudianteRepository;
import Interfaces.InscripcionCarreraRepository;
import Repositorios.CarreraRespositoryImpl;
import Repositorios.EstudianteRepositoryImpl;
import Repositorios.InscripcionCarreraRepositoryImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HelperCSV {
    private List<Estudiante> estudiantes;
    private List<Carrera> carreras;
    private List<InscripcionCarrera> inscripciones;
    private CarreraRepository cr;
    private EstudianteRepository er;
    private InscripcionCarreraRepository icr;

    public HelperCSV(){
        this.estudiantes = new LinkedList<>();
        this.carreras = new LinkedList<>();
        this.inscripciones = new LinkedList<>();
        this.cr = new CarreraRespositoryImpl();
        this.er = new EstudianteRepositoryImpl();
        this.icr = new InscripcionCarreraRepositoryImpl();
    }

    public void InsertarCSV(String csvEstudiante, String csvCarrera) throws IOException {
        String csvFilePath = System.getProperty("user.dir") + "/" + csvEstudiante;
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            Estudiante estudiante = new Estudiante(Integer.parseInt(row.get("dni")), Integer.parseInt(row.get("libreta")), row.get("nombre"), row.get("apellido"), Integer.parseInt(row.get("edad")), row.get("genero"), row.get("ciudad"));
            estudiantes.add(estudiante);
        }

        csvFilePath = System.getProperty("user.dir") + "/" + csvCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(row.get("nombre"), Integer.parseInt(row.get("duracion")));
            carreras.add(carrera);
        }

        assign();
    }

    private void assign(){
        Random r = new Random();
        for(Estudiante estudiante:estudiantes){
            int cantCarreras = r.nextInt(3);
            for(int i=0;i<cantCarreras;i++){
                int index = r.nextInt(carreras.size());
                Carrera carrera = carreras.get(index);

                int incripcionesEstudiante = estudiante.getInscripciones().size();
                int a=0;
                while (a<incripcionesEstudiante){
                    for(InscripcionCarrera inscr: estudiante.getInscripciones()){
                        if(inscr.getCarrera().equals(carrera)){
                            carrera = carreras.get(r.nextInt(carreras.size()));
                            a=0;
                        }
                    }
                    a++;
                }

                InscripcionCarrera ic = new InscripcionCarrera();
//
//                InscripcionId iId = new InscripcionId();
//                iId.setId(carrera.getId());
//                iId.setDni(estudiante.getEstudianteId().getDni());
//                iId.setLibretaUniversitaria(estudiante.getEstudianteId().getLibretaUniversitaria());
//                ic.setId(iId);

                ic.setEstudiante(estudiante);
                ic.setCarrera(carrera);
                ic.setAntiguedad(r.nextInt(10));
                ic.setGraduado(ic.getAntiguedad() > carrera.getDuracion());

                inscripciones.add(ic);
            }
        }
        insert();
    }

    private void insert(){
        for(Estudiante estudiante: estudiantes){
            er.agregarEstudiante(estudiante);
        }

        for(Carrera carrera: carreras){
            cr.agregarCarrera(carrera);
        }

        for(InscripcionCarrera inscripcion: inscripciones){
            icr.agregarInscripcionCarrera(inscripcion);
        }
    }
}
