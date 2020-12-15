package models.figures;

import enums.FigureType;
import enums.Team;
import models.Coordinates;

public abstract class Figure 
{
	protected Coordinates coordinates;
	protected Team team;
	protected boolean isMoved;
	protected FigureType type;
	protected Coordinates[] reachableCells;
	protected int reachableCellsCount;
	
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
	
	public abstract int CalculateReachableCells();
	
	public void addReachableCell(Coordinates coordinates)
	{
		if(reachableCellsCount >= reachableCells.length && coordinates != null)
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
