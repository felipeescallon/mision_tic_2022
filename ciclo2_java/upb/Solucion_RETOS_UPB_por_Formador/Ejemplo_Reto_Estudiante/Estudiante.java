/*
 */
/**
 *
 * @author Jorge
 */
//package edu.upb.proy02_8am;
import java.util.ArrayList;
public class Estudiante {
   private String id;
   private String nombre;
   private boolean subsidioInclusion;
   
   public Estudiante(String _id, String _nombre, boolean _subsidioInclusion) {
      id = _id;
      nombre = _nombre;
      subsidioInclusion = _subsidioInclusion;
   }
   
   public static ArrayList<Double> calcPromsCredito(ArrayList<Estudiante> estudiantes) {
      final int CREDITOS_POR_MATERIA = 3;       // Se asume
      final double MAX_CALIF = 5.0;
      final double VALOR_SUBSIDIO = 0.05;       // Para estudiantes de regiones marginadas, minorias, etc.
      
      ArrayList<Double> gpas = new ArrayList<>();
      
      if (estudiantes.isEmpty())
         return null;
      
      double unGPA;
      double unaCalif;
      double acumulado;
      int numMaterias;
      int totalCred;
      for (Estudiante unEstudiante : estudiantes) {
         acumulado = 0.0;
         totalCred = 0;
         numMaterias = (int)Math.round(5*Math.random()) + 1;    // Un # aleatorio en [1, 6]
         for (int i = 1; i <= numMaterias; i++) {               // Para un # aleatorio en [a, b]: (b-a)*NumRand + a
            unaCalif = 1.5 * Math.random() + 3.5;               // Se asume: Todas las calificaciones en [3.5, 5]
            acumulado += unaCalif * CREDITOS_POR_MATERIA;
            totalCred += CREDITOS_POR_MATERIA;
         }
         unGPA = acumulado / totalCred;
         unGPA += (unEstudiante.subsidioInclusion && (unGPA+VALOR_SUBSIDIO) <= MAX_CALIF) ? VALOR_SUBSIDIO : 0.0;
         gpas.add(unGPA);
      }
      return gpas;
   }
   
   @Override //sobrescrito de la clase object
   public String toString() {
      String unEstudiante;
      String subInclusion = (subsidioInclusion) ? "Si" : "No";
      unEstudiante = id + " " + nombre + "\t" + subInclusion;
      return unEstudiante;
   }
}
