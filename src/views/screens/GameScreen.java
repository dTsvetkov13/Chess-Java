package views.screens;
import views.BoardView;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Board;
import models.Player;

public class GameScreen extends Screen 
{
	public final static int FONT_SIZE = 25;
	
	public final static Insets PNL_TAKEN_FIGURES_INSETS = new Insets(140, 150, 140, 150); // top left bottom right
	public final static Insets PNL_LEFT_INSETS = new Insets(40, 5, 700, 5);
	public final static Insets PNL_RIGHT_INSETS = new Insets(470, 5, 20, 5);
	public final static Insets PNL_BOARD_INSETS = new Insets(500, 450, 500, 450);
	
	public final static Color FIGURE_LOST = new Color(222,184,135);
	public final static Color INFORMATION = new Color(184,134,11);
	public final static Color BORDER_FIELD_COLOR = new Color(240,230,140);
	//255,222,173 255,228,181 - other colors
	public final static Color BORDER_FIELD_DARKER_COLOR = new Color(139,69,19);
	//139,69,19 160,82,45 - other colors 
	
	private Player firstPlayer;
	private Player secondPlayer;
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
	
	public void repaintBoard(BoardView boardView)
	{
		if(boardView != null)
		{
			boardView.repaint();
		}
	}
	
	private void drawPnlLeftSide()
	{
		JPanel left = new JPanel();
		left.setBackground(BACKGROUND);
		left.setBorder(new EmptyBorder(PNL_LEFT_INSETS));
		left.setVisible(true);
		
		//String player = firstPlayer.getUsername(); 
		String playerName = "Pesho";
		left.add(pnlPlayer(playerName));
		
		this.add(left);
	}

	private void drawBoard()
	{
		JPanel middle = new JPanel();
		middle.setBackground(Color.GRAY);
		middle.setBorder(new EmptyBorder(PNL_BOARD_INSETS));
				
		this.add(middle);
	}
	
	private void drawPnlRightSide()
	{
		JPanel right = new JPanel();
		right.setBackground(BACKGROUND);
		right.setBorder(new EmptyBorder(PNL_RIGHT_INSETS));
		
		//String player = secondPlayer.getUsername(); 
		String playerName = "Gosho";
		right.add(pnlPlayer(playerName));
		
		this.add(right);
	}
	
	private JPanel pnlPlayer(String playerName)
	{
		JPanel player = new JPanel();
		BoxLayout boxlayoutPlayer = new BoxLayout(player, BoxLayout.Y_AXIS);
		player.setLayout(boxlayoutPlayer);
		
		JLabel nickname = new JLabel(playerName);
		nickname.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
		
		JPanel pnlTakenFigures = new JPanel();
		pnlTakenFigures.setBackground(FIGURE_LOST);
		pnlTakenFigures.setBorder(new EmptyBorder(PNL_TAKEN_FIGURES_INSETS));
		
		player.add(nickname);
		player.add(pnlTakenFigures);
		
		return player;
	}
}
