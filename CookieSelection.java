import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CookieSelection extends JFrame implements ActionListener 
{

    private JComboBox<String> cookieBox, nutsBox, drinkBox;
    private JRadioButton[] radioTemperature;
    private JButton btnNext;
    private String temperature = "";

    public CookieSelection() 
    {
        setTitle("Cookie Selection");
        setSize(520, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] cookies = {"Classic Chocolate Chip", "Dark Chocolate Chip", "Plain", "White Chocolate Chip"};
        String[] nuts = {"Almonds", "Macadamia", "Hazelnut", "Walnut", "Mixed Nuts", "None"};
        String[] drinks = {"Latte", "Milk", "Matcha", "Chocolate"};

        cookieBox = new JComboBox<>(cookies);
        nutsBox = new JComboBox<>(nuts);
        drinkBox = new JComboBox<>(drinks);

        radioTemperature = new JRadioButton[2];
        radioTemperature[0] = new JRadioButton("Iced");
        radioTemperature[1] = new JRadioButton("Hot");

        ButtonGroup groupTemperature = new ButtonGroup();
        for (int i = 0; i < 2; i++) 
        {
            groupTemperature.add(radioTemperature[i]);
        }

        JPanel panelCookie = new JPanel();
        panelCookie.setLayout(new GridLayout(1, 0));
        panelCookie.setBorder(BorderFactory.createTitledBorder("Select the type of cookie"));
        panelCookie.add(cookieBox);

        JPanel panelNuts = new JPanel();
        panelNuts.setLayout(new GridLayout(1, 0));
        panelNuts.setBorder(BorderFactory.createTitledBorder("Select type of nuts"));
        panelNuts.add(nutsBox);

        JPanel panelDrink = new JPanel();
        panelDrink.setLayout(new GridLayout(1, 0));
        panelDrink.setBorder(BorderFactory.createTitledBorder("Select the drink"));
        panelDrink.add(drinkBox);

        JPanel panelTemperature = new JPanel();
        for (int i = 0; i < 2; i++) 
        {
            panelTemperature.add(radioTemperature[i]);
        }
        panelTemperature.setBorder(BorderFactory.createTitledBorder("Choose temperature"));

        btnNext = new JButton("NEXT");
        btnNext.addActionListener(this);

        setLayout(new BorderLayout());
        add(panelCookie, BorderLayout.NORTH);
        add(panelNuts, BorderLayout.CENTER);
        add(panelDrink, BorderLayout.SOUTH);
        add(panelTemperature, BorderLayout.EAST);
        add(btnNext, BorderLayout.WEST);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btnNext) 
        {
            String selectedCookies = (String) cookieBox.getSelectedItem();
            String selectedNuts = (String) nutsBox.getSelectedItem();
            String selectedDrinks = (String) drinkBox.getSelectedItem();

            // Determine the selected temperature
            temperature = radioTemperature[0].isSelected() ? "Iced" : "Hot";

            // Calculate the total price based on selections
            double totalPrice = calculateTotalPrice(selectedNuts, selectedDrinks);

            // Dispose of the current frame and create a new DiningOption frame
            dispose();
            SwingUtilities.invokeLater(() -> {
                new DiningOption(selectedCookies, selectedNuts, selectedDrinks, temperature, totalPrice);
            });
        }
    }

    private double calculateTotalPrice(String selectedNuts, String selectedDrinks) 
    {
        double totalPrice = 20; // Base price for cookie

        // Add price for nuts
        if (!selectedNuts.equals("None")) 
        {
            totalPrice += 2.50;
        }

        // Add price for drinks
        switch (selectedDrinks) 
        {
            case "Milk":
                totalPrice += 3.00;
                break;
            default:
                totalPrice += 7.00;
        }

        // Add price for iced drinks
        if (radioTemperature[0].isSelected()) 
        {
            totalPrice += 1.50;
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> 
        {
            new CookieSelection();
        });
    }
}