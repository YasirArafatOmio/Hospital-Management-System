package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel dateLabel;
    JButton b1, b2;

    NEW_PATIENT() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(240, 240, 240));  // Light background for a modern feel
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Arial", Font.BOLD, 24));  // More modern font
        labelName.setForeground(new Color(0, 51, 102));  // Deep blue color
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(33, 76, 200, 14);
        labelID.setFont(new Font("Arial", Font.BOLD, 14));
        labelID.setForeground(new Color(0, 51, 102));
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"Voter ID", "Driving License"});
        comboBox.setBounds(271, 73, 150, 30);
        comboBox.setBackground(new Color(255, 255, 255));  // White background for combo box
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(33, 111, 200, 14);
        labelNumber.setFont(new Font("Arial", Font.BOLD, 14));
        labelNumber.setForeground(new Color(0, 51, 102));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 30);
        textFieldNumber.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name:");
        labelName1.setBounds(33, 151, 200, 14);
        labelName1.setFont(new Font("Arial", Font.BOLD, 14));
        labelName1.setForeground(new Color(0, 51, 102));
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 30);
        textName.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(33, 191, 200, 14);
        labelGender.setFont(new Font("Arial", Font.BOLD, 14));
        labelGender.setForeground(new Color(0, 51, 102));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial", Font.BOLD, 14));
        r1.setBackground(new Color(240, 240, 240));
        r1.setBounds(271, 191, 80, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Arial", Font.BOLD, 14));
        r2.setBackground(new Color(240, 240, 240));
        r2.setBounds(350, 191, 80, 20);
        panel.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Arial", Font.BOLD, 14));
        labelDisease.setForeground(new Color(0, 51, 102));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 30);
        textFieldDisease.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Arial", Font.BOLD, 14));
        labelRoom.setForeground(new Color(0, 51, 102));
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("Room_No"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 30);
        c1.setFont(new Font("Arial", Font.PLAIN, 14));
        c1.setBackground(new Color(255, 255, 255));
        panel.add(c1);

        JLabel labelDate = new JLabel("Date:");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Arial", Font.BOLD, 14));
        labelDate.setForeground(new Color(0, 51, 102));
        panel.add(labelDate);

        Date date1 = new Date();
        dateLabel = new JLabel(date1.toString());
        dateLabel.setBounds(271, 316, 250, 14);
        dateLabel.setForeground(new Color(0, 51, 102));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(dateLabel);

        JLabel labelDeposite = new JLabel("Deposit:");
        labelDeposite.setBounds(35, 359, 200, 17);
        labelDeposite.setFont(new Font("Arial", Font.BOLD, 14));
        labelDeposite.setForeground(new Color(0, 51, 102));
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 359, 150, 30);
        textFieldDeposite.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 40);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(0, 102, 204));  // Blue color for the button
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260, 430, 120, 40);
        b2.setForeground(Color.white);
        b2.setBackground(new Color(204, 0, 0));  // Red color for the button
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.addActionListener(this);
        panel.add(b2);

        setTitle("New Patient Form");
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 150);
        getContentPane().setBackground(new Color(173, 216, 230));  // Light blue background
        setVisible(true);
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = dateLabel.getText(); // Correct way to get date
            String s8 = textFieldDeposite.getText();

            try {
                String q = "INSERT INTO Patient_Info (ID, Number, Name, Gender, Patient_Disease, Room_Number, Time, Deposite) VALUES ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1 = "UPDATE Room SET Availability = 'Occupied' WHERE Room_No = '" + s6 + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
