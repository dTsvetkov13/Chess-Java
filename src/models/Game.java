package models;

import java.awt.CardLayout;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

import common.Constants;
import common.Validator;
import views.screens.GameScreen;
import views.screens.Screen;

public class Game
{
	private static Game gameInstance = null;
	private JFrame window;
	private CardLayout layout;
	private GameEventListener listener;
	private Screen lastScreen;
	
	private Game()
	{
		window = new JFrame();
		layout = new CardLayout();
		window.setLayout(layout);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static Game getInstance()
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
			System.out.println("Screen added");
			this.window.add(screen);
			this.lastScreen = screen;
			this.layout.previous(this.window.getContentPane());
		}
	}
	
	public void changeToPreviousScreen()
	{
		this.layout.previous(this.window.getContentPane());
	}
	
	public JFrame getWindow()
	{
		return this.window;
	}
	
	public void setListener(GameEventListener listener)
	{
		if(!Validator.isNull(listener))
		{
			this.listener = listener;
		}
	}
	
	public GameEventListener getListener()
	{
		return this.listener;
	}
	
	//Method for testing, delete later
	public void addComponent(JComponent comp)
	{
		this.window.add(comp);
	}
	
	public void repaintTheBoard()
	{
		this.window.revalidate();
		((GameScreen) this.getLastScreen()).repaint();
	}
	
	public Screen getLastScreen()
	{
		return this.lastScreen;
	}
}
