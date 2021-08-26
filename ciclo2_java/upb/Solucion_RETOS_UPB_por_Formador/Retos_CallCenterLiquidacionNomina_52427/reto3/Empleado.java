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
public class Empleado {
    
    //atributos: por encapsulamiento en POO deben ser de acceso privado
    private int id;
    private String nombre;
    private int horasExtra;//se refiere al valor (en pesos $) por concepto de horasExtra
    private boolean auxilioTransporte;
    private int salario;

    //métodos: 
    
        //OJO: Este constructor está tal cual como lo solicita el reto (no se requiere id):
        public Empleado(/*int id+,*/String nombre, int horasExtra, boolean auxilioTransporte, int salario){
             //this.id = id;//NO LO REQUIERE
             this.nombre = nombre;
             this.horasExtra = horasExtra;
             this.auxilioTransporte = auxilioTransporte;
             this.salario = salario;            
            }
        
        //getters and setters:

        //get
        public int getId(){
            return id;
        }
        public String getNombre(){
            return nombre;
        }
        public int getHorasExtra(){
            return horasExtra;
        }
        public boolean isAuxilioTransporte(){//si es booleano el retorno, entonces el nombre no inicvia con get sino con is
            return auxilioTransporte;
        }
        public int getSalario(){
            return salario;
        }


        //set
        public void setId(int id){
            this.id = id;
        }
        //int id, String nombre, int horasExtra, boolean auxilioTransporte, int salario
        public void setNombre(String nombre){    
             this.nombre = nombre;    
        }

        public void setHorasExtra(int horasExtra){    
                this.horasExtra = horasExtra;        
        }

        public void setAuxilioTransporte(boolean auxilioTransporte){        
            this.auxilioTransporte = auxilioTransporte;    
        }

        public void setSalario(int salario){
            this.salario = salario;
        }
    
}
