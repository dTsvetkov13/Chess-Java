package views;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import common.Constants;
import models.Board;
import models.Coordinates;
import models.figures.Figure;

public class BoardView extends JPanel
{
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
		Rectangle tempRect = new Rectangle(0, 0);
		tempRect.width = this.getWidth() / (Constants.MAX_COLUMN_VALUE + 1);
		tempRect.height = this.getHeight() / (Constants.MAX_ROW_VALUE + 1);
		
		if(true) //playerOnTurn.getTeam().equals(White)
		{
			for(int row = 0; row < figures.length; row++)
			{
				for(int column = 0; column < figures[row].length; column++)
				{
					tempCell = new CellView(figures[row][column]);
					tempCell.setBounds(tempRect);
					this.add(tempCell);
					tempRect.x += tempRect.width;
				}
			}
			tempRect.y += tempRect.height;
		}
		else
		{
			for(int row = Constants.MAX_ROW_VALUE; row >= Constants.MIN_ROW_VALUE; row--)
			{
				for(int column = Constants.MAX_COLUMN_VALUE; column >= Constants.MIN_COLUMN_VALUE; column--)
				{
					tempCell = new CellView(figures[row][column]);
					tempCell.setBounds(tempRect);
					this.add(tempCell);
					tempRect.x += tempRect.width;
				}
				tempRect.y += tempRect.height;
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