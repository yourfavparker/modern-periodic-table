package database.mpt;
import java.sql.*;

/**
 *
 * @author Yousef
 */
 
public class DatabaseMPT {
    static final String port = ":3306";
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost" + port + "/modern_periodic_table";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName(jdbcDriver);
        conn = DriverManager.getConnection(dbURL, "root", "");
        stmt = conn.createStatement();

        String sql;

        sql = "SELECT * FROM elements";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int atomicNumber = rs.getInt("atomic_number");
            String symbol = rs.getString("symbol");
            String name = rs.getString("Name"); 
            float atomicMass = rs.getFloat("atomic_mass");
            int group = rs.getInt("group_number");
            int period = rs.getInt("period");
            String category = rs.getString("category");

            System.out.println(atomicNumber + " " + symbol + " " + name + " " +
                               atomicMass + " " + group + " " + period + " " + category);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
