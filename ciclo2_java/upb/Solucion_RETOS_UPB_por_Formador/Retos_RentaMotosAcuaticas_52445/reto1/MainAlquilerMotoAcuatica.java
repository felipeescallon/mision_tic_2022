/*

RETO #1 DEL CICLO 2 (Programación en Java-SQL-MVC)
PROGRAMA MISION TIC 2022
Autor Ing. Andrés Felipe Escallón Portilla (30 de Julio de 2021)

HE SOLUCIONADO EL RETO DENTRO DE MI ROL COMO FORMADOR DE DICHO PROGRAMA LABORANDO CON EL MINISTERIO TIC  (MinTIC) DE COLOMBIA 
Y CON LA UNIVERSIDAD PONTIFICIA BOLIVARIANA DE MEDELLIN

El requerimiento del Reto#1 se puede encontrar aquí:
https://drive.google.com/drive/folders/1OyQn_GYc-6l1dKt1-5tmNMc6abJO5DNq?usp=sharing

*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

//import AlquilerMotoAcuatica;
import java.util.Scanner;//para pedir datos al usuario por teclado
/**
 *
 * @author Administrador
 */
public class MainAlquilerMotoAcuatica {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //AlquilerMotoAcuatica alquiler_moto_acuatica = new AlquilerMotoAcuatica();
        /*
        //INGRESO DE DATOS MANUALMENTE:
        
        int Id = 542;
        String CedulaCliente = "10031234";
        int AnoNacimientoCliente = 2016;
        String IdentificadorMoto = "QYD341";
        int HorasAlquiler = 5;
        
        AlquilerMotoAcuatica alquiler_moto_acuatica = new AlquilerMotoAcuatica(Id, CedulaCliente, AnoNacimientoCliente, IdentificadorMoto, HorasAlquiler);
        double prueba1 = alquiler_moto_acuatica.TerminarAlquiler(-15);
        System.out.println("prueba1: "+prueba1);
        double prueba2 = alquiler_moto_acuatica.TerminarAlquiler(5);
        System.out.println("prueba2: "+prueba2);
        double prueba3 = alquiler_moto_acuatica.TerminarAlquiler(7);
        System.out.println("prueba3: "+prueba3);
        double prueba4 = alquiler_moto_acuatica.TerminarAlquiler(8);
        System.out.println("prueba4: "+prueba4);
        */
        
        //INGRESO DE DATOS POR TECLADO:
        Scanner lectura = new Scanner(System.in);
        System.out.println("BIENVENIDO AL SISTEMA DE RENTA DE MOTOS ACUATICAS:");
        System.out.println("Ingrese Id: ");//542
        int Id = lectura.nextInt();
        
        System.out.println("Ingrese Cedula Cliente: ");
        String CedulaCliente = lectura.next();//10031234
        
        System.out.println("Ingrese Año Nacimiento Cliente: ");
        int AnoNacimientoCliente = lectura.nextInt();//2016
        
        System.out.println("Ingrese IdentificadorMoto: ");
        String IdentificadorMoto = lectura.next();//QYD341
        
        System.out.println("Ingrese Horas Alquiler: ");
        int HorasAlquiler = lectura.nextInt();//5
        
        AlquilerMotoAcuatica alquiler_moto_acuatica2 = new AlquilerMotoAcuatica(Id, CedulaCliente, AnoNacimientoCliente, IdentificadorMoto, HorasAlquiler);
        
        for(int i=0; i<4; i++){//son 4 pruebas (de i=0 a i=3)
            System.out.println("Ingrese cantidad Horas: ");
            int cantidadHoras = lectura.nextInt();//-15,5,7,8
            double prueba = alquiler_moto_acuatica2.TerminarAlquiler(cantidadHoras);
            System.out.println("prueba "+i+" : "+prueba);
        }               
                          
    }
    
}
