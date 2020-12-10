package models;

import enums.FigureType;
import enums.Team;

public class Rook extends Figure 
{

	public Rook(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Rook;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{
		return 0;
	}

}
