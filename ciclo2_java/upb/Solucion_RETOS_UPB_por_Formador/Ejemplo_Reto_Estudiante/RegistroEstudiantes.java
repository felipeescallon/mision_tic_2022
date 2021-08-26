/*
 */
//package edu.upb.proy02_8am;

/**
 *
 * @author Jorge
 */
import java.util.ArrayList;
//import edu.upb.proy02_8am.*;
public class RegistroEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       final String[] IDS = {"001", "002", "003"};
       final String[] NOMBRES = {"Maria", "Gabriel", "Miguel"};
       final boolean[] SUB_INCLUSION = {false, true, false};
       ArrayList<Estudiante> estudiantes = new ArrayList<>();
       ArrayList<Double> promsCredito;
       
       promsCredito = Estudiante.calcPromsCredito(estudiantes);
       if (promsCredito == null)
          System.out.println("\t*** No se han ingresado estudiantes a la lista ***");
       // Crea la ArrayList estudiantes
       for (int i = 0; i < IDS.length; i++) {
          Estudiante unEstudiante = new Estudiante(IDS[i], NOMBRES[i], SUB_INCLUSION[i]);
          estudiantes.add(unEstudiante);
       }
       
       promsCredito = Estudiante.calcPromsCredito(estudiantes);
       int i = 0;
       double unPromCred;
       System.out.println("\tId  Nombre\tSub. Incl.\tProm-Cred");
       for (Estudiante unEstudiante : estudiantes) {
          unPromCred = promsCredito.get(i);
          System.out.format("\t%s\t\t%.2f%n", unEstudiante.toString(), unPromCred);
          i++;
       }
    }   
}
