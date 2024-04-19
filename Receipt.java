/**
 * 
 *Beatrisyia's part
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receipt extends JFrame implements ActionListener 
{
    private JComboBox<String> paymentMethodBox;
    private String dineOpt, selectedCookies, selectedNuts, selectedDrinks, temperature;
    private double totalPrice;

    public Receipt(String dineOpt, String selectedCookies, String selectedNuts, String selectedDrinks, String temperature, double totalPrice) 
    {
        this.dineOpt = dineOpt;
        this.selectedCookies = selectedCookies;
        this.selectedNuts = selectedNuts;
        this.selectedDrinks = selectedDrinks;
        this.temperature = temperature;
        this.totalPrice = totalPrice;

        setTitle("Receipt");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        String[] paymentMethods = {"Cash", "Credit Card", "Online Payment"};
        paymentMethodBox = new JComboBox<>(paymentMethods);
        panel.add(new JLabel("Select Payment Method:"), BorderLayout.NORTH);
        panel.add(paymentMethodBox, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate Receipt");
        generateButton.addActionListener(this);
        panel.add(generateButton, BorderLayout.SOUTH);

        // Button to open CookieF window
        JButton faqButton = new JButton("FAQ");
        faqButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                new Cookiefaq().setVisible(true);
            }
        });
        panel.add(faqButton, BorderLayout.WEST);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Generate Receipt")) 
        {
            String paymentMethod = (String) paymentMethodBox.getSelectedItem();

            JTextArea receiptTextArea = new JTextArea();
            receiptTextArea.setEditable(false);
            receiptTextArea.setBackground(Color.WHITE);
            receiptTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
            receiptTextArea.append("Dining Option: " + dineOpt + "\n");
            receiptTextArea.append("Selected Cookies: " + selectedCookies + "\n");
            receiptTextArea.append("Selected Nuts: " + selectedNuts + "\n");
            receiptTextArea.append("Selected Drinks: " + selectedDrinks + " (" + temperature + ")\n");
            receiptTextArea.append("Total Price: RM" + String.format("%.2f", totalPrice) + "\n");
            receiptTextArea.append("Payment Method: " + paymentMethod + "\n");

            JOptionPane.showMessageDialog(this, new JScrollPane(receiptTextArea), "Receipt", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
}