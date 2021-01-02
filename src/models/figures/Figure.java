package models.figures;

import common.Validator;
import enums.FigureType;
import enums.Team;
import models.Coordinates;
import models.MovementInDirection;

public abstract class Figure 
{
	protected Coordinates coordinates;
	protected Team team;
	protected boolean isMoved;
	protected FigureType type;
	protected Coordinates[] reachableCells;
	protected int reachableCellsCount;
	protected boolean isSelected;
	
	public Figure(Coordinates coordinates, Team team)
	{
		if(coordinates != null)
		{
			this.coordinates = coordinates;
			this.team = team;
			this.isMoved = false;
			this.reachableCells = new Coordinates[32]; // TO DO: make constant for it
		}
	}
	
	public Figure(Figure figure)
	{
		this(figure.getCoordinates(), figure.getTeam());
		this.isMoved = figure.isMoved();
		this.type = figure.getType();
	}
	
	public void setCoordinates(Coordinates coordinates)
	{
		if(!Validator.isNull(coordinates))
		{
			this.coordinates = coordinates;
		}
	}
	
	public void setMoved(boolean isMoved)
	{
		this.isMoved = isMoved;
	}
	
	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public Coordinates getCoordinates()
	{
		return coordinates;
	}
	
	public Team getTeam()
	{
		return team;
	}
	
	public boolean isMoved()
	{
		return isMoved;
	}
	
	public FigureType getType()
	{
		return type;
	}
	
	public Coordinates[] getReachableCells()
	{
		return reachableCells;
	}
	
	public int getReachableCellsCount()
	{
		return reachableCellsCount;
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public abstract int CalculateReachableCells();
	
	public void addCoordinatesFromMovementInDirectionArray(MovementInDirection[] array)
	{
		if(!Validator.isNull(array))
		{
			for(int i = 0; i < array.length; i++)
			{
				this.addCoordinatesFromMovementInDirection(array[i]);
			}
		}
	}
	
	public void addCoordinatesFromMovementInDirection(MovementInDirection directions)
	{
		if(!Validator.isNull(directions))
		{
			for(int i = 0; i < directions.getMove().length; i++)
			{
				this.addReachableCell(directions.getMove()[i]);
			}
		}
	}
	
	public void addReachableCell(Coordinates coordinates)
	{
		if(reachableCellsCount < reachableCells.length && coordinates != null)
		{
			reachableCells[reachableCellsCount] = coordinates;
			reachableCellsCount++;
		}
	}
	
	public boolean isOneOfReachableCells(Coordinates coordinates)
	{
		if(reachableCellsCount > 0)
		{
			for(int i = 0; i < reachableCellsCount; i++)
			{
				if(reachableCells[i].getRow() == coordinates.getRow() && 
						reachableCells[i].getColumn() == coordinates.getColumn())
				{
					return true;
				}
			
			}
		}
		return false;
	}
	
	public boolean canYouReachEnemyKing()
	{
		return false;  
	}
}
