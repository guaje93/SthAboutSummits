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

public class window2 {

	private JFrame frame;

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

	/**
	 * Create the application.
	 */
	public window2(String sciezka, String text, String name) {

		frame = new JFrame();
		frame.setBounds(100, 100, 638, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle(name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(40, 59, 246, 264);
		

		JTextPane textPane = new JTextPane();
		textPane.setBounds(40, 59, 246, 264);
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
		

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(296, 59, 300, 200);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 5, 556, 29);
		frame.getContentPane().add(lblNewLabel);

		////////////////////////////////////////////////////////////////////
		insertPicture(sciezka, lblNewLabel_1);
		textPane.setText(text);
		lblNewLabel.setText(name);

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}