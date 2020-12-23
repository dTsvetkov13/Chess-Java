package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import common.Validator;
import models.Coordinates;
import models.Game;
import models.figures.Figure;

public class CellView extends JPanel
					  implements MouseListener 
{
	private Figure figure;
	private Coordinates coordinates;
	
	public CellView(Figure figure)
	{
		this(figure, null);
	}
	
	public CellView(Figure figure, Coordinates coordinates)
	{
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
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
		else
		{
			this.setFigure(figure);
			this.setCoordinates(coordinates);
		}
	}
	
	private void setFigure(Figure figure)
	{
		if(!Validator.isNull(figure))
		{
			this.figure = figure;
		}
	}
	
	public void setCoordinates(Coordinates coordinates)
	{
		if(!Validator.isNull(coordinates))
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
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(!Validator.isNull(this.getFigure()))
		{
			UIFigureDrawer.drawfigure(this.getFigure().getType(), g, this.getFigure().getTeam(), this.getBounds());
		}
	}
	
	public void repaint()
	{
		if(this.getGraphics() != null)
		{
			this.paint(this.getGraphics());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if(Validator.isNull(Game.getInstance().getListener()))
		{
			Game.getInstance().getListener().onCellClicked(this);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		
	}
}
