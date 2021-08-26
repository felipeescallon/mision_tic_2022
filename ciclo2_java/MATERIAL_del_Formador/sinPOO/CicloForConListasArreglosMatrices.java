import java.util.LinkedList;//para usar una lista enlazada como en Python
import java.util.ArrayList;//para usar un arrraylist similar a Python


public class CicloForConListasArreglosMatrices {

    public static void main(String[] args){

        LinkedList<Integer> linked_list_digits = new LinkedList<Integer>();//se creó una linkedList vacía de enteros para luego agregar en la posición (0-9) los valores de los digitos+10
        ArrayList array_list_digits = new ArrayList();//se creó una arrayList vacio de enteros para luego agregar en la posición (0-9) los valores de los digitos+10

        //Arreglo unidimensional de tipo entero en java:        
        int arreglo_digitos[] = new int[10];//java tomó esta sintaxis de lenguajes como C/C++
        //digitos (numeros enteros del 0-9, en total son 10): posiciones=0,1,2,3,4,5,6,7,8,9. Valores=0+10,1+10,...,8+10,9+10=10,11,...,18,19
        //int cero=0+10;
        //int cuatro=4+10;
        //int nueve=9+10;                 
        //trabajar con nueve variables se vuelve inmanejable
        
        //llenar las tres "listas" o "arreglos":
        for (int d=0;d<10;d++){//d es para referirse abreviadamente a digito
            linked_list_digits.add(d+10);//.append() se usaba en Python
            array_list_digits.add(d+10);//.append() se usaba en Python
            arreglo_digitos[d]=d+10;//similar a numpy en Pyhton
        }

        //mostrar los tres "arreglos" o "listas":
        for(int digit : linked_list_digits){
            System.out.println("Digito + 10 = "+digit);
        }                      

        for(int p=0;p<array_list_digits.size();p++) {
            System.out.println("array_list_digits["+p+"]="+array_list_digits.get(p));
          }

        for (int pos=0;pos<10;pos++){//p es para referirse abreviadamente a posición
            System.out.println("arreglo_digitos["+pos+"]="+arreglo_digitos[pos]);
        }

        /*Este es un ejemplo de una matriz (arrreglo bidimensional) de 3 (filas van de 0 a 2) x 3(columnas van de 0 a 2):
        [1,2,3]
        [4,5,6]
        [7,8,9]
        */
        
        System.out.println("TAREA EXTRA OPCIONAL: llenar y mostrar la matriz de 3x3 anterior sin/con pedirle datos al usuario y/o calculando la suma de todos los datos y el promedio");

    }

}
