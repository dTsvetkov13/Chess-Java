package views.screens;
import javax.swing.JFrame;

public class TestScreen 
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		//MenuScreen menu = new MenuScreen("menu");
		EndingScreen gameOver = new EndingScreen("Game over");
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setTitle(gameOver.getName());
		window.add(gameOver);
		
		//window.setTitle(menu.getName());
		//window.add(menu);
		
		window.pack();
		window.repaint();
	}
}
