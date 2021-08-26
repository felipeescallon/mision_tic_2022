/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package clases;

import Cliente;
import Auto;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author Administrador
 */
public class Alquiler {
    private Cliente Cliente;
    private Auto Auto;
    private LocalDate Fecha;
    private int HorasAlquiler;

    public Alquiler(Cliente cliente, Auto auto, LocalDate fecha, int horasAlquiler) {
        Cliente = cliente;
        Auto = auto;
        Fecha = fecha;
        HorasAlquiler = horasAlquiler;
    }

    
    /**
     * @return the Cliente
     */
    public Cliente getCliente() {
        return Cliente;
    }

    /**
     * @return the Auto
     */
    public Auto getAuto() {
        return Auto;
    }

    /**
     * @return the Fecha
     */
    public LocalDate getFecha() {
        return Fecha;
    }

    /**
     * @return the HorasAlquiler
     */
    public int getHorasAlquiler() {
        return HorasAlquiler;
    }
    
    public int ObtenerDescuento(Alquiler[] alquileres){
        int descuento=0;
        Cliente Cliente_alquiler=null;
        Auto Auto_alquiler=null;;
        LocalDate Fecha_alquiler=null;
        LocalDate Fecha_actual=null;
        int HorasAlquiler_alquiler=0;
        int horas_acumuladas=0;
        long diferencia_fecha_dias=0;
        
        
        if((!(this.Auto.NecesitaMantenimiento()))&&(this.Auto.SePuedeRentar())){
            horas_acumuladas=this.getHorasAlquiler();//a este valor se le van a sumar si es el caso las horas acumuladas del historial de alquileres si la fecha anterior a la actual no supera los 30 días
            for (Alquiler alquiler : alquileres){
                //Cliente_alquiler = alquiler.getCliente();
                //Auto_alquiler = alquiler.getAuto();
                Fecha_alquiler = alquiler.getFecha();
                Fecha_actual = this.Fecha;
                //HorasAlquiler_alquiler = alquiler.getHorasAlquiler();
                if(this.Cliente.getCedula().equals(alquiler.Cliente.getCedula())){//mismo cliente actual con respecto al que está en alguna iteración de la lista
                    diferencia_fecha_dias = Fecha_alquiler.until(Fecha_actual, DAYS);//diferencia en día desde una fecha de inicio del historial de alquiler hasta la fecha "actual" que es el objeto this que invoca al método ObtenerDescuento
                    if(diferencia_fecha_dias<=30){                        
                        horas_acumuladas=horas_acumuladas+alquiler.getHorasAlquiler();
                    }                                                                                         
                       
                }                
            }
            if (horas_acumuladas<20){ 
                descuento=0;
            }else if (horas_acumuladas>=20 && horas_acumuladas<50) {
                descuento=2;
            }else{//horas_acumuladas>=50
                descuento=5;
            }  
            
            return descuento;
            
        }else{
            return descuento;//retorna el valor inicial que es 0
        }
    }
}
            
 

