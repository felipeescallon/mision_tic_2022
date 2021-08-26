//URL:
//https://www.delftstack.com/es/howto/java/how-to-check-type-of-a-variable-in-java/#:~:text=Podemos%20comprobar%20el%20tipo%20de,llamando%20al%20m%C3%A9todo%20getClass().&text=Este%20m%C3%A9todo%20s%C3%B3lo%20puede%20ser,primero%20la%20primitiva%20a%20Objeto
public class VerificacionTipoDatoJava {
    public static void main(String args[]) {
        
        String str = "Sample String";
        System.out.println("Como se declaró str como String y tiene guardada una cadena, verificando el tipo de dato de str en java, arroja diciendo que str es de tipo: " +str.getClass().getSimpleName());
        
        String[] arr = new String[5];
        System.out.println("Como se declaró arr como un array de tipo String , verificando el tipo de dato de arr en java, arroja diciendo que str es de tipo: " +arr.getClass().getSimpleName());
        
        int x = 5;        
        System.out.println("Como se declaró x como un entero y tiene guardado un número entero, verificando el tipo de dato de x en java, arroja diciendo que x es de tipo: " +((Object)x).getClass().getSimpleName());

    }
}