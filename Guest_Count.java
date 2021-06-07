import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Guest_Count {
    Connection connection;
    Statement statement;

    Guest_Count() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chan_yukwan_db", "root", "nata19990921");
            statement = connection.createStatement();
            String query = "select count(*) as Position from System_Table";
            ResultSet resultSet = statement.executeQuery(query);
            JOptionPane.showMessageDialog(null, "There are" + resultSet + " guest in totally");

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
