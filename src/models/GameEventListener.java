package models;

import models.figures.Figure;
import views.BoardView;
import views.CellView;

public interface GameEventListener
{
	void onBoardChanged(BoardView boardView);
	void onFigureTaken();
	void onGameOver(Game game);
	void onGameStart(Game game);
	void onCellClicked(CellView cellView);
	void onFigureClicked(Figure figure);
	void onDestinationClicked(Coordinates from, Coordinates to);
}