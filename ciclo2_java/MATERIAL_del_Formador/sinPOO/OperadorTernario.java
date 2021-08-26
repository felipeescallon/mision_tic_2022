import java.util.Scanner;

public class OperadorTernario{
    public static void main(String args[]) {
      
      Scanner sc=new Scanner(System.in);
      
          
      //declaro/inicializo
           
      boolean salir=false;//usando un do-while es el ejemplo ideal para al menos ejecutarse una vez y que luego el usuario tome la decisión de salir o no del mismo       
      boolean decision;//no es necesario inicializar , solo declarar pues en el ciclo tomará un valor  

      do {
          
          System.out.println("Salir= "+salir);
          System.out.print("¿Desea salir del programa (S/N)?: ");
          String seleccion=sc.next();//se declara y se asigna valor en una sola linea
          System.out.println("Seleccionaste= "+seleccion);
          
          //EJEMPLO DE OPERADOR TERNARIO:guardo en una variable booleana el resultado elegido por el usuario
          decision=((seleccion.equals("S"))?(!salir):salir);               
          System.out.println("Decision (salir)= "+decision);
          if (decision) salir=!salir; 

      } while(!decision);//en pregunta se guarda el estado de la condición dependiendo de la respuesta del usuario

      System.out.println("¡Se ha mostrado el uso del operador ternario con un ciclo do-while!");
      
      
    }
}