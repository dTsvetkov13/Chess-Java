package views.screens;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.Team;
import models.Game;
import models.GameInfo;
import models.Player;

public class MenuScreen extends Screen
{
	public final static int LABELS_FONT_SIZE = 20;
	public final static int BUTTON_FONT_SIZE = 20;
	
	public final static int BUTTON_COLUMNS_WIDHT = 2;
	public final static int BUTTON_PADDING = 2;
	
	public final static int TEXT_FIELD_COLUMNS = 10;
	
	public final static int SPACE = 10;
	
	public final static int DEFAULT_PADDING = 0;
	
	private GridBagConstraints gbc;
	private JTextField firstFieldForPlayer;
	private JTextField secondFieldForPlayer;
	
	public MenuScreen(String name)
	{
		super(name);
		
		this.setLayout(new GridBagLayout());
		this.gbc = new GridBagConstraints();
		
		drawMenuScreen();
	}
	
	public void drawMenuScreen()
	{
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(SPACE, SPACE, SPACE, SPACE); //external padding 
	
		//make first row (label textField)
		drawInformativeLabel(DEFAULT_PADDING, DEFAULT_PADDING, "Player 1 :");
		this.firstFieldForPlayer = fieldForNameOfPlayer(DEFAULT_PADDING + 1, DEFAULT_PADDING);
		
		
		//make second row (label textField)
		drawInformativeLabel(DEFAULT_PADDING, DEFAULT_PADDING + 1, "Player 2 :");
		this.secondFieldForPlayer = fieldForNameOfPlayer(DEFAULT_PADDING + 1, DEFAULT_PADDING + 1);
			
		drawBtnStart();
	}
	
	private void drawInformativeLabel(int gridx, int gridy, String text)
	{
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		
		JLabel lblPlayer = new JLabel(text);
		lblPlayer.setFont(new Font("Arial", Font.PLAIN, LABELS_FONT_SIZE));
		
		this.add(lblPlayer, gbc);
	}
	
	private JTextField fieldForNameOfPlayer(int gridx, int gridy) 
	{
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		
		JTextField txtPlayer = new JTextField();
		
		txtPlayer.setColumns(TEXT_FIELD_COLUMNS);
		//txtPlayer.setVisible(true);
		
		this.add(txtPlayer, gbc);
		
		return txtPlayer;
	}
	
	private void drawBtnStart()
	{
		gbc.gridwidth = BUTTON_COLUMNS_WIDHT;
		gbc.gridx = DEFAULT_PADDING;
		gbc.gridy = BUTTON_PADDING;
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Arial", Font.PLAIN, BUTTON_FONT_SIZE));
		
		btnStart.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				GameInfo.getInstance().addPlayerAt(0, new Player(firstFieldForPlayer.getText(), Team.White));
				GameInfo.getInstance().addPlayerAt(1, new Player(secondFieldForPlayer.getText(), Team.Black));
				
				Game.getInstance().getListener().onGameStart(Game.getInstance());
			}
		});
		
		this.add(btnStart, gbc);
	}
}
