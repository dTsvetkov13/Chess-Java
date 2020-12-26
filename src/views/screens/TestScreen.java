package views.screens;
import javax.swing.JFrame;

public class TestScreen 
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		//MenuScreen menu = new MenuScreen("menu");
		//EndingScreen gameOver = new EndingScreen("Game over");
		GameScreen game = new GameScreen("chess");
	
		window.setLocationRelativeTo(null);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setTitle(game.getName());
		window.add(game);
		
		//window.setTitle(gameOver.getName());
		//window.add(gameOver);
		
		//window.setTitle(menu.getName());
		//window.add(menu);
		
		window.pack();
		window.repaint();
	}
}
