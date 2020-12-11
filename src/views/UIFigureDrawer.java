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
	
	private static void drawBishop (Graphics graphics, Rectangle bounds)
	{
		var x = bounds.y + bounds.height;
		var y = bounds.x + bounds.width;
		
		
		graphics.drawPolygon(new int [] {20, 30, 40}, new int[] {40, 20, 40}, 3); //magic numbers to be changed
		graphics.fillPolygon(new int [] {20, 30, 40}, new int[] {40, 20, 40}, 3);	
	}
	
	private static void drawKnight(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());  //5 , 5 ,30 ,10 
		Rectangle2D.Double rect2 = new Rectangle2D.Double(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()); //5, 5, 10, 40
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
		graphics2D.fill(rect);
		graphics2D.fill(rect2);
	}
	
	private static void drawQueen(Graphics graphics, Rectangle bounds)
	{
		Graphics2D g = (Graphics2D) graphics;
		graphics.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
		graphics.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);//10, 10, 38, 38
	}
	
	private static void drawKing(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		//graphics2D.drawLine(10, 10, 10, 50);
		//graphics2D.drawLine(20, 10, 20, 100);
		//graphics2D.drawLine(10, 10, 20, 10);
		//graphics2D.drawLine(20, 49, 10, 49);
		//graphics2D.drawLine(40, 30, 10, 30);
		//graphics2D.drawLine(arg0, arg1, arg2, arg3);
		//graphics2D.drawLine(-5, 10, 30, 20);	
		Rectangle2D.Double rect = new Rectangle2D.Double(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()); //5, 17, 30, 10
		Rectangle2D.Double rect2 = new Rectangle2D.Double(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()); //15, 10, 10, 37
		
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
		graphics2D.fill(rect);
		graphics2D.fill(rect2);
	}
	
	private static void drawPawn(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(bounds.getX(), bounds.getY(), 
														 bounds.getWidth(), bounds.getHeight()); 
		graphics2D.draw(rect);
		graphics2D.fill(rect);
	}
	
	private static void drawRook(Graphics graphics, Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()); 
		graphics2D.draw(rect);
		graphics2D.fill(rect);
	}
}
