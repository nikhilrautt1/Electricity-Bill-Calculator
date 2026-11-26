
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricityBillCalculator extends JFrame implements ActionListener {

    JLabel title, nameLabel, unitsLabel, resultLabel;
    JTextField nameField, unitsField;
    JButton calculateButton, clearButton;

    ElectricityBillCalculator() {

        setTitle("IT2359_C_Nikhil Raut ");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        title = new JLabel("ELECTRICITY BILL CALCULATOR");
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(35, 30, 330, 30);
        add(title);

        nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(40, 100, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, 100, 170, 25);
        add(nameField);

        unitsLabel = new JLabel("Units Consumed:");
        unitsLabel.setBounds(40, 150, 120, 25);
        add(unitsLabel);

        unitsField = new JTextField();
        unitsField.setBounds(170, 150, 170, 25);
        add(unitsField);

        calculateButton = new JButton("Calculate Bill");
        calculateButton.setBounds(50, 210, 130, 35);
        calculateButton.addActionListener(this);
        add(calculateButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(210, 210, 100, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        resultLabel = new JLabel("Your bill will appear here.");
        resultLabel.setBounds(40, 275, 330, 50);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {

            try {
                String name = nameField.getText();
                int units = Integer.parseInt(unitsField.getText());

                if (name.trim().isEmpty() || units < 0) {
                    JOptionPane.showMessageDialog(this,
                            "Enter valid customer details!");
                    return;
                }

                double bill;

                if (units <= 100)
                    bill = units * 3;
                else if (units <= 200)
                    bill = 100 * 3 + (units - 100) * 5;
                else
                    bill = 100 * 3 + 100 * 5 + (units - 200) * 7;

                resultLabel.setText(
                    "<html>Customer: " + name +
                    "<br> Total Bill: Rs. " +
                    String.format("%.2f", bill) + "</html>"
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid units!");
            }
        }

        if (e.getSource() == clearButton) {
            nameField.setText("");
            unitsField.setText("");
            resultLabel.setText("Your bill will appear here.");
        }
    }

    public static void main(String[] args) {
        new ElectricityBillCalculator();
    }
}
