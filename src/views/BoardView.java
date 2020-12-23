package views;

import java.awt.Color;
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
		Rectangle tempCellBounds = new Rectangle(0, 0);
		tempCellBounds.width = this.getWidth() / (Constants.MAX_COLUMN_VALUE + 1);
		tempCellBounds.height = this.getHeight() / (Constants.MAX_ROW_VALUE + 1);
		
		boolean isWhiteCell = true;
		
		if(Game.getInstance().getPlayerOnTurn().getTeam().equals(Team.White))
		{	
			for(int row = 0; row < figures.length; row++)
			{
				tempCellBounds.x = 0;
				for(int column = 0; column < figures[row].length; column++)
				{
					tempCell = createCellView(figures[row][column], new Coordinates(row, column),
							  				  tempCellBounds, isWhiteCell);
					
					this.add(tempCell);
					tempCellBounds.x += tempCellBounds.width;
					isWhiteCell = !isWhiteCell;
				}
				tempCellBounds.y += tempCellBounds.height;
				isWhiteCell = !isWhiteCell;
			}
		}
		else
		{
			isWhiteCell = false;
			
			for(int row = Constants.MAX_ROW_VALUE; row >= Constants.MIN_ROW_VALUE; row--)
			{
				tempCellBounds.x = 0;
				for(int column = Constants.MAX_COLUMN_VALUE; column >= Constants.MIN_COLUMN_VALUE; column--)
				{
					tempCell = createCellView(figures[row][column], new Coordinates(row, column),
											  tempCellBounds, isWhiteCell);
					
					this.add(tempCell);
					tempCellBounds.x += tempCellBounds.width;
					isWhiteCell = !isWhiteCell;
				}
				tempCellBounds.y += tempCellBounds.height;
				isWhiteCell = !isWhiteCell;
			}
		}
		
		for(var comp : this.getComponents())
		{
			comp.repaint();
		}
	}
	
	private CellView createCellView(Figure figure, Coordinates coordinates, Rectangle bounds, boolean isWhiteCell)
	{
		CellView result = new CellView(figure, coordinates);
		result.setBounds(bounds);
		result.setLayout(null);
		
		//Example colors
		if(isWhiteCell)
		{
			result.setBackground(new Color(160, 143, 71));
		}
		else
		{
			result.setBackground(new Color(1, 113, 13));
		}
		
		return result;
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