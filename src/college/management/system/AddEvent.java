package college.management.system;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEvent extends JFrame implements ActionListener {
    JLabel labelname, labeldate, labeltime, labelvenue;
    JTextField name, time, venue;
    JXDatePicker date;
    JButton submit;
    String n, d, t, v;
    Date selectedDate;

    AddEvent() {
        labelname = new JLabel("EVENT NAME");
        labelname.setBounds(10, 10, 100, 20);
        add(labelname);

        name = new JTextField();
        name.setBounds(120, 10, 100, 20);
        add(name);

        labeldate = new JLabel("EVENT DATE");
        labeldate.setBounds(10, 40, 100, 20);
        add(labeldate);

        date = new JXDatePicker();
        date.setBounds(120, 40, 100, 20);
        add(date);

        labeltime = new JLabel("EVENT TIME");
        labeltime.setBounds(10, 70, 100, 20);
        add(labeltime);

        time = new JTextField();
        time.setBounds(120, 70, 100, 20);
        add(time);

        labelvenue = new JLabel("EVENT VENUE");
        labelvenue.setBounds(10, 100, 100, 20);
        add(labelvenue);

        venue = new JTextField();
        venue.setBounds(120, 100, 100, 20);
        add(venue);

        submit = new JButton("Submit");
        submit.setBounds(40, 140, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setBackground(Color.PINK);
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(100, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            n = name.getText();
            selectedDate = date.getDate();
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
            d = format1.format(selectedDate);
            t = time.getText();
            v = venue.getText();
            String sql = "insert into events (name,date,time,venue) values ('" + n + "', STR_TO_DATE('" + d + "','%d-%m-%Y'),'" + t + "','" + v + "')";
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.connection.prepareStatement(sql);
//            pstmt.setString(1, textField.getText());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "SUCCESS!");
//            ResultSet resultSet = c.statement.executeQuery(
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
