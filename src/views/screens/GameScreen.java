package views.screens;
import views.BoardView;
import java.awt.Color;
import java.awt.Dimension;
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
	
	public final static Insets PNL_RIGHT_INSETS = new Insets(470, 0, 0, 0);
	public final static Insets LETTERS_LBL_INSETS = new Insets(-7, 38, -7, 38);
	public final static Insets NUMBERS_LBL_INSETS = new Insets(30, 0, 30, 0);
	
	public final static Dimension CHESS_BOARD_SIZE_MINIMUM_SIZE = new Dimension(500, 500);//
	public final static Dimension CHESS_BOARD_SIZE_PREFERED_SIZE = new Dimension(700, 700);//
	public final static Dimension PNL_TAKEN_FIGURES_MINIMUM_SIZE = new Dimension(250, 250);
	public final static Dimension PNL_TAKEN_FIGURES_PREFERED_SIZE = new Dimension(310, 310);
	public final static Dimension PNL_LETTERS_MINIMUM_SIZE = new Dimension(800, 20);
	public final static Dimension PNL_LETTERS_PREFERED_SIZE = new Dimension(800, 25);
	
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
		
		//String name = Game.getInstance().getPlayerAt(0); 
		String playerName = "Pesho";
		left.add(pnlPlayer(playerName));
		
		this.add(left);
	}

	private void drawBoard()
	{
		JPanel middle = new JPanel();
		
		middle.setBackground(BACKGROUND);
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
	
		chessBoard.setMinimumSize(CHESS_BOARD_SIZE_MINIMUM_SIZE);
		chessBoard.setPreferredSize(CHESS_BOARD_SIZE_PREFERED_SIZE);
		
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
		pnlTakenFigures.setMinimumSize(PNL_TAKEN_FIGURES_MINIMUM_SIZE);
		pnlTakenFigures.setPreferredSize(PNL_TAKEN_FIGURES_PREFERED_SIZE);
		
		player.add(nickname);
		player.add(pnlTakenFigures);
		
		return player;
	}
	
	private JPanel pnlLetters()
	{
		JPanel pnlLetters = new JPanel();
		
		pnlLetters.setMinimumSize(PNL_LETTERS_MINIMUM_SIZE);
		pnlLetters.setPreferredSize(PNL_LETTERS_PREFERED_SIZE);
		pnlLetters.setBackground(BACKGROUND);
		
		String[] arrLetters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		for(String letter : arrLetters)
		{
			JLabel lbl = new JLabel(letter);
			
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
