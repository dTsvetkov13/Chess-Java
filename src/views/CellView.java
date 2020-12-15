package views;

import java.awt.Graphics;

import javax.swing.JComponent;

import models.figures.Figure;

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
	}
	
	public Figure getFigure()
	{
		return this.figure;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		if(figure != null)
		{
			//UIFigureDrawer.drawfigure(this.getFigure().getType(), g, this.getFigure().getTeam(), this.getBounds());
		}
	}
}
