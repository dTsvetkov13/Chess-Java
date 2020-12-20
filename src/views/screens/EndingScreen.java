package views.screens;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EndingScreen extends Screen
{
	public final static int SPACE = 15;
	
	public final static int LBL_WINER_ROW = 0;
	public final static int BTN_NEW_GAME_ROW = 1;
	public final static int BTN_EXIT_ROW = 2;
	
	public final static int FONT_SIZE = 30;
	
	private GridBagConstraints gbc;
	
	public EndingScreen(String name) 
	{
		super(name);
		
		this.setLayout(new GridBagLayout());
		this.gbc = new GridBagConstraints();
		
		drawEndingScreen();
	}

	public void drawEndingScreen()
	{
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(SPACE, SPACE, SPACE, SPACE); //external padding
		
		drawLables();
		drawBtnNewGame();
		drawBtnExit();
	}
	
	private void drawLables()
	{
		gbc.gridy = LBL_WINER_ROW;
		
		JLabel winer = new JLabel();
		String player = "Johnny63_13";//change with name of Player class
		
		winer.setText(player + " wins");
		winer.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE)); 
		
		this.add(winer, gbc);
	}
	
	//add action on button
	private void drawBtnNewGame()
	{	
		gbc.gridy = BTN_NEW_GAME_ROW; 
		
		JButton newGame = new JButton("New game");
		newGame.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE)); 
		
		//add action
		
		this.add(newGame, gbc);
	}
	
	private void drawBtnExit()
	{
		gbc.gridy = BTN_EXIT_ROW; 
		
		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
		
		exit.addActionListener (new ActionListener () {
			 public void actionPerformed (ActionEvent e) {
			  System.exit(0);
			 }
		});
		
		this.add(exit, gbc);
	}
}
