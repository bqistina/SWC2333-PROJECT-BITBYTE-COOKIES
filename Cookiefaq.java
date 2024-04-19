import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Cookiefaq extends JFrame 
{

    private JList<String> faqList;
    private String[] faqEntries = 
    {
        "1. What types of cookies do you offer?",
        "2. How do I place an order?",
        "3. Do you have gluten-free options?",
        "4. What are your delivery options?",
        "5. Do you offer vegan cookies?",
        "6. How can I track my order?",
        "7. Can I customize my cookie order?",
        "8. What is your return policy?"
    };

    private String[] answers = 
    {
        "We offer chocolate chip, oatmeal raisin, sugar cookies, and more.",
        "You can place an order through our website or by phone.",
        "Yes, we have a selection of gluten-free cookies available.",
        "We offer local delivery and nationwide shipping.",
        "Yes, we have vegan cookie options such as almond butter cookies and peanut butter cookies.",
        "Once your order is shipped, you will receive a tracking number via email.",
        "Yes, you can customize your cookie order with specific ingredients or decorations.",
        "Please refer to our website for details about our return policy."
    };

    public Cookiefaq() 
    {
        setTitle("Cookie FAQ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 225));

        // Create and configure the FAQ list
        faqList = new JList<>(faqEntries);
        faqList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        faqList.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size for FAQ entries
        JScrollPane scrollPane = new JScrollPane(faqList);

        // Create the FAQ list selection listener
        faqList.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e) 
            {
                int selectedIndex = faqList.getSelectedIndex();
                if (selectedIndex != -1) 
                {
                    String selectedQuestion = faqEntries[selectedIndex];
                    String answer = answers[selectedIndex];
                    // Display answer and contact information in a JOptionPane dialog
                    String message = answer + "\n\nFor further inquiries, please contact us at:\nPhone: 123-456-7890\nEmail: info@example.com";
                    JOptionPane.showMessageDialog(Cookiefaq.this, message, selectedQuestion, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Create button to open Receipt window
        JButton receiptButton = new JButton("Checkout");
        receiptButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                // Open Receipt window
                dispose();
                SwingUtilities.invokeLater(() -> 
                {
                    // Example values passed to Receipt constructor
                    new Receipt("Dine In", "Classic Chocolate Chip", "Almonds", "Milk", "Hot", 25.50);
                });
            }
        });

        // Set layout for content pane
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(receiptButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            // Create and display the GUI
            Cookiefaq app = new Cookiefaq();
            app.setVisible(true);
        });
    }
}