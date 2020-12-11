package views.screens;

import java.awt.Color;
import javax.swing.JFrame;


public abstract class Screen {
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 500;
	public static final Color BACKGROUND = new Color(238,232,170);
	
	private static JFrame window;
	//private static boolean isFullScreen;
	
	public Screen (String name, boolean isFullScreen)
	{
		window = new JFrame(name);
		window.getContentPane().setBackground(BACKGROUND);
		if (isFullScreen)
		{
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else 
		{
			window.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		}
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setVisible(true);
		window.repaint();
	}
	
	public JFrame getWindow()
	{
		return this.window;
	}
}
