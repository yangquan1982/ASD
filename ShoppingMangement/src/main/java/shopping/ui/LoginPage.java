package shopping.ui;
import shopping.bus.CustomerBUS;
import shopping.bus.ICustomerBUS;
import shopping.model.Customer.Customer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public JTextField getTextFieldUN() {
		return textFieldUN;
	}

	public void setTextFieldUN(JTextField textFieldUN) {
		this.textFieldUN = textFieldUN;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
//		connection = sqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\shop-icon.png"));
		frame.setBackground(new Color(153, 153, 204));
		frame.setBounds(100, 100, 727, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Icons\\Office-Customer-Male-Light-icon.png"));
		lblNewLabel.setBounds(210, 172, 61, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Icons\\Security-Password-2-icon.png"));
		lblNewLabel_1.setVerifyInputWhenFocusTarget(false);
		lblNewLabel_1.setBounds(415, 172, 61, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		textFieldUN.setBounds(176, 247, 135, 42);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("Icons\\160_F_7270311_iwRCdBvGmJuovg13PLhhMAUnxvPvHesp.jpg"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ICustomerBUS customerBUS = CustomerBUS.getCustomerBUS();
					boolean login = customerBUS.login(textFieldUN.getText(),passwordField.getText());

					if (login)
					{
						JOptionPane.showMessageDialog(null, "Username & Password is correct");
						frame.dispose();
						MainPanel mainPanel = new MainPanel();
						mainPanel.setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Username & Password is not correct");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setBounds(301, 314, 87, 35);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(382, 248, 135, 42);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\supershop-logo.png"));
		label.setBounds(132, 0, 412, 109);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_total = new JLabel("Login Page");
		lblNewLabel_total.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblNewLabel_total.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_total.setForeground(Color.ORANGE);
		lblNewLabel_total.setBackground(Color.ORANGE);
		lblNewLabel_total.setIcon(new ImageIcon("Icons\\cool-light-blue-backgrounds.jpg"));
		lblNewLabel_total.setBounds(0, 0, 721, 445);
		frame.getContentPane().add(lblNewLabel_total);
		
	}
}
