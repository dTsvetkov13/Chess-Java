package models;

import java.awt.CardLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;

import views.screens.MenuScreen;
import views.screens.Screen;

public class Game
{
	private static Game gameInstance = null;
	private JFrame window;
	private CardLayout layout;
	
	private Game()
	{
		window = new JFrame();
		layout = new CardLayout();
		window.setLayout(layout);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Game getInstance()
	{
		if(gameInstance == null)
		{
			gameInstance = new Game();
		}
		return gameInstance;
	}
	
	public void initialize(Rectangle windowBounds, boolean isOnFullScreen)
	{
		if(isOnFullScreen)
		{
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else
		{
			window.setBounds(windowBounds);
		}
	}
	
	public void run()
	{
		window.setVisible(true);
		//window.add(new MenuScreen("Menu", isOnFullScreen));
	}
	
	public void addScreen(Screen screen)
	{
		if(screen != null)
		{
			//this.window.add(screen);	
		}
	}
	
	public JFrame getWindow()
	{
		return this.window;
	}
}
