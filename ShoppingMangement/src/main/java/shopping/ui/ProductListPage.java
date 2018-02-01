package shopping.ui;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import shopping.bus.ProductManager;
import shopping.model.Product.IProductBuilder;
import shopping.model.Product.Product;
import shopping.model.Product.ProductBuilder;
import shopping.model.Product.ProductCategory;
import shopping.model.Product.ProductList;
import shopping.model.Product.ProductSupplier;
import shopping.util.DbUtils;

import java.awt.SystemColor;
/**
 * @author Quan Yang
 *
 */
public class ProductListPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private ProductManager pManager;
	private ProductList plist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListPage frame = new ProductListPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		Connection connection = null;
		private JTextField txtSearchProducts;
		private JLabel lblProductIsDiscount;
		private JLabel lblProductName;
		private JLabel lblProductCatagory;
		private JLabel lblProductPrice;
		private JTextField textField_id;
		private JTextField textField_name;
		private JTextField textField_catagory;
		private JTextField textField_price;
		private JButton btnAddProduct;
		private JButton btnDeleteProduct;
		private JButton btnUpdate;
		private JLabel lblUnit;
		private JLabel lblSupplier;
		private JTextField textField_supplier;
		private JTextField textField_ttcnt;
		private JTextField textField_address;
		private JTextField textField_phone;
		private JTextField textField_discount;
		private JLabel label_1;
		private JLabel label_2;
		private JLabel label_3;
		private JLabel label_4;
		private JScrollPane scrollPane;
		private JLabel label_5;
		private JCheckBox checkBox_discount;
		
		public void refreshTable ()
		{
			try {
				pManager.getAllProducts();
				TableModel tModel = pManager.setAllProductsToTableModel();
				if (tModel!=null) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					table.setModel(tModel);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//					table.setAutoscrolls(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private void clearTable() {
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
			dm.getDataVector().removeAllElements();
			dm.fireTableDataChanged();
		}
	/**
	 * Create the frame.
	 */
	public ProductListPage() {
		plist = new ProductList();
		pManager = ProductManager.getProductManager(plist);
		setResizable(false);
		setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\shopping_bag.png"));
		setTitle("Product List");
		//connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBox.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Product ID", "Product Name", "Product Catagory", "Product Supplier"}));
		comboBox.setBounds(57, 11, 151, 41);
		contentPane.add(comboBox);
		
		txtSearchProducts = new JTextField();
		txtSearchProducts.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
//					String selection= (String)comboBox.getSelectedItem();
//					String query = "select *  from Product where "+selection+"=?";
//					PreparedStatement pst = connection.prepareStatement(query);
//					pst.setString(1, txtSearchProducts.getText());
//					ResultSet rs = pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
//					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		txtSearchProducts.setBounds(57, 56, 151, 30);
		txtSearchProducts.setToolTipText("Search Product s");
		contentPane.add(txtSearchProducts);
		txtSearchProducts.setColumns(10);
		
		JButton btnLoadProducts = new JButton("Load Products");
		btnLoadProducts.setForeground(Color.DARK_GRAY);
		btnLoadProducts.setSelectedIcon(new ImageIcon("Icons\\package_installed_updated.png"));
		btnLoadProducts.setBackground(SystemColor.menu);
		btnLoadProducts.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnLoadProducts.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
		btnLoadProducts.setBounds(528, 47, 191, 47);
		btnLoadProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pManager.getAllProducts();
					TableModel tModel = pManager.setAllProductsToTableModel();
					if (tModel!=null) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						table.setModel(tModel);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//						table.setAutoscrolls(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnLoadProducts);
		checkBox_discount = new JCheckBox("");
		checkBox_discount.setEnabled(true);
		checkBox_discount.setBounds(147, 130, 18, 18);
		contentPane.add(checkBox_discount);
//		textField_id = new JTextField();
//		textField_id.setBounds(147, 130, 109, 20);
//		contentPane.add(textField_id);
//		textField_id.setColumns(10);
		
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Products Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
//					int row = table.getSelectedRow();
//					String p_id_=(table.getModel().getValueAt(row, 0)).toString();
//					String query = "select * from Product where p_id='"+p_id_+"' ";
//					PreparedStatement pst = connection.prepareStatement(query);
//					ResultSet rs=pst.executeQuery();
//					
//					while (rs.next())
//							{
//								textField_id.setText(rs.getString("p_id"));
//								textField_name.setText(rs.getString("p_name"));
//								textField_catagory.setText(rs.getString("p_catagory"));
//								textField_price.setText(rs.getString("p_price"));
//								textField_unit.setText(rs.getString("p_unit"));
//							}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setBounds(333, 97, 386, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
//					int row = table.getSelectedRow();
//					String p_id_=(table.getModel().getValueAt(row, 0)).toString();
//					String query = "select * from Product where p_id='"+p_id_+"' ";
//					PreparedStatement pst = connection.prepareStatement(query);
//					ResultSet rs=pst.executeQuery();
//					
//					while (rs.next())
//							{
//						textField_id.setText(rs.getString("p_id"));
//						textField_name.setText(rs.getString("p_name"));
//						textField_catagory.setText(rs.getString("p_catagory"));
//						textField_price.setText(rs.getString("p_price"));
//						textField_unit.setText(rs.getString("p_unit"));
//							}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textField_name = new JTextField();
		textField_name.setBounds(147, 160, 109, 20);
		textField_name.setColumns(10);
		contentPane.add(textField_name);
		
		textField_catagory = new JTextField();
		textField_catagory.setBounds(147, 190, 109, 20);
		textField_catagory.setColumns(10);
		contentPane.add(textField_catagory);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(147, 220, 109, 20);
		contentPane.add(textField_price);
		
		textField_ttcnt = new JTextField();
		textField_ttcnt.setColumns(10);
		textField_ttcnt.setBounds(147, 250, 109, 20);
		contentPane.add(textField_ttcnt);
		
		btnAddProduct = new JButton("Add");
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddProduct.setBounds(5, 420, 88, 30);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
//				String query = "insert into Product (p_id,p_name,p_catagory,p_price,p_unit) values (?,?,?,?,?)";
//				PreparedStatement pst = connection.prepareStatement(query);
//				if (textField_id.getText().equals(""))
//				{
//					pst.setString(1, null);
//					
//				}
//				else {
//					pst = connection.prepareStatement(query);
//					pst.setString(1, textField_id.getText());
//				}
//				
//				pst.setString(2, textField_name.getText());
//				pst.setString(3, textField_catagory.getText());
//				pst.setString(4, textField_price.getText());
//				pst.setString(5, textField_unit.getText());
//				
//				pst.execute();
//				pst.close();
//				
//				JOptionPane.showMessageDialog(null, "Data Saved");
					IProductBuilder pBuilder = new ProductBuilder();
					pBuilder.buildProductIdName(UUID.randomUUID().toString(), textField_name.getText());
					pBuilder.buildProductCategory(new ProductCategory(null, textField_catagory.getText()));
					pBuilder.buildProductSupplier(new ProductSupplier(null, 
							textField_supplier.getText(), textField_address.getText(), textField_phone.getText()));
					String strPrice = textField_price.getText();
					double price = Double.valueOf(strPrice);
					String strCnt = textField_ttcnt.getText();
					int ttCnt = Integer.valueOf(strCnt);
					pBuilder.buildPriceAndCount(price, ttCnt);
					String strDiscount = textField_discount.getText();
					double discount = Double.valueOf(strDiscount);
					boolean isDiscount = true;
					if (isDiscount) {
						pBuilder.buildDiscount(isDiscount, discount);
					}
					Product product = pBuilder.getProduct();
					if (pManager.addNewProduct(product)) {
						JOptionPane.showMessageDialog(null, "Data Saved");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		
		textField_supplier = new JTextField();
		textField_supplier.setBounds(147, 280, 109, 20);
		textField_supplier.setColumns(10);
		contentPane.add(textField_supplier);
		
		textField_address = new JTextField();
		textField_address.setBounds(147, 310, 109, 20);
		textField_address.setColumns(10);
		contentPane.add(textField_address);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(147, 340, 109, 20);
		textField_phone.setColumns(10);
		contentPane.add(textField_phone);
		
		textField_discount = new JTextField();
		textField_discount.setBounds(147, 370, 109, 20);
		textField_discount.setColumns(10);
		contentPane.add(textField_discount);
//		label_1 = new JLabel("");
//		label_1.setIcon(new ImageIcon("Icons\\plus.png"));
//		label_1.setBounds(28, 397, 48, 46);
//		contentPane.add(label_1);
		contentPane.add(btnAddProduct);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(103, 420, 88, 30);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
//					String query = "Update Product set p_id='"+textField_id.getText()+"' , p_name='"+textField_name.getText()+"' , p_catagory='"+textField_catagory.getText()+"' , p_price='"+textField_price.getText()+"', p_unit='"+textField_unit.getText()+"' where p_id='"+textField_id.getText()+"' ";
//					PreparedStatement pst = connection.prepareStatement(query);
//					
//					pst.execute();
//					JOptionPane.showMessageDialog(null, "Data updated");
//					pst.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				
				
			}
		});
		
		btnDeleteProduct = new JButton("Delete");
		btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteProduct.setBounds(203, 420, 88, 30);
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
//					String query = "Delete from Product where p_id='"+textField_id.getText()+"'";
//					PreparedStatement pst = connection.prepareStatement(query);
//					
//					pst.execute();
//					JOptionPane.showMessageDialog(null, "Data Deleted");
//					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				refreshTable();
			}
		});
		
