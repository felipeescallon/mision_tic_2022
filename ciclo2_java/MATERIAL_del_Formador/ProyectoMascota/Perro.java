/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Clases;//solo por diferenciar pero los paquetes deberían ser nombrados en minúsculas

/**
 *
 * @author Administrador
 */
public class Perro extends Mascota{
    //atributos        
    private String raza;
    private boolean pedigri;
    //(Ejecutar Refactor>>Encapsulate Fields...)

    //métodos    
    //constructores:
    
    public Perro() {
    }

    public Perro(String raza, boolean pedigri) {
        this.raza = raza;
        this.pedigri = pedigri;
    }

    public Perro(String raza, boolean pedigri, String codigo, String nombre, int anio_nacimiento, String color, String estadoSalud) {
        super(codigo, nombre, anio_nacimiento, color, estadoSalud);
        this.raza = raza;
        this.pedigri = pedigri;
    }  
    
    
    
        
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

    /**
     * @return the pedigri
     */
    public boolean isPedigri() {//es automático usando refactor
        return pedigri;
    }

    /**
     * @param pedigri the pedigri to set
     */
    public void setPedigri(boolean pedigri) {
        this.pedigri = pedigri;
    }
    
    //VAMOS A USAR LAS TECKAS CONTROL+ESPACIO PARA GENERAR AUTOMÁTICAMENTE @Override:

    @Override
    public void emitirSonido() {
        //super.emitirSonido(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("El perro está ladrando");
        System.out.println(this.getNombre()+" está haciendo: 'guauuuuu'!!!");
    }

       

    /*
    @Override
    public void Comer() {
        super.Comer(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Movilizarse() {
        super.Movilizarse(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emitirSonido() {
        //super.emitirSonido(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.getNombre()+" está haciendo: 'guauuuuu'!!!");
    }
*/
    
    
    public String emitirSonido2(){        
        return this.getNombre()+" : 'guauuuuu'";
    }
    
    public void Pasear(){
        System.out.println(this.getNombre()+" está paseando.");
    }
    
    //Ejemplos de sobrecarga
    public void Pasear(int km){
        System.out.println(this.getNombre()+" va a pasear "+ km +" kilometros");
    }
    
    public void Pasear(int minutos, int vueltas){
        System.out.println(this.getNombre()+" va a pasear "+ vueltas +" vueltas al parque equivalentes a "+ minutos +" minutos");
    }
    
    public void Pasear(boolean correaPerro){    
            if (correaPerro) System.out.println(this.getNombre()+", ¿está paseando con correa?: SI ("+correaPerro+")");
            else System.out.println(this.getNombre()+", ¿está paseando con correa?: NO ("+correaPerro+")");
    }
    
  
    
    
    
}
