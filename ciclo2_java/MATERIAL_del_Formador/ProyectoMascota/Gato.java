/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Clases;

/**
 *
 * @author Administrador
 */
public class Gato extends Mascota {
    
    private String raza;

    public Gato() {
    }

    public Gato(String raza) {
        this.raza = raza;
    }

    public Gato(String raza, String codigo, String nombre, int anio_nacimiento, String color, String estadoSalud) {
        super(codigo, nombre, anio_nacimiento, color, estadoSalud);
        this.raza = raza;
    }
    

    
    
    
    
    

    /*
    public Gato(String raza, String codigo, String nombre, int anio_nacimiento, String color, String estadoSalud) {
        super(codigo, nombre, anio_nacimiento, color, estadoSalud);
        this.raza = raza;
    }
    */
       
    
    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }   
      
    public void autoLimpiarse(){
        
        System.out.println(this.getNombre()+" se está auto limpiando.");
    }

    /*
    @Override //ESTE DECORADOR HACE REFERENCIA AL POLIMORFISMO DE SOBREESCRITURA
    public void Comer() {
        super.Comer(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Movilizarse() {
        super.Movilizarse(); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public void emitirSonido() {
        //super.emitirSonido(); //To change body of generated methods, choose Tools | Templates.
        String mensaje=" está haciendo: 'miauuuuu'!!!";
        System.out.println(this.getNombre()+ mensaje);        
    } 
          
    //Ejemplo de POLIMORFISMO de sobrecarga:
    public void emitirSonido(String mensaje){//mensaje=" está haciendo: 'miauuuuu'!!!";
        
        System.out.println(this.getNombre()+ mensaje);
    }
    
    
}
