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
import java.util.List;
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
import javax.swing.ListSelectionModel;
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
		private JButton btnSearch;
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
		
		private void displayResult() {
			clearTable();
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
		}
		private void refreshTable ()
		{
			pManager.getAllProducts();
			displayResult();
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
		comboBox.setModel(new DefaultComboBoxModel
				(new String[] {"Product Name", "Product Catagory", "Product Supplier"}));
		comboBox.setBounds(57, 11, 151, 41);
		contentPane.add(comboBox);
		
		txtSearchProducts = new JTextField();
//		txtSearchProducts.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				
//				try {
//					String selection= (String)comboBox.getSelectedItem();
//					if (selection.equals("Product Name")) {
//						
//					} else if (selection.equals("Product Catagory")) {
//						
//					} else if (selection.equals("Product Supplier")) {
//						
//					}
//					String query = "select *  from Product where "+selection+"=?";
//					PreparedStatement pst = connection.prepareStatement(query);
//					pst.setString(1, txtSearchProducts.getText());
//					ResultSet rs = pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
//					pst.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		txtSearchProducts.setBounds(57, 56, 151, 30);
		txtSearchProducts.setToolTipText("Search Products");
		contentPane.add(txtSearchProducts);
		txtSearchProducts.setColumns(10);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("Icons\\find.png"));
		btnSearch.setBounds(5, 48, 46, 47);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selection= (String)comboBox.getSelectedItem();
				List<Product> products = null;
				if (selection.equals("Product Name")) {
					products = pManager.getProductsByName(txtSearchProducts.getText());
				} else if (selection.equals("Product Catagory")) {
					products = pManager.getProductsByCategoryName(txtSearchProducts.getText());
				} else if (selection.equals("Product Supplier")) {
					products = pManager.getProductsBySupplierName(txtSearchProducts.getText());
				}
				if (products != null) {
					plist.setProducts(products);
				} else {
					return;
				}
				pManager.setList(plist);
				displayResult();
			}
		});
		contentPane.add(btnSearch);
		
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
						clearTable();
						table.setModel(tModel);
						table.getColumnModel().getColumn(0).setMaxWidth(0);
						table.getColumnModel().getColumn(0).setMinWidth(0);
						table.getColumnModel().getColumn(0).setWidth(0);
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
		textField_id = new JTextField();
		
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), 
				"Products Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		scrollPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				try {
//					int row = table.getSelectedRow();
//					String productId = (table.getModel().getValueAt(row, 0)).toString();
//					Product product = pManager.getProductById(productId);
//					if (product==null) {
//						return;
//					}
//					ProductCategory category = pManager.getProductCategoryById(product.getCategory().getId());
//					ProductSupplier supplier = pManager.getProductSupplierById(product.getSupplier().getId());
//					if (category!=null && supplier!=null) {
//						textField_name.setText(product.getName());
//						textField_catagory.setText(category.getCategoryName());
//						textField_price.setText(String.valueOf(product.getUnitPrice()));
//						textField_ttcnt.setText(String.valueOf(product.getTotalCnt()));
//						textField_supplier.setText(supplier.getName());
//						textField_address.setText(supplier.getAddress());
//						textField_phone.setText(supplier.getPhoneNum());
//						textField_discount.setText(String.valueOf(product.getDiscountRatio()));
//					}
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
		scrollPane.setBounds(333, 97, 386, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String productId = (table.getModel().getValueAt(row, 0)).toString();
					Product product = pManager.getProductById(productId);
					if (product==null) {
						return;
					}
					ProductCategory category = pManager.getProductCategoryById(product.getCategory().getId());
					ProductSupplier supplier = pManager.getProductSupplierById(product.getSupplier().getId());
					if (category!=null && supplier!=null) {
						textField_id.setText(product.getId());
						textField_name.setText(product.getName());
						textField_catagory.setText(category.getCategoryName());
						textField_price.setText(String.valueOf(product.getUnitPrice()));
						textField_ttcnt.setText(String.valueOf(product.getTotalCnt()));
						textField_supplier.setText(supplier.getName());
						textField_address.setText(supplier.getAddress());
						textField_phone.setText(supplier.getPhoneNum());
						textField_discount.setText(String.valueOf(product.getDiscountRatio()));
					}					
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
					if (textField_name.getText().trim().equals("") || textField_catagory.getText().trim().equals("")
							|| textField_supplier.getText().trim().equals("") || textField_address.getText().trim().equals("")
							|| textField_phone.getText().trim().equals("") || textField_price.getText().trim().equals("")
							|| textField_ttcnt.getText().trim().equals("") || textField_discount.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Wrong Data");
						return;
					}
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
						refreshTable();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		contentPane.add(btnAddProduct);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(103, 420, 88, 30);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					IProductBuilder pBuilder = new ProductBuilder();
					pBuilder.buildProductIdName(textField_id.getText(), textField_name.getText());
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
					List<ProductCategory> pCategories = 
							pManager.getProductCategoriesByName(textField_catagory.getText());
					if (pCategories != null && !pCategories.isEmpty()) {
						product.getCategory().setId(pCategories.get(0).getId());
					} else {
						ProductCategory newCategory = new ProductCategory(UUID.randomUUID().toString(), 
								textField_catagory.getText());
						pManager.addProductCategory(newCategory);
						product.getCategory().setId(newCategory.getId());
					}
					pManager.getAllProductSuppliers();
					boolean isSupplierExist = false;
					for (ProductSupplier item : pManager.getSuppliers()) {
						if (item.getName().equals(textField_supplier.getText()) 
								&& item.getAddress().equals(textField_address.getText()) 
								&& item.getPhoneNum().equals(textField_phone.getText())) {
							isSupplierExist = true;
							product.getSupplier().setId(item.getId());
							break;
						}
					}
					if (!isSupplierExist) {
						ProductSupplier newSupplier = new ProductSupplier();
						newSupplier.setId(UUID.randomUUID().toString());
						newSupplier.setName(textField_supplier.getText());
						newSupplier.setAddress(textField_address.getText());
						newSupplier.setPhoneNum(textField_phone.getText());
						pManager.addProductSupplier(newSupplier);
						product.getSupplier().setId(newSupplier.getId());
					}
					if (!pManager.updateProduct(product)) {
						System.out.println("Update Data Failed!!!");
						return;
					}
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
					if (textField_name.getText().trim().equals("") || textField_catagory.getText().trim().equals("")
							|| textField_supplier.getText().trim().equals("") || textField_address.getText().trim().equals("")
							|| textField_phone.getText().trim().equals("") || textField_price.getText().trim().equals("")
							|| textField_ttcnt.getText().trim().equals("") || textField_discount.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Wrong Data");
						return;
					}
					if (!pManager.removeProductById(textField_id.getText())) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		
		contentPane.add(btnDeleteProduct);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\shopping_bag.png"));
		label.setBounds(273, 11, 48, 58);
		contentPane.add(label);
		
		JLabel lblProductList = new JLabel("Product List");
		lblProductList.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
		lblProductList.setBounds(333, 22, 123, 47);
		contentPane.add(lblProductList);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), 
				"Product Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
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
