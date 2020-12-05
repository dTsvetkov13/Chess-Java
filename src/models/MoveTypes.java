package models;

public class MoveTypes 
{
	static Board board = Board.getInstance();

	public static Coordinates[] horizontal(Figure f) 
	{
		Coordinates[] reachable = new Coordinates[8];
		int row = f.getCoordinates().getRow();
		int col = f.getCoordinates().getColumn();
		if (col == 0) 
		{
			for (int i = col; i < 8; i++) 
			{
				Coordinates coor = new Coordinates(row, i);
				Figure temp = board.getFigure(coor);
				if (temp != null) 
				{
					if (temp.getTeam() == f.getTeam()) 
					{
						for(int j = i; j < 8; j++) 
						{
							reachable[j] = new Coordinates(row, j);
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i + 1; j < 8; j++)
						{
							reachable[j] = new Coordinates(row, j);
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
					if (temp.getTeam() == f.getTeam()) 
					{
						for(int j = i; j >= 0; j--) 
						{
							reachable[j] = new Coordinates(row, j);
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i - 1; j >= 0; j--)
						{
							reachable[j] = new Coordinates(row, j);
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
					if (temp.getTeam() == f.getTeam()) 
					{
						for(int j = i; j < 8; j++) 
						{
							reachable[j] = new Coordinates(row, j);
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i + 1; j < 8; j++)
						{
							reachable[j] = new Coordinates(row, j);
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
					if (temp.getTeam() == f.getTeam()) 
					{
						for(int j = i; j >= 0; j--) 
						{
							reachable[j] = new Coordinates(row, j);
						}
						break;
					}
					else 
					{
						reachable[i] = coor;
						for(int j = i - 1; j >= 0; j--)
						{
							reachable[j] = new Coordinates(row, j);
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
		return reachable;
	}
}
