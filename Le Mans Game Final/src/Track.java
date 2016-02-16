import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Track extends Canvas {
	public static final JFrame track = new JFrame("Le Mans Game: Track");
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	public static void intializeTrack()
	{
		makeImage();
		Track image = new Track();
		track.setSize(800, 630);
		track.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		track.getContentPane().add(image).setBackground(Color.white);;
		track.setResizable(false);
		track.setLocationRelativeTo(null);
		track.setVisible(true);
	}
	
	public static void makeImage()
	{
		contentPane = (JPanel) track.getContentPane();
		final JPanel panel = new JPanel();
		JLabel imgLabel = new JLabel(new ImageIcon("Le Mans Game Track copy.PNG"), JLabel.CENTER);
		contentPane.add(imgLabel, BorderLayout.NORTH);
	}
	
	public void paint(Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(20, 20, 300, 300);;
	}
}
