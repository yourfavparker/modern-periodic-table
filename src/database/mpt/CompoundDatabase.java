/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.mpt;
import java.sql.*;

/**
 *
 * @author Yousef
 */ 
public class CompoundDatabase {
    
    public static void insertCompound(Compound compound) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO compounds VALUES (?, ?, ?)")) {

            ps.setString(1, compound.getName());
            ps.setString(2, compound.getFormula());
            ps.setString(3, compound.getProperties());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Compound getCompoundByName(String name) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM compounds WHERE name=?")) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Compound(
                    rs.getString("name"),
                    rs.getString("formula"),
                    rs.getString("properties")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
    

