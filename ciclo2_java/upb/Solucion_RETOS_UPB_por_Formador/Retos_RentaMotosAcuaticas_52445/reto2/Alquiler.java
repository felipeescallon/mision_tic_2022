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
public class Alquiler {
    private int Id;
    private Persona Cliente;
    private MotoAcuatica Moto; 

    public Alquiler(int id, Persona cliente, MotoAcuatica moto) {
        Id = id;
        Cliente = cliente;
        Moto = moto;
    }       
    
    
    public double TerminarAlquiler(int cantidadHoras){
        int costo_por_hora=0;
        int total=0;
        
        if(this.Moto.getMarca().equals("Yamaha"))costo_por_hora = 50000;
        if(this.Moto.getMarca().equals("Kawasaki"))costo_por_hora = 60000;
        if(this.Moto.getMarca().equals("Sea-Doo"))costo_por_hora = 60000;
        
        total = cantidadHoras * costo_por_hora;
        
        int resultado = (this.Cliente.getEdad()<18)? 2*total:total;
        return resultado;                   
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return this.Cliente.getNombre()+" con cédula "+this.Cliente.getCedula()+" renta la moto "+this.Moto.getId()+" modelo "+this.Moto.getModelo()+".";
    }
    
    
    
    
}
