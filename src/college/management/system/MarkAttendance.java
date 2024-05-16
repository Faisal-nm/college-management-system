package college.management.system;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarkAttendance extends JFrame implements ActionListener {
//    JCheckBox checkBox;

    JButton submit, back;
    boolean isSelected = false;
    String dateString = "10-05-2024";
    JTextField rollno;
    Date selectedDate;
    JXDatePicker datePicker;
    JCheckBox checkBox;

    MarkAttendance() {
        JLabel labelName3 = new JLabel("<html><h3><b>Mark Attendance</b></h3></html>");
        labelName3.setBounds(40, 10, 1000, 40);
        add(labelName3);
        JLabel labelName1 = new JLabel("Select Date");
        labelName1.setBounds(40, 40, 100, 20);
        add(labelName1);
        datePicker = new JXDatePicker();
        datePicker.setBounds(150, 40, 100, 20);
        add(datePicker);
//        add(datePicker);

//        JCalendar calendar = new JCalendar();


//        Date selectedDate = calendar.getDate();
//
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//        dateString = format.format(selectedDate);

        JLabel labelName = new JLabel("Roll No");
        labelName.setBounds(40, 70, 100, 20);
        add(labelName);

        rollno = new JTextField();
        rollno.setBounds(150, 70, 100, 20);
        add(rollno);

        JLabel labelName2 = new JLabel("Present?");
        labelName2.setBounds(40, 100, 100, 20);
        add(labelName2);
        checkBox = new JCheckBox("Present");
        checkBox.setBounds(150, 100, 100, 20);

        add(checkBox);


        submit = new JButton("Submit");
        submit.setBounds(40, 140, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
//        String sql = "insert into attendance (date,roll_no,isPresent) values ('" + dateString + "','" + rollno.getText() + "','" + isSelected + "')";
//        try {
//            Conn c = new Conn();
//            PreparedStatement pstmt = c.connection.prepareStatement(sql);
////            pstmt.setString(1, textField.getText());
//            pstmt.executeUpdate();
////            ResultSet resultSet = c.statement.executeQuery(
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MarkAttendance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            selectedDate = datePicker.getDate();
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
            dateString = format1.format(selectedDate);
            isSelected = checkBox.isSelected();
            System.out.println(dateString + " " + rollno.getText() + " " + isSelected);
//            String sql = "insert into attendance (date,roll_no,isPresent) values (STR_TO_DATE('" + dateString + "',%d-%m-%y)," + rollno.getText() + "," + isSelected + ")";
//            String sql = "insert into attendance (date,roll_no,isPresent) values (STR_TO_DATE('" + dateString + "',%d-%m-%y')," + rollno.getText() + "," + isSelected + ")";
            String sql = "insert into attendance (date,roll_no,isPresent) values (STR_TO_DATE('" + dateString + "','%d-%m-%Y')," + rollno.getText() + "," + isSelected + ")";

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




