package views;

import java.awt.Graphics;

import javax.swing.JComponent;

import models.Figure;

public class CellView extends JComponent
{
	private Figure figure;
	
	public CellView(Figure figure)
	{
		this.setFigure(figure);
	}
	
	private void setFigure(Figure figure)
	{
		if(figure != null)
		{
			this.figure = figure;
		}
		else
		{
			throw new IllegalArgumentException("");
		}
	}
	
	public Figure getFigure()
	{
		return this.figure;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		//UIFigureDrawer.drawfigure(this.getFigure().getType(), g, this.getFigure().getTeam(), this.getBounds());
	}
}
