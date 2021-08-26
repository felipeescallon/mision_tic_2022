/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import java.util.LinkedList;

/**
 *
 * @author USUARIO
 */
public class ctlPet {//CRUD

    private modelDog modelDog;
    private modelCat modelCat;
    
    public ctlPet() {
        this.modelDog = new modelDog();//puente entre controlador y modelo
        this.modelCat = new modelCat();//puente entre controlador y modelo
    }

    public boolean CreatePet(clsPet pet) {
        try {
            switch (pet.getAnimalType()) {                
                case "Dog":
                    this.modelDog.CreatePet((clsDog)pet);
                    break;
                 case "Cat":
                    this.modelCat.CreatePet((clsCat)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public clsPet SearchPet(String code, String type) {
        clsPet pet = null;
        try {
            switch (type) {
                case "Cat":
                    pet = this.modelCat.SearchPet(code);
                    break;
                case "Dog":
                    pet = this.modelDog.SearchPet(code);
                    break;
            }
            return pet;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean EditPet(clsPet pet) {

        try {
            switch (pet.getAnimalType()) {
                case "Cat":
                    this.modelCat.EditPet((clsCat)pet);
                    break;
                case "Dog":
                    this.modelDog.EditPet((clsDog)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePet(clsPet pet) {

        try {
            switch (pet.getAnimalType()) {
                case "Cat":
                    this.modelCat.DeletePet((clsCat)pet);
                    break;
                case "Dog":
                    this.modelDog.DeletePet((clsDog)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
       
    
    public LinkedList<clsPet> ListPet(String type) {
        LinkedList<clsPet> petList = null;
        try {
            switch (type) {                
                case "Dog":
                    petList = this.modelDog.ListPet();
                    break;
                case "Cat":
                    petList = this.modelCat.ListPet();
                    break;
            }
            return petList;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public LinkedList<clsReportByHealthStatus> ListPetByHealthStatus() {
        //LinkedList<clsReportByHealthStatus> report =  this.modelDog.ListPetByHealthStatus();
        LinkedList<clsReportByHealthStatus> report =  this.modelCat.ListPetByHealthStatus();
        //Cualquiera de los dos PERO NO AMBOS  permiten graficar el nuúmero de mascotas agrupadas por estado de salud
        return report;
    }
    
    public LinkedList<clsReportByHealthStatus> ListDogByHealthStatus() {
        //LinkedList<clsReportByHealthStatus> report =  this.modelDog.ListPetByHealthStatus();
        LinkedList<clsReportByHealthStatus> report =  this.modelDog.ListDogByHealthStatus();
        //Cualquiera de los dos PERO NO AMBOS  permiten graficar el nuúmero de mascotas agrupadas por estado de salud
        return report;
    }
    
    public LinkedList<clsReportByHealthStatus> ListCatByHealthStatus() {
        //LinkedList<clsReportByHealthStatus> report =  this.modelDog.ListPetByHealthStatus();
        LinkedList<clsReportByHealthStatus> report =  this.modelCat.ListCatByHealthStatus();
        //Cualquiera de los dos PERO NO AMBOS  permiten graficar el nuúmero de mascotas agrupadas por estado de salud
        return report;
    }
    
    
    
    
}
