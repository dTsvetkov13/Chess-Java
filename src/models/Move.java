package models;

import common.Validator;
import models.figures.Figure;

public class Move
{
	private Coordinates coordinatesFrom;
	private Coordinates coordinatesTo;
	private Figure movedFigure;
	private Figure replacedFigure; //Sometimes it will be null
	
	public Move(Coordinates coordinatesFrom, Coordinates coordinatesTo,
			Figure movedFigure)
	{
		this(coordinatesFrom, coordinatesTo, movedFigure, null);
	}
	
	public Move(Coordinates coordinatesFrom, Coordinates coordinatesTo,
				Figure movedFigure, Figure replacedFigure)
	{
		this.setCoordinatesFrom(coordinatesFrom);
		this.setCoordinatesTo(coordinatesTo);
		this.setMovedFigure(movedFigure);
		this.setReplacedFigure(replacedFigure);
	}

	public Coordinates getCoordinatesFrom()
	{
		return coordinatesFrom;
	}

	public Coordinates getCoordinatesTo()
	{
		return coordinatesTo;
	}

	public Figure getMovedFigure()
	{
		return movedFigure;
	}

	public Figure getReplacedFigure()
	{
		return replacedFigure;
	}

	public void setCoordinatesFrom(Coordinates coordinatesFrom)
	{
		if(Validator.isNull(coordinatesFrom))
		{
			this.coordinatesFrom = coordinatesFrom;
		}
	}

	public void setCoordinatesTo(Coordinates coordinatesTo)
	{
		if(Validator.isNull(coordinatesTo))
		{
			this.coordinatesTo = coordinatesTo;
		}
	}

	public void setMovedFigure(Figure movedFigure)
	{
		if(Validator.isNull(movedFigure))
		{
			this.movedFigure = movedFigure;
		}
	}

	public void setReplacedFigure(Figure replacedFigure)
	{
		//This can be null
		this.replacedFigure = replacedFigure;
	}
}
