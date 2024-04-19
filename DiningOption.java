import javax.swing.*;
/**
 * Ain's part
 * 
 */
import java.awt.*;
import java.awt.event.*;

public class DiningOption extends JFrame implements ActionListener 
{

    private JButton checkoutButton;
    private JComboBox<String> dineOptionBox;
    private String selectedCookies, selectedNuts, selectedDrinks, temperature;
    private double totalPrice;

    public DiningOption(String selectedCookies, String selectedNuts, String selectedDrinks, String temperature, double totalPrice) 
    {
        this.selectedCookies = selectedCookies;
        this.selectedNuts = selectedNuts;
        this.selectedDrinks = selectedDrinks;
        this.temperature = temperature;
        this.totalPrice = totalPrice;

        setTitle("Dining Option");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 11));
        add(panel);

        JLabel label1 = new JLabel("Selected Cookies: " + selectedCookies);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label1);

        JLabel label2 = new JLabel("Selected Nuts: " + selectedNuts);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label2);

        JLabel label3 = new JLabel("Selected Drinks: " + selectedDrinks + " (" + temperature + ")");
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label3);

        String[] dineOptions = {"Take Away", "Dine In", "Drive Thru"};
        dineOptionBox = new JComboBox<>(dineOptions);
        panel.add(new JLabel("Select Dining Option:"));
        panel.add(dineOptionBox);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);
        panel.add(checkoutButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == checkoutButton) 
        {
            String selectedDineOption = (String) dineOptionBox.getSelectedItem();
            dispose();
            SwingUtilities.invokeLater(() -> 
            {
                new Receipt(selectedDineOption, selectedCookies, selectedNuts, selectedDrinks, temperature, totalPrice);
            });
        }
    }
}