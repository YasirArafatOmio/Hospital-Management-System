package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    JButton back;

    Room() {
        setTitle("Room Details");
        setSize(900, 600);
        setLocation(300, 230);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("Room Details");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        heading.setBounds(350, 20, 200, 30);
        panel.add(heading);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "SELECT * FROM Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(380, 500, 140, 40);
        back.setBackground(new Color(200, 50, 50));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setFocusPainted(false);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}