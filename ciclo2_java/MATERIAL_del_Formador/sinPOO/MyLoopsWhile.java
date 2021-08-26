import java.util.Scanner;

public class MyLoopsWhile{
    public static void main(String args[]) {
      
      Scanner sc=new Scanner(System.in);
      
      boolean condicion=(15>7);//true
      //boolean condicion=(15<7);//false: para probar que el while no se ejecuta ni una vez    
      
      while(condicion){
          
          System.out.println("Condición= "+condicion);
          System.out.print("¿Desea cambiar la condición anterior?...Presione Si o No:");
          String seleccion=sc.next();
          System.out.println("Seleccionaste="+seleccion);
          //if (seleccion=="Si") //no funciona asi para cadenas en java
          //if("Si".equals(seleccion)) // esta es otra altertativa que si funciona como la siguiente:
          if(seleccion.equals("Si"))
          {
            System.out.println("Condición anterior= "+condicion);
            condicion=(!condicion);
            System.out.println("Condición cambiada= "+condicion);
          }         


      } 

      System.out.println("TAREA 1: analizar el código y realizar este mismo programa pero usando un ciclo do-while");
      
      
    }
}