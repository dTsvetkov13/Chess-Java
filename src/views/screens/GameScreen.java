package views.screens;
import views.BoardView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Validator;
import models.Board;
import models.Game;
import models.GameInfo;
import models.Player;

public class GameScreen extends Screen 
{
	public final static int FONT_SIZE = 25;
	public final static int FIRST_NUMBER = 1;
	public final static int LAST_NUMBER = 8;
	public final static int MAX_NAME_LENGHT = 20;
	
	public final static String DEFAULT_PLAYER_ONE_NAME = "Player1"; 
	public final static String DEFAULT_PLAYER_TWO_NAME = "Player2";
	
	public final static Insets PNL_RIGHT_INSETS = new Insets(470, 0, 0, 0);
	public final static Insets LETTERS_LBL_INSETS = new Insets(-7, 38, -7, 38);
	public final static Insets NUMBERS_LBL_INSETS = new Insets(30, 0, 30, 0);
	
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
	private String playerOneName;
	private String playerTwoName;
	
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
		
		String name = null;
		if(GameInfo.getInstance().getPlayerAt(0) != null)
		{
			name = GameInfo.getInstance().getPlayerAt(0).getUsername(); 
		}
		setPlayerOneName(name);
		
		left.add(pnlPlayer(this.playerOneName));
		
		this.add(left);
	}

	private void drawBoard()
	{
		JPanel middle = new JPanel();
		
		middle.setBackground(BACKGROUND);
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		
		JPanel board = new JPanel();
		
		board.setBackground(BACKGROUND);
		board.setLayout(new BoxLayout(board, BoxLayout.X_AXIS));
		
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
		
		String name = null;
		if(GameInfo.getInstance().getPlayerAt(0) != null)
		{
			name = GameInfo.getInstance().getPlayerAt(1).getUsername(); 
		}
		setPlayerTwoName(name);
		
		right.add(pnlPlayer(this.playerTwoName));
		
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
	
	private void setPlayerOneName(String name)
	{
		if(!Validator.isNullOrEmpty(name) && name.length() <= MAX_NAME_LENGHT)
		{
			this.playerOneName = name;
		}
		else 
		{
			this.playerOneName = DEFAULT_PLAYER_ONE_NAME;
		}
	}
	
	private void setPlayerTwoName(String name)
	{
		if(!Validator.isNullOrEmpty(name) && name.length() <= MAX_NAME_LENGHT)
		{
			this.playerTwoName = name;
		}
		else 
		{
			this.playerTwoName = DEFAULT_PLAYER_TWO_NAME;
		}
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
	
	private JPanel pnlRotateLetters()
	{
		JPanel pnlLetters = new JPanel();
		
		pnlLetters.setMinimumSize(PNL_LETTERS_MINIMUM_SIZE);
		pnlLetters.setPreferredSize(PNL_LETTERS_PREFERED_SIZE);
		pnlLetters.setBackground(BACKGROUND);
		
		String[] arrLetters = {"A", "B", "C", "D", "E", "F", "G", "H"};
		for(int i = arrLetters.length - 1; i >= 0; i--)
		{
			JLabel lbl = new JLabel(arrLetters[i]);
			
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
		
		for(int i = FIRST_NUMBER; i <= LAST_NUMBER ; i++)
		{
			JLabel lbl = new JLabel(String.format("%d", i));
			
			lbl.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
			lbl.setBorder(new EmptyBorder(NUMBERS_LBL_INSETS));
			
			pnlNumbers.add(lbl);
		}
		
		return pnlNumbers;
	}
	
	private JPanel pnlRotateNumbers()
	{
		JPanel pnlNumbers = new JPanel();
		
		pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.Y_AXIS));
		pnlNumbers.setBackground(BACKGROUND);
		
		for(int i = LAST_NUMBER; i >= FIRST_NUMBER ; i--)
		{
			JLabel lbl = new JLabel(String.format("%d", i));
			
			lbl.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
			lbl.setBorder(new EmptyBorder(NUMBERS_LBL_INSETS));
			
			pnlNumbers.add(lbl);
		}
		
		return pnlNumbers;
	}
}
