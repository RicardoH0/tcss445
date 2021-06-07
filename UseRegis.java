import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UseRegis extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField PT;
    private JTextField username;
    private JTextField mob;
    private JTextField DOB;
    private JTextField country;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton loginButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UseRegis frame = new UseRegis();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UseRegis() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Create header
        JLabel lblNewUserRegister = new JLabel("Welcome to FEPTI System");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewUserRegister.setBounds(362, 52, 425, 50);
        contentPane.add(lblNewUserRegister);

        //Create first name label
        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblPTAddress = new JLabel("Position\r\n Type");
        lblPTAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPTAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblPTAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        PT = new JTextField();
        PT.setFont(new Font("Tahoma", Font.PLAIN, 32));
        PT.setBounds(214, 320, 228, 50);
        contentPane.add(PT);
        PT.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        JLabel lblDOBNumber = new JLabel("Date of Birth");
        lblDOBNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDOBNumber.setBounds(542, 413, 139, 26);
        contentPane.add(lblDOBNumber);

        DOB = new JTextField();
        DOB.setFont(new Font("Tahoma", Font.PLAIN, 32));
        DOB.setBounds(707, 405, 228, 50);
        contentPane.add(DOB);
        DOB.setColumns(10);

        JLabel lblCOuntry = new JLabel("Country");
        lblCOuntry.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCOuntry.setBounds(58, 405, 139, 26);
        contentPane.add(lblCOuntry);

        country = new JTextField();
        country.setFont(new Font("Tahoma", Font.PLAIN, 32));
        country.setBounds(214, 405, 228, 50);
        contentPane.add(country);
        country.setColumns(10);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String PTId = PT.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                String dob = DOB.getText();
                String cou = country.getText();
//                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
//                if (len != 10) {
//                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
//                }

                try {
                   // Class.forName("com.mysql.jdbc.Driver");
                    Connection connection =  (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/finalPj","root","123456");
                    //genearate random user ID
                    Random rand = new Random();
                    int user_ID = rand.nextInt(10000);
                    String query = "INSERT INTO category values('" + user_ID + "','" + firstName + "','" + lastName + "','" + userName + "','" +
                            PTId + "','" + dob + "','" + cou + "','" + password + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(599, 477, 259, 74);
        contentPane.add(btnNewButton);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserLogin ul = new UserLogin();
                ul.setTitle("Welcome");
                ul.setVisible(true);
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        loginButton.setBounds(299, 477, 259, 74);
        contentPane.add(loginButton);
    }
}
