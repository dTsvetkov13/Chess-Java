package views;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import common.Constants;
import enums.Team;
import models.Board;
import models.Coordinates;
import models.Game;
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
		super.paintComponent(g);
		Figure[][] figures = board.getAllFigures();
		CellView tempCell;
		Rectangle tempRect = new Rectangle(0, 0);
		tempRect.width = this.getWidth() / (Constants.MAX_COLUMN_VALUE + 1);
		tempRect.height = this.getHeight() / (Constants.MAX_ROW_VALUE + 1);
		
		if(Game.getInstance().getPlayerOnTurn().getTeam().equals(Team.White))
		{
			for(int row = 0; row < figures.length; row++)
			{
				tempRect.x = 0;
				for(int column = 0; column < figures[row].length; column++)
				{
					tempCell = new CellView(figures[row][column], new Coordinates(row, column));
					tempCell.setBounds(tempRect);
					tempCell.setLayout(null);
					this.add(tempCell);
					tempRect.x += tempRect.width;
				}
				tempRect.y += tempRect.height;
			}
		}
		else
		{
			for(int row = Constants.MAX_ROW_VALUE; row >= Constants.MIN_ROW_VALUE; row--)
			{
				tempRect.x = 0;
				for(int column = Constants.MAX_COLUMN_VALUE; column >= Constants.MIN_COLUMN_VALUE; column--)
				{
					tempCell = new CellView(figures[row][column], new Coordinates(row, column));
					tempCell.setBounds(tempRect);
					tempCell.setLayout(null);
					this.add(tempCell);
					tempRect.x += tempRect.width;
				}
				tempRect.y += tempRect.height;
			}
		}
		
		for(var comp : this.getComponents())
		{
			comp.repaint();
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