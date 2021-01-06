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
		
		MovementInDirection[] directions = MoveTypes.pawnMove(this);
		this.addCoordinatesFromMovementInDirectionArray(directions);
		
		return super.getReachableCellsCount();
	}

}
