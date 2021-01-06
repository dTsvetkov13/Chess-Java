package models;

import common.Validator;
import enums.Team;
import models.figures.Figure;
import views.BoardView;
import views.CellView;
import views.screens.EndingScreen;
import views.screens.GameScreen;

public class ChessGameEventListener implements GameEventListener
{
	@Override
	public void onBoardChanged()
	{
		GameInfo.getInstance().changeTurn();
		Game.getInstance().repaintTheBoard();
	}

	@Override
	public void onFigureTaken()
	{
		//repaint figure taken
	}

	@Override
	public void onGameOver(Game game)
	{
		game.addScreen(new EndingScreen("Game Over"));
	}

	@Override
	public void onGameStart(Game game)
	{
		System.out.println("onGameStart");
		Game.getInstance().addScreen(new GameScreen("Chess"));
	}

	@Override
	public void onFigureClicked(Figure figure)
	{
		figure.CalculateReachableCells();
		figure.setSelected(true);
		Game.getInstance().repaintTheBoard();
	}

	@Override
	public void onDestinationClicked(Coordinates from, Coordinates to)
	{
		if(Board.getInstance().getFigure(from).isOneOfReachableCells(to))
		{
			Board.getInstance().moveFigure(from, to);
			Game.getInstance().getListener().onBoardChanged();
			Game.getInstance().getListener().onFigureTaken();
		}
	}

	@Override
	public void onCellClicked(CellView cellView)
	{
		if(Validator.isNull(cellView))
		{
			throw new IllegalArgumentException("CellView cannot be null!");
		}
		
		Coordinates figureCoordinates = cellView.getCoordinates();
		
		determineBoardBehaviour(figureCoordinates);
	}
	
	private void determineBoardBehaviour(Coordinates coordinates)
	{
		if(Validator.isNull(coordinates))
		{
			throw new IllegalArgumentException("Coordinates cannot be null!");
		}
		
		Board board = Board.getInstance();
		Figure selectedFigure = board.getFigure(coordinates);
		Team playerOnTurnTeam = GameInfo.getInstance().getPlayerOnTurn().getTeam();
		Figure lastSelectedFigure = board.getFigure(board.getLastSelectedFigure());
		
		if(!Validator.isNull(selectedFigure)
		   && selectedFigure.getTeam().equals(playerOnTurnTeam))
		{
			board.setLastSelectedFigure(coordinates);
			Game.getInstance().getListener().onFigureClicked(selectedFigure);
			System.out.println("Figure clicked");
		}
		else
		{
			if(!Validator.isNull(lastSelectedFigure))
			{
				if(lastSelectedFigure.getTeam().equals(playerOnTurnTeam))
				{
					System.out.println("Destination clicked");
					Game.getInstance().getListener()
									  .onDestinationClicked(board.getLastSelectedFigure(),
											  				coordinates);
				}
			}
			else
			{
				System.out.println("Else clicked");
				//TODO: Think of a way to announce the player to select again
			}
		}
	}
}
