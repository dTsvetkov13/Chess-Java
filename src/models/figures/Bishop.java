package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

public class Bishop extends Figure 
{

	public Bishop(Coordinates coordinates, Team team)
	{
		super(coordinates, team);
		this.type = FigureType.Bishop;
	}


	@Override
	public int CalculateReachableCells() 
	{
		return 0;
	}

}
