import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
import javax.swing.*;

public class addPassenger extends JFrame implements ActionListener
{
    JTextField FROMTextField,toTextField,CLASSTextField,TRAVELDATETextField,price,adulttext,Chidtext,tickettext;
    JButton save;
    addPassenger()
    {

        setLayout(null);

        JLabel FROM=new JLabel("From");
        FROM.setBounds(100, 50, 50, 20);
        this.add(FROM);
  
         FROMTextField=new JTextField();
        FROMTextField.setBounds(200, 50, 100, 20);
        this.add(FROMTextField);

        JLabel to=new JLabel("To");
        to.setBounds(350, 50, 90, 20);
        this.add(to);

         toTextField=new JTextField();
        toTextField.setBounds(450, 50, 100, 20);
        this.add(toTextField);

        JLabel CLASS=new JLabel("Class");
        CLASS.setBounds(100, 100, 100, 20);
        this.add(CLASS);

         CLASSTextField=new JTextField();
        CLASSTextField.setBounds(200, 100, 100, 20);
        this.add(CLASSTextField);

        JLabel TRAVELDATE=new JLabel("Travel Date");
        TRAVELDATE.setBounds(350, 100, 100, 20);
        this.add(TRAVELDATE);

         TRAVELDATETextField=new JTextField();
        TRAVELDATETextField.setBounds(450, 100, 100, 20);
        this.add(TRAVELDATETextField);

        JLabel TOTELPRICE=new JLabel("Total Price");
        TOTELPRICE.setBounds(100, 150, 150, 20);
        this.add(TOTELPRICE);

         price=new JTextField();
        price.setBounds(200, 150, 100, 20);
        this.add(price);


        JLabel adult=new JLabel("Adult");
        adult.setBounds(350, 150, 150, 20);
        this.add(adult);

         adulttext=new JTextField();
        adulttext.setBounds(450, 150, 100, 20);
        this.add(adulttext);

        
        JLabel Chidren=new JLabel("Chidern");
        Chidren.setBounds(100, 200, 150, 20);
        this.add(Chidren);

         Chidtext=new JTextField();
        Chidtext.setBounds(200, 200, 100, 20);
        this.add(Chidtext);


        JLabel ticket=new JLabel("Ticket Number");
        ticket.setBounds(350, 200, 150, 20);
        this.add(ticket);

         tickettext=new JTextField();
        tickettext.setBounds(450, 200, 100, 20);
        this.add(tickettext);

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(350, 250, 100, 20);
        this.add(cancel);

          save=new JButton("Save");
        save.setBounds(460, 250, 100, 20);
        save.addActionListener(this);
        this.add(save);


 
        setSize(900, 900);
        setVisible(true);
        setTitle("Add Passenger");
        setLocation(300, 30);
    }
    public void actionPerformed(ActionEvent ob)
    {
      if(ob.getSource()==save)
      {
          JOptionPane.showMessageDialog(null,"Succesfull Add");
      
        String from=FROMTextField.getText();
        String to=toTextField.getText();
        String classtext=CLASSTextField.getText();
        String traval=TRAVELDATETextField.getText();
        String pr=price.getText();
        String adult=adulttext.getText();
        String Chiders=Chidtext.getText();
        String ticket=tickettext.getText();

    String DB_URL = "jdbc:mysql://localhost:3306/railway";
    String USER = "root";
    String PASS = "";

   
    try {
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      String sql = "insert into addpasanger values('"+from+"','"+to+"','"+classtext+"','"+traval+"','"+pr+"','"+adult+"','"+Chiders+"','"+ticket+"')";
      stmt.executeUpdate(sql);
      System.out.println("Record ADDED successfully...");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    }
    public static void main(String[] args) {
        new addPassenger();
    }
}
