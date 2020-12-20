package views.screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EndingScreen extends Screen
{
	public final static int FIRST_ROW_X = 85;
	public final static int FIRST_ROW_Y = 30;
	
	public final static int FONT_SIZE = 30;
	public final static int LABLES_HIGHT = 30;
	
	public final static int SPACE = 20;
	
	public final static int BTN_WIDTH = 300;
	public final static int BTN_HEIGHT = 65;
	
	public final static int BTN_X = (SCREEN_WIDTH - BTN_WIDTH) / 2 - 8;
	public final static int FIRST_BTN_Y = 200;
	
	
	public EndingScreen(String name) {
		super(name);
		drawEndingScreen();
	}

	public void drawEndingScreen()
	{
		drawLables();
		drawBtnNewGame();
		drawBtnExit();
	}
	
	public int centerHorizontallyX(String text)//add better name
	{
		int size = text.length();

		if(size % 2 == 1) size++;
		
		return ((SCREEN_WIDTH - size) / 2);
	}
	
	private void drawLables()
	{
		int x = FIRST_ROW_X; 
		int y = FIRST_ROW_Y;
		
		JLabel congratilations = new JLabel("Congratulations\n");
		
		congratilations.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
		congratilations.setBounds(x, y, SCREEN_WIDTH - x, LABLES_HIGHT);
		
		this.add(congratilations);
		
		String player = "Johnny63_13";//change with name of Player class
		
		JLabel winer = new JLabel();
		
		winer.setText(player + " win");
		winer.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE)); 
		
		x = centerHorizontallyX(winer.getText());
		y += LABLES_HIGHT + SPACE; 
		
		winer.setBounds(x, y, SCREEN_WIDTH - x, LABLES_HIGHT);
		
		this.add(winer);
	}
	
	//add action on button
	private void drawBtnNewGame()
	{	
		JButton newGame = new JButton("New game");
		
		newGame.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE)); 
		newGame.setBounds(BTN_X, FIRST_BTN_Y, BTN_WIDTH, BTN_HEIGHT);
		
		//add action
		
		this.add(newGame);
	}
	
	private void drawBtnExit()
	{
		int y = FIRST_BTN_Y + BTN_HEIGHT + SPACE; 
		
		JButton exit = new JButton("Exit");
		
		exit.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
		exit.setBounds(BTN_X, y, BTN_WIDTH, BTN_HEIGHT);
		
		exit.addActionListener (new ActionListener () {
			 public void actionPerformed (ActionEvent e) {
			  System.exit(0);
			 }
		});
		
		this.add(exit);
	}
}
