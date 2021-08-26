/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package retocallcenter2;

//import clases.*;

import  Empleado;
import CallCenter;

import java.util.ArrayList;//necesario para manejar ArrayList

/**
 *
 * @author Administrador
 */
public class MainRetoCallCenter2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
                
        //Defino cada objeto emnpleado y luego los agrego a una lista de Empleados
        Empleado empleado1 = new Empleado("Carmen",40000,true,1500000);        
        Empleado empleado3 = new Empleado("Laura",50000,false,2000000);

        
        //Defino la lista de empleados vacía:
        ArrayList<Empleado> empleados = new ArrayList<>();
        //Agrego cada empleado a la lista 
        empleados.add(empleado1);
        
        empleados.add(empleado3);
        //Aqui la lista de empleados contiene tres objetos de tipo Empleado (3 empleados)
        
                  
        //CREO UN OBJETO CON EL CONSTRUCTOR VACIO (como si fuera el tesorero que llama a la función liquidarNominaEmp):
        CallCenter tesorero = new CallCenter();
        //Asigno los empleados a la lista del CallCenter
        tesorero.setEmpleados(empleados);
        //Defino un ArrayList de tipo Double para recibir la lista de la nomina que retorna la función:
        ArrayList<Double> nominas = new ArrayList<>();//defino una lista de nominas vacía (null)
        ArrayList<Double> prestaciones = new ArrayList<>();//defino una lista de prestaciones vacía (null)
        //nominas = tesorero.liquidarNominaEmp(empleados);//funciona con un objeto de la clase también   
        //prestaciones = tesorero.liquidarPrestacionesEmp(empleados);//funciona con un objeto de la clase también
        nominas = CallCenter.liquidarNominaEmp(empleados);//Directamente debo acceder con la clase y no es necesario con el objeto pues es un método static        
        prestaciones = CallCenter.liquidarPrestacionesEmp(empleados);//Directamente debo acceder con la clase y no es necesario con el objeto pues es un método static

        //Ahora con un cilo for each recorro los empleados y con otro for each la nomina de cada uno, y con eso se soluciona este reto:              


        //Recorro la lista de nominas
        for (double nomina : nominas) {
            System.out.println("\n Nomina del Empleado CON for each, respectivamente: "+nomina);
        }

        for(int j=0; j<nominas.size(); j++){
            System.out.println("\n Nomina del Empleado SIN for each, respectivamente: "+nominas.get(j));
        }
        
        System.out.println("...");
        
        //Recorro la lista de prestaciones
        for (double prestacion : prestaciones) {
            System.out.println("\n Prestaciones del Empleado CON for each, respectivamente: "+prestacion);
        }

        for(int k=0; k<prestaciones.size(); k++){
            System.out.println("\n Prestaciones del Empleado SIN for each, respectivamente: "+prestaciones.get(k));
        }
     
        System.out.println("...");
    
        //FUNCIONA BIEN CON LA LISTA DE EMPLEADOS LLENA!!!
        System.out.println("\n FUNCIONA BIEN CON LA LISTA DE EMPLEADOS LLENA");

        //PROBEMOS AHORA PASANDOLE UNA LISTA DE EMPLEADOS VACIA (null) PORQUE DEBEN RETORNAR UNA LISTA DE NOMINAS VACIA (null)
        System.out.println("\n PROBEMOS AHORA PASANDOLE UNA LISTA DE EMPLEADOS VACIA (null) PORQUE DEBEN RETORNAR UNA LISTA DE NOMINAS VACIA (null)");
        //Defino la lista de empleados vacía:
        ArrayList<Empleado> empleados_vacia = new ArrayList<>();            
        
        //CREO OTRO OBJETO CON EL CONSTRUCTOR VACIO (como si fuera el tesorero que llama a la función liquidarNominaEmp):
        CallCenter tesorero2 = new CallCenter();
        //Asigno los empleados a la lista del CallCenter
        tesorero2.setEmpleados(empleados_vacia);
        
        //Defino un ArrayList de tipo Double para recibir la lista de la nomina que retorna la función:
        ArrayList<Double> nominas_vacia = new ArrayList<>();//defino una lista de nominas vacía (null)
        ArrayList<Double> prestaciones_vacia = new ArrayList<>();//defino una lista de nominas vacía (null)
        //nominas_vacia = tesorero2.liquidarNominaEmp(empleados_vacia);//funciona con un objeto de la clase también
        //prestaciones_vacia = tesorero2.liquidarPrestacionesEmp(empleados_vacia);//funciona con un objeto de la clase también
        nominas_vacia = CallCenter.liquidarNominaEmp(empleados_vacia);//Directamente debo acceder con la clase y no es necesario con el objeto pues es un método static
        prestaciones_vacia = CallCenter.liquidarPrestacionesEmp(empleados_vacia);//Directamente debo acceder con la clase y no es necesario con el objeto pues es un método static
        
                
        if (nominas_vacia==null){
                System.out.println("¡La nomina está vacía porque la lista de empleados está vacía!");

            }     
        
        if (prestaciones_vacia==null){
                System.out.println("¡Las prestaciones están vacías porque la lista de empleados está vacía!");

            } 

        System.out.println("\n TAMBIÉN FUNCIONÓ CORRECTAMENTE CON LA LISTA DE EMPLEADOS VACÍA.");
        System.out.println("\n QUEDA PENDIENTE REALIZAR LAS PRUEBAS UNITARIAS PARA LAS FUNCIONES LIQUIDAR NÓMINA/PRESTACIONES CON JUNIT...");

    }
    
}
