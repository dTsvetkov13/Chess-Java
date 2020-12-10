package models;

import enums.FigureType;
import enums.Team;

public class King extends Figure
{

	public King(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.King;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{	
		return 0;
	}

}
