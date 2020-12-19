package models;

import enums.Directions;
import models.figures.Figure;

public class MovementInDirection 
{
	private Directions direction;
	private Coordinates[] move;
	
	public MovementInDirection(Directions directionValue, Coordinates[] moveValue)
	{
		this.direction = directionValue;
		this.move = moveValue;
	}
	
	public void setDirection(Directions directionValue)
	{
		this.direction = directionValue;
	}
	
	public void setMove(Coordinates[] moveValue)
	{
		this.move = moveValue;
	}
	
	public Directions getDirection()
	{
		return this.direction;
	}
	
	public Coordinates[] getMove()
	{
		return this.move;
	}
}
