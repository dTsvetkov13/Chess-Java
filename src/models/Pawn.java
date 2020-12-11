package models;

import enums.FigureType;
import enums.Team;

public class Pawn extends Figure{

	public Pawn(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Pawn;
	}

	@Override
	public int CalculateReachableCells(Coordinates coordinates) 
	{
		return 0;
	}

}
