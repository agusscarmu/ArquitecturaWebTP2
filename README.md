Ejercicio Integrador 2
1) Considere el diseño de un registro de estudiantes, con la siguiente información: nombres, apellido, edad, género, número de documento, ciudad de residencia, número de libreta universitaria, carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras, y si se graduó o no. Diseñar el diagrama de objetos y el diagrama DER correspondiente.
2) Implementar consultas para:
   a) dar de alta un estudiante
   b) matricular un estudiante en una carrera
   c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
   d) recuperar un estudiante, en base a su número de libreta universitaria.
   e) recuperar todos los estudiantes, en base a su género.
   f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos. 
   g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
3) Generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.

1 - La consigna 1 se encuentra en la carpeta "Diagrams", dentro se encontraran los diagramas solicitados.

2 - 
a) Proporcionamos la funcion agregarEstudiante() en donde se pasa como parametro un Estudiante. Y tambien la funcion altaEstudiante() en donde se pasa por parametro todos los datos de un estudiante y el mismo se instancia dentro de la funcion. 

b) matricularEstudiante()

c) obtenerTodosLosEstudiantes(), por parametro debe pasarse el metodo de ordenamiento (nombre, apellido, dni, libreta universitaria). Si se utiliza la funcion sin pasarle por parametro ningun metodo de ordenamiento especifico, se ordenara por nombre.

d) obtenerEstudiantePorLibreta(), por parametro debe pasarse la libreta universitaria.

e) obtenerTodosLosEstudiantesPorGenero(), por parametro debe pasarse "Masculino" o "Femenino".

f) obtenerCarrerasConInscriptos().

g) obtenerListaFiltrada(), por parametro debe pasarse la ciudad y la carrera.

3 - obtenerReporte(). El reporte de las carreras se implemento en el repositorio de InscripcionCarrera. 