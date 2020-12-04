package models;

import enums.FigureType;
import enums.Team;

public abstract class Figure 
{
	private Cordinates coordinates;
	private Team team;
	private boolean isMoved;
	private FigureType type;
	private Cordinates[] reachableCells;
	private int reachableCellsCount;
	
	public Figure(Cordinates coordinates, Team team, FigureType type)
	{
		if(coordinates != null)
		{
			this.coordinates = coordinates;
			this.team = team;
			this.isMoved = false;
			this.type = type;
			this.reachableCells = new Cordinates[32]; // TO DO: make constant for it
		}
	}
	
	public Cordinates getCoordinates()
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
	
	public Cordinates[] getReachableCells()
	{
		return reachableCells;
	}
	
	public int getReachableCellsCount()
	{
		return reachableCellsCount;
	}
	
	public abstract int CalculateReachableCells(Cordinates row, Cordinates column);
	
	public void addReachableCells(Cordinates coordinates)
	{
		for(int i = 1; i < reachableCellsCount - 1; i++)
		{
			reachableCells[i-1] = reachableCells[i];
			reachableCellsCount++;
			reachableCells[i] = coordinates;
		}
	}
	
	public boolean isOneOfReachableCells(Cordinates coordinates)
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
