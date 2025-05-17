package database.mpt;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author Yousef
 */

public class ElementInfoWindow extends JFrame {
    public ElementInfoWindow(int atomicNumber) {
        setTitle("Element Info");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/modern_periodic_table", "root", "");
            String sql = "SELECT * FROM elements WHERE atomic_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, atomicNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String info = "Name: " + rs.getString("name") + "\n" +
                              "Symbol: " + rs.getString("symbol") + "\n" +
                              "Atomic Number: " + rs.getInt("atomic_number") + "\n" +
                              "Atomic Mass: " + rs.getFloat("atomic_mass") + "\n" +
                              "Group: " + rs.getInt("group_number") + "\n" +
                              "Period: " + rs.getInt("period") + "\n" +
                              "Category: " + rs.getString("category");

                textArea.setText(info);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        setVisible(true); 
    }
}
