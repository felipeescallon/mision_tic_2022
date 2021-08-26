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
public class Mascota {
    //atributos
    protected String codigo; 
    protected String nombre;
    protected int anio_nacimiento;//calculo matemático
    protected String color;
    protected String estadoSalud;
    
    
    //métodos

    public Mascota() {
        /*ESTO ES INNECESARIO PORQUE EL CONSTRUCTOR VACIO INICIALIZA EL ESTADO DE UN OBJETO CON LOS VALORES POR DEFECTO
        codigo = null;
        nombre = null;
        anio_nacimiento = 0;
        color = null;
        estadoSalud = null;
        */
    }

    public Mascota(String codigo, String nombre, int anio_nacimiento, String color, String estadoSalud) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anio_nacimiento = anio_nacimiento;
        this.color = color;
        this.estadoSalud = estadoSalud;
    }
    
    

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anio_nacimiento
     */
    public int getAnio_nacimiento() {
        return anio_nacimiento;
    }

    /**
     * @param anio_nacimiento the anio_nacimiento to set
     */
    public void setAnio_nacimiento(int anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the estadoSalud
     */
    public String getEstadoSalud() {
        return estadoSalud;
    }

    /**
     * @param estadoSalud the estadoSalud to set
     */
    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    
    //otros métodos:
    public void Comer(){
        System.out.println("La mascota está comiendo");
    }
                 
    public void Movilizarse(){
        System.out.println("La mascota está movilizándose");
    }
    
    public String obtenerTipoAnimal(){
        return "La mascota es de tipo: '4 patas'";
    }
    
    public int obtenerNumHuesos(){
        return 320;//supongamos que es perro
        //return 230;//supongamos que es gato
    }
    
     public void emitirSonido(){
        System.out.println("La mascota está emitiendo un Sonido");
    }
    
    

            
    
    
    
}
