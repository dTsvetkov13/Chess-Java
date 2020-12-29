package views.screens;
import views.BoardView;
import java.awt.Color;
import java.awt.Font;

import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Board;
import models.Game;
import models.Player;

public class GameScreen extends Screen 
{
	public final static int FONT_SIZE = 25;
	
	public final static Insets PNL_TAKEN_FIGURES_INSETS = new Insets(140, 150, 140, 150); // top left bottom right
	public final static Insets PNL_LEFT_INSETS = new Insets(40, 5, 700, 5);
	public final static Insets PNL_RIGHT_INSETS = new Insets(470, 5, 20, 5);
	public final static Insets PNL_NUMBERS = new Insets(0, 5, 0, 5);
	public final static Insets LETTERS_LBL_INSETS = new Insets(0, 38, 0, 38);
	public final static Insets NUMBERS_LBL_INSETS = new Insets(30, 0, 30, 0);
	
	public final static int CHESS_BOARD_SIZE = 700;
	
	public final static Color FIGURE_LOST = new Color(222,184,135);
	public final static Color INFORMATION = new Color(184,134,11);
	public final static Color BORDER_FIELD_COLOR = new Color(240,230,140);
	//255,222,173 255,228,181 - other colors
	public final static Color BORDER_FIELD_DARKER_COLOR = new Color(139,69,19);
	//139,69,19 160,82,45 - other colors 
	
	private BoardView chessBoard;
	private BoxLayout layout;
	
	public GameScreen(String name)
	{
		super(name);
		
		if(chessBoard == null) chessBoard = new BoardView(); // use Validator
		
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
	
	public void repaintBoard()
	{
		if(this.chessBoard != null)
		{
			chessBoard.repaint();
		}
	}
	
	private void drawPnlLeftSide()
	{
		JPanel left = new JPanel();
		left.setBackground(BACKGROUND);
		left.setBorder(new EmptyBorder(PNL_LEFT_INSETS));
		left.setVisible(true);
		
		//String name = Game.getInstance().getPlayerAt(0); 
		String playerName = "Pesho";
		left.add(pnlPlayer(playerName));
		
		this.add(left);
	}

	private void drawBoard()
	{
		JPanel middle = new JPanel();
		middle.setBackground(Color.GRAY);
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
	
		chessBoard.setSize(CHESS_BOARD_SIZE, CHESS_BOARD_SIZE);
		chessBoard.setVisible(true);
		
		JPanel board = new JPanel();
		board.setBackground(BACKGROUND);
		board.setLayout(new BoxLayout(board, BoxLayout.X_AXIS));
		board.setVisible(true);
		
		JPanel leftPnlNumbers = pnlNumbers();
		JPanel rightPnlNumbers = pnlNumbers();
		
		board.add(leftPnlNumbers);
		board.add(chessBoard);
		board.add(rightPnlNumbers);

		JPanel pnlTopLetters = pnlLetters();
		JPanel pnlBottomLetters = pnlLetters();
		
		middle.add(pnlTopLetters);
		middle.add(board);
		middle.add(pnlBottomLetters);
		
		this.add(middle);
	}
	
	private void drawPnlRightSide()
	{
		JPanel right = new JPanel();
		right.setBackground(BACKGROUND);
		right.setBorder(new EmptyBorder(PNL_RIGHT_INSETS));
		
		//Should get username of player
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
	
	private JPanel pnlLetters()
	{
		JPanel pnlLetters = new JPanel();
		
		pnlLetters.setBackground(BACKGROUND);
		
		String[] arrLablels = {"A", "B", "C", "D", "E", "F", "G", "H"};
		for(String lable : arrLablels)
		{
			JLabel lbl = new JLabel(lable);
			
			lbl.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
			lbl.setBorder(new EmptyBorder(LETTERS_LBL_INSETS));
			
			pnlLetters.add(lbl);
		}
		
		return pnlLetters;
	}
	
	private JPanel pnlNumbers()
	{
		JPanel pnlNumbers = new JPanel();
		
		pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.Y_AXIS));
		pnlNumbers.setBorder(new EmptyBorder(PNL_NUMBERS));
		pnlNumbers.setBackground(BACKGROUND);
		
		for(int i = 1; i <= 8 ; i++)//add constants
		{
			JLabel lbl = new JLabel(String.format("%d", i));
			
			lbl.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
			lbl.setBorder(new EmptyBorder(NUMBERS_LBL_INSETS));
			
			pnlNumbers.add(lbl);
		}
		
		return pnlNumbers;
	}
}
