package shopping.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import framework.pagenavigation.AbstractFactory.ConcreteFactory.LogMainNavFactory;
import framework.pagenavigation.AbstractFactory.ConcreteFactory.MainPListNavFactory;
import framework.pagenavigation.AbstractFactory.ConcreteFactory.MainPurchaseNavFactory;
import framework.pagenavigation.FactoryMethod.component.*;
import framework.pagenavigation.FactoryMethod.page.*;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.MainPListNavigator;
import shopping.ui.abstractproduct.APage;

public class MainPanel extends APage implements Serializable {
	private static final long serialVersionUID = -7913300791375041079L;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_5;
	private ProductListPage pListPage;
	private String customName;
	private static MainPanel INSTANCE = null;
	/**
	 * Create the frame.
	 */
	private MainPanel(EPageName name, String customName, APageNavigator navigator) {
		super(name, navigator);
		this.customName = customName;
	}
    public static MainPanel getInstance(EPageName name, String customName, APageNavigator navigator) {
        if (INSTANCE == null) {
            synchronized (MainPanel.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MainPanel(name, customName, navigator);
                }
            }
        }
        return INSTANCE;
    }
    
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainPanel.getInstance("Admin").setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		setResizable(false);
		setType(Type.POPUP);
		setFont(new Font("Lucida Fax", Font.BOLD, 14));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 488);
		contentPane = (JPanel) JPanelFactory.getFactory().createComponent();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = (JLabel) JLabelFactory.getFactory().createComponent("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		btnNewButton_2 = (JButton) JButtonFactory.getFactory().createComponent("Purchase");
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(0, 201, 145, 35);
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		if (customName.equals("admin") || customName.equals("Admin")) {
			btnNewButton_2.setEnabled(false);
		}
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APageNavigator mainPurNavigator = MainPurchaseNavFactory.getFactory().createNavigator();
				APage mainPage = MainPurchaseNavFactory.getFactory().createPageA(EPageName.MAINPANEL, mainPurNavigator);
				APage purPage = MainPurchaseNavFactory.getFactory().createPageB(EPageName.PURCHASE, mainPurNavigator);
				mainPage.setNavigator(mainPurNavigator);
				purPage.setNavigator(mainPurNavigator);
				mainPurNavigator.setCurrentState(mainPurNavigator.getFromAToBState());
				mainPurNavigator.setPageAB(mainPage, purPage);
				mainPage.navigate();
			}
		});
		
		label_2 = (JLabel) JLabelFactory.getFactory().createComponent("");
		label_2.setBounds(155, 106, 592, 354);
		label_2.setIcon(new ImageIcon("Icons\\1437265607286.jpg"));
		contentPane.add(label_2);
		
		btnNewButton = (JButton) JButtonFactory.getFactory().createComponent("Product List");
		btnNewButton.setForeground(new Color(102, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 109, 145, 35);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		if (!customName.equals("admin") && !customName.equals("Admin")) {
			btnNewButton.setEnabled(false);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APageNavigator mainPListNavigator = MainPListNavFactory.getFactory().createNavigator();
				APage mainPage = MainPListNavFactory.getFactory().createPageA(EPageName.MAINPANEL, mainPListNavigator);
				APage pListPage = MainPListNavFactory.getFactory().createPageB(EPageName.PLISTPAGE, mainPListNavigator);
				mainPage.setNavigator(mainPListNavigator);
				pListPage.setNavigator(mainPListNavigator);
				mainPListNavigator.setCurrentState(mainPListNavigator.getFromAToBState());
				mainPListNavigator.setPageAB(mainPage, pListPage);
				mainPage.navigate();
			}
		});
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_5 = (JButton) JButtonFactory.getFactory().createComponent("Logout");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(0, 389, 145, 25);
		btnNewButton_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				APageNavigator logMainNavigator = LogMainNavFactory.getFactory().createNavigator();
				APage mainPage = LogMainNavFactory.getFactory().createPageB(EPageName.MAINPANEL, logMainNavigator);
				APage loginPage = LogMainNavFactory.getFactory().createPageA(EPageName.LOGINPAGE, logMainNavigator);
				mainPage.setNavigator(logMainNavigator);
				loginPage.setNavigator(logMainNavigator);
				logMainNavigator.setCurrentState(logMainNavigator.getFromBToAState());
				logMainNavigator.setPageAB(loginPage, mainPage);
				mainPage.navigate();
			}
		});
		contentPane.add(btnNewButton_5);
		
		label_3 = (JLabel) JLabelFactory.getFactory().createComponent("");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setIcon(new ImageIcon("Icons\\f9ab3cd3d492197df7be5a99026468db.jpg"));
		label_3.setBounds(0, 0, 728, 472);
		contentPane.add(label_3);
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
