package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

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
