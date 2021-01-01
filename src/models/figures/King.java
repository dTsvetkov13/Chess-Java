package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;

public class King extends Figure
{

	public King(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.King;
	}

	@Override
	public int CalculateReachableCells() 
	{
		super.reachableCellsCount = 0;
		
		MovementInDirection[] directions = MoveTypes.kingMove(this, null, null);//to be modified
		super.addCoordinatesFromMovementInDirectionArray(directions);
		
		return super.getReachableCellsCount();
	}

}
