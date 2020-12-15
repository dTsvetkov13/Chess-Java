package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

public class Pawn extends Figure{

	public Pawn(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Pawn;
	}

	@Override
	public int CalculateReachableCells() 
	{
			return 0;
	}

}
