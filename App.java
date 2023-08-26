import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App {
  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame();

    frame.setTitle("Railway Booking");
    frame.setSize(600, 400);
    frame.setVisible(true);

    JMenuBar menuBar = new JMenuBar();
    // JMenu Train = new JMenu("Train");
    // JMenuItem addTrain = new JMenuItem("Avialable");

    // Train.add(addTrain);

    // menuBar.add(Train);
    frame.setJMenuBar(menuBar);

    JMenu booking = new JMenu("Booking");
    JMenuItem addbooking = new JMenuItem("Add");
    JMenuItem removebooking = new JMenuItem("Remove");
    JMenuItem updatebooking = new JMenuItem("Update");
    JMenuItem viewallbooking = new JMenuItem("View All");

    booking.add(addbooking);
    booking.add(removebooking);
    booking.add(updatebooking);
    booking.add(viewallbooking);

    menuBar.add(booking);

    JMenu tt = new JMenu("TT");
    JMenuItem addtt = new JMenuItem("Add");
    JMenuItem removett = new JMenuItem("Remove TT");
    JMenuItem updatett = new JMenuItem("Update");
    JMenuItem viewalltt = new JMenuItem("View TT");

    tt.add(addtt);
    tt.add(removett);
    tt.add(updatett);
    tt.add(viewalltt);

    menuBar.add(tt);

    addbooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new addPassenger();
      }
    });

    removebooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new RemovePassenger();
      }
    });

    updatebooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new UpdatePassenger();
      }
    });

   

     removett.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      new RemoveTT();
      }
    });


    addtt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new addTT();
      }
    });

     viewalltt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      new ViewTT();
      }
    });

     updatett.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      new updateTT();
      }
    });


    viewallbooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/railway";
        String username = "root";
        String password = "";

        try {
         // Class.forName("com.mysql.jdbc.Driver");
          Connection connection = DriverManager.getConnection(url, username, password);

          String query = "SELECT * FROM addpasanger";
          PreparedStatement preparedStatement = connection.prepareStatement(query);

          ResultSet resultSet = preparedStatement.executeQuery();

          DefaultTableModel tableModel = new DefaultTableModel();
          tableModel.addColumn("From");
          tableModel.addColumn("To");
          tableModel.addColumn("Class");
          tableModel.addColumn("TravalDate");
          tableModel.addColumn("ToatlPrice");
          tableModel.addColumn("Adult");
          tableModel.addColumn("Chidern");
          tableModel.addColumn("TicketNumber");

          while (resultSet.next()) {
            String from = resultSet.getString("From");
            String to = resultSet.getString("To");
            String classs = resultSet.getString("Class");
            String traval = resultSet.getString("TravalDate");
            String totalprice = resultSet.getString("ToatlPrice");
            String adult = resultSet.getString("Adult");
            String chidern = resultSet.getString("Chidren");
            String ticketnumber = resultSet.getString("TicketNumber");

            tableModel.addRow(new Object[] { from, to, classs, traval, totalprice, adult, chidern, ticketnumber });
          }

          JTable bookTable = new JTable(tableModel);
          JScrollPane scrollPane = new JScrollPane(bookTable);

          frame.getContentPane().removeAll();
          frame.getContentPane().add(scrollPane);
          frame.revalidate();
          resultSet.close();
          preparedStatement.close();
          connection.close();
        } catch (Exception obj) {
          obj.printStackTrace();
          JOptionPane.showMessageDialog(frame,obj);
        }
        // catch(Exception obj)
        // {
        // System.out.println(obj);
        // }
      }
    });

  }
}