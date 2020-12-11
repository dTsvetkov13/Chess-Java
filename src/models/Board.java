package models;

import common.Constants;
import common.Validator;
import enums.Team;

public class Board
{
	private static Board boardInstance = null;
	Figure[][] figures;
	
	private Board()
	{
		figures = 
			new Figure[Constants.MAX_COLUMN_VALUE + 1][Constants.MAX_COLUMN_VALUE + 1];
		
		setAllFigures();
	}
	
	private void setAllFigures() //Black up and White down
	{
		//figures[0][0] = new Rook();
		//...
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
}
