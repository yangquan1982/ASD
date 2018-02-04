package shopping.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import shopping.UserData;
import shopping.bus.IProductManager;
import shopping.bus.ProductManager;
import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;
import shopping.model.Product.ProductList;
import shopping.model.ShoppingCart.LineItem;
import shopping.model.ShoppingCart.ShoppingCart;
import shopping.ui.framework.APage;
import shopping.ui.framework.compfactory.*;
import shopping.ui.framework.pagefactory.*;
import shopping.util.DbUtils;

public class BillPage extends APage implements Serializable {
	private static final long serialVersionUID = 2613235098516131250L;
	private static final JLabel textField_csname = null;
	private JPanel contentPane;
	private JTextField textField_n;
	private JTextField textField_cn;
	private JTextField textField_sn;
	private JTextField textField_ad;
	private JTextField textField_sum;
	private JTextField textField_payment;
	private JTextField textField_change;
	private JLabel lblPayment;
	private JLabel lblChange;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblTotaltk;
	private JLabel lblTk;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblBillPage;
	private JLabel label_6;
	private JLabel lblPaid;
	private JLabel label_5;
	private JButton btnPaid;
	private JButton btnBack;
	private JTable table;
	private JDesktopPane desktopPane;
	private JDesktopPane desktopPane_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	private ShoppingCart shoppingCart = Purchase.shoppingCart;
	private Customer customer = LoginPage.userData.getCustomer();
	private CustomerProfile profile = customer.getCustomerProfile();
	private static BillPage INSTANCE = null;
	/**
	 * Create the frame.
	 */
	private BillPage() {
		initialize();
	}
    public static BillPage getInstance() {
        if (INSTANCE == null) {
            synchronized (BillPage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BillPage();
                }
            }
        }
        return INSTANCE;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPage.INSTANCE.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 736, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = (JLabel) JLabelFactory.getFactory().createComponent("Name");
		label.setBounds(31, 79, 54, 21);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label);
		
		textField_n = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_n.setBounds(85, 80, 70, 20);
		textField_n.setColumns(10);
		textField_n.setText(profile.getFullName().split(" ")[0]);
		contentPane.add(textField_n);
		
		label_1 = (JLabel) JLabelFactory.getFactory().createComponent("Contact");
		label_1.setBounds(31, 113, 46, 14);
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label_1);
		
		textField_cn = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_cn.setBounds(85, 111, 150, 20);
		textField_cn.setColumns(10);
		textField_cn.setText(profile.getEmail());
		contentPane.add(textField_cn);
		
		textField_sn = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_sn.setBounds(165, 80, 70, 20);
		textField_sn.setColumns(10);
		textField_sn.setText(profile.getFullName().split(" ")[1]);
		contentPane.add(textField_sn);
		
		label_2 = (JLabel) JLabelFactory.getFactory().createComponent("Address");
		label_2.setBounds(31, 149, 46, 14);
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label_2);
		
		textField_ad = (JTextField) JTextFieldFactory.getFactory().createComponent();
		textField_ad.setBounds(85, 147, 150, 20);
		textField_ad.setColumns(10);
		textField_ad.setText(profile.getAddress());
		contentPane.add(textField_ad);
		
		desktopPane = (JDesktopPane) JDesktopPaneFactory.getFactory().createComponent();
		desktopPane.setBounds(20, 56, 223, 118);
		desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane.setBackground(new Color(255, 255, 0));
		contentPane.add(desktopPane);
		
		scrollPane = (JScrollPane) JScrollPaneFactory.getFactory().createComponent();
		scrollPane.setBounds(20, 66, 223, 106);
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		contentPane.add(scrollPane);
		
		scrollPane_1 = (JScrollPane) JScrollPaneFactory.getFactory().createComponent();
		scrollPane_1.setBounds(387, 67, 333, 374);
		contentPane.add(scrollPane_1);
		
		table = (JTable) JTableFactory.getFactory().createComponent();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		scrollPane_1.setViewportView(table);
		double sum = 0;
		try {
			ProductList plist = new ProductList();
			IProductManager pManager = ProductManager.getProductManager(plist);
			pManager.clearProductList();
			for (LineItem lineItem:shoppingCart.getLineItemList()){
				pManager.addProduct(lineItem.getProduct());
				sum+= lineItem.getSubtotal();
			}

			TableModel tModel = pManager.setAllProductsToTableModel();
			if (tModel!=null) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				table.setModel(tModel);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			}
			lblTotaltk = (JLabel) JLabelFactory.getFactory().createComponent("Total (Tk)");
			lblTotaltk.setBounds(31, 219, 71, 14);
			contentPane.add(lblTotaltk);
			
			textField_sum = (JTextField) JTextFieldFactory.getFactory().createComponent();
			textField_sum.setBounds(112, 216, 108, 20);
			textField_sum.setText(String.valueOf(sum));
			textField_sum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					
				}
			});
			contentPane.add(textField_sum);
			textField_sum.setColumns(10);
			
			lblPayment = (JLabel) JLabelFactory.getFactory().createComponent("Payment");
			lblPayment.setBounds(31, 254, 83, 14);
			contentPane.add(lblPayment);
			
			lblChange = (JLabel) JLabelFactory.getFactory().createComponent("Change");
			lblChange.setBounds(31, 290, 83, 14);
			contentPane.add(lblChange);
			
			textField_payment = (JTextField) JTextFieldFactory.getFactory().createComponent();
			textField_payment.setBounds(112, 251, 108, 20);
			textField_payment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double sum = Double.valueOf(textField_sum.getText());
					sum = Double.valueOf(textField_payment.getText()) - sum;
					textField_change.setText(String.valueOf(new BigDecimal(sum).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue()));
				}
			});
			contentPane.add(textField_payment);
			textField_payment.setColumns(10);
			
			textField_change = (JTextField) JTextFieldFactory.getFactory().createComponent();
			textField_change.setBounds(112, 287, 108, 20);
			textField_change.setColumns(10);
			contentPane.add(textField_change);
			
			desktopPane_1 = (JDesktopPane) JDesktopPaneFactory.getFactory().createComponent();
			desktopPane_1.setBounds(20, 190, 286, 147);
			desktopPane_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Bill Payment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			desktopPane_1.setBackground(new Color(210, 105, 30));
			contentPane.add(desktopPane_1);
			
			lblTk = (JLabel) JLabelFactory.getFactory().createComponent("Tk");
			lblTk.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(lblTk);
			
			label_3 = (JLabel) JLabelFactory.getFactory().createComponent("Tk");
			label_3.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(label_3);
			
			label_4 = (JLabel) JLabelFactory.getFactory().createComponent("Tk");
			label_4.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(label_4);
			
			btnPaid = (JButton) JButtonFactory.getFactory().createComponent("");
			btnPaid.setBounds(20, 348, 99, 52);
			btnPaid.setIcon(new ImageIcon("Icons\\Cash-register-icon.png"));
			btnPaid.addActionListener(new ActionListener() {
				BillPage frame = BillPage.this;
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Bill Done....!");
					frame.dispose();
					Purchase purchase = null;
					purchase = (Purchase) PurchaseFactory.getFactory().createPage();
					purchase.setVisible(true);
				}
			});
			btnPaid.setBackground(new Color(51, 204, 255));
			btnPaid.setFont(new Font("Castellar", Font.BOLD, 15));
			contentPane.add(btnPaid);
			
			btnBack = (JButton) JButtonFactory.getFactory().createComponent("");
			btnBack.setBounds(200, 348, 80, 52);
			btnBack.setIcon(new ImageIcon("Icons\\previous.jpeg"));
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnBack.setBackground(new Color(255, 204, 51));
			btnBack.setFont(new Font("Castellar", Font.BOLD, 15));
			contentPane.add(btnBack);
			
			lblBillPage = (JLabel) JLabelFactory.getFactory().createComponent("Bill Page");
			lblBillPage.setForeground(Color.WHITE);
			lblBillPage.setFont(new Font("Algerian", Font.BOLD, 15));
			lblBillPage.setBounds(355, 21, 115, 32);
			contentPane.add(lblBillPage);
			
			label_6 = (JLabel) JLabelFactory.getFactory().createComponent("");
			label_6.setIcon(new ImageIcon("Icons\\dollars.png"));
			label_6.setBounds(270, 11, 93, 58);
			contentPane.add(label_6);
			
			lblPaid = (JLabel) JLabelFactory.getFactory().createComponent("Paid");
			lblPaid.setForeground(new Color(255, 255, 255));
			lblPaid.setFont(new Font("Forte", Font.BOLD, 25));
			lblPaid.setBounds(31, 411, 77, 21);
			contentPane.add(lblPaid);
			
			label_5 = (JLabel) JLabelFactory.getFactory().createComponent("");
			label_5.setIcon(new ImageIcon("Icons\\vista_styled_hd_background_by_jcsawyer.jpg"));
			label_5.setBounds(0, 0, 720, 454);
			contentPane.add(label_5);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}
}
