import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class updateTT extends JFrame {
    JLabel id, name, email, phone;
    JTextField idtextfield, nametextfield, emailtextfield, phoneextfiled;
    JButton search, update, cancel;

    updateTT() {
        setTitle("Update tt");
        setSize(600, 400);
        setVisible(true);
        GridLayout grid = new GridLayout(6, 2);
        this.setLayout(null);
        id = new JLabel("Id :");
        id.setBounds(60, 30, 60, 30);
        name = new JLabel("Name :");
        name.setBounds(60, 70, 60, 30);
        email = new JLabel("E-mail:");
        email.setBounds(60, 120, 60, 30);
        phone = new JLabel("Phone :");
        phone.setBounds(60, 170, 60, 30);
        idtextfield = new JTextField();
        idtextfield.setBounds(140, 30, 100, 30);
        nametextfield = new JTextField();
        nametextfield.setBounds(140, 70, 100, 30);
        emailtextfield = new JTextField();
        emailtextfield.setBounds(140, 120, 100, 30);
        phoneextfiled = new JTextField();
        phoneextfiled.setBounds(140, 170, 100, 30);
        search = new JButton("Search");
        search.setBounds(250, 30, 100, 30);
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 250, 100, 30);
        update = new JButton("Update");
        update.setBounds(350, 250, 100, 30);
        this.add(id);
        this.add(idtextfield);
        this.add(search);
        this.add(name);
        this.add(nametextfield);
        this.add(email);
        this.add(emailtextfield);
        this.add(phone);
        this.add(phoneextfiled);
        this.add(cancel);
        this.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DB_URL = "jdbc:mysql://localhost:3306/railway";
                String USER = "root";
                String PASS = "";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    String query = "UPDATE addtt SET `Name`=?, `E-mail`=?, Phone=?WHERE Id=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, nametextfield.getText());
                    preparedStatement.setString(2, emailtextfield.getText());
                    preparedStatement.setString(3, phoneextfiled.getText());
                    preparedStatement.setString(4, idtextfield.getText());
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update failed");
                    }
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to update the passenger.");
                }
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DB_URL = "jdbc:mysql://localhost:3306/airline";
                String USER = "root";
                String PASS = "";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    String query = "SELECT * FROM addtt WHERE Id=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, idtextfield.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        nametextfield.setText(resultSet.getString("Name"));
                        emailtextfield.setText(resultSet.getString("E-mail"));
                        phoneextfiled.setText(resultSet.getString("Phone"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Pessanger not found.");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to search for the Pessanger.");
                }
            }
        });

    }
    public static void main(String[] args) {
        new updateTT();
    }
}