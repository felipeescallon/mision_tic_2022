import java.util.Scanner;//se necesita importar la clase Scanner que está dentro del paquete java.util para leer datos por teclado


public class CalculadoraBasicaSinPoo{

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

    public static void main(String[] args)
    {
        System.out.println("Operaciones:");

        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        
        System.out.println("Digite la opción de la operación deseada:");
	
	      Scanner lector = new Scanner(System.in);//se crea un objeto ("variable") de tipo Scanner (clase)
	      int opcion=lector.nextInt();//con el objeto accedo al método nextInt() para leer un entero
        
        //Scanner lector1 = new Scanner(System.in);//se crea un objeto ("variable") de tipo Scanner (clase)
        System.out.println("Escriba su nombre:");
        //String nombre=lector1.next();//con el objeto accedo al método next() para leer una cadena
        String nombre=lector.next();//con el objeto accedo al método next() para leer una cadena
        System.out.println("El nombre ingresado es: "+nombre);

        System.out.println("Ingrese número 1:");
	      float n1=lector.nextFloat();//con el objeto accedo al método nextLine() para leer un número decimal (float)

        System.out.println("Ingrese número 2:");
	      float n2=lector.nextFloat();//con el objeto accedo al método nextLine() para leer un número decimal (float)

        if (opcion==1){
          System.out.println(n1 + "+" + n2 + "=" + sumar(n1,n2));
        }
        
		    if (opcion==2){
          System.out.println(n1 + "-" + n2 + "=" +restar(n1,n2));
        }

		    if (opcion==3){
        System.out.println(n1 + "*" + n2 + "=" +multiplicar(n1,n2));
        }
		    
        if (opcion==4){
          
          //while(n2!=0){
          //  System.out.println(n1 + "/" + n2 + "=" +dividir(n1,n2));
          //}
          
          if(n2==0) {
            System.out.println("No es posible dividir entre cero!");
          } 
          else
          {
            System.out.println(n1 + "/" + n2 + "=" +dividir(n1,n2));
          }  
          
      }
              
    }

  }
