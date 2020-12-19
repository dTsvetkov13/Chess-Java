package models;

import enums.Directions;
import models.figures.Figure;

public class MovementInDirection {
	private Directions direction;
	private Figure[] move;
	
	public MovementInDirection(Directions directionValue, Figure[] moveValue)
	{
		this.direction = directionValue;
		this.move = moveValue;
	}
}
