/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.mpt;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Yousef
 */
public class ModifyElement {

    public void modifyElement(String currentName, String newName, String newSymbol,
                              int newAtomicNumber, double newAtomicMass, int newGroupNumber,
                              int newPeriod, String newCategory) throws Exception {
        String sql = "UPDATE elements SET name=?, symbol=?, atomic_number=?, atomic_mass=?, group_number=?, period=?, category=? WHERE name=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setString(2, newSymbol);
            ps.setInt(3, newAtomicNumber);
            ps.setDouble(4, newAtomicMass);
            ps.setInt(5, newGroupNumber);
            ps.setInt(6, newPeriod);
            ps.setString(7, newCategory);
            ps.setString(8, currentName);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                throw new Exception("Element with name '" + currentName + "' not found.");
            }
        }
    }
}
    

