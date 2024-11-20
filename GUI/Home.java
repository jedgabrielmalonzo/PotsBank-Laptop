package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ChangePinGui.Change_Pin;
import CheckBalanceGUI.Check_Balance;
import DepositGUI.Deposit;
import WithdrawGUI.Withdraw;

public class Home extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                    window.setVisible(true);  // Set the visibility of this JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Home() {
        getContentPane().setBackground(new Color(230, 245, 254));
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("Home");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // "Deposit" button
        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBackground(new Color(252, 183, 21));
        btnDeposit.setForeground(new Color(0, 78, 168));
        btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDeposit.addActionListener(e -> {
            Deposit.main(new String[0]); 
            dispose();  
        });
        btnDeposit.setBounds(498, 174, 204, 54);
        getContentPane().add(btnDeposit);

        // "Withdraw" button
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBackground(new Color(252, 183, 21));
        btnWithdraw.setForeground(new Color(0, 78, 168));
        btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnWithdraw.addActionListener(e -> {
            Withdraw.main(new String[0]);  // Open Withdraw window
            dispose();  // Close Home window
        });
        btnWithdraw.setBounds(498, 239, 204, 54);
        getContentPane().add(btnWithdraw);

        // "Check Balance" button
        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBackground(new Color(252, 183, 21));
        btnCheckBalance.setForeground(new Color(0, 78, 168));
        btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCheckBalance.addActionListener(e -> {
            Check_Balance.main(new String[0]);  // Open Check Balance window
            dispose();  // Close Home window
        });
        btnCheckBalance.setBounds(498, 314, 204, 54);
        getContentPane().add(btnCheckBalance);

        // "Change Pin" button
        JButton btnChangePin = new JButton("Change Pin");
        btnChangePin.setBackground(new Color(252, 183, 21));
        btnChangePin.setForeground(new Color(0, 78, 168));
        btnChangePin.addActionListener(e -> {
        	Change_Pin.main(new String[0]);  
            dispose();
        });
        btnChangePin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnChangePin.setBounds(498, 379, 204, 54);
        getContentPane().add(btnChangePin);

        // Left panel with labels
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(0, 0, 363, 501);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("<html>What would you<br>like to do?</html>");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblTitle.setBounds(33, 11, 298, 107);
        panel.add(lblTitle);

        JLabel lblDescription = new JLabel("<html>Choose an action from the options on the right to manage your account:<br><br>Deposit: Add money to your account securely.<br><br>Withdraw: Withdraw funds from your account.<br><br>Check Balance: View your current account balance.<br><br>Change Pin: Update your PIN for added security.<br><br>");
        lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
        lblDescription.setForeground(Color.WHITE);
        lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDescription.setBounds(55, 158, 256, 306);
        panel.add(lblDescription);

        // Header labels
        JLabel lblBankTitle = new JLabel("Welcome to PotsBank");
        lblBankTitle.setBounds(441, 26, 331, 37);
        lblBankTitle.setForeground(new Color(0, 78, 168));
        lblBankTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(lblBankTitle);

        JLabel lblSubtitle = new JLabel("Your Trust, Our Commitment");
        lblSubtitle.setBounds(505, 62, 197, 35);
        lblSubtitle.setForeground(new Color(245, 185, 19));
        lblSubtitle.setFont(new Font("Tahoma", Font.ITALIC, 15));
        getContentPane().add(lblSubtitle);
    }
}