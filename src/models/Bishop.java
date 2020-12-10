package models;

import enums.FigureType;
import enums.Team;

public class Bishop extends Figure 
{

	public Bishop(Coordinates coordinates, Team team)
	{
		super(coordinates, team);
		this.type = FigureType.Bishop;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{
		return 0;
	}

}
