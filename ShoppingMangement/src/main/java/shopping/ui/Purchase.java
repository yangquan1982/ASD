package shopping.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import framework.pagenavigation.AbstractFactory.ConcreteFactory.MainPurchaseNavFactory;
import framework.pagenavigation.AbstractFactory.ConcreteFactory.PurchaseBillNavFactory;
import framework.pagenavigation.FactoryMethod.component.*;
import framework.pagenavigation.FactoryMethod.page.*;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import shopping.UserData;
import shopping.bus.*;
import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;
import shopping.model.Product.Product;
import shopping.model.Product.ProductList;
import shopping.model.ShoppingCart.LineItem;
import shopping.model.ShoppingCart.Order;
import shopping.model.ShoppingCart.ShoppingCart;
import shopping.ui.abstractproduct.APage;
import shopping.util.DbUtils;

public class Purchase extends APage implements Serializable {
	private static final long serialVersionUID = 5812669177372609562L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnAddToCurt;
	private JButton btnBack;
	private JButton btnLoadProductData;
	private JButton btnNewButton;
	private JTextField textField_cname;
	private JTextField textField_contact;
	private JTextField textField_csname;
	private JTextField textField_address;
	private JTextField textSearchProducts;
	private JTextField textField_name;
	private JTextField textField_catagory;
	private JTextField textField_unit;
	private JTextField textField_price;
	private JDesktopPane desktopPane;
	private JDesktopPane desktopPane_1;
	private JDesktopPane desktopPane_2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lblCatagory;
	private JLabel lblUnit;
	private JLabel lblPrice;
	private JLabel lblPurchasStation;
	private JLabel lblName;
	private JLabel lblContact;
	private JLabel lblAddress;
	private JLabel label;
	private JTable table;
	
	public static int billId = 1;
	private String selectItem;
	public static ShoppingCart shoppingCart = new ShoppingCart();
	private UserData userData = LoginPage.userData;
	private Customer customer = userData.getCustomer();
	private CustomerProfile profile = customer.getCustomerProfile();
	private static Purchase INSTANCE = null;

