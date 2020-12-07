package views;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.Board;
import models.Coordinates;
import models.Figure;

public class BoardView extends JPanel
{	
	private Coordinates lastClickedCell;
	private Board board;
	
	public BoardView()
	{
		board = Board.getInstance();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Figure[][] figures = board.getAllFigures();
		CellView tempCell;
		
		for(int i = 0; i < figures.length; i++)
		{
			for(int j = 0; j < figures[i].length; j++)
			{
				tempCell = new CellView(figures[i][j]);
				tempCell.setBounds(null); //TODO: set bounds
				this.add(tempCell);
			}
		}
	}
	
	@Override
	public void repaint()
	{
		if(this.getGraphics() != null)
		{
			this.printComponent(this.getGraphics());
		}
	}
}