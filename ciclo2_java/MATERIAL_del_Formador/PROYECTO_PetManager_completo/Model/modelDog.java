/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

//import java.sql.*;

import java.util.LinkedList;




/**
 *
 * @author USUARIO
 */
public class modelDog {

    DbData dbData;

    public modelDog() {
        this.dbData = new DbData();
    }

    //CRUD (SQL)
    
    public boolean CreatePet(clsDog dog) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementPet = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPet.setString(1, dog.getCode());
            statementPet.setString(2, dog.getName());
            statementPet.setInt(3, dog.getBorn_year());
            statementPet.setString(4, dog.getColor());
            statementPet.setString(5, dog.getHealth_status());
            int rowsInserted = statementPet.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statementPet.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idPet = generatedKeys.getInt(1);
                    query = "INSERT INTO tb_dog (breed, pedigree, id_pet) VALUES (?, ?, ?)";
                    PreparedStatement statementDog = conn.prepareStatement(query);
                    statementDog.setString(1, dog.getBreed());
                    statementDog.setBoolean(2, dog.isPedigree());
                    statementDog.setInt(3, idPet);
                    rowsInserted = statementDog.executeUpdate();
                    if (rowsInserted > 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public clsPet SearchPet(String code) {
        clsDog dog = null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet WHERE p.code = ?";
            PreparedStatement statementPet = conn.prepareStatement(query);
            statementPet.setString(1, code);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                int petId = result.getInt(1);
                String petCode = result.getString(2);
                String petName = result.getString(3);
                int petBornYear = result.getInt(4);
                String petColor = result.getString(5);
                String petHealthStatus = result.getString(6);
                int dogId = result.getInt(7);
                String petBreed = result.getString(8);
                Boolean petPedigree = result.getBoolean(9);
                dog = new clsDog(dogId, petBreed, petPedigree, petId, petCode, petName, petBornYear, petColor, petHealthStatus);
            }
            return dog;
        } catch (Exception e) {
            return dog;
        }
    }
    
    public boolean EditPet(clsDog dog) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String queryPet = "UPDATE tb_pet SET code = ?, name = ?, born_year = ?, color = ?, health_status = ? WHERE id = ?";
            PreparedStatement statementPet = conn.prepareStatement(queryPet);
            statementPet.setString(1, dog.getCode());
            statementPet.setString(2, dog.getName());
            statementPet.setInt(3, dog.getBorn_year());
            statementPet.setString(4, dog.getColor());
            statementPet.setString(5, dog.getHealth_status());
            statementPet.setInt(6, dog.getPetId());

            String queryDog = "UPDATE tb_dog SET breed = ?, pedigree = ? WHERE id = ?";
            PreparedStatement statementDog = conn.prepareStatement(queryDog);
            statementDog.setString(1, dog.getBreed());
            statementDog.setBoolean(2, dog.isPedigree());
            statementDog.setInt(3, dog.getDogId());
            int rowsUpdatedPet = statementPet.executeUpdate();
            int rowsUpdatedDog = statementDog.executeUpdate();
            return rowsUpdatedPet > 0 && rowsUpdatedDog > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean DeletePet(clsDog dog) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            // se deja en false para que luego se haga la ejecución de las instrucciones una a una
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");//Guardo una referencia de la BD para que el rollback la use
            try {
                // se debe eliminar primero el específico y luego el general 
                //se puede verificar en phpmyadmin que de la forma contraria no es posible por la propiedad de atomicidad
                String queryDog = "DELETE FROM tb_dog WHERE id = ?";//lo elimino directamente por id porque así se pasó desde View (constructor usado para eliminar)
                PreparedStatement statementDog = conn.prepareStatement(queryDog);
                statementDog.setInt(1, dog.getDogId());
                int rowsUpdatedDog = statementDog.executeUpdate();
                conn.commit();

                String queryPet = "DELETE FROM tb_pet WHERE id = ?";
                PreparedStatement statementPet = conn.prepareStatement(queryPet);
                statementPet.setInt(1, dog.getPetId());
                int rowsUpdatedPet = statementPet.executeUpdate();
                conn.commit();
                return rowsUpdatedPet > 0 && rowsUpdatedDog > 0;
            } catch (Exception e) {
                conn.rollback(savePoint);//ante cualquier error me devuelvo a la versión anterior (antes de borrar)
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    
    
    
    public LinkedList<clsPet> ListPet() {
        LinkedList<clsPet> dogList = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet";
            PreparedStatement statementPet = conn.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                int petId = result.getInt(1);
                String petCode = result.getString(2);
                String petName = result.getString(3);
                int petBornYear = result.getInt(4);
                String petColor = result.getString(5);
                String petHealthStatus = result.getString(6);
                int dogId = result.getInt(7);
                String petBreed = result.getString(8);
                Boolean petPedigree = result.getBoolean(9);
                clsDog dog = new clsDog(dogId, petBreed, petPedigree, petId, petCode, petName, petBornYear, petColor, petHealthStatus);
                dogList.add(dog);
            }
            return dogList;
        } catch (Exception e) {
            return dogList;
        }
    }
    
    public LinkedList<clsReportByHealthStatus> ListPetByHealthStatus() {
        LinkedList<clsReportByHealthStatus> report = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT health_status, count(health_status) FROM `tb_pet` GROUP BY health_status";
            PreparedStatement statementPet = conn.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                clsReportByHealthStatus record = new clsReportByHealthStatus();
                String healthStatusType = result.getString(1);
                int amount = result.getInt(2);
                record.setHealthStatus(healthStatusType);
                record.setAmountOfPetsByHealthStatus(amount);
                report.add(record);
            }
            return report;
        } catch (Exception e) {
            return report;
        }
    }
    
    public LinkedList<clsReportByHealthStatus> ListDogByHealthStatus() {
        LinkedList<clsReportByHealthStatus> report = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            //String query = "(SELECT * FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet AS temp), SELECT health_status, count(health_status) FROM temp GROUP BY health_status";
            //String query = "SELECT health_status, count(health_status) FROM (SELECT * FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet) GROUP BY health_status";
            //String query = "SELECT a.health_status, count(a.health_status) FROM (SELECT * FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet) a GROUP BY health_status";
            String query = "SELECT a.health_status, count(a.health_status) FROM (SELECT p.code,p.name,p.born_year,p.color,p.health_status,d.breed,d.pedigree FROM tb_pet AS p INNER JOIN tb_dog AS d on p.id = d.id_pet) a GROUP BY health_status";
            PreparedStatement statementPet = conn.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                clsReportByHealthStatus record = new clsReportByHealthStatus();
                String healthStatusType = result.getString(1);
                int amount = result.getInt(2);
                record.setHealthStatus(healthStatusType);
                record.setAmountOfPetsByHealthStatus(amount);
                report.add(record);
            }
            return report;
        } catch (Exception e) {
            return report;
        }
    }
}
