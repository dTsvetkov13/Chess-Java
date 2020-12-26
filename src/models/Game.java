package models;

import java.awt.CardLayout;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

import common.Constants;
import common.Validator;
import views.screens.Screen;

public class Game
{
	private static Game gameInstance = null;
	private JFrame window;
	private CardLayout layout;
	private Player[] players;
	private int playerOnTurnIndex;
	private GameEventListener listener;
	
	private Game()
	{
		window = new JFrame();
		layout = new CardLayout();
		window.setLayout(layout);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		players = new Player[Constants.PLAYERS_COUNT];
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
			this.window.add(screen);
			System.out.println("Bounds: " + screen.getBounds());
		}
	}
	
	public JFrame getWindow()
	{
		return this.window;
	}
	
	public void changeTurn()
	{
		this.playerOnTurnIndex++;
		
		if(this.playerOnTurnIndex >= this.players.length)
		{
			this.playerOnTurnIndex = 0;
		}
	}
	
	public Player getPlayerOnTurn()
	{
		return this.players[this.playerOnTurnIndex];
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
	
	public void addPlayerAt(int index, Player player)
	{
		if(!Validator.isNull(player))
		{
			if(Validator.isLessThan(this.players.length, index))
			{
				this.players[index] = player;
			}
		}
	}
	
	public Player getPlayerAt(int index)
	{
		if(Validator.isGreaterThan(-1, index)
			&& Validator.isLessThan(this.players.length, index))
		{
			return this.players[index];
		}
		else
		{
			return null;
		}
	}
}
