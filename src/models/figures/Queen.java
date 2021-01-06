package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;

public class Queen extends Figure
{

	public Queen(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Queen;
	}

	@Override
	public int CalculateReachableCells() 
	{
		super.reachableCellsCount = 0;
		
		MovementInDirection[] directions = MoveTypes.vertical(this);
		super.addCoordinatesFromMovementInDirectionArray(directions);
		directions = MoveTypes.horizontal(this);
		super.addCoordinatesFromMovementInDirectionArray(directions);
		directions = MoveTypes.diagonal(this);
		super.addCoordinatesFromMovementInDirectionArray(directions);
		
		return super.getReachableCellsCount();
	}

}
