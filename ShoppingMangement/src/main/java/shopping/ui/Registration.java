package shopping.ui;
import shopping.bus.CustomerBUS;
import shopping.bus.NewCustomerBUS;
import shopping.model.Customer.Customer;
import shopping.ui.framework.APage;
import shopping.ui.framework.compfactory.*;
import shopping.ui.framework.navigator.*;
import shopping.ui.framework.pagefactory.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;

public class Registration extends APage implements Serializable {
	private static final long serialVersionUID = 6598475679920825522L;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel lblNewPassword;
	private JTextField textOldu;
	private JTextField passwordField_1;
	private JTextField textOldpw;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JDesktopPane desktopPane_1;
	private JLabel label;
	public static final Registration INSTANCE = new Registration();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration.INSTANCE.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void closeWindow() {
		Registration.INSTANCE.setVisible(false);
		Registration.INSTANCE.dispose();
	}
	/**
	 * Create the frame.
	 */
	private Registration() {
		super();
		initialize();
	}
	
	private void initialize() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Sign Up");
		setBounds(100, 100, 622, 401);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnLogin = (JButton) JButtonFactory.getFactory().createComponent("Login");
		btnLogin.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = (LoginPage) LoginPageFactory.getFactory().createPage();
				loginPage.getFrame().setVisible(true);
				closeWindow();
			}
		});
		btnLogin.setBackground(new Color(69, 255, 0));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(241, 50, 121, 43);
		getContentPane().add(btnLogin);
		
		btnSignUp = (JButton) JButtonFactory.getFactory().createComponent("Sign Up");
		btnSignUp.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		btnSignUp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
//					CustomerBUS customerBUS = CustomerBUS.getCustomerBUS();
					NewCustomerBUS newCustomerBUS = new NewCustomerBUS();

					String username = txtUsername.getText();
					String password = passwordField_1.getText();
					newCustomerBUS.SignUp(username,password);
//					Customer customer = new Customer(username);
//					customer.setPassword(password);
//
//					customerBUS.register(customer);
					System.out.println("Sign up");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSignUp.setBackground(new Color(255, 69, 0));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBounds(241, 263, 121, 43);
		getContentPane().add(btnSignUp);
		
		desktopPane_1 = (JDesktopPane) JDesktopPaneFactory.getFactory().createComponent();
		desktopPane_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "New Username & Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		desktopPane_1.setBackground(new Color(0, 102, 0));
		desktopPane_1.setBounds(117, 129, 343, 123);
		getContentPane().add(desktopPane_1);
		
		passwordField_1 = (JTextField) JTextFieldFactory.getFactory().createComponent();
		passwordField_1.setBounds(130, 76, 178, 20);
		desktopPane_1.add(passwordField_1);
		passwordField_1.setColumns(10);
		
		txtUsername = (JTextField) JTextFieldFactory.getFactory().createComponent();
		txtUsername.setBounds(130, 22, 178, 31);
		desktopPane_1.add(txtUsername);
		txtUsername.setToolTipText("New User Name");
		txtUsername.setColumns(10);
		
		lblNewPassword = (JLabel) JLabelFactory.getFactory().createComponent("New Password");
		lblNewPassword.setBounds(10, 74, 100, 23);
		desktopPane_1.add(lblNewPassword);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		lblUsername = (JLabel) JLabelFactory.getFactory().createComponent("New Username");
		lblUsername.setBounds(10, 25, 105, 23);
		desktopPane_1.add(lblUsername);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		label = (JLabel) JLabelFactory.getFactory().createComponent("");
		label.setForeground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon("Icons\\Dark_Red_Background_by_Vik_for_Stuff.png"));
		label.setBounds(0, 0, 616, 373);
		getContentPane().add(label);
	}
	@Override
	public void open() {
		
	}
	@Override
	public void close() {
		
	}
}
