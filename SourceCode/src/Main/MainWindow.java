package Main;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import database.DataBaseDirector;

public class MainWindow {

	private JFrame frame;
	private JTable tableMountainsList;
	private DataBaseDirector dataBaseDirector;
	private JTextField textFieldChoice;
	private JLabel labelHeightValue = new JLabel("New label");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainWindow();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {

		// POdczytanie bazy danych
		dataBaseDirector = new DataBaseDirector();

		// Wczytanie poszczególnych komponentow graficznych
		setFrame();
		setTable();
		setSlider();
		setPanelChoice();
		setPanelHeight();
		setTitleLabel();
		setPicturePanel();
	}

	public void setFrame() {

		frame = new JFrame();
		frame.setBounds(100, 100, 638, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Mountains v1.0");
	}

	// Slider okreslajacy wysokosc

	public void setSlider() {
		JSlider slider = new JSlider();

		setSliderListener(slider);

		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMinorTickSpacing(100);
		slider.setMinimum(8000);
		slider.setMaximum(8900);
		slider.setBounds(40, 61, 40, 258);

		frame.getContentPane().add(slider);

	}

	// Listener wysokosci minimalnej
	public void setSliderListener(JSlider slider) {

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				int k = slider.getValue();

				dataBaseDirector = new DataBaseDirector(k);

				tableMountainsList.setModel(
						new DefaultTableModel(dataBaseDirector.setTableContent(), dataBaseDirector.setTableColumns()));
				tableMountainsList.getColumnModel().getColumn(0).setPreferredWidth(25);
				tableMountainsList.getColumnModel().getColumn(1).setPreferredWidth(100);
				tableMountainsList.getColumnModel().getColumn(2).setPreferredWidth(100);
				tableMountainsList.getColumnModel().getColumn(3).setPreferredWidth(50);

				labelHeightValue.setText(Integer.toString(slider.getValue()));
			}
		});

	}

	// Panel pokazujący wysokość minimalną
	public void setPanelHeight() {
		JPanel panelHeight = new JPanel();
		panelHeight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHeight.setBounds(117, 133, 169, 29);
		panelHeight.setLayout(null);
		frame.getContentPane().add(panelHeight);

		JLabel labelHeight = new JLabel("Wysokość powyżej:");
		labelHeight.setBounds(5, 5, 115, 14);
		panelHeight.add(labelHeight);

		labelHeightValue.setBounds(125, 5, 34, 14);
		panelHeight.add(labelHeightValue);

	}

	// Wczytanie obrazka
	public void setPicturePanel() {

		JPanel picturePanel = new JPanel();
		picturePanel.setBounds(117, 167, 169, 156);
		frame.getContentPane().add(picturePanel);
		picturePanel.setLayout(null);

		JLabel pictureLabel = new JLabel("New label");
		pictureLabel.setBounds(0, 0, 169, 156);
		picturePanel.add(pictureLabel);
		insertPicture("C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\mountain.jpg", pictureLabel);
	}

	// Tytul
	public void setTitleLabel() {

		JLabel titleLabel = new JLabel("Program zawierajacy kilka ciekawostek o górach wysokich");
		titleLabel.setForeground(SystemColor.textHighlight);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		titleLabel.setBounds(40, 5, 556, 29);
		frame.getContentPane().add(titleLabel);
	}

	// Panel wyboru - wiecej info
	private void setPanelChoice() {

		JPanel panelChoice = new JPanel();
		panelChoice.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panelChoice.setBounds(117, 65, 169, 62);
		panelChoice.setLayout(null);

		JLabel labelMountainChoice = new JLabel("Wybierz górę:");
		labelMountainChoice.setBounds(5, 8, 88, 14);

		textFieldChoice = new JTextField();
		textFieldChoice.setBounds(96, 5, 68, 20);
		textFieldChoice.setColumns(10);

		JButton buttonChoice = new JButton("Więcej info");
		buttonListener(buttonChoice);
		buttonChoice.setBounds(5, 30, 159, 23);

		panelChoice.add(labelMountainChoice);
		panelChoice.add(textFieldChoice);
		panelChoice.add(buttonChoice);
		frame.getContentPane().add(panelChoice);
	}

	public void buttonListener(JButton buttonChoice) {

		buttonChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Integer.valueOf(textFieldChoice.getText()) <= dataBaseDirector.setTableContent().length
						&& Integer.valueOf(textFieldChoice.getText()) > 0) {
					String[] s = dataBaseDirector.open(Integer.valueOf(textFieldChoice.getText()));
					new InformationWindow(s[0], s[1], s[2]);
				} else
					JOptionPane.showMessageDialog(null, "Podano błędną wartość");
			}
		});

	}

	public void setTable() {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(296, 65, 300, 258);

		tableMountainsList = new JTable();
		tableMountainsList.setEnabled(false);
		scrollPane.setViewportView(tableMountainsList);
		frame.getContentPane().add(scrollPane);
	}

	public void insertPicture(String path, JLabel Label1) {

		try {
			File file = new File(path);
			BufferedImage bi = ImageIO.read(file);
			ImageIcon imgIcon = new ImageIcon(bi);
			Label1.setIcon(imgIcon);
		} catch (IOException ex) {
			Logger.getLogger(InformationWindow.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}