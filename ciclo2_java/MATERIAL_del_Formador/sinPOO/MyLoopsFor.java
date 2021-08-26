import java.util.ArrayList;//para usar un arrraylist similar a Python
import java.util.LinkedList;//para usar una lista enlazada como en Python

public class MyLoopsFor {

    public static void main(String[] argas){

    //EJEMPLO 1 (digitos sin usar una lista)  con un ciclo for:
    System.out.println("EJEMPLO 1 (digitos sin usar una lista) con un ciclo for:");
    for (int digito=0; digito<=9; digito++)
    {
        System.out.println("Digito: "+ digito);
    } 

    //EJEMPLO 2 (lista de digitos) con un ciclo for:
    System.out.println("EJEMPLO 2 (lista de digitos):");
    LinkedList<Integer> listaDigitos = new LinkedList<Integer>();//se creó una lista vacía de enteros para luego agregar los digitos(0-9)
    System.out.println("Se ha creado una lista vacía.");
    
    //Lleno la lista con los digitos 0-9
    for (int digito=0; digito<=9; digito++)
    {
        listaDigitos.add(digito);
    }     
    System.out.println("¡En la memoria de Java, se ha llenado la lista con digitos (enteros del 0 al 9)!");
    //Imprimo los digitos de la lista que se llenó anteriormente
    System.out.println("Procedemos a imprimir los digitos de la lista que se llenó anteriormente:");
    for(int digito:listaDigitos)
    {
        System.out.println("Digito: "+digito);
    }
    System.out.println("TAREA EXTRA A): hacer el EJEMPLO 3 de un ciclo for con un arreglo de enteros (con digitos del 0-9)");
    System.out.println("SOLUCIÓN TAREA EXTRA:");
    
    System.out.println("Creo el arreglo de 10 digitos (tamaño=10):");
    int arregloDigitosA[]={0,0,0,0,0,0,0,0,0,0};//inicializo
    //int arregloDigitosA[]={0,1,2,3,4,5,6,7,8,9};//manualmente
    System.out.println("arregloDigitos.length="+arregloDigitosA.length);
      
    System.out.println("Imprimo el arreglo de 10 digitos:");
    for (int posicion=0; posicion<arregloDigitosA.length; posicion++)
    {
        arregloDigitosA[posicion]=posicion;//automaticamente de 0 a 9        
    }

    for (int digito:arregloDigitosA)
    {
        //System.out.println("arregloDigitos["+digito+"]="+arregloDigitosA[digito]+"");
        System.out.println("arregloDigitos["+digito+"]="+digito+"");                
    }

    
    System.out.println("TAREA EXTRA B): hacer el EJEMPLO 3 de un ciclo for con un arreglo de enteros (que las posiciones sean los digitos 0-9 y que los valores sean de 10 a 19)");
    System.out.println("SOLUCIÓN TAREA EXTRA B):");

    
    System.out.println("Creo el arreglo de 10 digitos (tamaño=10):");
    int arregloDigitosB[]={0,0,0,0,0,0,0,0,0,0};//inicializo
    //int arregloDigitosB[]={10,11,12,13,14,15,16,17,18,19};//manualmente
    System.out.println("arregloDigitos.length="+arregloDigitosB.length);
      
    System.out.println("Imprimo el arreglo de 10 digitos:");
    for (int posicion=0; posicion<arregloDigitosB.length; posicion++)
    {
        arregloDigitosB[posicion]=posicion+10;//automaticamente de 10 a 19        
    }

    /*for (int posicion=0; posicion<arregloDigitosB.length; posicion++)
    {
        System.out.println("arregloDigitos["+posicion+"]="+arregloDigitosB[posicion]+"");        
    }*/

    for (int digito_mas_10:arregloDigitosB)
    {
        //System.out.println("arregloDigitos["+digito+"]="+arregloDigitosA[digito]+"");
        System.out.println("arregloDigitos["+digito_mas_10+""+-10+"]="+digito_mas_10+"");                
    }


    System.out.println("TAREA EXTRA C): hacer el EJEMPLO 3 de un ciclo for con un arrayList(0-9))");
    System.out.println("SOLUCIÓN TAREA EXTRA C):");

    ArrayList array_list_digitos = new ArrayList();
    for (int d=0;d<10;d++){
        array_list_digitos.add(d);
    }

    for(int p=0;p<array_list_digitos.size();p++) {
        System.out.println("array_list_digitos["+p+"]="+array_list_digitos.get(p));
      }

    // Otro ejemplo de arreglo
    System.out.println("Otro ejemplo de arreglo:");
    Object[] arreglo = new Object[10];
    Integer[] arreglo2 = new Integer[10];

    for (int cont = 0; cont < arreglo.length; cont++){
        arreglo[cont]=cont;
    } 
    
    for (int con = 0; con < arreglo2.length; con++){
        arreglo2[con]=con+10;
    } 

    for (Object valor:arreglo){
        System.out.println("arreglo["+valor+"]="+valor);
    }
    for (Integer valor2:arreglo2){
        System.out.println("arreglo2["+valor2+"-10]="+valor2);
    }


    /*for (int cont = 0; cont < arreglo.length; cont++){
        System.out.println("arreglo["+cont+"]="+arreglo[cont]);
    }*/

    System.out.println("Mas información en:");
    System.out.println("https://es.stackoverflow.com/questions/62695/recorrer-arreglo-java-eficientemente");
    System.out.println("http://lineadecodigo.com/java/recorrer-un-arraylist/");
    System.out.println("https://javadesdecero.es/arrays/bucle-for-each/");


  }

}

