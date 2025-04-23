package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details() {
        setTitle("Update Patient Details");
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(31, 60, 85));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Update Patient Details");
        title.setBounds(300, 20, 400, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel lblName = new JLabel("Select Patient: ");
        lblName.setBounds(50, 80, 150, 20);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setForeground(Color.WHITE);
        panel.add(lblName);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 200, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM Patient_Info");
            while (rs.next()) {
                choice.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRoom = new JLabel("Room Number:");
        lblRoom.setBounds(50, 130, 150, 20);
        lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRoom.setForeground(Color.WHITE);
        panel.add(lblRoom);

        JTextField txtRoom = new JTextField();
        txtRoom.setBounds(200, 130, 200, 25);
        panel.add(txtRoom);

        JLabel lblTime = new JLabel("In-Time:");
        lblTime.setBounds(50, 180, 150, 20);
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTime.setForeground(Color.WHITE);
        panel.add(lblTime);

        JTextField txtTime = new JTextField();
        txtTime.setBounds(200, 180, 200, 25);
        panel.add(txtTime);

        JLabel lblAmount = new JLabel("Amount Paid:");
        lblAmount.setBounds(50, 230, 150, 20);
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAmount.setForeground(Color.WHITE);
        panel.add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(200, 230, 200, 25);
        panel.add(txtAmount);

        JLabel lblPending = new JLabel("Pending Amount:");
        lblPending.setBounds(50, 280, 150, 20);
        lblPending.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPending.setForeground(Color.WHITE);
        panel.add(lblPending);

        JTextField txtPending = new JTextField();
        txtPending.setBounds(200, 280, 200, 25);
        txtPending.setEditable(false);
        panel.add(txtPending);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(450, 80, 100, 30);
        btnCheck.setBackground(new Color(34, 167, 240));
        btnCheck.setForeground(Color.WHITE);
        panel.add(btnCheck);

        btnCheck.addActionListener(e -> {
            String id = choice.getSelectedItem();
            try {
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery("SELECT * FROM Patient_Info WHERE Name='" + id + "'");
                if (rs.next()) {
                    txtRoom.setText(rs.getString("Room_Number"));
                    txtTime.setText(rs.getString("Time"));
                    txtAmount.setText(rs.getString("Deposite"));
                }
                ResultSet rs1 = c.statement.executeQuery("SELECT * FROM room WHERE room_no='" + txtRoom.getText() + "'");
                if (rs1.next()) {
                    int amountPaid = Integer.parseInt(rs1.getString("Price")) - Integer.parseInt(txtAmount.getText());
                    txtPending.setText(String.valueOf(amountPaid));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 350, 120, 35);
        btnUpdate.setBackground(new Color(34, 167, 240));
        btnUpdate.setForeground(Color.WHITE);
        panel.add(btnUpdate);

        btnUpdate.addActionListener(e -> {
            try {
                conn c = new conn();
                String q = choice.getSelectedItem();
                String room = txtRoom.getText();
                String time = txtTime.getText();
                String amount = txtAmount.getText();
                c.statement.executeUpdate("UPDATE Patient_Info SET Room_Number = '" + room + "', Time = '" + time + "', Deposite = '" + amount + "' WHERE Name = '" + q + "'");
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 350, 120, 35);
        btnBack.setBackground(new Color(192, 57, 43));
        btnBack.setForeground(Color.WHITE);
        panel.add(btnBack);

        btnBack.addActionListener(e -> setVisible(false));

        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}