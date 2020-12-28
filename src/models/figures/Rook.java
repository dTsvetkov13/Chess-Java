package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;

public class Rook extends Figure 
{

	public Rook(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Rook;
	}

	@Override
	public int CalculateReachableCells() 
	{
		super.reachableCellsCount = 0;
		
		MovementInDirection[] directions = MoveTypes.vertical(this);
		super.addCoordinatesFromMovementInDirectionArray(directions);
		directions = MoveTypes.horizontal(this);
		super.addCoordinatesFromMovementInDirectionArray(directions);
		
		return super.getReachableCellsCount();
	}

}
