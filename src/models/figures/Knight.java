package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

public class Knight extends Figure
{
	public Knight(Coordinates coordinates, Team team)
	{
		super(coordinates, team);
		this.type = FigureType.Knight;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates)
	{
		return 0;
	}
}