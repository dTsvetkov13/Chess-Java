package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.GameInfo;
import models.MoveTypes;
import models.MovementInDirection;

public class Rook extends Figure 
{
	public Rook(Coordinates coordinates, Team team) 
	{
		super(coordinates, team);
		this.type = FigureType.Rook;
	}
}
