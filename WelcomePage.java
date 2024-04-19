import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener 
{
    JButton startButton;

    public WelcomePage() 
    {
        setTitle("Welcome to BitByte Cookies");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        JLabel label = new JLabel("Welcome to Bitbyte Cookies", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);

        startButton = new JButton("Start Ordering");
        startButton.addActionListener(this);
        panel.add(startButton, BorderLayout.SOUTH);

        ImageIcon logo = new ImageIcon("bitbyte cookies.jpg");
        JLabel logoLabel = new JLabel(logo);
        panel.add(logoLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == startButton) 
        {
            dispose();
            SwingUtilities.invokeLater(() -> 
            {
                new CookieSelection();
            });
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new WelcomePage();
        });
    }
}