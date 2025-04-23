package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(38, 50, 56));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250, 11, 200, 40);
        For.setForeground(Color.white);
        For.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panel.add(For);

        JLabel status = new JLabel("Status:");
        status.setBounds(70, 70, 80, 20);
        status.setForeground(Color.white);
        status.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 25);
        choice.add("Available");
        choice.add("Occupied");
        choice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 210);
        table.setBackground(new Color(48, 63, 159));
        table.setForeground(Color.white);
        table.setSelectionBackground(new Color(25, 118, 210));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23, 162, 150, 20);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(175, 162, 150, 20);
        available.setForeground(Color.white);
        available.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(458, 162, 150, 20);
        price.setForeground(Color.white);
        price.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(580, 162, 150, 20);
        Bed.setForeground(Color.white);
        Bed.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200, 420, 120, 30);
        Search.setBackground(new Color(25, 118, 210));
        Search.setForeground(Color.white);
        Search.setFont(new Font("Segoe UI", Font.BOLD, 16));
        Search.setFocusPainted(false);
        Search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(Search);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '" + choice.getSelectedItem() + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380, 420, 120, 30);
        Back.setBackground(new Color(211, 47, 47));
        Back.setForeground(Color.white);
        Back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        Back.setFocusPainted(false);
        Back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(700, 500);
        setLayout(null);
        setLocation(450, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
