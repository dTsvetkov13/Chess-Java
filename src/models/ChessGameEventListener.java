package models;

import javax.swing.JFrame;

import models.figures.Figure;
import views.BoardView;
import views.CellView;
import views.screens.EndingScreen;
import views.screens.GameScreen;

public class ChessGameEventListener implements GameEventListener
{
	@Override
	public void onBoardChanged(BoardView boardView)
	{
		//team change
		boardView.repaint();
	}

	@Override
	public void onFigureTaken()
	{
		
	}

	@Override
	public void onGameOver(Game game)
	{
		game.addScreen(new EndingScreen("Game Over",
				game.getInstance().getWindow().getExtendedState() == JFrame.MAXIMIZED_BOTH));
	}

	@Override
	public void onGameStart(Game game)
	{
		game.addScreen(new GameScreen("Chess",
			   	game.getInstance().getWindow().getExtendedState() == JFrame.MAXIMIZED_BOTH));
	}

	@Override
	public void onFigureClicked(Figure figure)
	{
		figure.CalculateReachableCells();
	}

	@Override
	public void onDestinationClicked(Coordinates from, Coordinates to)
	{
		if(Board.getInstance().getFigure(from).isOneOfReachableCells(to))
		{
			Board.getInstance().moveFigure(from, to);
		}
	}

	@Override
	public void onCellClicked(CellView cellView)
	{
	}
}
