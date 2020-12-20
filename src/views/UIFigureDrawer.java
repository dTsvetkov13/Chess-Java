package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import enums.FigureType;
import enums.Team;

public class UIFigureDrawer
{	
	public static void drawfigure(FigureType figure, Graphics graphics, Team team, Rectangle bounds)
	{
		if(team == Team.Black)
		{
			graphics.setColor(Color.black);
		}
		else
		{
			graphics.setColor(Color.white);
		}
		
		if(bounds != null)
		{
			switch(figure)
			{
				case Bishop:
				{
					drawBishop(graphics, bounds);
					break;
				}
				case Knight:
				{
					drawKnight(graphics, bounds);
					break;
				}	
				case Queen:
				{
					drawQueen(graphics, bounds);
					break;
				}
				case King:
				{
					drawKing(graphics, bounds);
					break;
				}
				case Pawn:
				{
					drawPawn(graphics, bounds);
					break;	
				}
				case Rook:
				{
					drawRook(graphics, bounds);
					break;
				}
				
			}
		}
	}
	
	private static void drawBishop (Graphics graphics, Rectangle bounds)
	{
		graphics.drawPolygon(new int[] {0, bounds.width, bounds.width / 2}, 
							 new int[] {bounds.height, bounds.height, 0}, 3);
		
		graphics.fillPolygon(new int[] {0, bounds.width, bounds.width / 2}, 
							 new int[] {bounds.height, bounds.height, 0}, 3);
	}
	
	private static void drawKnight(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0,bounds.width, bounds.height * 0.3); 
		Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, bounds.width * 0.3, bounds.height * 2); 
		
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
		graphics2D.fill(rect);
		graphics2D.fill(rect2);
	}
	
	private static void drawQueen(Graphics graphics, Rectangle bounds)
	{
		Graphics2D g = (Graphics2D) graphics;
		int greaterValue = Math.max(bounds.width, bounds.height);
		int smallerValue = Math.min(bounds.width, bounds.height);
		
		graphics.drawOval((greaterValue - smallerValue) / 2, 0, smallerValue, smallerValue); 
		graphics.fillOval((greaterValue - smallerValue) / 2, 0, smallerValue, smallerValue);	
	}
	
	private static void drawKing(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0.2 * bounds.height, bounds.width, bounds.height * 0.15); 
		Rectangle2D.Double rect2 = new Rectangle2D.Double((bounds.width - 0.20 * bounds.width) / 2, 0, 
														   bounds.width * 0.20, bounds.height); 
		
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
		graphics2D.fill(rect);
		graphics2D.fill(rect2);
	}
	
	private static void drawPawn(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, bounds.width * 0.5, bounds.height * 0.5); 
		
		graphics2D.draw(rect);
		graphics2D.fill(rect);
	}
	
	private static void drawRook(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, bounds.width, bounds.height);
		
		graphics2D.draw(rect);
		graphics2D.fill(rect);
	}
}
