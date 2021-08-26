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
//package clases;

/**
 *
 * @author Administrador
 */
public class AlquilerMotoAcuatica {
    private int Id;
    private String CedulaCliente;
    private int AnoNacimientoCliente;
    private String IdentificadorMoto;
    private int HorasAlquiler;

    public AlquilerMotoAcuatica() {
    }

    public AlquilerMotoAcuatica(int Id, String CedulaCliente, int AnoNacimientoCliente, String IdentificadorMoto, int HorasAlquiler) {
        this.Id = Id;
        this.CedulaCliente = CedulaCliente;
        this.AnoNacimientoCliente = AnoNacimientoCliente;
        this.IdentificadorMoto = IdentificadorMoto;
        this.HorasAlquiler = HorasAlquiler;
    }
    
    

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the CedulaCliente
     */
    public String getCedulaCliente() {
        return CedulaCliente;
    }

    /**
     * @param CedulaCliente the CedulaCliente to set
     */
    public void setCedulaCliente(String CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    /**
     * @return the AnoNacimientoCliente
     */
    public int getAnoNacimientoCliente() {
        return AnoNacimientoCliente;
    }

    /**
     * @param AnoNacimientoCliente the AnoNacimientoCliente to set
     */
    public void setAnoNacimientoCliente(int AnoNacimientoCliente) {
        this.AnoNacimientoCliente = AnoNacimientoCliente;
    }

    /**
     * @return the IdentificadorMoto
     */
    public String getIdentificadorMoto() {
        return IdentificadorMoto;
    }

    /**
     * @param IdentificadorMoto the IdentificadorMoto to set
     */
    public void setIdentificadorMoto(String IdentificadorMoto) {
        this.IdentificadorMoto = IdentificadorMoto;
    }

    /**
     * @return the HorasAlquiler
     */
    public int getHorasAlquiler() {
        return HorasAlquiler;
    }

    /**
     * @param HorasAlquiler the HorasAlquiler to set
     */
    public void setHorasAlquiler(int HorasAlquiler) {
        this.HorasAlquiler = HorasAlquiler;
    }
    
    
    public double TerminarAlquiler(int cantidadHoras){
        final int COSTO_POR_HORA = 40000;
        double costo=0;
        
        if(cantidadHoras<=0){
            costo=0;
        }
        
        else if(cantidadHoras <= this.getHorasAlquiler()){
            costo = (this.getHorasAlquiler())*COSTO_POR_HORA;            
        }
        
        else if((cantidadHoras-this.getHorasAlquiler())<3){
            int diferencia_horas = cantidadHoras - this.getHorasAlquiler();            
            costo = (this.getHorasAlquiler() + diferencia_horas)*COSTO_POR_HORA*1.15;                        
        }
        
        else if((cantidadHoras-this.getHorasAlquiler())>=3){
            int diferencia_horas = cantidadHoras - this.getHorasAlquiler();            
            costo = (this.getHorasAlquiler() + diferencia_horas)*COSTO_POR_HORA*1.30;                        
        }
        return costo;        
    }
    
}
