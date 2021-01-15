package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.GameInfo;
import models.MoveTypes;
import models.MovementInDirection;

public class Queen extends Figure
{
	public Queen(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Queen;
	}
}
