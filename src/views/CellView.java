package views;

import javax.swing.JComponent;

import common.Validator;
import models.Coordinates;
import models.figures.Figure;

public class CellView extends JComponent
{
	private Figure figure;
	private Coordinates coordinates;
	
	public CellView(Figure figure)
	{
		this(figure, null);
	}
	
	public CellView(Figure figure, Coordinates coordinates)
	{
		if(Validator.isNull(coordinates))
		{
			if(Validator.isNull(figure))
			{
				throw new IllegalArgumentException("The figure and the coordinates cannot be both null");
			}
			else
			{
				this.setFigure(figure);
				this.setCoordinates(figure.getCoordinates());
			}
		}
	}
	
	private void setFigure(Figure figure)
	{
		if(Validator.isNull(figure))
		{
			this.figure = figure;
		}
	}
	
	private void setCoordinates(Coordinates coordinates)
	{
		if(Validator.isNull(coordinates))
		{
			this.coordinates = coordinates;
		}
	}
	
	public Figure getFigure()
	{
		return this.figure;
	}
	
	public Coordinates getCoordinates()
	{
		return this.coordinates;
	}
}
