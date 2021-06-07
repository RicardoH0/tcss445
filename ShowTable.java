
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShowTable implements ActionListener {

    JFrame frame1;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton enterButton;

    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;
    int flag=0;


    ShowTable() {

        frame1 = new JFrame();
        frame1.setTitle("Database Data");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame1.setLayout(bagLayout);

        bagConstraints.insets = new Insets(15, 40, 0, 0);


        nameLabel = new JLabel("Enter Username");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame1.add(nameLabel, bagConstraints);


        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame1.add(nameTextField, bagConstraints);


        enterButton = new JButton("Enter");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(enterButton, bagConstraints);



        enterButton.addActionListener(this);



        frame1.setVisible(true);
        frame1.validate();


    }

    public static void main(String[] args) {
        new ShowTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enterButton) {

            String userName = nameTextField.getText().toString();
            frameSecond(userName);
        }
    }


    public void frameSecond(String userName) {

        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Position");


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chan_yukwan_db", "root", "nata19990921");//Crating connection with database
            statement = connection.createStatement();
            String query = "select * from System_table" ;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                
                String x = resultSet.getString("Username");
                String y = resultSet.getString("email");
                String z = resultSet.getString("position");
                if (userName.equalsIgnoreCase(x)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{x, y, z});
                    frame2.setVisible(true);
                    frame2.validate();
                    break;
                }
            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such Username Found");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
