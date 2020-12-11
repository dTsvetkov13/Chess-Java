package views.screens;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuScreen extends Screen{

	public final static int FIRST_ROW_X = 30;
	public final static int FIRST_ROW_Y = 50;
	public final static int LABELS_WIDTH = 150;
	public final static int LABELS_HEIGHT = 30;
	
	public final static int BTN_WIDTH = 300;
	public final static int BTN_HEIGHT = 65;
	public final static int BTN_X = (SCREEN_WIDTH - BTN_WIDTH) / 2 - 8;
	
	public MenuScreen(String name, boolean isFullScreen)
	{
		super(name, isFullScreen);
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
		player1.setFont(new Font("Arial", Font.PLAIN, 30));
		player1.setBounds(FIRST_ROW_X, FIRST_ROW_Y, LABELS_WIDTH, LABELS_HEIGHT);
		super.getWindow().add(player1);
		
		JLabel player2 = new JLabel("Player 2 :");
		player2.setFont(new Font("Arial", Font.PLAIN, 30));
		player2.setBounds(FIRST_ROW_X, FIRST_ROW_Y + LABELS_HEIGHT + 30, LABELS_WIDTH, LABELS_HEIGHT);
		super.getWindow().add(player2);
	}
	
	//has problem 
	private void drawFieldsForNamesOfPlayers()
	{
		JTextField txtPlayer1 = new JTextField();
		txtPlayer1.setBounds(FIRST_ROW_X + LABELS_WIDTH + 10 , FIRST_ROW_Y, 200, LABELS_HEIGHT);
		txtPlayer1.setVisible(true);
		super.getWindow().add(txtPlayer1);
		txtPlayer1.setColumns(10);
	}
	
	private void drawBtnStart()
	{
		int y = 300;
		
		JButton newGame = new JButton("Start");
		newGame.setFont(new Font("Arial", Font.PLAIN, 30));
		newGame.setBounds(BTN_X, y, BTN_WIDTH, BTN_HEIGHT);
		//add action
		super.getWindow().add(newGame);
	}
}
