package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.GameInfo;
import models.MoveTypes;
import models.MovementInDirection;

public class Pawn extends Figure
{
	public Pawn(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Pawn;
	}
}
