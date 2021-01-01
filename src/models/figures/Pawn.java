package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;

public class Pawn extends Figure{

	public Pawn(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Pawn;
	}

	@Override
	public int CalculateReachableCells() 
	{
		super.reachableCellsCount = 0;
		
		Coordinates[] directions = MoveTypes.pawnMove(this);
		for(int i = 0; i < directions.length; i++)
		{
			super.addReachableCell(directions[i]);
		}
		
		return super.getReachableCellsCount();
	}

}
