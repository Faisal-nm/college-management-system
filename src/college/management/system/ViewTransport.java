package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewTransport extends JFrame {
    JTable table;

    ViewTransport() {
        JLabel labelName = new JLabel("Bus Id                               Bus Number                       Driver                     Contact");
        labelName.setBounds(40, 30, 500, 20);
        add(labelName);
        table = new JTable();
        table.setBounds(40, 50, 500, 500);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        add(table);

        try {
            Conn c = new Conn();
            Statement stmt = c.statement;
            ResultSet rs = stmt.executeQuery("SELECT * FROM buses");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewTransport();
    }
}
