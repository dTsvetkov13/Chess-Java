package models;

import common.Constants;
import enums.Directions;
import enums.Team;
import models.figures.Figure;
import models.figures.King;
import models.figures.Rook;


public class MoveTypes 
{
	static Board board = Board.getInstance();

	public static MovementInDirection[] horizontal(Figure f) 
	{
		MovementInDirection[] reachable = new MovementInDirection[2];
		Coordinates[] reachableWest = new Coordinates[8];
		Coordinates[] reachableEast = new Coordinates[8];
		int index = 0;
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		
		//this for calculates the reachable cells to the right (East) of the figure
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
						reachableEast[j] = null;
					}
					break;
				}
				else
				{
					reachableEast[i] = coor;
					index++;
					for(int j = i + 1; j < 8; j++)
					{
						reachableEast[j] = null;
					}
					break;
				}
			}
			else
			{
				reachableEast[i] = coor;
				index++;
			}
		}
		
		if(col <= 7) 
		{
			MovementInDirection m = new MovementInDirection(Directions.East, reachableEast);
			reachable[index] = m;
			index++;
		}
		
		//this for calculates the reachable cells to the left (West) of the figure
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
						reachableWest[j] = null;
					}
					break;
				}
				else
				{
					reachableWest[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableWest[j] = null;
					}
					break;
				}
			}
			else
			{
				reachableWest[i] = coor;
				index++;
			}
		}
		
		if(col >= 0)
		{
			MovementInDirection m1 = new MovementInDirection(Directions.West, reachableWest);
			reachable[index] = m1;
			index++;
		}
		
		
		return reachable;
	}
	
	public static MovementInDirection[] vertical(Figure f)
	{
		MovementInDirection[] reachable = new MovementInDirection[2];
		Coordinates[] reachableNorth = new Coordinates[8];
		Coordinates[] reachableSouth = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index = 0;
		
		//this for calculates the reachable cells above (North) the figure, if such exist
		for(int i = row + 1; i <= 7; i++)
		{
			Coordinates coor = new Coordinates(i, col);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j <= 7; j++)
					{
						reachableNorth[j] = null;
					}
					break;
				}
				else
				{
					reachableNorth[i] = coor;
					index++;
					for(int j = i + 1; j <= 7; j++)
					{
						reachableNorth[j] = null;
					}
				}
			}
			else
			{
				reachableNorth[i] = coor;
				index++;
			}
		}
		
		if(row < 7)
		{
			MovementInDirection m = new MovementInDirection(Directions.North, reachableNorth);
			reachable[index] = m;
			index++;
		}
		
		//this for calculates the reachable cells below (South) the figure, if such exist
		for(int i = row - 1; i >= 0; i--)
		{
			Coordinates coor = new Coordinates(i, col);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachableSouth[j] = null;
					}
				}
				else
				{
					reachableSouth[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableSouth[j] = null;
					}
				}
			}
			else
			{
				reachableSouth[i] = coor;
				index++;
			}
		}
		
		if(row > 0)
		{
			MovementInDirection m1 = new MovementInDirection(Directions.South, reachableSouth);
			reachable[index] = m1;
			index++;
		}
		
		return reachable;
	}
	
	public static Coordinates[] diagonal(Figure f) 
	{
		Coordinates[] reachable = new Coordinates[13];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index=0;
		int j=col;
		// This loop checks the possible moves in the following order - down and to the right
		for(int i = row + 1; i <= Constants.MAX_ROW_VALUE; i++)
		{
			j++;
			Coordinates coor = new Coordinates(i, j);
			Figure temp = board.getFigure(coor);
			if(temp != null)
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
		for(int i = row + 1; i <= Constants.MAX_ROW_VALUE; i++) 
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
		for(int i = row - 1; i >= Constants.MIN_ROW_VALUE; i--) 
		{
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
		for(int i = row - 1; i > Constants.MIN_ROW_VALUE; i--) 
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
		for(int i = 0; i < index; i++) 
		{
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
		
		//checks for possible moves in row below the King's, if it exists
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
		
		//checks for possible moves in the row above the King's, if it exists 
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
		
		//checks for a possible move to the left of the King, if such cell exists
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
		
		//checks for a possible move to the right of the King, if such a cell exists
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
	
	public static MovementInDirection[] knightMove(Figure f)
	{
		//could do with some optimising, I guess
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		MovementInDirection[] reachableTemp = new MovementInDirection[8];
		int index = 0;
		
		//checks for possible moves in row two times below the Knight's, if it exists
		for(int i = row - 2, j = col - 1, count = 0; i >= 0 && count <= 1; j += 2, count++)
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
					else
					{
						m = new MovementInDirection(Directions.LowerRight, reachable1);
					}
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		//checks for possible moves in row below Knight's, if it exists
		for(int i = row - 1, j = col - 2, count = 0; i >= 0 && count <= 1; j += 4, count++)
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
						if(j == col - 2)
						{
							m = new MovementInDirection(Directions.LowerLeft, reachable1);
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
					if(j == col - 2)
					{
						m = new MovementInDirection(Directions.LowerLeft, reachable1);
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
		
		//checks for possible moves in row two times above Knight's, if it exists
		for(int i = row + 2, j = col - 1, count = 0; i <= 7 && count <= 1; j += 2, count++)
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
					else
					{
						m = new MovementInDirection(Directions.UpperRight, reachable2);
					}
					reachableTemp[index] = m;
					index++;
				}
				
			}
		}
		
		//checks for possible moves in row above Knight's, if it exists
		
		for(int i = row + 1, j = col - 2, count = 0; i <= 7 && count <= 1; j += 4, count++)
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
						
						if(j == col - 2)
						{
							m = new MovementInDirection(Directions.UpperLeft, reachable2);
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
					
					if(j == col - 2)
					{
						m = new MovementInDirection(Directions.UpperLeft, reachable2);
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
	
	public static MovementInDirection kingSideCastling(King k, Rook r)
	{
		//doesn't check whether King is checked or cells are guarded
		if(k.getTeam().equals(Team.White))
		{
			Coordinates g1 = new Coordinates(0, 6);
			Coordinates f1 = new Coordinates(0, 5);
			if(k.isMoved() == true || r.isMoved() == true)
			{
				return null;
			}
			else if(board.getFigure(g1) == null && board.getFigure(f1) == null)
			{
				Coordinates[] reachable = {g1, f1};
				MovementInDirection m = new MovementInDirection(Directions.KingSideCastling, reachable);
				return m;
			}
			else
			{
				return null;
			}
		}
		else
		{
			Coordinates g8 = new Coordinates(7, 6);
			Coordinates f8 = new Coordinates(7, 5);
			if(k.isMoved() == true || r.isMoved() == true)
			{
				return null;
			}
			else if(board.getFigure(g8) == null && board.getFigure(f8) == null)
			{
				Coordinates[] reachable = {g8, f8};
				MovementInDirection m = new MovementInDirection(Directions.KingSideCastling, reachable);
				return m;
			}
			else
			{
				return null;
			}
		}
	}
	
	

	
	//Yova - knightMove, kingMove
	//Boris - pawnMove, anPasan
}
