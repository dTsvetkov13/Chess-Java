package models;

public class MoveTypes 
{
	static Board board = Board.getInstance();

	public static boolean[] horizontal(Figure f) 
	{
		boolean[] reachable = new boolean[8];
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
							reachable[j] = false;
						}
						break;
					}
					else 
					{
						reachable[i] = true;
						for(int j = i + 1; j < 8; j++)
						{
							reachable[j] = false;
						}
						break;
					}
				}
				else 
				{
					reachable[i] = true;
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
							reachable[j] = false;
						}
						break;
					}
					else 
					{
						reachable[i] = true;
						for(int j = i - 1; j >= 0; j--)
						{
							reachable[j] = false;
						}
						break;
					}
				}
				else 
				{
					reachable[i] = true;
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
							reachable[j] = false;
						}
						break;
					}
					else 
					{
						reachable[i] = true;
						for(int j = i + 1; j < 8; j++)
						{
							reachable[j] = false;
						}
						break;
					}
				}
				else 
				{
					reachable[i] = true;
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
							reachable[j] = false;
						}
						break;
					}
					else 
					{
						reachable[i] = true;
						for(int j = i - 1; j >= 0; j--)
						{
							reachable[j] = false;
						}
						break;
					}
				}
				else 
				{
					reachable[i] = true;
				}
			}
		}
		
		return reachable;
	}
}
