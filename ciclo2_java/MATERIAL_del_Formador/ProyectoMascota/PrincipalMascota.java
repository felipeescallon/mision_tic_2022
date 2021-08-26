/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package mascota;

import Gato;
import Mascota;
import Perro;


import java.util.Scanner;


//import java.util.Scanner;//usado para pedir datos por teclado

/**
 *
 * @author Administrador
 */
public class PrincipalMascota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Mascota mascota = new Mascota(String codigo, String nombre, int anio_nacimiento, String color, String estadoSalud) {
        //Mascota mascota = new Mascota("001", "Firulais", 2010, "negro", "saludable");
        //Mascota mascota = new Mascota();
        
        //TAREA: fijarlos manualmente y/o pedirle al usuarios los datos por teclado:
        //String codigo="001";   
        //Scanner sc=new Scanner(System.in);
        //String codigo=sc.next();       
        //...
        
        //Mascota mascota = new Mascota(codigo, nombre, anio_nacimiento, color, estadoSalud)
        
        //Mascota mascota = new Mascota();
        System.out.println("\n MASCOTA:");
        Mascota mascota = new Mascota("001", "Firulais", 2010, "negro", "saludable");
        
        mascota.Comer();
        mascota.Movilizarse();
        System.out.println(mascota.obtenerTipoAnimal());
        System.out.println(mascota.obtenerNumHuesos());
        mascota.emitirSonido();
        
        
        
        //Perro perro = new Perro();
        System.out.println("\n PERRO:");
        Perro perro = new Perro("Pincher",false,"002", "Blacky", 2020, "café", "enfermo");
        
        perro.Comer();
        perro.Movilizarse();
        System.out.println(perro.obtenerTipoAnimal());
        System.out.println(perro.obtenerNumHuesos());
        perro.emitirSonido();//Polimorfismo de sobreescritura
        perro.Pasear();
        perro.Pasear(4);
        perro.Pasear(11, 3);
        perro.Pasear(false);
        System.out.println(perro.emitirSonido2());
        
        
        
        
        //Gato gato = new Gato();
        System.out.println("\n GATO:");
        Gato gato = new Gato("Angora","003", "Violeta", 2018, "blanca", "convaleciente");
        
        gato.Comer();
        gato.Movilizarse();
        System.out.println(gato.obtenerTipoAnimal());
        System.out.println(gato.obtenerNumHuesos());
        gato.autoLimpiarse();
        gato.emitirSonido();//Polimorfismo de sobreescritura
        gato.emitirSonido(" : 'I am a kitty' ");

        
        
    }    
}
