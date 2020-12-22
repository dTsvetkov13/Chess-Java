package views.screens;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		drawFieldForNameOfPlayer(DEFAULT_PADDING + 1, DEFAULT_PADDING);
		
		//make second row (label textField)
		drawInformativeLabel(DEFAULT_PADDING, DEFAULT_PADDING + 1, "Player 2 :");
		drawFieldForNameOfPlayer(DEFAULT_PADDING + 1, DEFAULT_PADDING + 1);
		
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
	
	private void drawFieldForNameOfPlayer(int gridx, int gridy) 
	{
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		
		JTextField txtPlayer1 = new JTextField();
		
		txtPlayer1.setColumns(TEXT_FIELD_COLUMNS);
		txtPlayer1.setVisible(true);
		
		this.add(txtPlayer1, gbc);
	}
	
	private void drawBtnStart()
	{
		gbc.gridwidth = BUTTON_COLUMNS_WIDHT;
		gbc.gridx = DEFAULT_PADDING;
		gbc.gridy = BUTTON_PADDING;
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Arial", Font.PLAIN, BUTTON_FONT_SIZE));
		//add action
		
		this.add(btnStart, gbc);
	}
}
