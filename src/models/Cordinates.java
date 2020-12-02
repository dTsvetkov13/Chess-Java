package models;

import common.Constants;
import common.Validator;

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
		if(Validator.isGreaterThan(Constants.MAX_ROW_VALUE, row)
			|| Validator.isLessThan(Constants.MIN_ROW_VALUE, row))
		{
			throw new IllegalArgumentException("");
		}
		else
		{
			this.row = row;
		}
	}
	
	public void setColumn(int column)
	{
		if(Validator.isGreaterThan(Constants.MAX_COLUMN_VALUE, column)
			|| Validator.isLessThan(Constants.MIN_COLUMN_VALUE, column))
		{
			throw new IllegalArgumentException("");	
		}
		else
		{
			this.column = column;
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