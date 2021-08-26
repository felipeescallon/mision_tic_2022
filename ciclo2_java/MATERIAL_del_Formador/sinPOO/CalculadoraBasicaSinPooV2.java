import java.util.Scanner;//se necesita importar la clase Scanner que está dentro del paquete java.util para leer datos por teclado

public class CalculadoraBasicaSinPooV2{

    //Cuando estemos con POO (Programación Orientada a Objetos), 
    //aquí se deben declarar los atributos (características) de la clase (son como las "variables" de la clase)

    //métodos (funciones u operaciones)

    //aquí defino las funciones de la calculadora:

        /*
        RECORDAR COMO SE HACIA EN PYTHON PARA CONTRASTARLO CON JAVA:
            def float sumar(num1,num2):
                return num1+num1
        */
    public static float sumar(float num1,float num2)
    {     
      return num1+num2;                 
    }

    public static float restar(float num1,float num2)
    {     
      return num1-num2;                 
    }
    
    public static float multiplicar(float num1,float num2)
    {     
      return num1*num2;                 
    }
        
    public static float dividir(float num1,float num2)
    {     
      return num1/num2;                 
    }

    public static void imprimirDivision(float n1, float n2)
    {     
        System.out.println("DIVIDIR: "+ n1 + " / " + n2 + " = " +dividir(n1,n2));                 
    }

    public static void imprimirDivisionCero()
    {     
        System.out.println("No es posible dividir entre cero!");
    }
    
    
    
    public static void imprimirMenu()
    {     
        System.out.println("Operaciones:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
    }
    

    public static void main(String[] args)
    {
      System.out.println(5.3+6.2);//esta es una operación correcta entre dos decimales
      //System.out.println(5,3+6,2);//los float se los debe poner con coma solo cuando se los pidas por consola
      //quiero monitorear por si java lanza una excepción (problema de compilación que se atrapa como un mensaje de error en el catch después de cerrar el bloque del try)   
      try
      {

        // aquí llamo o invoco a las funciones definidas antes del main (debajo de la clase):
        imprimirMenu();

        //PIDO LOS DATOS AL USUARIO      
	
	    Scanner lector = new Scanner(System.in);//se crea un objeto ("variable") de tipo Scanner (clase)
	    
      System.out.print("Ingrese su frase favorita: ");
      String frase=lector.nextLine();
      System.out.println("Su frase favorita es: "+frase);

      System.out.print("Digite la opción de la operación deseada: ");
      int opcion=lector.nextInt();//con el objeto accedo al método nextInt() para leer un entero
        
        System.out.print("Ingrese el primer número: ");
	    float n1=lector.nextFloat();//con el objeto accedo al método nextLine() para leer un número decimal (float)        
        System.out.print("Ingrese el segundo número: ");
	    float n2=lector.nextFloat();//con el objeto accedo al método nextLine() para leer un número decimal (float)

        boolean cero;
        cero=(n2==0);//true or false

	    switch (opcion)
	    {
		    case 1: System.out.println("SUMAR: " + n1 + " + " + n2 + " = " + sumar(n1,n2)); break;
		    case 2: System.out.println("RESTAR: "+ n1 + " - " + n2 + " = " +restar(n1,n2)); break;
		    case 3: System.out.println("MULTIPLICAR: "+ n1 + " * " + n2 + " = " +multiplicar(n1,n2)); break;		    
		    case 4: 
                if (!cero) imprimirDivision(n1,n2);//imprimirDivisionCero();
                else imprimirDivisionCero();//imprimirDivision(n1,n2);
                break;
            default: System.out.println("Opción inválida!"); break;
	    }

    }
    //aquí atrapo las excepciones
    catch(Exception e){
      System.out.println("Error!!!");
    }
    //este finally es opcional
    finally{
      System.out.println("Sin importar lo que suceda antes(haya o no haya excepción 'error'), SIEMPRE se ejecuta el finally!");
      System.out.println("TAREA---Reforzar loops (ciclos) en java visitando: ");
      System.out.println("https://www.youtube.com/watch?v=OzH9KPHdTQQ&list=PL_Gken4TwEnv-apZQsT27qwb_LbNPKikS");
      System.out.println("https://www.youtube.com/channel/UCB71XGdKnhBVDN-9SikOxFQ");
    }


    }
              
}
