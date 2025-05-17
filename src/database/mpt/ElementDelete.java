
package database.mpt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Yousef
 */
public class ElementDelete {
    
public int deleteElement(String elementName) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "DELETE FROM elements WHERE name=?")) {

            ps.setString(1, elementName);

            return ps.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}