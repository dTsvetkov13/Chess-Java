package views.screens;
import views.BoardView;
import java.awt.Color;
import javax.swing.JPanel;

public class GameScreen extends Screen{
	
	public final static int WIDTH = 1616;
	public final static int HEIGHT = 910;
	public final static int BOARD_SIZE = HEIGHT * 8 / 10;
	public final static int SMALL_SQUARE_SIZE = (HEIGHT - 35 - BOARD_SIZE) / 2;
	
	public final static int LOST_FIGURES_WIDTH = ((WIDTH - HEIGHT) / 2) - 15 - (SMALL_SQUARE_SIZE / 2);
	public final static int LOST_FIGURES_HEIGHT = (int) (LOST_FIGURES_WIDTH * 1.3);
	
	//*may add class with colors
	public final static Color BORDER_FIELD_COLOR = new Color(240,230,140);
	//255,222,173 255,228,181 - other colors
	public final static Color BORDER_FIELD_DARKER_COLOR = new Color(139,69,19);
	//139,69,19 160,82,45 - other colors 
	public final static Color FIGURE_LOST = new Color(222,184,135);
	public final static Color INFORMATION = new Color(184,134,11);
	
	//private Player playerOne;
	//private Player playerTwo;
	private BoardView chessBoard;
	
	//upgrade constructor
	public GameScreen(String name, boolean isFullScreen)
	{
		super(name, isFullScreen);
	}
	
	private void drawInformation()
	{
		JPanel information = new JPanel();
		information.setBounds(5, 5, SMALL_SQUARE_SIZE / 2, SMALL_SQUARE_SIZE / 2);
		information.setBackground(INFORMATION);
		information.setVisible(true);
		super.getWindow().add(information);
	}
	
	private void drawPanelOfLostFigures(int x, int y)
	{
		JPanel pnlLostFigures = new JPanel();
		pnlLostFigures.setBounds(x, y, LOST_FIGURES_WIDTH, LOST_FIGURES_HEIGHT);
		pnlLostFigures.setBackground(FIGURE_LOST);
		pnlLostFigures.setVisible(true);
		super.getWindow().add(pnlLostFigures);
	}
	
	private void drawPanelsOfLostFigures()
	{
		int x = SMALL_SQUARE_SIZE / 2 + 10;
		int y = 5;
		drawPanelOfLostFigures(x, y);
		
		x = HEIGHT + LOST_FIGURES_WIDTH + 20;
		y = HEIGHT - LOST_FIGURES_HEIGHT - 36;
		drawPanelOfLostFigures(x, y);
	}
	
	private void makePanelHorizontally(int x, int y)
	{
		JPanel panel = new JPanel();
		panel.setBounds(x, y, BOARD_SIZE, SMALL_SQUARE_SIZE);
		panel.setBackground(Color.black);
		panel.setVisible(true);
		super.getWindow().add(panel);
	}
	
	private void makePanelVertically(int x, int y)
	{
		JPanel panel = new JPanel();
		panel.setBounds(x, y, SMALL_SQUARE_SIZE, BOARD_SIZE);
		panel.setBackground(Color.black);
		panel.setVisible(true);
		super.getWindow().add(panel);
	}
	
	//draw panels for letters(A-H) and numbers(1-8) 
	private void drawBorder()
	{
		int x = ((WIDTH - HEIGHT) / 2) + SMALL_SQUARE_SIZE;
		int y = 0;
		makePanelHorizontally(x, y);
		y = SMALL_SQUARE_SIZE + BOARD_SIZE;
		makePanelHorizontally(x, y);
		x -= SMALL_SQUARE_SIZE;
		y = SMALL_SQUARE_SIZE;
		makePanelVertically(x, y);
		x += SMALL_SQUARE_SIZE + BOARD_SIZE;
		makePanelVertically(x, y);
	}
	
	//add only panels - information, lost figures, letters(A-H) and numbers(1-8)
	//should add board and labels with nicknames of players
	public void draw()
	{
		this.drawInformation();
		this.drawPanelsOfLostFigures();
		this.drawBorder();
	}
	
}
