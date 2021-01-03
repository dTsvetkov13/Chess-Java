package views.screens;
import java.awt.FlowLayout;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import models.Board;
import views.BoardView;

public class TestScreen 
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		
		window.setLocationRelativeTo(null);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.LINE_AXIS));
		
		//GameScreen test
		GameScreen game = new GameScreen("chess");
				
		window.setTitle(game.getName());
		window.add(game);
		
		//MenuScreen test
		/*MenuScreen menu = new MenuScreen("menu");
		
		window.setTitle(menu.getName());
		window.add(menu);*/
		
		//EndingScreen test
		/*EndingScreen gameOver = new EndingScreen("Game over");
		
		window.setTitle(gameOver.getName());
		window.add(gameOver);*/
		
		window.pack();
		window.repaint();
	}
}
