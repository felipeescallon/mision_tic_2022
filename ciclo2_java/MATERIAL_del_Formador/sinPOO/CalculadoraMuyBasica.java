//LINK PARA COMPLEMENTAR EL TEMA DE EXCEPCIONES EN JAVA:
//http://puntocomnoesunlenguaje.blogspot.com/2014/04/java-excepciones.html

import java.util.Scanner;

public class CalculadoraMuyBasica{
    public static void main(String args[]){
        
       try{
      
        System.out.println("¡Calculadora muy Basica!");
        System.out.println("MENU:");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");

        Scanner sc=new Scanner(System.in);
        
        System.out.print("Seleccione una opción: ");
        int opcion=sc.nextInt();//puede lanzar una excepción (capturo el error con try-catch)
        
        System.out.print("Ingrese primer número: ");//pueden lanza una excepción (capturo el error con try-catch)
        float n1=sc.nextFloat();

        System.out.print("Ingrese segundo número: ");//puede lanzar una excepción (capturo el error con try-catch)
        float n2=sc.nextFloat();

        System.out.println("Los resultados de la operación seleccionada son:");

        if (opcion==1) System.out.println("SUMA: "+ (n1+n2));
        if (opcion==2) System.out.println("RESTA: "+ (n1-n2));
        if (opcion==3) System.out.println("MULTIPLICAR: "+ (n1*n2));
        if (opcion==4) System.out.println("DIVIDIR: "+ (n1/n2));//División por cero muestra Infinity

    
    }
    catch (Exception e){
        System.out.println("Error");//conversión o distintos tipos de datos
    }    
    finally{
        System.out.println("Siempre se ejecuta esta línea!!!");
    }
    


    }
}
