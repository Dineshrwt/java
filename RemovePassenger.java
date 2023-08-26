import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class RemovePassenger extends JFrame implements ActionListener
 {
    JButton remove;
    JTextField ticketNumberTextField;
    RemovePassenger()
    {
        setLayout(null);

        JLabel ticketNumber=new JLabel("Ticket Number");
        ticketNumber.setBounds(100, 50, 100, 20);
        this.add(ticketNumber);

       ticketNumberTextField=new JTextField();
        ticketNumberTextField.setBounds(200, 50, 100, 20);
        this.add(ticketNumberTextField);

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(100, 300, 100, 20);
        this.add(cancel);

         remove=new JButton("Remove");
        remove.setBounds(250, 300, 100, 20);
        remove.addActionListener(this);
        this.add(remove);

        setSize(500, 450);
        setVisible(true);
        setTitle("Remove Passanger");
        setLocation(300, 30);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==remove)
        {
          String ticket=ticketNumberTextField.getText();

          String DB_URL = "jdbc:mysql://localhost:3306/railway";
    String USER = "root";
    String PASS = "";

   
    try {
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      String sql = "DELETE FROM addpasanger WHERE TicketNumber"; 
     
      stmt.executeUpdate(sql);
      System.out.println("Record REMOVED successfully...");
    } catch (Exception ob) {
      ob.printStackTrace();
    }
        }
    }

    public static void main(String[] args) {
       new  RemovePassenger();
    }
}
