package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AddTransport extends JFrame implements ActionListener {
    JLabel lid, lno, lname, lphone;
    JTextField id, no, name, phone;
    JButton submit;

    AddTransport() {
        lid = new JLabel("Bus Id:");
        lid.setBounds(10, 10, 250, 20);
        add(lid);

        lno = new JLabel("Bus Number:");
        lno.setBounds(10, 40, 250, 20);
        add(lno);

        lname = new JLabel("Bus Driver Name:");
        lname.setBounds(10, 70, 250, 20);
        add(lname);

        lphone = new JLabel("Bus Driver Contact:");
        lphone.setBounds(10, 100, 250, 20);
        add(lphone);

        id = new JTextField();
        id.setBounds(300, 10, 250, 20);
        add(id);

        no = new JTextField();
        no.setBounds(300, 40, 250, 20);
        add(no);

        name = new JTextField();
        name.setBounds(300, 70, 250, 20);
        add(name);

        phone = new JTextField();
        phone.setBounds(300, 100, 250, 20);
        add(phone);

        submit = new JButton("Submit");
        submit.setBounds(40, 140, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(100, 100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddTransport();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String sql = "insert into buses (bus_id,bus_no,driver,contact) values ('" + id.getText() + "','" + no.getText() + "','" + name.getText() + "','" + phone.getText() + "');";
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.connection.prepareStatement(sql);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "SUCCESS!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
