import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Prueba Práctica del examen de Java:
Se considera que un número es perfecto cuando es igual a la suma de todos sus divisores positivos 
(excepto él mismo).
Dado un número entero n, escriba una función llamada perfecto que reciba como parámetro n 
y que retorne Verdadero cuando n sea un número Perfecto y Falso cuando no lo sea.
Ejemplo:
Entrada: n=28
Función:
public boolean perfecto(int n)
{
    //lógica de la función
}
Salida:true
Explicación: 1 + 2 + 4 + 7 + 14 = 28

-Pruebas unitarias:
        System.out.println(perfecto(28));   //true
        System.out.println(perfecto(8));    //false
        System.out.println(perfecto(7));    //false
        System.out.println(perfecto(8128)); //true    
*/

public class ExamenJavaMisionTicUcaldas 
{
    public static void main(String[] args) throws Exception
    {        
        System.out.println(perfecto(28));   //true
        System.out.println(perfecto(8));    //false
        System.out.println(perfecto(7));    //false
        System.out.println(perfecto(8128)); //true                    
    }

    public static boolean perfecto(int n)
    {
        int sum = 0; //suma (acumulador)
     
        for (int c = 1; c < n; c++) //contador
        {
            if (n % c == 0) //n es divisible entre c
            {
                sum = sum + c;// sumando (acumulando) los divisores de n (desde 1 hasta antes de n)
            }
        }
     
        if (sum == n) //cuando la suma acumulada resulte igual a n, entonces se dice que n es un numero perfecto 
        {
            return true; // n es perfecto
        } 
        else 
        {
            return false; // n NO es perfecto
        }
    } 

}
