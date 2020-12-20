package views.screens;
import javax.swing.JFrame;

public class TestScreen 
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		MenuScreen menu = new MenuScreen("menu");
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setTitle(menu.getName());
		
		window.add(menu);
		
		window.pack();
		window.repaint();
	}
}
