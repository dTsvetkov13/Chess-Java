package models;

import enums.FigureType;
import enums.Team;

public abstract class Figure 
{
	private Coordinates coordinates;
	private Team team;
	private boolean isMoved;
	private FigureType type;
	private Coordinates[] reachableCells;
	private int reachableCellsCount;
	
	public Figure(Coordinates coordinates, Team team, FigureType type)
	{
		if(coordinates != null)
		{
			this.coordinates = coordinates;
			this.team = team;
			this.isMoved = false;
			this.type = type;
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
	
	public abstract int CalculateReachableCells(Coordinates row, Coordinates column);
	
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
