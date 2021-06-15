import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.SpinnerNumberModel;

public class wdyclothes {

	private int hargaKP;
	private int hargaU;
	
	private JFrame frame;
	private JTextField tfNP;
	private JTextField tfH;
	private JTable table;
	private DefaultTableModel dtm;
	private JComboBox cmbJP;
	private JComboBox cmbKP;
	private JComboBox cmbU;
	private JSpinner spnJ;
	
	ArrayList<Pelanggan> pembeli = new ArrayList<Pelanggan>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wdyclothes window = new wdyclothes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public wdyclothes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dtm = new DefaultTableModel();
		dtm.setColumnCount(0);
		dtm.addColumn("No.");
		dtm.addColumn("Nama");
		dtm.addColumn("Jenis");
		dtm.addColumn("Kode");
		dtm.addColumn("Uk");
		dtm.addColumn("Juml");
		dtm.addColumn("Harga");
		
		
		hargaKP=0;
		hargaU=0;
		
		frame = new JFrame("wdyclothes");
		frame.setResizable(false);
		frame.setBounds(100, 100, 661, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Buat Pesanan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NamaPembeli = tfNP.getText();
				String JenisPakaian = cmbJP.getSelectedItem().toString();
				String KodePakaian = cmbKP.getSelectedItem().toString();
				String Ukuran = cmbU.getSelectedItem().toString();
				int Jumlah = (int) spnJ.getValue();
				int HargaTotal = Integer.valueOf(tfH.getText());
				pembeli.add(new Pelanggan(NamaPembeli, JenisPakaian, KodePakaian, Ukuran, Jumlah, HargaTotal));
				refreshTable();
				
			}
		});
		btnNewButton.setBounds(65, 260, 113, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nama Pembeli");
		lblNewLabel_1.setBounds(32, 55, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfNP = new JTextField();
		tfNP.setBounds(115, 52, 86, 20);
		frame.getContentPane().add(tfNP);
		tfNP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kode Pakaian");
		lblNewLabel_2.setBounds(32, 124, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jumlah");
		lblNewLabel_3.setBounds(32, 186, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(65, 161, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ukuran");
		lblNewLabel_5.setBounds(32, 157, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfH = new JTextField();
		tfH.setEditable(false);
		tfH.setBounds(115, 215, 86, 20);
		frame.getContentPane().add(tfH);
		tfH.setColumns(10);
		
		cmbU = new JComboBox();
		cmbU.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		cmbU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbU.getSelectedItem() == "S") {
					hargaU= 0;
				}
				if(cmbU.getSelectedItem() == "M") {
					hargaU= 5000;
				}
				if(cmbU.getSelectedItem() == "L") {
					hargaU= 6000;
				}
				if(cmbU.getSelectedItem() == "XL") {
					hargaU= 7000;
				}
				if(cmbU.getSelectedItem() == "XXL") {
					hargaU= 8000;
				}
			}
		});
		
		cmbU.setBounds(115, 153, 86, 22);
		frame.getContentPane().add(cmbU);
		
		JLabel lblNewLabel = new JLabel("Jenis Pakaian");
		lblNewLabel.setBounds(32, 91, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		cmbKP = new JComboBox();
		cmbKP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Baju Kaos
				if(cmbKP.getSelectedItem() == "BK-S101") {
					hargaKP = 180000;
				}
				if(cmbKP.getSelectedItem() == "BK-S102") {
					hargaKP = 195000;
				}
				if(cmbKP.getSelectedItem() == "BK-S103") {
					hargaKP = 190000;
				}
				if(cmbKP.getSelectedItem() == "BK-S104") {
					hargaKP = 185000;
				}
				if(cmbKP.getSelectedItem() == "BK-S105") {
					hargaKP = 160000;
				}
				
				//Baju Kemeja
				if(cmbKP.getSelectedItem() == "BK-201") {
					hargaKP = 100000;
				}
				if(cmbKP.getSelectedItem() == "BK-202") {
					hargaKP = 115000;
				}
				if(cmbKP.getSelectedItem() == "BK-203") {
					hargaKP = 110000;
				}
				if(cmbKP.getSelectedItem() == "BK-204") {
					hargaKP = 110000;
				}
				if(cmbKP.getSelectedItem() == "BK-205") {
					hargaKP = 120000;
				}
				
				//Celana Jeans
				if(cmbKP.getSelectedItem() == "CJ-301") {
					hargaKP = 190000;
				}
				if(cmbKP.getSelectedItem() == "CJ-302") {
					hargaKP = 180000;
				}
				if(cmbKP.getSelectedItem() == "CJ-303") {
					hargaKP = 200000;
				}
				if(cmbKP.getSelectedItem() == "CJ-304") {
					hargaKP = 195000;
				}
				if(cmbKP.getSelectedItem() == "CJ-305") {
					hargaKP = 195000;
				}
				
				//Celana Kain
				if(cmbKP.getSelectedItem() == "CK-401") {
					hargaKP = 120000;
				}
				if(cmbKP.getSelectedItem() == "CK-402") {
					hargaKP = 145000;
				}
				if(cmbKP.getSelectedItem() == "CK-403") {
					hargaKP = 135000;
				}
				if(cmbKP.getSelectedItem() == "CK-404") {
					hargaKP = 105000;
				}
				if(cmbKP.getSelectedItem() == "CK-405") {
					hargaKP = 115000;
				}
			}
		});
				
		cmbKP.setBounds(115, 120, 86, 22);
		frame.getContentPane().add(cmbKP);
		
		JLabel lblNewLabel_6 = new JLabel("Harga");
		lblNewLabel_6.setBounds(32, 218, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		cmbJP = new JComboBox();
		cmbJP.setModel(new javax.swing.DefaultComboBoxModel<>(new String [] { "Baju Kaos","Baju Kemeja","Celana Jeans","Celana Kain"}));
		cmbJP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbJP.getSelectedItem() == "Baju Kaos") {
					cmbKP.setModel(new DefaultComboBoxModel(new String[] {"BK-S101", "B-S102", "B-S103", "B-S104", "B-S105"}));
				}
				if(cmbJP.getSelectedItem() == "Baju Kemeja"){
					cmbKP.setModel(new DefaultComboBoxModel(new String[] {"BK-201", "BK-202", "BK-203", "BK-204", "BK-205"}));
				}
				if(cmbJP.getSelectedItem() == "Celana Jeans") {
					cmbKP.setModel(new DefaultComboBoxModel<>(new String[] {"CJ-301", "CJ-302", "CJ-303", "CJ-304", "CJ-305"}));
				}
				if(cmbJP.getSelectedItem() == "Celana Kain") {
					cmbKP.setModel(new DefaultComboBoxModel<>(new String[] {"CK-401", "CK-402", "CK-403", "CK-404", "CK-405"}));
				}
				
			}
		});
		cmbJP.setBounds(115, 87, 86, 22);
		frame.getContentPane().add(cmbJP);
		
		spnJ = new JSpinner();
		spnJ.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnJ.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				 int harga = hargaKP + hargaU;
				 int hargaTotal = harga * ((int) spnJ.getValue());
				 tfH.setText(String.valueOf(hargaTotal));
			}
		});
		spnJ.setBounds(115, 183, 86, 20);
		frame.getContentPane().add(spnJ);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 48, 392, 226);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(wdyclothes.class.getResource("/images/wdy(2).png")));
		lblNewLabel_7.setBounds(32, 4, 169, 40);
		frame.getContentPane().add(lblNewLabel_7);
	}
	
	public void refreshTable() {
		
		
		dtm.setRowCount(0);
		for(int i = 0; i < pembeli.size();i++) {
			String NamaPembeli = pembeli.get(i).NamaPembeli;
			String JenisPakaian = pembeli.get(i).JenisPakaian;
			String KodePakaian = pembeli.get(i).KodePakaian;
			String Ukuran = pembeli.get(i).Ukuran;
			int Jumlah = pembeli.get(i).Jumlah;
			int HargaTotal = pembeli.get(i).HargaTotal;
			Object[] konsumen = {1+i,NamaPembeli, JenisPakaian, KodePakaian, Ukuran, Jumlah, HargaTotal};
			dtm.addRow(konsumen);
		}
		
	}
}