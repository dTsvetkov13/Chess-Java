package views;

import java.awt.Graphics;

import javax.swing.JPanel;

import common.Constants;
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
		
		if(true) //playerOnTurn.Team().equals(White)
		{
			for(int row = 0; row < figures.length; row++)
			{
				for(int column = 0; column < figures[row].length; column++)
				{
					tempCell = new CellView(figures[row][column]);
					tempCell.setBounds(null); //TODO: set bounds
					this.add(tempCell);
				}
			}	
		}
		else
		{
			for(int row = Constants.MAX_ROW_VALUE; row >= Constants.MIN_ROW_VALUE; row--)
			{
				for(int column = Constants.MAX_COLUMN_VALUE; column >= Constants.MIN_COLUMN_VALUE; column--)
				{
					tempCell = new CellView(figures[row][column]);
					tempCell.setBounds(null); //TODO: set bounds
					this.add(tempCell);
				}
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