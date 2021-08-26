/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package clases;

/**
 *
 * @author Administrador
 */
public class Cliente {
     private String Cedula;
    private int Edad;
    private String Nombre;

    public Cliente (String cedula, int edad, String nombre) {
        Cedula = cedula;
        Edad = edad;
        Nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public String getNombre() {
        return Nombre;
    }
}
