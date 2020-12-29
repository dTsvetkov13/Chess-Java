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
		for(int i = col; i <= Constants.MAX_COLUMN_VALUE; i++)
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
		for(int i = col; i >= Constants.MIN_COLUMN_VALUE; i--)
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
		
		//this for calculates the reachable cells below (South) the figure, if such exist
		for(int i = row + 1; i <= Constants.MAX_ROW_VALUE; i++)
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
			MovementInDirection m = new MovementInDirection(Directions.South, reachableNorth);
			reachable[index] = m;
			index++;
		}
		
		//this for calculates the reachable cells above (North) the figure, if such exist
		for(int i = row - 1; i >= Constants.MIN_ROW_VALUE; i--)
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
			MovementInDirection m1 = new MovementInDirection(Directions.North, reachableSouth);
			reachable[index] = m1;
			index++;
		}
		
		return reachable;
	}
	
	public static MovementInDirection[] diagonal(Figure f) 
	{
		MovementInDirection[] reachable = new MovementInDirection[4];
		Coordinates[] reachableUpperLeft = new Coordinates[8];
		Coordinates[] reachableLowerLeft = new Coordinates[8];
		Coordinates[] reachableUpperRight = new Coordinates[8];
		Coordinates[] reachableLowerRight = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index=0;
		int k=col;
		
		// This loop checks the possible moves in the following order - lower right
		
		for(int i = row + 1; i <= Constants.MAX_ROW_VALUE; i++)
		{
			k++;
			Coordinates coor = new Coordinates(i, k);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachableLowerRight[j] = null;
					}
				}
				else
				{
					reachableLowerRight[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableLowerRight[j] = null;
					}
				}
			}
			else
			{
				reachableLowerRight[i] = coor;
				index++;
			}
		}
		MovementInDirection m = new MovementInDirection(Directions.LowerRight, reachableLowerRight);
		reachable[index] = m;
		index++;
		k=col;
		
		// This loop checks the possible moves in the following order - lower left
		
		for(int i = row + 1; i <= Constants.MAX_ROW_VALUE; i++) 
		{
			k--;
			Coordinates coor = new Coordinates(i, k);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachableLowerLeft[j] = null;
					}
				}
				else
				{
					reachableLowerLeft[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableLowerLeft[j] = null;
					}
				}
			}
			else
			{
				reachableLowerLeft[i] = coor;
				index++;
			}
			
		}
		MovementInDirection m1 = new MovementInDirection(Directions.LowerLeft, reachableLowerLeft);
		reachable[index] = m1;
		index++;
		k=col;
		
		// This loop checks the possible moves in the following order- upper right
		
		for(int i = row - 1; i >= Constants.MIN_ROW_VALUE; i--) 
		{
			k++;
			Coordinates coor = new Coordinates(i, k);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachableUpperRight[j] = null;
					}
				}
				else
				{
					reachableUpperRight[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableUpperRight[j] = null;
					}
				}
			}
			else
			{
				reachableUpperRight[i] = coor;
				index++;
			}
			
		}
		MovementInDirection m2 = new MovementInDirection(Directions.UpperRight, reachableUpperRight);
		reachable[index] = m2;
		index++;
		k=col;
		
		// This loop checks the possible moves in the following order - upper left
		
		for(int i = row - 1; i > Constants.MIN_ROW_VALUE; i--) 
		{
			k--;
			Coordinates coor = new Coordinates(i, k);
			Figure temp = board.getFigure(coor);
			if(temp != null)
			{
				if(temp.getTeam().equals(f.getTeam()))
				{
					for(int j = i; j >= 0; j--)
					{
						reachableUpperLeft[j] = null;
					}
				}
				else
				{
					reachableUpperLeft[i] = coor;
					index++;
					for(int j = i - 1; j >= 0; j--)
					{
						reachableUpperLeft[j] = null;
					}
				}
			}
			else
			{
				reachableUpperLeft[i] = coor;
				index++;
			}
			
		}
		MovementInDirection m3 = new MovementInDirection(Directions.UpperLeft, reachableUpperLeft);
		reachable[index] = m3;
		index++;
		
		return reachable;
	}
	
	public static MovementInDirection[] pawnMove(Figure f) 
	{
		MovementInDirection[] reachable = new MovementInDirection[3];
		Coordinates[] reachableUpperLeft = new Coordinates[1];
		Coordinates[] reachableUpperRight = new Coordinates[1];
		Coordinates[] reachableNorth = new Coordinates[2];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index=0;
		Coordinates coor = new Coordinates(row-1, col);
		Figure temp = board.getFigure(coor);
		if(temp == null) 
		{
			reachableNorth[index]=coor;
			index++;
			if(f.getCoordinates().getRow()==1) 
			{
				coor = new Coordinates(row-2, col);
				temp = board.getFigure(coor);
				if(temp == null) 
				{
					reachableNorth[index]=coor;
					index++;
				}
			}
		}
		MovementInDirection m = new MovementInDirection(Directions.North, reachableNorth);
		reachable[index] = m;
		index++;
		coor = new Coordinates(row-1, col+1);
		temp = board.getFigure(coor);
		if(temp != null) 
		{
			if(!temp.getTeam().equals(f.getTeam())) 
			{
				reachableUpperRight[index]=coor;
				index++;
			}	
		}
		MovementInDirection m1 = new MovementInDirection(Directions.UpperRight, reachableUpperRight);
		reachable[index] = m1;
		index++;
		coor = new Coordinates(row-1, col-1);
		temp = board.getFigure(coor);
		if(temp != null) 
		{
			if(!temp.getTeam().equals(f.getTeam())) 
			{
				reachableUpperLeft[index]=coor;
				index++;
			}	
		}
		MovementInDirection m2 = new MovementInDirection(Directions.UpperLeft, reachableUpperLeft);
		reachable[index] = m2;
		index++;
		return reachable;
	}
	
	public static MovementInDirection[] kingMove(Figure f)
	{
		//needs optimising
		//doesn't check for impossible moves
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		int index = 0;
		MovementInDirection[] reachableTemp = new MovementInDirection[10];
		
		//checks for possible moves in row above the King's, if it exists
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
							m = new MovementInDirection(Directions.UpperLeft, reachable1);
			
						}
						else if(j == col)
						{
							m = new MovementInDirection(Directions.North, reachable1);
						}
						else
						{
							m = new MovementInDirection(Directions.UpperRight, reachable1);
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
						m = new MovementInDirection(Directions.UpperLeft, reachable1);
		
					}
					else if(j == col)
					{
						m = new MovementInDirection(Directions.North, reachable1);
					}
					else
					{
						m = new MovementInDirection(Directions.UpperRight, reachable1);
					}
					
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		//checks for possible moves in the row below the King's, if it exists 
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
							m = new MovementInDirection(Directions.LowerLeft, reachable2);
						}
						else if(j == col)
						{
							m = new MovementInDirection(Directions.South, reachable2);
						}
						else
						{
							m = new MovementInDirection(Directions.LowerRight, reachable2);
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
						m = new MovementInDirection(Directions.LowerLeft, reachable2);
					}
					else if(j == col)
					{
						m = new MovementInDirection(Directions.South, reachable2);
					}
					else
					{
						m = new MovementInDirection(Directions.LowerRight, reachable2);
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
		
		//checks for possible Castling
		
		if(f.getTeam().equals(Team.Black))
		{
			Coordinates a8 = new Coordinates(0, 0);
			Coordinates h8 = new Coordinates(0, 7);
			Figure r1 = board.getFigure(a8);
			Figure r2 = board.getFigure(h8);
			MovementInDirection kingSideCastling = MoveTypes.kingSideCastling((King)f, (Rook)r2);
			MovementInDirection queenSideCastling = MoveTypes.queenSideCastling((King)f, (Rook)r1);
			if(kingSideCastling != null)
			{
				reachableTemp[index] = kingSideCastling;
				index++;
			}
			if(queenSideCastling != null)
			{
				reachableTemp[index] = queenSideCastling;
				index++;
			}
		}
		else
		{
			Coordinates a1 = new Coordinates(7, 0);
			Coordinates h1 = new Coordinates(7, 7);
			Figure r1 = board.getFigure(a1);
			Figure r2 = board.getFigure(h1);
			MovementInDirection kingSideCastling = MoveTypes.kingSideCastling((King)f, (Rook)r2);
			MovementInDirection queenSideCastling = MoveTypes.queenSideCastling((King)f, (Rook)r1);
			if(kingSideCastling != null)
			{
				reachableTemp[index] = kingSideCastling;
				index++;
			}
			if(queenSideCastling != null)
			{
				reachableTemp[index] = queenSideCastling;
				index++;
			}
			
		}
		
		//returns an array without nulls
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
		
		//checks for possible moves in row two times above the Knight's, if it exists
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
							m = new MovementInDirection(Directions.UpperLeft, reachable1);
						}
						else
						{
							m = new MovementInDirection(Directions.UpperRight, reachable1);
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
						m = new MovementInDirection(Directions.UpperLeft, reachable1);
					}
					else
					{
						m = new MovementInDirection(Directions.UpperRight, reachable1);
					}
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		//checks for possible moves in row above Knight's, if it exists
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
							m = new MovementInDirection(Directions.UpperLeft, reachable1);
						}
						else
						{
							m = new MovementInDirection(Directions.UpperRight, reachable1);
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
						m = new MovementInDirection(Directions.UpperLeft, reachable1);
					}
					else
					{
						m = new MovementInDirection(Directions.UpperRight, reachable1);
					}
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		//checks for possible moves in row two times below Knight's, if it exists
		for(int i = row + 2, j = col - 1, count = 0; i <= 7 && count <= 1; j += 2, count++)
		{
			if(j >= 0 && j <= 7)
			{
				Coordinates coor = new Coordinates(i, j);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					System.out.println(temp.getTeam());
					System.out.println("Our figure: " + f.getTeam());
					if(!temp.getTeam().equals(f.getTeam()))
					{
						Coordinates[] reachable2 = new Coordinates[1];
						reachable2[0] = coor;
						MovementInDirection m;
						if(j == col - 1)
						{
							m = new MovementInDirection(Directions.LowerLeft, reachable2);
						}
						else
						{
							m = new MovementInDirection(Directions.LowerRight, reachable2);
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
						m = new MovementInDirection(Directions.LowerLeft, reachable2);
					}
					else
					{
						m = new MovementInDirection(Directions.LowerRight, reachable2);
					}
					reachableTemp[index] = m;
					index++;
				}
				
			}
		}
		
		//checks for possible moves in row below Knight's, if it exists
		
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
							m = new MovementInDirection(Directions.LowerLeft, reachable2);
						}
						else
						{
							m = new MovementInDirection(Directions.LowerRight, reachable2);
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
						m = new MovementInDirection(Directions.LowerLeft, reachable2);
					}
					else
					{
						m = new MovementInDirection(Directions.LowerRight, reachable2);
					}
					
					reachableTemp[index] = m;
					index++;
				}
			}
		}
		
		
		//creates an array with no nulls
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
			Coordinates g1 = new Coordinates(7, 6);
			Coordinates f1 = new Coordinates(7, 5);
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
			Coordinates g8 = new Coordinates(0, 6);
			Coordinates f8 = new Coordinates(0, 5);
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
	
	public static MovementInDirection queenSideCastling(King k, Rook r)
	{
		//doesn't check whether King is checked or cells are guarded
		if(k.getTeam().equals(Team.White))
		{
			Coordinates d1 = new Coordinates(7, 3);
			Coordinates c1 = new Coordinates(7, 2);
			Coordinates b1 = new Coordinates(7, 1);
			if(k.isMoved() == true || r.isMoved() == true)
			{
				return null;
			}
			else if(board.getFigure(d1) == null && board.getFigure(c1) == null && board.getFigure(b1) == null)
			{
				Coordinates[] reachable = {c1, d1};
				MovementInDirection m = new MovementInDirection(Directions.QueenSideCastling, reachable);
				return m;
			}
			else
			{
				return null;
			}
		}
		else
		{
			Coordinates d8 = new Coordinates(0, 3);
			Coordinates c8 = new Coordinates(0, 2);
			Coordinates b8 = new Coordinates(0, 1);
			if(k.isMoved() == true || r.isMoved() == true)
			{
				return null;
			}
			else if(board.getFigure(d8) == null && board.getFigure(c8) == null && board.getFigure(b8) == null)
			{
				Coordinates[] reachable = {c8, d8};
				MovementInDirection m = new MovementInDirection(Directions.QueenSideCastling, reachable);
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
