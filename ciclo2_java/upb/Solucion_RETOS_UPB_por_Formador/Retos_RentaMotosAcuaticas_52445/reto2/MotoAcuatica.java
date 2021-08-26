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
public class MotoAcuatica {
    private String Id;
    private String Modelo;
    private String Marca;

    public MotoAcuatica(String id, String modelo, String marca) {
        Id = id;
        Modelo = modelo;
        Marca = marca;
    }
    
    

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @return the Modelo
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * @return the Marca
     */
    public String getMarca() {
        return Marca;
    }
    
    
}
