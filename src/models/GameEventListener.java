package models;

import models.figures.Figure;
import views.BoardView;

public interface GameEventListener
{
	void onBoardChanged(BoardView boardView);
	void onFigureTaken();
	void onGameOver(Game game);
	void onGameStart(Game game);
	
	void onFigureClicked(Figure figure);
	void onDestinationClicked(Coordinates from, Coordinates to);
}