package shopping.ui;
import shopping.UserData;
import shopping.bus.CustomerBUS;
import shopping.bus.ICustomerBUS;
import shopping.bus.NewCostomerBUS;
import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;
import shopping.ui.abstractproduct.APage;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
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

import framework.pagenavigation.AbstractFactory.ConcreteFactory.LogMainNavFactory;
import framework.pagenavigation.AbstractFactory.ConcreteFactory.RegLogNavFactory;
import framework.pagenavigation.FactoryMethod.component.*;
import framework.pagenavigation.FactoryMethod.page.*;
import framework.pagenavigation.Mediator.AbstractMediator.*;

public class LoginPage extends APage implements Serializable {
	private static final long serialVersionUID = -535506443986136694L;
	private JFrame frame;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnExit;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNewLabel_total;
	public static UserData userData = new UserData();
	private static LoginPage INSTANCE = null;
	/**
	 * Create the application.
	 */
	private LoginPage(EPageName name, APageNavigator navigator) {
		super(name, navigator);
	}
    public static LoginPage getInstance(EPageName name, APageNavigator navigator) {
        if (INSTANCE == null) {
            synchronized (LoginPage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LoginPage(name, navigator);
                }
            }
        }
        return INSTANCE;
    }
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
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
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	public JButton getBtnSignUp() {
		return btnSignUp;
	}
	public void setBtnSignUp(JButton btnSignUp) {
		this.btnSignUp = btnSignUp;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public JLabel getLblNewLabel_total() {
		return lblNewLabel_total;
	}
	public void setLblNewLabel_total(JLabel lblNewLabel_total) {
		this.lblNewLabel_total = lblNewLabel_total;
	}
	public static UserData getUserData() {
		return userData;
	}
	public static void setUserData(UserData userData) {
		LoginPage.userData = userData;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = (JFrame) JFrameFactory.getFactory().createComponent();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\shop-icon.png"));
		frame.setBackground(new Color(153, 153, 204));
		frame.setBounds(100, 100, 727, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = (JLabel) JLabelFactory.getFactory().createComponent("");
		lblNewLabel.setIcon(new ImageIcon("Icons\\Office-Customer-Male-Light-icon.png"));
		lblNewLabel.setBounds(210, 172, 61, 64);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = (JLabel) JLabelFactory.getFactory().createComponent("");
		lblNewLabel_1.setIcon(new ImageIcon("Icons\\Security-Password-2-icon.png"));
		lblNewLabel_1.setVerifyInputWhenFocusTarget(false);
		lblNewLabel_1.setBounds(415, 172, 61, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textFieldUN.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		textFieldUN.setBounds(176, 247, 135, 42);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		btnExit = (JButton) JButtonFactory.getFactory().createComponent();
		btnExit.setIcon(new ImageIcon("Icons\\exit.jpg"));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					System.exit(0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnExit.setBounds(600, 314, 87, 35);
		getContentPane().add(btnExit);
		frame.getContentPane().add(btnExit);
		
		btnLogin = (JButton) JButtonFactory.getFactory().createComponent("");
		btnLogin.setIcon(new ImageIcon("Icons\\login.jpg"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String username = textFieldUN.getText();
					String password = passwordField.getText();
					NewCostomerBUS newCostomerBUS = new NewCostomerBUS();
					boolean login = newCostomerBUS.login(username,password);
					ICustomerBUS customerBUS = CustomerBUS.getCustomerBUS();
					if (login)
					{
						Customer customer = customerBUS.getCustomerByUsername(username);
						CustomerProfile profile = customerBUS.getCustomerProfileByUsername(username);
						if(profile != null){
							customer.setCustomerProfile(profile);
							userData.setCustomer(customer);
						}						
						APageNavigator logMainNavigator = LogMainNavFactory.getFactory().createNavigator();
						APage mainPage = LogMainNavFactory.getFactory().createPageB(EPageName.MAINPANEL, logMainNavigator);
						APage loginPage = LogMainNavFactory.getFactory().createPageA(EPageName.LOGINPAGE, logMainNavigator);
						loginPage.setNavigator(logMainNavigator);
						mainPage.setNavigator(logMainNavigator);
						logMainNavigator.setCurrentState(logMainNavigator.getFromAToBState());
						((MainPanel) mainPage).setCustomName(username);
						logMainNavigator.setPageAB(loginPage, mainPage);
						loginPage.navigate();
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
		
		btnSignUp = (JButton) JButtonFactory.getFactory().createComponent("");
		btnSignUp.setIcon(new ImageIcon("Icons\\sign-up.png"));
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				APageNavigator regLogNavigator = RegLogNavFactory.getFactory().createNavigator();
				APage regPage = RegLogNavFactory.getFactory().createPageA(EPageName.REGPAGE, regLogNavigator);
				APage loginPage = RegLogNavFactory.getFactory().createPageB(EPageName.LOGINPAGE, regLogNavigator);
				regPage.setNavigator(regLogNavigator);
				loginPage.setNavigator(regLogNavigator);
				regLogNavigator.setCurrentState(regLogNavigator.getFromBToAState());
				regLogNavigator.setPageAB(regPage, loginPage);
				loginPage.navigate();
			}
		});
		btnSignUp.setBounds(301, 354, 87, 28);
		frame.getContentPane().add(btnSignUp);
		
		passwordField = (JPasswordField) JPasswordFieldFactory.getFactory().createComponent();
		passwordField.setBounds(382, 248, 135, 42);
		frame.getContentPane().add(passwordField);
		
		label = (JLabel) JLabelFactory.getFactory().createComponent("");
		label.setIcon(new ImageIcon("Icons\\supershop-logo.png"));
		label.setBounds(132, 0, 412, 109);
		frame.getContentPane().add(label);
		
		lblNewLabel_total = (JLabel) JLabelFactory.getFactory().createComponent("Login Page");
		lblNewLabel_total.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblNewLabel_total.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_total.setForeground(Color.ORANGE);
		lblNewLabel_total.setBackground(Color.ORANGE);
		lblNewLabel_total.setIcon(new ImageIcon("Icons\\cool-light-blue-backgrounds.jpg"));
		lblNewLabel_total.setBounds(0, 0, 721, 445);
		frame.getContentPane().add(lblNewLabel_total);
		INSTANCE.getFrame().setVisible(true);
		INSTANCE.setVisible(true);
	}

	@Override
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();//Facade
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void navigate() {
		navigator.navigate(this);
	}
}
