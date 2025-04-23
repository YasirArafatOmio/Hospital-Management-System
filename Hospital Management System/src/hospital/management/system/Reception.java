package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {
        setTitle("Hospital Management System - Reception");
        setSize(1600, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 245, 250));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 1600, 100);
        headerPanel.setBackground(new Color(0, 87, 183));
        headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        add(headerPanel);

        JLabel title = new JLabel("Reception Dashboard");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(30, 30, 400, 40);
        headerPanel.add(title);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 5, 20, 20));
        menuPanel.setBounds(100, 150, 1400, 350);
        menuPanel.setBackground(new Color(245, 245, 250));
        add(menuPanel);

        String[] buttonLabels = {
                "Add New Patient", "Room", "Department", "All Employee Info",
                "Patient Info", "Patient Discharge", "Update Patient Details",
                "Hospital Ambulance", "Search Room", "Logout"
        };

        ActionListener[] actions = {
                e -> new NEW_PATIENT(), e -> new Room(), e -> new Department(),
                e -> new Employee_info(), e -> new ALL_Patient_Info(), e -> new patient_discharge(),
                e -> new update_patient_details(), e -> new Ambulance(), e -> new SearchRoom(),
                e -> { setVisible(false); new Login(); }
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createStyledButton(buttonLabels[i]);
            button.addActionListener(actions[i]);
            menuPanel.add(button);
        }

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 123, 255));
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 87, 183), 2),
                BorderFactory.createEmptyBorder(15, 25, 15, 25)));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 140, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        new Reception();
    }
}