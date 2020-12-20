package views.screens;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuScreen extends Screen
{
	public final static int FIRST_ROW_X = 30;
	public final static int FIRST_ROW_Y = 50;
	
	public final static int LABELS_FONT_SIZE = 30;
	public final static int LABELS_HEIGHT = 30;
	public final static int LABELS_WIDTH = 150;
	
	public final static int SPACE = 30;
	
	public final static int TEXT_FIELD_WIDTH = 200;
	public final static int TEXT_FIELD_COLUMNS = 10;
	
	public final static int BUTTON_FONT_SIZE = 30;
	public final static int BTN_WIDTH = 300;
	public final static int BTN_HEIGHT = 65;
	public final static int BTN_X = (SCREEN_WIDTH - BTN_WIDTH) / 2 - 8;
	public final static int BTN_Y = FIRST_ROW_Y + LABELS_HEIGHT + (2 * SPACE);
	
	public MenuScreen(String name)
	{
		super(name);
		drawMenuScreen();
	}
	
	public void drawMenuScreen()
	{
		drawInformativeLabels();
		drawBtnStart();
		drawFieldsForNamesOfPlayers();
	}
	
	private void drawInformativeLabels()
	{
		JLabel player1 = new JLabel("Player 1 :");
		
		player1.setFont(new Font("Arial", Font.PLAIN, LABELS_FONT_SIZE));
		player1.setBounds(FIRST_ROW_X, FIRST_ROW_Y, LABELS_WIDTH, LABELS_HEIGHT);
		
		this.add(player1);
		
		JLabel player2 = new JLabel("Player 2 :");
		
		player2.setFont(new Font("Arial", Font.PLAIN, LABELS_FONT_SIZE));
		player2.setBounds(FIRST_ROW_X, FIRST_ROW_Y + LABELS_HEIGHT + SPACE, LABELS_WIDTH, LABELS_HEIGHT);
		
		this.add(player2);
	}
	
	//has a problem 
	private void drawFieldsForNamesOfPlayers()
	{
		JTextField txtPlayer1 = new JTextField();
		
		txtPlayer1.setBounds(FIRST_ROW_X + LABELS_WIDTH + SPACE , FIRST_ROW_Y, TEXT_FIELD_WIDTH, LABELS_HEIGHT);
		txtPlayer1.setVisible(true);
		
		this.add(txtPlayer1);
		
		txtPlayer1.setColumns(TEXT_FIELD_COLUMNS);
	}
	
	private void drawBtnStart()
	{
		JButton newGame = new JButton("Start");
		
		newGame.setFont(new Font("Arial", Font.PLAIN, BUTTON_FONT_SIZE));
		newGame.setBounds(BTN_X, BTN_Y, BTN_WIDTH, BTN_HEIGHT);
		
		//add action
		
		this.add(newGame);
	}
}
