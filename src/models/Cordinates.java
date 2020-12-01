package models;

import common.Constants;

public class Cordinates
{
	private int row;
	private int column;
	
	public Cordinates()
	{
		this(Constants.MIN_ROW_VALUE, Constants.MIN_COLUMN_VALUE);
	}
	
	public Cordinates(int row, int column)
	{
		setRow(row);
		setColumn(column);
	}
	
	public void setRow(int row)
	{
		if((row >= Constants.MIN_ROW_VALUE) && (row <= Constants.MAX_ROW_VALUE))
		{
			this.row = row;
		}
		else
		{
			System.out.println("Unimplemented behaviour");
		}
	}
	
	public void setColumn(int column)
	{
		if((column >= Constants.MIN_COLUMN_VALUE) && (column <= Constants.MAX_COLUMN_VALUE))
		{
			this.column = column;
		}
		else
		{
			System.out.println("Unimplemented behaviour");
		}
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
}