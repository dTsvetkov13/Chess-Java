package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

public class Queen extends Figure
{

	public Queen(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Queen;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{
		return 0;
	}

}