//		label_3 = new JLabel("");
//		label_3.setIcon(new ImageIcon("Icons\\bt_remove.png"));
//		label_3.setBounds(226, 397, 48, 46);
//		contentPane.add(label_3);
		contentPane.add(btnDeleteProduct);
//		
//		label_2 = new JLabel("");
//		label_2.setIcon(new ImageIcon("Icons\\system_software_update.png"));
//		label_2.setBounds(127, 397, 48, 46);
//		contentPane.add(label_2);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\shopping_bag.png"));
		label.setBounds(273, 11, 48, 58);
		contentPane.add(label);
		
		JLabel lblProductList = new JLabel("Product List");
		lblProductList.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
		lblProductList.setBounds(333, 22, 123, 47);
		contentPane.add(lblProductList);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("Icons\\find.png"));
		label_4.setBounds(5, 50, 46, 47);
		contentPane.add(label_4);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Product Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		desktopPane.setBackground(new Color(102, 204, 102));
		desktopPane.setBounds(3, 97, 286, 315);
		contentPane.add(desktopPane);
		
		lblProductIsDiscount = new JLabel("Is Discount");
		lblProductIsDiscount.setBounds(10, 26, 150, 30);
		desktopPane.add(lblProductIsDiscount);
		lblProductIsDiscount.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblProductName = new JLabel("Name");
		lblProductName.setBounds(10, 56, 150, 30);
		desktopPane.add(lblProductName);
		lblProductName.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblProductCatagory = new JLabel("Catagory Name");
		lblProductCatagory.setBounds(10, 86, 150, 30);
		desktopPane.add(lblProductCatagory);
		lblProductCatagory.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblProductPrice = new JLabel("Unit Price");
		lblProductPrice.setBounds(10, 116, 150, 30);
		desktopPane.add(lblProductPrice);
		lblProductPrice.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblUnit = new JLabel("Total Count");
		lblUnit.setBounds(10, 146, 150, 30);
		desktopPane.add(lblUnit);
		lblUnit.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblSupplier = new JLabel("Supplier Name");
		lblSupplier.setBounds(10, 176, 150, 30);
		desktopPane.add(lblSupplier);
		lblSupplier.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblSupplier = new JLabel("Supplier Address");
		lblSupplier.setBounds(10, 206, 150, 30);
		desktopPane.add(lblSupplier);
		lblSupplier.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblSupplier = new JLabel("Supplier Phone");
		lblSupplier.setBounds(10, 236, 150, 30);
		desktopPane.add(lblSupplier);
		lblSupplier.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		lblSupplier = new JLabel("Discount Ratio");
		lblSupplier.setBounds(10, 266, 150, 30);
		desktopPane.add(lblSupplier);
		lblSupplier.setFont(new Font("Siyam Rupali", Font.BOLD, 15));
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("Icons\\default.jpg"));
		label_5.setBounds(1, 0, 728, 456);
		contentPane.add(label_5);
		
		
	}
}
