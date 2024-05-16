package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewEvents extends JFrame {
    JTable table;

    ViewEvents() {
        JLabel labelName = new JLabel("Name                                         Date                                 Time                              Venue");
        labelName.setBounds(40, 30, 500, 20);
        add(labelName);
        table = new JTable();
        table.setBounds(40, 50, 500, 500);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
//        table.addActionListener(this);
        add(table);

        try {
            Conn c = new Conn();
            Statement stmt = c.statement;
            ResultSet rs = stmt.executeQuery("SELECT * FROM events ORDER BY date DESC, time DESC");
//                table.setColumnIdentifiers(new Object[]{"Column1", "Column2", "Column3"});

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
        new ViewEvents();
    }
}
