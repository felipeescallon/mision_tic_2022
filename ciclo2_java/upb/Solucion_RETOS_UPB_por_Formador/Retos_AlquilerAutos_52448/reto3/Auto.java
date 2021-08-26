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
public class Auto{
    
    private String Placa;
    private int DiasDesdeUltimoMantenimiento;
    private boolean TieneSeguro;

    public Auto(String Placa, int DiasDesdeUltimoMantenimiento, boolean TieneSeguro) {
        this.Placa = Placa;
        this.DiasDesdeUltimoMantenimiento = DiasDesdeUltimoMantenimiento;
        this.TieneSeguro = TieneSeguro;
    }

        
        
    public boolean NecesitaMantenimiento() {
        
        boolean respuesta;
        respuesta = (this.DiasDesdeUltimoMantenimiento > 20)? true : false;        
        return respuesta;
    }

    public boolean SePuedeRentar()
     {
        if (!NecesitaMantenimiento()){
            if (this.TieneSeguro){            
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}   
