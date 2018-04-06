package Main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformationWindow {

	private JFrame frame;

	public InformationWindow(String sciezka, String text, String name) {

		setFrame(name);
		setInformationPane(sciezka, text, name);
	}
	public void setFrame(String name) {

		frame = new JFrame();
		frame.setBounds(100, 100, 638, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle(name);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void setInformationPane(String sciezka, String text, String name) {
		// Panel główny
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(40, 59, 246, 264);

		// Panel tekstowy wyswietlajacy opis
		JTextPane textPane = new JTextPane();
		textPane.setBounds(40, 59, 246, 264);
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
		textPane.setText(text);

		// Etykieta wyswietlajaca zdjecie
		JLabel labelPicture = new JLabel("New label");
		labelPicture.setBounds(296, 59, 300, 200);
		frame.getContentPane().add(labelPicture);
		insertPicture(sciezka, labelPicture);

		// Etykieta wyswietlajaca tytuł
		JLabel labelTitle = new JLabel("");
		labelTitle.setForeground(SystemColor.textHighlight);
		labelTitle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelTitle.setBounds(40, 5, 556, 29);
		frame.getContentPane().add(labelTitle);
		labelTitle.setText(name);
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