	private Purchase(EPageName name, APageNavigator navigator) {
		super(name, navigator);
	}
    public static Purchase getInstance(EPageName name, APageNavigator navigator) {
        if (INSTANCE == null) {
            synchronized (Purchase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Purchase(name, navigator);
                }
            }
        }
        return INSTANCE;
    }

	private void initialize() {
		setResizable(false);
		setBackground(new Color(204, 102, 51));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 482);
		contentPane = (JPanel) JPanelFactory.getFactory().createComponent();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPurchasStation = (JLabel) JLabelFactory.getFactory().createComponent("Purchas Station");
		lblPurchasStation.setForeground(new Color(255, 255, 255));
		lblPurchasStation.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
		lblPurchasStation.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblPurchasStation.setBounds(298, 0, 180, 62);
		contentPane.add(lblPurchasStation);
		
		textField_cname = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_cname.setBounds(75, 74, 70, 20);
		String[] fulname = profile.getFullName().split(" ");
		textField_cname.setText(fulname[0]);
		contentPane.add(textField_cname);
		textField_cname.setColumns(10);
		
		lblContact = (JLabel) JLabelFactory.getFactory().createComponent("Contact");
		lblContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblContact.setBounds(21, 107, 46, 14);
		contentPane.add(lblContact);
		
		textField_contact = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_contact.setColumns(10);
		textField_contact.setBounds(75, 105, 150, 20);
		textField_contact.setText(profile.getEmail());
		contentPane.add(textField_contact);
		
		textField_csname = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_csname.setColumns(10);
		textField_csname.setBounds(155, 74, 70, 20);
		if(fulname.length > 1){
			textField_csname.setText(fulname[1]);
		}
		contentPane.add(textField_csname);
		
		lblAddress = (JLabel) JLabelFactory.getFactory().createComponent("Address");
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAddress.setBounds(21, 143, 46, 14);
		contentPane.add(lblAddress);
		
		textField_address = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_address.setColumns(10);
		textField_address.setBounds(75, 141, 150, 20);
		textField_address.setText(profile.getAddress());
		contentPane.add(textField_address);
		
		desktopPane = (JDesktopPane) JDesktopPaneFactory.getFactory().createComponent();
		desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, 
				null, new Color(0, 0, 255)));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 50, 223, 118);
		contentPane.add(desktopPane);
		
		scrollPane = (JScrollPane) JScrollPaneFactory.getFactory().createComponent();
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		scrollPane.setBounds(10, 60, 223, 106);
		contentPane.add(scrollPane);
		
		scrollPane_1 = (JScrollPane) JScrollPaneFactory.getFactory().createComponent();
		scrollPane_1.setBounds(434, 50, 263, 350);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane_1);
		
		table = (JTable) JTableFactory.getFactory().createComponent();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ProductList plist = new ProductList();
		IProductManager pManager = ProductManager.getProductManager(plist);

		pManager.getAllProducts();
		TableModel tModel = pManager.setAllProductsToTableModel();
		if (tModel!=null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			table.setModel(tModel);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					selectItem = table.getValueAt(table.getSelectedRow(), 0).toString();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table);
		
		btnAddToCurt = (JButton) JButtonFactory.getFactory().createComponent("Add");
		btnAddToCurt.setBackground(Color.WHITE);
		btnAddToCurt.setIcon(new ImageIcon("Icons\\shopping_cart.png"));
		btnAddToCurt.setFont(new Font("Vrinda", Font.BOLD, 15));
		btnAddToCurt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					Product product = pManager.getProductById(selectItem);
					ILineItemBUS lineItemBUS = LineItemBUS.getLineItemBUS();
					IOrderBUS orderBUS = OrderBUS.getOrderBUS();
					LineItem lineItem = new LineItem(product);
					shoppingCart.addCartItem(lineItem);
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnAddToCurt.setBounds(10, 222, 223, 66);
		contentPane.add(btnAddToCurt);
		
		btnBack = (JButton) JButtonFactory.getFactory().createComponent("");
		btnBack.setIcon(new ImageIcon("Icons\\backward.png"));
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				APageNavigator mainPurNavigator = MainPurchaseNavFactory.getFactory().createNavigator();
				APage purPage = MainPurchaseNavFactory.getFactory().createPageB(EPageName.PURCHASE, mainPurNavigator);
				APage mainPage = MainPurchaseNavFactory.getFactory().createPageA(EPageName.MAINPANEL, mainPurNavigator);
				purPage.setNavigator(mainPurNavigator);
				mainPage.setNavigator(mainPurNavigator);
				mainPurNavigator.setCurrentState(mainPurNavigator.getFromBToAState());
				mainPurNavigator.setPageAB(mainPage, purPage);
				purPage.navigate();
			}
		});
		btnBack.setBounds(317, 222, 50, 50);
		contentPane.add(btnBack);
		
		btnNewButton = (JButton) JButtonFactory.getFactory().createComponent("");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				APageNavigator purBillNavigator = PurchaseBillNavFactory.getFactory().createNavigator();
				APage purPage = PurchaseBillNavFactory.getFactory().createPageA(EPageName.PURCHASE, purBillNavigator);
				APage billPage = PurchaseBillNavFactory.getFactory().createPageB(EPageName.BILLPAGE, purBillNavigator);
				purPage.setNavigator(purBillNavigator);
				billPage.setNavigator(purBillNavigator);
				purBillNavigator.setCurrentState(purBillNavigator.getFromAToBState());
				purBillNavigator.setPageAB(purPage, billPage);
				purPage.navigate();
			}
		});
		btnNewButton.setForeground(new Color(0, 204, 0));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setIcon(new ImageIcon("Icons\\shop-icon.png"));
		btnNewButton.setBounds(10, 367, 223, 66);
		contentPane.add(btnNewButton);
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
		if (INSTANCE != null) {
			INSTANCE.setVisible(false);
			INSTANCE.dispose();
			INSTANCE = null;
		}
	}
}
