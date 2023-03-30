package Operaciones;

import java.awt.Color;

public class Procesos {

private static final Persona[] ListaPersonas = null;

public String calcularDefinitiva(double promedio) {
String resultado="";
if(promedio>=3.5) {
resultado="Gana la materia";
}else {
resultado="pierde la materia";
}
return resultado;
}

public double calcularPromedio(Persona estudiante) {

System.out.println(estudiante.getNota1());
System.out.println(estudiante.getNota2());
System.out.println(estudiante.getNota3());

double prom =(estudiante.getNota1()+ estudiante.getNota2()+estudiante.getNota3());


estudiante.setPromedio(prom);


System.out.println(estudiante.getPromedio());

return estudiante.getPromedio();
}

public void ImprimirListaEstudiantes() {
for (Persona persona : ListaPersonas) {
System.out.println(persona);
}
}

}
