package models;

import enums.FigureType;
import enums.Team;

public class King extends Figure
{

	public King(Coordinates coordinates, Team team, FigureType type) 
	{
		super(coordinates, team, type);
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{	
		return 0;
	}

}
