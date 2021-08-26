/*

RETO #1 DEL CICLO 2 (Programación en Java-SQL-MVC)
PROGRAMA MISION TIC 2022
Autor Ing. Andrés Felipe Escallón Portilla (30 de Julio de 2021)

HE SOLUCIONADO EL RETO DENTRO DE MI ROL COMO FORMADOR DE DICHO PROGRAMA LABORANDO CON EL MINISTERIO TIC  (MinTIC) DE COLOMBIA 
Y CON LA UNIVERSIDAD PONTIFICIA BOLIVARIANA DE MEDELLIN

El requerimiento del Reto#1 se puede encontrar aquí:
https://drive.google.com/drive/folders/1OyQn_GYc-6l1dKt1-5tmNMc6abJO5DNq?usp=sharing

*/

import java.util.ArrayList;//necesario para manejar ArrayList

public class PrincipalEmpleado{

    public static void main(String[] args){
        
        Empleado empleado_pruebaA = new Empleado();        
        System.out.println("Invocando el método String toString() desde el método main: directamente/implícitamente con System.out.println(objeto);:");
         //Mostramos la informacion del objeto de dos maneras equivalentes:
        System.out.println("Directamente/implícitamente: "+empleado_pruebaA);//Directamente/implícitamente
        System.out.println("Invocando explícitamente System.out.println(objeto.toString());: "+empleado_pruebaA.toString());//Invocando explícitamente
        
        Empleado empleado_pruebaB = new Empleado(1,"Andrés",500000,true,3000000);
        Empleado empleado_pruebaC = new Empleado("Felipe",1500000,false,13500000);
        
        //Defino cada objeto emnpleado y luego los agrego a una lista de Empleados
        Empleado empleado1 = new Empleado("Carmen",40000,true,1500000);
        Empleado empleado2 = new Empleado("Pablo",25000,true,1200000);
        Empleado empleado3 = new Empleado("Laura",50000,false,2000000);

        
        //Defino la lista de empleados vacía:
        ArrayList<Empleado> empleados = new ArrayList<>();
        //Agrego cada empleado a la lista
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        //Aqui la lista de empleados contiene tres objetos de tipo Empleado (3 empleados)
        
        
        //Recorro la lista de empleados
        for (Empleado empleado : empleados) {
            //System.out.println("Empleado: "+empleados.get(empleado).retornarValoresAtributoSinId());for(int i=0; i<empleados.size(); i++)
            System.out.println("\n Empleado CON for each: "+empleado.retornarValoresAtributoSinId());
        }
        
        
  
        for(int i=0; i<empleados.size(); i++){
            System.out.println("\n Empleado SIN for each: "+empleados.get(i).retornarValoresAtributoSinId());//este es para un for(int i=0; i<empleados.size(); i++)

        }

          
        //CREO UN OBJETO CON EL CONSTRUCTOR VACIO (como si fuera el tesorero que llama a la función liquidarNominaEmp):
        Empleado tesorero = new Empleado();
        //Defino un ArrayList de tipo Double para recibir la lista de la nomina que retorna la función:
        ArrayList<Double> nominas = new ArrayList<>();//defino una lista de nominas vacía (null)
        nominas = tesorero.liquidarNominaEmp(empleados);        

        //Ahora con un cilo for each recorro los empleados y con otro for each la nomina de cada uno, y con eso se soluciona este reto:              


        //Recorro la lista de nominas
        for (double nomina : nominas) {
            System.out.println("\n Nomina del Empleado CON for each, respectivamente: "+nomina);
        }

        for(int j=0; j<nominas.size(); j++){
            System.out.println("\n Nomina del Empleado SIN for each, respectivamente: "+nominas.get(j));
        }
    
        //FUNCIONA BIEN CON LA LISTA DE EMPLEADOS LLENA!!!
        System.out.println("\n FUNCIONA BIEN CON LA LISTA DE EMPLEADOS LLENA");

        //PROBEMOS AHORA PASANDOLE UNA LISTA DE EMPLEADOS VACIA (null) PORQUE DEBEN RETORNAR UNA LISTA DE NOMINAS VACIA (null)
        System.out.println("\n PROBEMOS AHORA PASANDOLE UNA LISTA DE EMPLEADOS VACIA (null) PORQUE DEBEN RETORNAR UNA LISTA DE NOMINAS VACIA (null)");
        //Defino la lista de empleados vacía:
        ArrayList<Empleado> empleados_vacia = new ArrayList<Empleado>();            
                      
        
        //Defino un ArrayList de tipo Double para recibir la lista de la nomina que retorna la función:
        ArrayList<Double> nominas_vacia = new ArrayList<Double>();//defino una lista de nominas vacía (null)
        nominas_vacia = tesorero.liquidarNominaEmp(empleados_vacia);
                
        if (nominas_vacia==null){
                System.out.println("¡La nomina está vacía porque la lista de empleados está vacía!");

            }     

        System.out.println("\n TAMBIÉN FUNCIONÓ CORRECTAMENTE CON LA LISTA DE EMPLEADOS VACÍA.");
        System.out.println("\n QUEDA PENDIENTE REALIZAR LAS PRUEBAS UNITARIAS PARA LA FUNCIÓN LIQUIDAR NÓMINA CON JUNIT...");

        
    }
    
}