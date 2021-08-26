import java.util.Scanner;

public class EntradaSalida2 {
   public static void main(String args[]) {
       
        Scanner lector = new Scanner(System.in);
        System.out.println("Digite una frase: ");
        String frase=lector.nextLine();//lee una frase
        //String frase=lector.next();//lee una sola palabra
        System.out.println("La frase digitada fue: "+frase);        
        lector.close();//sugerido(opcional)
   }
}
