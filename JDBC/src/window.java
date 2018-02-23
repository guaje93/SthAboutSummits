import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import database.DataBaseDirector;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class window {

	private JFrame frame;
	private JTable table_2;
	DataBaseDirector j;
	window2 w2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
					window.frame.setTitle("Mountains v1.0");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public window() {
		initialize();
	}

	private void initialize() {

		j = new DataBaseDirector();

		frame = new JFrame();
		frame.setBounds(100, 100, 638, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//////////////////////////////////////////////////////////////////////////////

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(296, 65, 300, 258);
		frame.getContentPane().add(scrollPane);

		table_2 = new JTable();
		table_2.setSurrendersFocusOnKeystroke(true);
		table_2.setBorder(null);
		table_2.setEnabled(false);
		scrollPane.setViewportView(table_2);
		table_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		/////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel_1 = new JLabel("New label");

		JSlider slider = new JSlider();

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				int k = slider.getValue();

				j = new DataBaseDirector(k);

				table_2.setModel(new DefaultTableModel(j.setTableContent(), j.setTableColumns()));
				table_2.getColumnModel().getColumn(0).setPreferredWidth(25);
				table_2.getColumnModel().getColumn(1).setPreferredWidth(100);
				table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
				table_2.getColumnModel().getColumn(3).setPreferredWidth(50);

				lblNewLabel_1.setText(Integer.toString(slider.getValue()));
			}
		});

		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMinorTickSpacing(100);
		slider.setMinimum(8000);
		slider.setMaximum(8900);
		slider.setBounds(40, 61, 40, 258);

		frame.getContentPane().add(slider);

		////////////////////////////////////////////////////////////////

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel.setBounds(117, 65, 169, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblWybierzGr = new JLabel("Wybierz górę:");
		lblWybierzGr.setBounds(5, 8, 88, 14);
		panel.add(lblWybierzGr);

		textField = new JTextField();
		textField.setBounds(96, 5, 68, 20);
		panel.add(textField);
		textField.setColumns(10);

		/////////////////////////////////////////////////////////////

		JButton btnNewButton_1 = new JButton("Więcej info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 	
				if(Integer.valueOf(textField.getText())<=j.setTableContent().length && Integer.valueOf(textField.getText())>0) {
				String[] s = j.open(Integer.valueOf(textField.getText()));
				w2 = new window2(s[0], s[1], s[2]);
				}
				else
					JOptionPane.showMessageDialog(null, "Błędna liczba");
			}
		});
		btnNewButton_1.setBounds(5, 30, 159, 23);
		panel.add(btnNewButton_1);

		// TITLE
		JLabel lblNewLabel = new JLabel("Program zawierajacy kilka ciekawostek o górach wysokich");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 5, 556, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(117, 133, 169, 29);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWysoko = new JLabel("Wysokość powyżej:");
		lblWysoko.setBounds(5, 5, 115, 14);
		panel_1.add(lblWysoko);
		
//		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(125, 5, 34, 14);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(117, 167, 169, 156);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 169, 156);
		panel_2.add(lblNewLabel_2);
		insertPicture("C:\\Users\\Kubek\\eclipse-workspace\\JDBC\\mountains\\mountain.jpg", lblNewLabel_2);
	}
	
	public void insertPicture(String path, JLabel Label1) {

		try {
			File file = new File(path);
			BufferedImage bi = ImageIO.read(file);
			ImageIcon imgIcon = new ImageIcon(bi);
			Label1.setIcon(imgIcon);
		} catch (IOException ex) {
			Logger.getLogger(window2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}