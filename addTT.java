import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class addTT extends JFrame implements ActionListener
{

    JLabel idlabel, namelabel, emaillabel, phonelabel;
    JTextField idtextfield,nametextfield,emailtextfield,phonetextfield; 
    JButton cancel,addbutton;
   

    addTT() 
     {
        setTitle("Add TT");
        setSize(800, 400);
        setVisible(true);
        GridLayout grid = new GridLayout(5, 4);
        this.setLayout(null);
        idlabel = new JLabel("Id :");
        idlabel.setBounds(50, 50, 100, 30);
        namelabel = new JLabel("Name :");
        namelabel.setBounds(400, 50, 100, 30);
        emaillabel = new JLabel("E-mail :");
        emaillabel.setBounds(50, 70, 200, 100);
        phonelabel = new JLabel("Phone :");
        phonelabel.setBounds(400, 70, 400, 100);
        idtextfield = new JTextField();
        idtextfield.setBounds(140, 50, 120, 30);
        nametextfield = new JTextField();
        nametextfield.setBounds(540, 50, 120, 30);
        emailtextfield = new JTextField();
        emailtextfield.setBounds(140, 100, 120, 30);
        phonetextfield = new JTextField();
        phonetextfield.setBounds(540, 100, 120, 30);
         JButton cancel=new JButton("Cancel");
        addbutton=new JButton("Add");
        addbutton.addActionListener(this);
        this.add(idlabel);
        this.add(idtextfield);
        this.add(namelabel);
        this.add(nametextfield);
        this.add(emaillabel);
        this.add(emailtextfield);
        this.add(phonelabel);
        this.add(phonetextfield);
        this.add(cancel);
        cancel.setBounds(400, 300, 80, 30);
        this.add(addbutton);
        addbutton.setBounds(550, 300, 80, 30);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addbutton)
        {
            String id=idtextfield.getText();
            String name=nametextfield.getText();
            String email=emailtextfield.getText();
            String phone=phonetextfield.getText();

   String DB_URL = "jdbc:mysql://localhost:3306/railway";
    String USER = "root";
    String PASS = "";

   
    try {
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      String sql = "insert into addtt values('"+id+"','"+name+"','"+email+"','"+phone+"')";
      stmt.executeUpdate(sql);
      System.out.println("Record ADDED successfully...");
    } catch (Exception ob) {
      ob.printStackTrace();
    }
        }
    }
     public static void main(String[] args) {
        new addTT();
    }
}
