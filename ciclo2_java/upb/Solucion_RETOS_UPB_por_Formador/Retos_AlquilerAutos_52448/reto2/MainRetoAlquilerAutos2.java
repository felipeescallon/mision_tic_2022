/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package retoalquilerautos2;

//import clases.*;

import Cliente;
import Alquiler;
import Auto;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class MainRetoAlquilerAutos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Auto auto1 = new Auto("DBZ 645", 2, true);
        Auto auto2 = new Auto("DBZ 645", 2, false);
        
        Cliente cliente1 = new Cliente("101010", 18, "Andrés Alvarez");
        Cliente cliente2 = new Cliente("202020", 28, "Bernardo Bravo");
        Cliente cliente3 = new Cliente("303030", 38, "Camila Clavijo");
        
        /*Alquiler alquiler0 = new Alquiler(cliente1, auto1, LocalDate.parse("12-06-2021"), 48);
        Alquiler alquiler1 = new Alquiler(cliente2, auto1, LocalDate.parse("12-07-2021"), 30);
        Alquiler alquiler2 = new Alquiler(cliente1, auto2, LocalDate.parse("14-07-2021"), 25);
        Alquiler alquiler3 = new Alquiler(cliente3, auto1, LocalDate.parse("14-07-2021"), 12);
        Alquiler alquiler4 = new Alquiler(cliente1, auto1, LocalDate.parse("16-07-2021"), 8);
        */
        
        Alquiler alquiler0 = new Alquiler(cliente1, auto1, LocalDate.parse("2021-06-12"), 48);
        Alquiler alquiler1 = new Alquiler(cliente2, auto1, LocalDate.parse("2021-07-12"), 30);
        Alquiler alquiler2 = new Alquiler(cliente1, auto2, LocalDate.parse("2021-07-14"), 25);
        Alquiler alquiler3 = new Alquiler(cliente3, auto1, LocalDate.parse("2021-07-14"), 12);
        Alquiler alquiler4 = new Alquiler(cliente1, auto1, LocalDate.parse("2021-07-16"), 8);
        
        Alquiler[] alquileres = new Alquiler[5];//lista vacía de 5 (0-4) objetos alquileres (tipo Alquiler)
        
        alquileres[0]=alquiler0;
        alquileres[1]=alquiler1;
        alquileres[2]=alquiler2;
        alquileres[3]=alquiler3;
        alquileres[4]=alquiler4;
        
        Alquiler alquiler_prueba1 = new Alquiler(cliente1, auto1, LocalDate.parse("2021-08-19"), 8);
        System.out.println(alquiler_prueba1.ObtenerDescuento(alquileres));
        System.out.println("¡El anterior FUNCIONÓ porque dió 0 y se esperaba 0!");
        
        Alquiler alquiler_prueba2 = new Alquiler(cliente1, auto2, LocalDate.parse("2021-07-19"), 8);
        System.out.println(alquiler_prueba2.ObtenerDescuento(alquileres));
        System.out.println("¡El anterior FUNCIONÓ porque dió 0 y se esperaba 0!");
                
        Alquiler alquiler_prueba3 = new Alquiler(cliente1, auto1, LocalDate.parse("2021-07-19"), 26);
        System.out.println(alquiler_prueba3.ObtenerDescuento(alquileres));
        System.out.println("¡El anterior FUNCIONÓ porque dió 5 y se esperaba 5!");
                
        Alquiler alquiler_prueba4 = new Alquiler(cliente2, auto1, LocalDate.parse("2021-07-19"), 12);
        System.out.println(alquiler_prueba4.ObtenerDescuento(alquileres));
        System.out.println("¡El anterior FUNCIONÓ porque dió 2 y se esperaba 2!");
    }
    
}
