/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package retorentamotosacuaticas2;

//import Alquiler;
//import MotoAcuatica;
//import Persona;

/**
 *
 * @author Administrador
 */
public class MainRetoRentaMotosAcuaticas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona cliente1 = new Persona("1000428", 20, "Juan");        
        Persona cliente2 = new Persona("10004830", 20, "Héctor");
        Persona cliente3 = new Persona("10008612", 14, "Carlos");
        Persona cliente4 = new Persona("522356", 53, "Israel");
        
        MotoAcuatica moto1 = new MotoAcuatica("001", "VXCruiser", "Yamaha");
        MotoAcuatica moto2 = new MotoAcuatica("3", "VXCruiser", "Yamaha");//**compartida por dos clientes        
        MotoAcuatica moto3 = new MotoAcuatica("2", "RXT", "Sea-Doo");
        
        Alquiler alquiler1= new Alquiler(5, cliente1, moto1);
        System.out.println(alquiler1.toString());//invoca al método toString()
        //System.out.println("Alquiler 1: "+alquiler1);//invoca automáticamente al método toString()
        
        Alquiler alquiler2= new Alquiler(123, cliente2, moto2);//**compartida por dos clientes
        System.out.println(alquiler2.TerminarAlquiler(5));
        
        Alquiler alquiler3= new Alquiler(125, cliente3, moto2);//**compartida por dos clientes
        System.out.println(alquiler3.TerminarAlquiler(5));
        
        Alquiler alquiler4= new Alquiler(92, cliente4, moto3);
        System.out.println(alquiler4.TerminarAlquiler(2));
        
    }
    
}
