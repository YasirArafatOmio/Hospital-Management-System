package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color startColor = new Color(100, 149, 237);
                Color endColor = new Color(0, 191, 255);
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,50,980,450);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(173, 216, 230));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "SELECT * FROM EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = createLabel("ID", 60, 9);
        JLabel label2 = createLabel("Name", 190, 9);
        JLabel label3 = createLabel("Age", 340, 9);
        JLabel label4 = createLabel("Phone", 500, 9);
        JLabel label5 = createLabel("Salary", 670, 9);
        JLabel label6 = createLabel("Gmail", 850, 9);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(350, 500, 120, 40);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBackground(new Color(60, 179, 113));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back button clicked!");
                ((JFrame) SwingUtilities.getWindowAncestor(backButton)).dispose();
            }
        });
        panel.add(backButton);

        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(Color.BLACK);
        return label;
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
