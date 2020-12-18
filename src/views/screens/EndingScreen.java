package views.screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EndingScreen extends Screen{

	public final static int BTN_WIDTH = 300;
	public final static int BTN_HEIGHT = 65;
	public final static int BTN_X = (SCREEN_WIDTH - BTN_WIDTH) / 2 - 8;
	
	public EndingScreen(String name, boolean isFullScreen) {
		super(name, isFullScreen);
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
		int x = ((SCREEN_WIDTH / 2) - ((size / 2) * 16));
		return x;
	}
	
	private void drawLables()
	{
		int x = 85;
		int y = 30;
		int h = 30; 
		
		JLabel congratilations = new JLabel("Congratulations\n");
		congratilations.setFont(new Font("Arial", Font.PLAIN, 30));
		congratilations.setBounds(x, y, SCREEN_WIDTH - x, h);
		this.add(congratilations);
		
		String player = "Johnny63_13";//change with name of Player class
		JLabel winer = new JLabel();
		winer.setText(player + " win");
		winer.setFont(new Font("Arial", Font.PLAIN, 30));
		x = centerHorizontallyX(winer.getText());
		y += h + 20;
		winer.setBounds(x, y, SCREEN_WIDTH - x, h);
		this.add(winer);
	}
	
	//add action on button
	private void drawBtnNewGame()
	{
		int y = 200;
		
		JButton newGame = new JButton("New game");
		newGame.setFont(new Font("Arial", Font.PLAIN, 30));
		newGame.setBounds(BTN_X, y, BTN_WIDTH, BTN_HEIGHT);
		//add action
		this.add(newGame);
	}
	
	private void drawBtnExit()
	{
		int y = 200 + BTN_HEIGHT + 45;
		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Arial", Font.PLAIN, 30));
		exit.setBounds(BTN_X, y, BTN_WIDTH, BTN_HEIGHT);
		exit.addActionListener (new ActionListener () {
			 public void actionPerformed (ActionEvent e) {
			  System.exit(0);
			 }
		});
		this.add(exit);
	}
}
