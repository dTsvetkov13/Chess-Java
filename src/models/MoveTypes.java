package models;

import common.Constants;

public class MoveTypes 
{
	static Board board = Board.getInstance();

	public static Coordinates[] horizontal(Figure f) 
	{
		Coordinates[] reachable = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		//optimise this - 2 fors, for left/right, if it's the end it'll just not enter the for
		if (col == 0) 
		{
			for (int i = col; i < 8; i++) 
			{
				Coordinates coor = new Coordinates(row, i);
				Figure temp = board.getFigure(coor);
				if (temp != null) 
				{
					if (temp.getTeam().equals(f.getTeam())) 
					{
						for(int j = i; j < 8; j++) 
						{
							reachable[j] = null;
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
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
				}
			}
		}
		
		else if(col == 7)
		{
			for(int i = col; i >= 0; i--)
			{
				Coordinates coor = new Coordinates(row, i);
				Figure temp = board.getFigure(coor);
				if (temp != null) 
				{
					if (temp.getTeam().equals(f.getTeam())) 
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
				}
			}
		}
		else 
		{
			for (int i = col; i < 8; i++) 
			{
				Coordinates coor = new Coordinates(row, i);
				Figure temp = board.getFigure(coor);
				if (temp != null) 
				{
					if (temp.getTeam().equals(f.getTeam())) 
					{
						for(int j = i; j < 8; j++) 
						{
							reachable[j] = null;
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
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
				}
			}
			
			for(int i = col; i >= 0; i--)
			{
				Coordinates coor = new Coordinates(row, i);
				Figure temp = board.getFigure(coor);
				if (temp != null) 
				{
					if (temp.getTeam().equals(f.getTeam())) 
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
				}
			}
		}
		
		return reachable;
	}
	
	public static Coordinates[] vertical(Figure f)
	{
		Coordinates[] reachable = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		//optimise this - 2 fors, for left/right, if it's the end it'll just not enter the for
		if(row == 0)
		{
			for(int i = row; i < 8; i++)
			{
				Coordinates coor = new Coordinates(i, col);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(temp.getTeam().equals(f.getTeam()))
					{
						for(int j = i; j < 8; j++)
						{
							reachable[j] = null;
						}
						break;
					}
					else
					{
						reachable[i] = coor;
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
				}
			}
		}
		else if(row == 7)
		{
			for(int i = row; i >= 0; i--)
			{
				Coordinates coor = new Coordinates(i, col);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(temp.getTeam().equals(f.getTeam()))
					{
						for(int j = i; j >= 0; j--)
							reachable[j] = null;
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i - 1; j >= 0; j--)
							reachable[j] = null;
						break;
					}
				}
				else
				{
					reachable[i] = coor;
				}
			}
		}
		else
		{
			for(int i = row; i < 8; i++)
			{
				Coordinates coor = new Coordinates(i, col);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(temp.getTeam().equals(f.getTeam()))
					{
						for(int j = i; j < 8; j++)
						{
							reachable[j] = null;
						}
						break;
					}
					else
					{
						reachable[i] = coor;
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
				}
			}
			
			for(int i = row; i >= 0; i--)
			{
				Coordinates coor = new Coordinates(i, col);
				Figure temp = board.getFigure(coor);
				if(temp != null)
				{
					if(temp.getTeam().equals(f.getTeam()))
					{
						for(int j = i; j >= 0; j--)
							reachable[j] = null;
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i - 1; j >= 0; j--)
							reachable[j] = null;
						break;
					}
				}
				else
				{
					reachable[i] = coor;
				}
			}
		}
		
		return reachable;
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
	
	//Yova - knightMove, kingMove
	//Boris - pawnMove, anPasan
}
