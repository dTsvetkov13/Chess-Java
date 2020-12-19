package models;

import common.Constants;
import enums.Directions;
import models.figures.Figure;


public class MoveTypes 
{
	static Board board = Board.getInstance();

	public static Coordinates[] horizontal(Figure f) 
	{
		Coordinates[] reachable = new Coordinates[8];
		int index = 0;
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		
		//this for calculates the reachable cells to the right of the figure
		for(int i = col; i <= 7; i++)
		{
			Coordinates coor = new Coordinates(row, i);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j <= 7; j++)
					{
						reachable[j] = null;
					}
					break;
				}
				else
				{
					reachable[i] = coor;
					index++;
					for(int j = i + 1; j < 8; j++)
					{
						reachable[j] = null;
					}
					break;
				}
			}
			else
			{
				reachable[i] = coor;
				index++;
			}
		}
		
		//this for calculates the reachable cells to the left of the figure
		for(int i = col; i >= 0; i--)
		{
			Coordinates coor = new Coordinates(row, i);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachable[j] = null;
					}
					break;
				}
				else
				{
					reachable[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachable[j] = null;
					}
					break;
				}
			}
			else
			{
				reachable[i] = coor;
				index++;
			}
		}
		//this for makes a Coordinates array with no nulls
		Coordinates[] result = new Coordinates[index];
		index = 0;
		for(int i = 0; i < reachable.length; i++)
		{
			if(reachable[i] != null)
			{
				result[index] = reachable[i];
				index++;
			}
		}
		
		return result;
	}
	
	public static Coordinates[] vertical(Figure f)
	{
		Coordinates[] reachable = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index = 0;
		
		//this for calculates the reachable cells above the figure
		for(int i = row; i <= 7; i++)
		{
			Coordinates coor = new Coordinates(i, col);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j <= 7; j++)
					{
						reachable[j] = null;
					}
					break;
				}
				else
				{
					reachable[i] = coor;
					index++;
					for(int j = i + 1; j <= 7; j++)
					{
						reachable[j] = null;
					}
				}
			}
			else
			{
				reachable[i] = coor;
				index++;
			}
		}
		
		//this for calculates the reachable cells below the figure
		for(int i = row; i >= 0; i--)
		{
			Coordinates coor = new Coordinates(i, col);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachable[j] = null;
					}
				}
				else
				{
					reachable[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachable[j] = null;
					}
				}
			}
			else
			{
				reachable[i] = coor;
				index++;
			}
		}
		
		//this for creates a Coordinates array with no nulls
		Coordinates[] result = new Coordinates[index];
		index = 0;
		for(int i = 0; i < reachable.length; i++)
		{
			if(reachable[i] != null)
			{
				result[index] = reachable[i];
				index++;
			}
		}
		
		return result;
	}
	
	public static Coordinates[] diagonal(Figure f) {
		Coordinates[] reachable = new Coordinates[13];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index=0;
		int j=col;
		// This loop checks the possible moves in the following order - down and to the right
		for(int i=row+1;i<=Constants.MAX_ROW_VALUE;i++)
		{
			j++;
			Coordinates coor = new Coordinates(i, j);
			Figure temp = board.getFigure(coor);
			if(temp!=null)
			{
				if(temp.getTeam().equals(f.getTeam())) 
				{
					break;
				}
				else  
				{
					reachable[index]=coor;
					index++;
					break;
				}
			}
			else 
			{
				reachable[index]=coor;
				index++;
				
			}
		}
		j=col;
		// This loop checks the possible moves in the following order - down and to the left
		for(int i=row+1;i<=Constants.MAX_ROW_VALUE;i++) 
		{
			j--;
			Coordinates coor = new Coordinates(i, j);
			Figure temp = board.getFigure(coor);
			if(temp!=null) 
			{
				if(temp.getTeam().equals(f.getTeam())) 
				{
					break;
				}
				else  
				{
					reachable[index]=coor;
					index++;
					break;
				}
			}
			else 
			{
				reachable[index]=coor;
				index++;
			
			}
			
		}
		j=col;
		// This loop checks the possible moves in the following order - up and to the right
		for(int i=row-1;i>=Constants.MIN_ROW_VALUE;i--) {
			j++;
			Coordinates coor = new Coordinates(i, j);
			Figure temp = board.getFigure(coor);
			if(temp!=null) {
				if(temp.getTeam().equals(f.getTeam())) 
				{
					break;
				}else  
				{
					reachable[index]=coor;
					index++;
					break;
				}
			}else {
				reachable[index]=coor;
				index++;
				
			}
			
		}
		j=col;
		// This loop checks the possible moves in the following order - up and to the left
		for(int i=row-1;i>Constants.MIN_ROW_VALUE;i--) 
		{
			j--;
			Coordinates coor = new Coordinates(i, j);
			Figure temp = board.getFigure(coor);
			if(temp!=null) 
			{
				if(temp.getTeam().equals(f.getTeam())) 
				{
					break;
				}
				else  
				{
					reachable[index]=coor;
					index++;
					break;
				}
			}
			else 
			{
				reachable[index]=coor;
				index++;
			}
			
		}
		
		Coordinates[] reachable2 = new Coordinates[index];
		for(int i=0;i<index;i++) {
			reachable2[i]=reachable[i];
		}
		return reachable2;
	}
	
	public static Coordinates[] pawnMove(Figure f) 
	{
		Coordinates[] reachable = new Coordinates[3];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index=0;
		Coordinates coor = new Coordinates(row-1, col);
		Figure temp = board.getFigure(coor);
		if(temp == null) 
		{
			reachable[index]=coor;
			index++;
		}
		coor = new Coordinates(row-1, col+1);
		temp = board.getFigure(coor);
		if(temp != null) 
		{
			if(!temp.getTeam().equals(f.getTeam())) 
			{
				reachable[index]=coor;
				index++;
			}	
		}
		coor = new Coordinates(row-1, col-1);
		temp = board.getFigure(coor);
		if(temp != null) 
		{
			if(!temp.getTeam().equals(f.getTeam())) 
			{
				reachable[index]=coor;
				index++;
			}	
		}
		
		Coordinates[] reachable2 = new Coordinates[index];
		for(int i = 0; i < index; i++) 
		{
			reachable2[i]=reachable[i];
		}
		return reachable2;
	}
	
	public static MovementInDirection[] kingMove(Figure f)
	{
		//needs optimising
		//doesn't check for impossible moves
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index = 0;
		MovementInDirection[] reachableTemp = new MovementInDirection[8];
		
		//this checks for possible moves in row below the King's, if it exists
		for(int i = row - 1, j = col - 1, count = 0; i >= 0 && count <= 2; j++, count++)
		{
			if(j >= 0 && j <= 7)
			{
				Coordinates coor = new Coordinates(i, j);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(!temp.getTeam().equals(f.getTeam()))
					{
						Coordinates[] reachable1 = new Coordinates[1];
						reachable1[0] = coor;
						MovementInDirection m;
						if(j == col - 1)
						{
							m = new MovementInDirection(Directions.LowerLeft, reachable1);
			
						}
						else if(j == col)
						{
							m = new MovementInDirection(Directions.South, reachable1);
						}
						else
						{
							m = new MovementInDirection(Directions.LowerRight, reachable1);
						}
						
						reachableTemp[index] = m;
						index++;
					}
				}
				else
				{
					Coordinates[] reachable1 = new Coordinates[1];
					reachable1[0] = coor;
					MovementInDirection m;
					if(j == col - 1)
					{
						m = new MovementInDirection(Directions.LowerLeft, reachable1);
		
					}
					else if(j == col)
					{
						m = new MovementInDirection(Directions.South, reachable1);
					}
					else
					{
						m = new MovementInDirection(Directions.LowerRight, reachable1);
					}
					
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		for(int i = row + 1, j = col - 1, count = 0;i <= 7 && count <= 2; j++, count++)
		{
			if(j >= 0 && j <= 7)
			{
				Coordinates coor = new Coordinates(i, j);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(!temp.getTeam().equals(f.getTeam()))
					{
						Coordinates[] reachable2 = new Coordinates[1];
						reachable2[0] = coor;
						MovementInDirection m;
						if(j == col - 1)
						{
							m = new MovementInDirection(Directions.UpperLeft, reachable2);
						}
						else if(j == col)
						{
							m = new MovementInDirection(Directions.North, reachable2);
						}
						else
						{
							m = new MovementInDirection(Directions.UpperRight, reachable2);
						}
						
						reachableTemp[index] = m;
						index++;
					}
				}
				else
				{
					Coordinates[] reachable2 = new Coordinates[1];
					reachable2[0] = coor;
					MovementInDirection m;
					if(j == col - 1)
					{
						m = new MovementInDirection(Directions.UpperLeft, reachable2);
					}
					else if(j == col)
					{
						m = new MovementInDirection(Directions.North, reachable2);
					}
					else
					{
						m = new MovementInDirection(Directions.UpperRight, reachable2);
					}
					
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		if((col - 1) >= 0)
		{
			Coordinates coor = new Coordinates(row, col - 1);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(!temp.getTeam().equals(f.getTeam()))
				{
					Coordinates[] reachable3 = new Coordinates[1];
					reachable3[0] = coor;
					MovementInDirection m = new MovementInDirection(Directions.West, reachable3);
					reachableTemp[index] = m;
					index++;
				}
			}
			else
			{
				Coordinates[] reachable3 = new Coordinates[1];
				reachable3[0] = coor;
				MovementInDirection m = new MovementInDirection(Directions.West, reachable3);
				reachableTemp[index] = m;
				index++;
			}
		}
		
		if((col + 1) <= 7)
		{
			Coordinates coor = new Coordinates(row, col + 1);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(!temp.getTeam().equals(f.getTeam()))
				{
					Coordinates[] reachable3 = new Coordinates[1];
					reachable3[0] = coor;
					MovementInDirection m = new MovementInDirection(Directions.East, reachable3);
					reachableTemp[index] = m;
					index++;
				}
			}
			else
			{
				Coordinates[] reachable3 = new Coordinates[1];
				reachable3[0] = coor;
				MovementInDirection m = new MovementInDirection(Directions.East, reachable3);
				reachableTemp[index] = m;
				index++;
			}
		}
		
		MovementInDirection[] reachable = new MovementInDirection[index];
		
		index = 0;
		for(int i = 0; i < reachableTemp.length; i++)
		{
			if(reachableTemp[i] != null)
			{
				reachable[index] = reachableTemp[i];
				index++;
			}
		}
		
		return reachable;
	}
	
	

	
	//Yova - knightMove, kingMove
	//Boris - pawnMove, anPasan
}
