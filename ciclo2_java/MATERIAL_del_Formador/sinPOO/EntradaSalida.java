import java.util.Scanner;

public class EntradaSalida{

    public static void main(String[] args){
        //int numero=5;    
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una cadena: ");
        String cadena = sc.next();
        System.out.println("El dato ingresado es: "+cadena);

        }

    }