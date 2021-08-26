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
public class clsReportByHealthStatus {
    private String healthStatus;
    private int amountOfPetsByHealthStatus;

    /**
     * @return the healthStatus
     */
    public String getHealthStatus() {
        return healthStatus;
    }

    /**
     * @param healthStatus the healthStatus to set
     */
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * @return the amountOfPetsByHealthStatus
     */
    public int getAmountOfPetsByHealthStatus() {
        return amountOfPetsByHealthStatus;
    }

    /**
     * @param amountOfPetsByHealthStatus the amountOfPetsByHealthStatus to set
     */
    public void setAmountOfPetsByHealthStatus(int amountOfPetsByHealthStatus) {
        this.amountOfPetsByHealthStatus = amountOfPetsByHealthStatus;
    }
}
