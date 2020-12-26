package views.screens;
import views.BoardView;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Player;

public class GameScreen extends Screen
{
	public final static Color BORDER_FIELD_COLOR = new Color(240,230,140);
	//255,222,173 255,228,181 - other colors
	public final static Color BORDER_FIELD_DARKER_COLOR = new Color(139,69,19);
	//139,69,19 160,82,45 - other colors 
	public final static Color FIGURE_LOST = new Color(222,184,135);
	public final static Color INFORMATION = new Color(184,134,11);
	
	//private Player playerOne;
	//private Player playerTwo;
	private BoardView chessBoard;
	
	private BoxLayout layout;
	
	public GameScreen(String name)
	{
		super(name);
		layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		
		drawGameScreen();
	}
	
	public void drawGameScreen()
	{
		this.drawPnlLeftSide();
		this.drawBoard();
		this.drawPnlRightSide();
	}
	
	private void drawPnlLeftSide()
	{
		JPanel left = new JPanel();
		left.setBackground(BACKGROUND);
		left.setBorder(new EmptyBorder(new Insets(40, 5, 700, 5)));// top left bottom right
		left.setVisible(true);
		
		left.add(pnlPlayerOne());
		this.add(left);
	}
	
	private JPanel pnlPlayerOne()
	{
		JPanel playerOne = new JPanel();
		BoxLayout boxlayoutPalyerOne = new BoxLayout(playerOne, BoxLayout.Y_AXIS);
		playerOne.setLayout(boxlayoutPalyerOne);
		
		JLabel nicknameOne = new JLabel("Pesho");
		nicknameOne.setFont(new Font("Serif", Font.BOLD, 25));
		
		JPanel pnlTakenByPlayerOne = new JPanel();
		pnlTakenByPlayerOne.setBackground(FIGURE_LOST);
		pnlTakenByPlayerOne.setBorder(new EmptyBorder(new Insets(140, 150, 140, 150)));// top left bottom right
		
		playerOne.add(nicknameOne);
		playerOne.add(pnlTakenByPlayerOne);
		
		return playerOne;
	}
	
	private void drawBoard()
	{
		JPanel middle = new JPanel();
		middle.setBackground(Color.GRAY);
		middle.setBorder(new EmptyBorder(new Insets(500, 430, 500, 430)));// top left bottom right
				
		this.add(middle);
	}
	
	private void drawPnlRightSide()
	{
		JPanel right = new JPanel();
		right.setBackground(BACKGROUND);
		right.setBorder(new EmptyBorder(new Insets(470, 5, 20, 5)));// top left bottom right
		
		right.add(pnlPlayerTwo());
		
		this.add(right);
	}
	
	private JPanel pnlPlayerTwo()
	{
		JPanel playerTwo = new JPanel();
		BoxLayout boxlayoutPalyerTwo = new BoxLayout(playerTwo, BoxLayout.Y_AXIS);
		playerTwo.setLayout(boxlayoutPalyerTwo);
		
		JLabel nicknameTwo = new JLabel("Gosho");
		nicknameTwo.setFont(new Font("Serif", Font.BOLD, 25));
		
		JPanel pnlTakenByPlayerTwo = new JPanel();
		pnlTakenByPlayerTwo.setBackground(FIGURE_LOST);
		pnlTakenByPlayerTwo.setBorder(new EmptyBorder(new Insets(140, 150, 140, 150)));// top left bottom right
		
		playerTwo.add(nicknameTwo);
		playerTwo.add(pnlTakenByPlayerTwo);
		
		return playerTwo;
	}
}
