package ChangePinGui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Home;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Change_Pin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Pin frame = new Change_Pin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Change_Pin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 641);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(230, 245, 255));
		contentPane.setBackground(new Color(230, 245, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setToolTipText("Enter Current Pin");
		textField.setBounds(327, 223, 260, 38);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter New Pin");
		textField_1.setColumns(10);
		textField_1.setBounds(327, 290, 260, 38);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("Confirm your pin");
		textField_2.setColumns(10);
		textField_2.setBounds(327, 360, 260, 38);
		contentPane.add(textField_2);

		JLabel lblNewLabel = new JLabel("CHANGE PIN");
		lblNewLabel.setForeground(new Color(0, 78, 168));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(373, 77, 160, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Pin:");
		lblNewLabel_1.setForeground(new Color(0, 78, 168));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(197, 235, 120, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("New Pin:");
		lblNewLabel_1_1.setForeground(new Color(0, 78, 168));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(223, 301, 94, 26);
		contentPane.add(lblNewLabel_1_1);

		lblNewLabel_2 = new JLabel("Confirm new Pin:");
		lblNewLabel_2.setBackground(new Color(252, 183, 21));
		lblNewLabel_2.setForeground(new Color(0, 78, 168));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(151, 372, 166, 26);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(0, 78, 168));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(391, 501, 119, 38);
		contentPane.add(btnNewButton);

		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 78, 168));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(52, 37, 89, 23);
		contentPane.add(btnHome);

		// Home Button ActionListener
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(new String[0]);
				Change_Pin.this.dispose(); // Close current frame
			}
		});

		// Update Button ActionListener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPin = textField.getText();
				String newPin = textField_1.getText();
				String confirmPin = textField_2.getText();

				// Input validation
				if (currentPin.isEmpty() || newPin.isEmpty() || confirmPin.isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!newPin.equals(confirmPin)) {
					JOptionPane.showMessageDialog(null, "New Pin and Confirm Pin do not match.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int reply = JOptionPane.showConfirmDialog(null, "Proceed to change the Pin?", "Confirm Update",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Pin updated successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Pin update canceled.");
				}
			}
		});
	}
}
