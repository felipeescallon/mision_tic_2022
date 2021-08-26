import java.util.Scanner;

public class HelloWorldV4{

    public static String message(String mensaje)
    {     
      return mensaje;                 
    }
        
    public static void main(String[] args)
    {
      System.out.println("Ingrese un mensaje:");

      Scanner entrada = new Scanner(System.in);
      String msg=entrada.next();
      entrada.close();//esto es opcional
      
      System.out.println("El mensaje ingresado fue: "+message(msg));
    }
              
}