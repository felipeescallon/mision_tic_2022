/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author USUARIO
 */
public class clsDog extends clsPet {
    private int dogId;//para manejar la Primary Key de tb_dog (id)
    private String breed;
    private boolean pedigree;

    public clsDog(int dogId, String breed, boolean pedigree, int petId, String code, String name, int born_year, String color, String health_status) {
        super(petId, code, name, born_year, color, health_status);
        this.dogId = dogId;
        this.breed = breed;
        this.pedigree = pedigree;
    }

    public clsDog(int petId, int dogId) {//usado en el botón eliminar de View
        super(petId, null, null, 0, null, null);
        this.dogId = dogId;
    }


    
       
    public void WalkAround(){
        System.out.println("El perro " + super.getName() + " está caminando.");
    }
    
    public void WalkAround(int km){
        System.out.println("El perro " + super.getName()+ " está caminando " + km + " km");
    }
    
    public void WalkAround(boolean dogLeash){
        String hasLeash = dogLeash ? "con correa" : "sin correa";
        System.out.println("El perro " + super.getName()+ " está caminando " + hasLeash);
    }
    

    @Override
    public void Sound(){
        System.out.println("El perro " + super.getName() +" hace Guuuuaaaauuu");
    }

    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    
    @Override
    public String getAnimalType(){
        return "Dog";
    }
     @Override
    public int getNumberOfBones(){
        return 320;
    }
    
    
    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the pedigree
     */
    public boolean isPedigree() {
        return pedigree;
    }

    /**
     * @param pedigree the pedigree to set
     */
    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    /**
     * @return the dogId
     */
    public int getDogId() {
        return dogId;
    }

    /**
     * @param dogId the dogId to set
     */
    public void setDogId(int dogId) {
        this.dogId = dogId;
    }
    
    
}
