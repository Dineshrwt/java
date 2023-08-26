import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UpdatePassenger extends JFrame {
    JLabel FROM, to, CLASS, TRAVELDATE, ticketnumber;
    JTextField FROMTextField, toTextField, CLASSTextField, TRAVELDATETextField, ticketnumberTextField;
    JButton Search = new JButton("Search");
    JButton save = new JButton("Save");
    JButton cancel = new JButton("Cancel");

    UpdatePassenger() {

        setLayout(null);

        JLabel FROM = new JLabel("From");
        FROM.setBounds(100, 50, 50, 20);
        this.add(FROM);

        JTextField FROMTextField = new JTextField();
        FROMTextField.setBounds(200, 50, 100, 20);
        this.add(FROMTextField);

        JLabel to = new JLabel("To");
        to.setBounds(350, 50, 90, 20);
        this.add(to);

        JTextField toTextField = new JTextField();
        toTextField.setBounds(450, 50, 100, 20);
        this.add(toTextField);

        JLabel CLASS = new JLabel("Class");
        CLASS.setBounds(100, 100, 100, 20);
        this.add(CLASS);

        JTextField CLASSTextField = new JTextField();
        CLASSTextField.setBounds(200, 100, 100, 20);
        this.add(CLASSTextField);

        JLabel TRAVELDATE = new JLabel("Travel Date");
        TRAVELDATE.setBounds(350, 100, 100, 20);
        this.add(TRAVELDATE);

        JTextField TRAVELDATETextField = new JTextField();
        TRAVELDATETextField.setBounds(450, 100, 100, 20);
        this.add(TRAVELDATETextField);

        JLabel ticketnumber = new JLabel("Ticket Number");
        ticketnumber.setBounds(100, 150, 150, 20);
        this.add(ticketnumber);

        JTextField ticketnumberTextField = new JTextField();
        ticketnumberTextField.setBounds(200, 150, 100, 20);
        this.add(ticketnumberTextField);

        Search.setBounds(320, 150, 80, 20);
        // Search.setBounds(200, 200, 100, 20);
        this.add(Search);

        cancel.setBounds(350, 250, 100, 20);
        this.add(cancel);

        save.setBounds(460, 250, 100, 20);
        this.add(save);

        setSize(900, 900);
        setVisible(true);
        setTitle("Update Passenger");
        setLocation(300, 30);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/railway";
                String username = "root";
                String password = "";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE `addpasanger` SET `From`=?,`To`=?,`Class`=?,`TravalDate`=?,`ToatlPrice`=?,`Adult`=?,`Chidren`=? WHERE `TicketNumber`=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    // Assuming you have defined ticketnumberTextField
                    // preparedStatement.setString(1, ticketnumberTextField.getText());
                    preparedStatement.setString(1, FROMTextField.getText());
                    preparedStatement.setString(2, toTextField.getText());
                    preparedStatement.setString(3, CLASSTextField.getText());
                    preparedStatement.setString(4, TRAVELDATETextField.getText());
                    preparedStatement.setString(5, ticketnumberTextField.getText());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Customer updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Unable to update the customer.");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to search for the ticket.");
                }
            }
        });

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/railway";
                String username = "root";
                String password = "";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "SELECT * FROM addpasanger WHERE TicketNumber=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, ticketnumberTextField.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        FROMTextField.setText(resultSet.getString("From"));
                        toTextField.setText(resultSet.getString("To"));
                        CLASSTextField.setText(resultSet.getString("Class"));
                        TRAVELDATETextField.setText(resultSet.getString("TravelDate"));
                        //ticketnumberTextField.setText(resultSet.getString("TicketNumber"));
                   } else {
                        JOptionPane.showMessageDialog(null, "Customer not found.");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to search for the customer.");
                }
            }
        });  

    }

}
class Main 
{
    public static void main(String[] args) {
        
        UpdatePassenger ob=new UpdatePassenger();
    }
}