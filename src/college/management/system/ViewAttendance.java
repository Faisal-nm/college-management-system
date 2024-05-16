package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewAttendance extends JFrame implements ActionListener {
    JTextField jTextField;
    JTable table;
    JButton jButton;

    ViewAttendance() {
        JLabel labelName1 = new JLabel("Enter Roll No.");
        labelName1.setBounds(40, 10, 100, 20);
        add(labelName1);

        jTextField = new JTextField();
        jTextField.setBounds(150, 10, 100, 20);
        add(jTextField);

        jButton = new JButton("Get");
        jButton.setBounds(260, 10, 100, 20);
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.white);
        jButton.addActionListener(this);
        add(jButton);

        JLabel labelName = new JLabel("Date                                         Roll No.                                          IsPresent");
        labelName.setBounds(40, 30, 500, 20);
        add(labelName);
        table = new JTable();
        table.setBounds(40, 50, 500, 500);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
//        table.addActionListener(this);
        add(table);

//        table.addRow(new Object[]{"Date","Roll No","IsPresent"});

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewAttendance();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            String sql;
            if (jTextField.getText().isEmpty())
                sql = "select * from attendance";
            else
                sql = "select * from attendance where roll_no = " + jTextField.getText();
            try {
                Conn c = new Conn();
                Statement stmt = c.statement;
                ResultSet rs = stmt.executeQuery(sql);
//                table.setColumnIdentifiers(new Object[]{"Column1", "Column2", "Column3"});

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}