package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import common.Constants;
import common.Validator;
import enums.Team;
import models.Board;
import models.Coordinates;
import models.GameInfo;
import models.figures.Figure;

public class BoardView extends JPanel
{
	private Board board;
	private CellView[][] cellViews;
	
	public BoardView()
	{
		board = Board.getInstance();
		
		Figure[][] boardFigures = board.getAllFigures();

		cellViews = new CellView[boardFigures.length][];
		
		for(int row = 0; row < boardFigures.length; row++)
		{
			cellViews[row] = new CellView[boardFigures[row].length];
			
			for(int column = 0; column < cellViews[row].length; column++)
			{
				cellViews[row][column] = new CellView(null, new Coordinates(row, column));
				cellViews[row][column].setLayout(null);
				cellViews[row][column].setVisible(true);
				this.add(cellViews[row][column]);
			}
		}
		
		this.setBoundsToAllCells();
	}
	
	private void setBoundsToAllCells()
	{
		Rectangle tempCellBounds = new Rectangle(0, 0);
		tempCellBounds.width = this.getWidth() / (Constants.MAX_COLUMN_VALUE + 1);
		tempCellBounds.height = this.getHeight() / (Constants.MAX_ROW_VALUE + 1);
		
		for(int row = 0; row < cellViews.length; row++)
		{
			tempCellBounds.x = 0;
			for(int column = 0; column < cellViews[row].length; column++)
			{
				cellViews[row][column].setBounds(tempCellBounds);
				tempCellBounds.x += tempCellBounds.width;
			}
			tempCellBounds.y += tempCellBounds.height;
		}
	}
	
	private void setCellViewColor(CellView cellView, boolean isWhiteCell)
	{
		if(isWhiteCell)
		{
			cellView.setBackground(new Color(160, 143, 71));
		}
		else
		{
			cellView.setBackground(new Color(1, 113, 13));
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		System.out.println("Board Paint");
		super.paintComponent(g);
		Figure[][] figures = board.getAllFigures();
		
		boolean isWhiteCell = true;
		
		if(GameInfo.getInstance().getPlayerOnTurn().getTeam().equals(Team.White))
		{
			for(int row = 0; row < figures.length; row++)
			{
				for(int column = 0; column < figures[row].length; column++)
				{
					cellViews[row][column].setFigure(figures[row][column]);
					cellViews[row][column].setCoordinates(new Coordinates(row, column));
					this.setCellViewColor(cellViews[row][column], isWhiteCell);
					isWhiteCell = !isWhiteCell;
				}
				isWhiteCell = !isWhiteCell;
			}
		}
		else
		{
			isWhiteCell = false;
			
			for(int row = Constants.MAX_ROW_VALUE; row >= Constants.MIN_ROW_VALUE; row--)
			{
				for(int column = Constants.MAX_COLUMN_VALUE; column >= Constants.MIN_COLUMN_VALUE; column--)
				{
					cellViews[Constants.MAX_ROW_VALUE - row][Constants.MAX_COLUMN_VALUE - column]
							 .setFigure(figures[row][column]);
					cellViews[row][column].setCoordinates(new Coordinates(Constants.MAX_ROW_VALUE - row, Constants.MAX_COLUMN_VALUE - column));
					this.setCellViewColor(cellViews[Constants.MAX_ROW_VALUE - row][Constants.MAX_COLUMN_VALUE - column],
										  isWhiteCell);
					isWhiteCell = !isWhiteCell;
				}
				isWhiteCell = !isWhiteCell;
			}
		}
		
		//Check whether the size of the BoardView is changed 
		if(!Validator.isNull(this.cellViews[0][0]))
		{
			Rectangle cellViewBounds = this.cellViews[0][0].getBounds();
				
			if(cellViewBounds.width != (this.getWidth() / (Constants.MAX_COLUMN_VALUE + 1))
				|| cellViewBounds.height != (this.getHeight() / (Constants.MAX_ROW_VALUE + 1)))
			{
				this.setBoundsToAllCells();
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