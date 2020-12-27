package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MoveTypes;
import models.MovementInDirection;

public class Bishop extends Figure 
{

	public Bishop(Coordinates coordinates, Team team)
	{
		super(coordinates, team);
		this.type = FigureType.Bishop;
	}


	@Override
	public int CalculateReachableCells() 
	{
		super.reachableCellsCount = 0;
		
		MovementInDirection[] directions = MoveTypes.vertical(this);//needs to be changed-diagonal
		super.addCoordinatesFromMovementInDirectionArray(directions);
		
		return super.getReachableCellsCount();
	}

}
