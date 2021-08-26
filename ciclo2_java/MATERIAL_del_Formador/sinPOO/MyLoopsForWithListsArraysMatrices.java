import java.util.ArrayList;//para usar un arrraylist similar a Python
import java.util.LinkedList;//para usar una lista enlazada como en Python
import java.util.Scanner;//para pedir datos al usuario

public class MyLoopsForWithListsArraysMatrices {

    public static void main(String[] args){

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
    
    int arregloDigitosA[] = new int[10];
    //int arregloDigitosA[]={0,0,0,0,0,0,0,0,0,0};//inicializo
    //int arregloDigitosA[]={0,1,2,3,4,5,6,7,8,9};//manualmente
    //System.out.println("arregloDigitos.length="+arregloDigitosA.length);
      
    //System.out.println("Imprimo el arreglo de 10 digitos:");
    
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
    System.out.println("https://www.lawebdelprogramador.com/foros/Java/522482-SABER-DIMENSIONES-DE-ARRAY-DE-DE-UNA-DIMENSION.html");
    System.out.println("");
    System.out.println("De las dos últimas URLs, tomo el ejemplo de: 'Uso de for-each para array de dos dimensiones' y lo adapto teniendo en cuenta el tamaño de la matriz para obtener lo siguiente:");
    
    // Uso de for-each para array de dos dimensiones

        int sum=0;
        //inicializo la matriz de 2x3
        //int nums[][]={{0,0,0},{0,0,0}};//matriz=array bidimensional (fila, columna) similar a lo visto en Python
        int nums[][] = new int[2][3];//creo en memoria de java una matriz vacía de 2x3
        //dando valores con dos ciclos (for anidados: un for dentro de otro para recorrer para cada fila toda las columnas)
        System.out.println("Dando valores con dos ciclos (for anidados: un for dentro de otro para recorrer para cada fila toda las columnas):");
        for (int i=0; i <2 ; i++)//2 filas
            for (int j=0; j<3; j++)//3 columnas
                nums[i][j]=(i+1)*(j+1);// 6 valores (fila, columna): 0<=i<=1 (i=0,1); 0<=j<=2 (j=0,1,2);
        
        //Muestro la matriz:
        System.out.println("Muestro la matriz:");
        for (int i=0; i <2 ; i++)//2 filas
            for (int j=0; j<3; j++)//3 columnas
                System.out.println("Valor de nums["+i+"]["+j+"]="+nums[i][j]);// 6 valores (fila, columna)       
                
        System.out.println("Uso de for-each para mostrar la suma total y luego calcular el promedio de los datos ingresados:");
        System.out.println("Recorriendo la matriz de izquierda a derecha y de arriba abajo (recorrido por filas):");
        //Uso de for-each para mostrar la suma total y luego calcular el promedio de los datos ingresados
        //Recorriendo la matriz de izquierda a derecha y de arriba abajo (recorrido por filas)
        for (int x[]:nums){//filas
            for (int y:x){//columnas
                System.out.println("---Subtotal = "+y);
                sum+=y;//voy acumulando la suma de los subtotales para dar el gran TOTAL
            }
        }
        System.out.println("Suma total= "+sum);   
        int num_filas = nums.length;
        int num_columnas = nums[0].length;
        int num_cols = nums[1].length;
        System.out.println("num_filas= "+num_filas);   
        System.out.println("num_columnas= "+num_columnas);
        System.out.println("num_cols= "+num_cols);      

        int cantidad_datos=num_filas*num_columnas;  


        System.out.println("Cantidad de datos= "+cantidad_datos);//tamaño de una matriz = #filas x #columnas   
        System.out.println("Promedio = Suma total / Cantidad de datos = "+sum+" / "+cantidad_datos+" = "+sum/cantidad_datos);   

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        System.out.println("ÚLTIMO EJEMPLO COMO SE TRABAJÓ EN PYTHON PARA PEDIRLE AL USUARIO EL NUMERO DE FILAS Y COLUMNAS DE UNA MATRIZ E IR LLENANDOLA CON LOS DATOS QUE EL MISMO INGRESE:");
        
        try{
            Scanner entrada = new Scanner(System.in);
            System.out.print("Ingrese el numero de filas(>=2) de la matriz:");
            int num_fil=entrada.nextInt();
            System.out.print("Ingrese el numero de columnas(>=2) de la matriz:");
            int num_col=entrada.nextInt();

            //tipo arreglo[] = new tipo[tamaño];//array unidimensional
            double matriz[][] = new double[num_fil][num_col];//array bidimensional = matriz
            double dato;

            System.out.println("Ingrese el valor de cada dato de la matriz:");
            for(int f=0; f<matriz.length; f++){
                for(int c=0; c<matriz[f].length; c++){
                    System.out.print("matriz["+f+"]["+c+"]= ");
                    dato=entrada.nextDouble();
                    matriz[f][c]=dato;
                }
            }

            double suma=0,promedio=0;

            System.out.println("Matriz ingresada:");
            for(int f=0; f<matriz.length; f++){
                for(int c=0; c<matriz[f].length; c++){
                    System.out.println("matriz["+f+"]["+c+"]="+matriz[f][c]);
                    suma=suma+matriz[f][c];
                }
            }
            int datos=matriz.length*matriz[0].length;
            System.out.println("La suma de todos los "+datos+" datos ingresados es:"+suma);
            System.out.println("El promedio resultante es:"+suma/datos);

                    
        }catch(Exception e){
            System.out.println("Error!");
        }



  }

}


