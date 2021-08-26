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
import java.util.LinkedList;

/**
 *
 * @author USUARIO
 */
public class modelCat {

    DbData dbData;

    public modelCat() {
        this.dbData = new DbData();
    }

    public boolean CreatePet(clsCat cat) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementPet = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPet.setString(1, cat.getCode());
            statementPet.setString(2, cat.getName());
            statementPet.setInt(3, cat.getBorn_year());
            statementPet.setString(4, cat.getColor());
            statementPet.setString(5, cat.getHealth_status());
            int rowsInserted = statementPet.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statementPet.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idPet = generatedKeys.getInt(1);
                    query = "INSERT INTO tb_cat (breed, id_pet) VALUES (?, ?)";
                    PreparedStatement statementCat = conn.prepareStatement(query);
                    statementCat.setString(1, cat.getBreed());                    
                    statementCat.setInt(2, idPet);
                    rowsInserted = statementCat.executeUpdate();
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
        clsCat cat = null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_pet AS p INNER JOIN tb_cat AS c on p.id = c.id_pet WHERE p.code = ?";
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
                int catId = result.getInt(7);
                String petBreed = result.getString(8);                
                cat = new clsCat(catId, petBreed, petId, petCode, petName, petBornYear, petColor, petHealthStatus);
            }
            return cat;
        } catch (Exception e) {
            return cat;
        }
    }
    
    public boolean EditPet(clsCat cat) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String queryPet = "UPDATE tb_pet SET code = ?, name = ?, born_year = ?, color = ?, health_status = ? WHERE id = ?";
            PreparedStatement statementPet = conn.prepareStatement(queryPet);
            statementPet.setString(1, cat.getCode());
            statementPet.setString(2, cat.getName());
            statementPet.setInt(3, cat.getBorn_year());
            statementPet.setString(4, cat.getColor());
            statementPet.setString(5, cat.getHealth_status());
            statementPet.setInt(6, cat.getPetId());

            String queryCat = "UPDATE tb_cat SET breed = ?, WHERE id = ?";
            PreparedStatement statementCat = conn.prepareStatement(queryCat);
            statementCat.setString(1, cat.getBreed());            
            statementCat.setInt(2, cat.getCatId());
            int rowsUpdatedPet = statementPet.executeUpdate();
            int rowsUpdatedDog = statementCat.executeUpdate();
            return rowsUpdatedPet > 0 && rowsUpdatedDog > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean DeletePet(clsCat cat) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            // se deja en false para que luego se haga la ejecución de las instrucciones una a una
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");
            try {
                // se debe eliminar primero el específico y luego el general
                //se puede verificar en phpmyadmin que de la forma contraria no es posible por la propiedad de atomicidad
                String queryCat = "DELETE FROM tb_cat WHERE id = ?";//lo elimino directamente por id porque así se pasó desde View (constructor usado para eliminar)
                PreparedStatement statementCat = conn.prepareStatement(queryCat);
                statementCat.setInt(1, cat.getCatId());
                int rowsUpdatedCat = statementCat.executeUpdate();
                conn.commit();

                String queryPet = "DELETE FROM tb_pet WHERE id = ?";
                PreparedStatement statementPet = conn.prepareStatement(queryPet);
                statementPet.setInt(1, cat.getPetId());
                int rowsUpdatedPet = statementPet.executeUpdate();
                conn.commit();
                return rowsUpdatedPet > 0 && rowsUpdatedCat > 0;
            } catch (Exception e) {
                conn.rollback(savePoint);
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    
    
    
    public LinkedList<clsPet> ListPet() {
        LinkedList<clsPet> catList = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_pet AS p INNER JOIN tb_cat AS c on p.id = c.id_pet";
            PreparedStatement statementPet = conn.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                int petId = result.getInt(1);
                String petCode = result.getString(2);
                String petName = result.getString(3);
                int petBornYear = result.getInt(4);
                String petColor = result.getString(5);
                String petHealthStatus = result.getString(6);
                int catId = result.getInt(7);
                String petBreed = result.getString(8);                
                clsCat cat = new clsCat(catId, petBreed, petId, petCode, petName, petBornYear, petColor, petHealthStatus);
                catList.add(cat);
            }
            return catList;
        } catch (Exception e) {
            return catList;
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
    
    public LinkedList<clsReportByHealthStatus> ListCatByHealthStatus() {
        LinkedList<clsReportByHealthStatus> report = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            //String query = "(SELECT * FROM tb_pet AS p INNER JOIN tb_cat AS d on p.id = d.id_pet AS temp) SELECT health_status, count(health_status) FROM temp GROUP BY health_status";
            //String query = "SELECT health_status, count(health_status) FROM (SELECT * FROM tb_pet AS p INNER JOIN tb_cat AS d on p.id = d.id_pet) GROUP BY health_status";
            //String query = "SELECT a.health_status, count(a.health_status) FROM (SELECT * FROM tb_pet AS p INNER JOIN tb_cat AS c on p.id = c.id_pet) a GROUP BY health_status";
            String query = "SELECT a.health_status, count(a.health_status) FROM (SELECT p.code,p.name,p.born_year,p.color,p.health_status,c.breed FROM tb_pet AS p INNER JOIN tb_cat AS c on p.id = c.id_pet) a GROUP BY health_status";
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
