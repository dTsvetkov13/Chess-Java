package models;

import common.Constants;
import common.Validator;
import enums.Team;
import models.figures.Figure;
import models.figures.*;

public class Board
{
	private static Board boardInstance = null;
	private Figure[][] figures;
	private Coordinates lastSelectedFigure;
	
	private Board()
	{
		figures = 
			new Figure[Constants.MAX_COLUMN_VALUE + 1][Constants.MAX_COLUMN_VALUE + 1];
		
		setAllFigures();
	}
	
	private void setAllFigures() //Black up and White down
	{
		Team team = Team.Black;
		figures[0][0] = new Rook(new Coordinates(0, 0), team);
		figures[0][1] = new Knight(new Coordinates(0, 1), team);
		figures[0][2] = new Bishop(new Coordinates(0, 2), team);
		figures[0][3] = new Queen(new Coordinates(0, 3), team);
		figures[0][4] = new King(new Coordinates(0, 4), team);
		figures[0][5] = new Bishop(new Coordinates(0, 5), team);
		figures[0][6] = new Knight(new Coordinates(0, 6), team);
		figures[0][7] = new Rook(new Coordinates(0, 7), team);
		
		team = Team.White;
		figures[7][0] = new Rook(new Coordinates(7, 0), team);
		figures[7][1] = new Knight(new Coordinates(7, 1), team);
		figures[7][2] = new Bishop(new Coordinates(7, 2), team);
		figures[7][3] = new Queen(new Coordinates(7, 3), team);
		figures[7][4] = new King(new Coordinates(7, 4), team);
		figures[7][5] = new Bishop(new Coordinates(7, 5), team);
		figures[7][6] = new Knight(new Coordinates(7, 6), team);
		figures[7][7] = new Rook(new Coordinates(7, 7), team);
		
		for(int i = 0; i <= Constants.MAX_COLUMN_VALUE; i++)
		{
			figures[1][i] = new Pawn(new Coordinates(1, i), Team.Black);
			figures[6][i] = new Pawn(new Coordinates(6, i), Team.White);
		}
	}
	
	public static Board getInstance()
	{
		if(boardInstance == null)
		{
			boardInstance = new Board();
		}
		
		return boardInstance;
	}
	
	public Figure[][] getAllFigures()
	{
		return figures;
	}
	
	public Figure getFigure(Coordinates coordinates)
	{
		if(isInRange(coordinates))
		{
			return figures[coordinates.getRow()][coordinates.getColumn()];
		}
		
		return null;
	}
	
	public boolean isInRange(Coordinates coordinates)
	{
		if(Validator.isGreaterThan(Constants.MAX_COLUMN_VALUE, coordinates.getColumn())
			|| Validator.isLessThan(Constants.MIN_COLUMN_VALUE, coordinates.getColumn())
			|| Validator.isGreaterThan(Constants.MAX_COLUMN_VALUE, coordinates.getRow())
			|| Validator.isLessThan(Constants.MIN_COLUMN_VALUE, coordinates.getRow()))
		{
			return false;
		}
		
		return true;
	}
	
	public void moveFigure(Coordinates from, Coordinates to)
	{
		
	}
	
	public int howManyFiguresReach(Coordinates coordinates, Team from)
	{
		
		return 0;
	}
	
	public void setLastSelectedFigure(Coordinates coordinates)
	{
		if(!Validator.isNull(coordinates))
		{
			this.lastSelectedFigure = coordinates;
		}
	}
	
	public Coordinates getLastSelectedFigure()
	{
		return this.lastSelectedFigure;
	}
}
