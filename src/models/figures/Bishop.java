package models.figures;

import java.lang.reflect.InvocationTargetException;

import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.GameInfo;
import models.MoveTypes;
import models.MovementInDirection;

public class Bishop extends Figure 
{
	public Bishop(Coordinates coordinates, Team team)
	{
		super(coordinates, team);
		this.type = FigureType.Bishop;
	}
}
