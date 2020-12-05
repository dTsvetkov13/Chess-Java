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
	public static void drawfigure(FigureType figure , Graphics graphics , Team team)
	{
		Rectangle bounds = new Rectangle(10 , 10 , 20 ,20);
		
		switch(figure)
		{
			case Bishop:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.BLACK);
					graphics.fillPolygon(new int [] {20 , 30 , 40} , new int[] {40 , 20 , 40}, 3);
					drawBishop(graphics);
					break;
				}
				else
				{
					graphics.setColor(Color.white);
					graphics.fillPolygon(new int [] {20 , 30 , 40} , new int[] {40 , 20 , 40}, 3);
					drawBishop(graphics);
					break;
				}
			
			}
			case Knight:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.black);
					graphics.fillRect(5, 5, 30, 10);
					graphics.fillRect(5, 5, 10, 40);
					drawKnight(graphics);
					break;
				}
				else
				{
					graphics.setColor(Color.white);
					graphics.fillRect(5, 5, 30, 10);
					graphics.fillRect(5, 5, 10, 40);
					drawKnight(graphics);
					break;
				}
			}	
			case Queen:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.black);
					graphics.fillOval(10, 10, 38, 38);
					drawQueen(graphics);
					break;
				}
				else
				{
					graphics.setColor(Color.white);
					graphics.fillOval(10, 10, 38, 38);
					drawQueen(graphics);
					break;
				}
			}
			case King:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.BLACK);
					graphics.fillRect(5, 17, 30, 10);
					graphics.fillRect(15, 10, 10, 37);
					drawKing(graphics);
					break;
				}
				else
				{
					graphics.setColor(Color.white);
					graphics.fillRect(5, 17, 30, 10);
					graphics.fillRect(15, 10, 10, 37);
					drawKing(graphics);
					break;
				}
			}
			case Pawn:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.black);
					graphics.fillRect(10 , 10 , 20 ,20);
					drawPawn(graphics , bounds);
					break;
				}
				else
				{
					graphics.setColor(Color.white);
					graphics.fillRect(10 , 10 , 20 ,20);
					drawPawn(graphics , bounds);
					break;
				}
			}
			case Rook:
			{
				if(team == Team.Black)
				{
					graphics.setColor(Color.BLACK);
					graphics.fillRect(20, 20, 40, 40);
					drawRook(graphics);
					break;
				}
				else
				{
					graphics.setColor(Color.WHITE);
					graphics.fillRect(20, 20, 40, 40);
					drawRook(graphics);
					break;
				}
			}
			
		}
	}
	
	private static void drawBishop (Graphics graphics)
	{
		graphics.drawPolygon(new int [] {20 , 30 , 40} , new int[] {40 , 20 , 40}, 3); //magic numbers to be changed
	}
	
	private static void drawKnight(Graphics graphics)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(5, 5, 30, 10);  //15 , 5 ,30 ,10 
		Rectangle2D.Double rect2 = new Rectangle2D.Double(5, 5, 10, 40);
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
	}
	
	private static void drawQueen(Graphics graphics)
	{
		graphics.drawOval(10, 10, 38, 38); 			//magic numbers to be changed
	}
	
	private static void drawKing(Graphics graphics)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		//graphics2D.drawLine(10, 10, 10, 50);
		//graphics2D.drawLine(20, 10, 20, 100);
		//graphics2D.drawLine(10, 10, 20, 10);
		//graphics2D.drawLine(20, 49, 10, 49);
		//graphics2D.drawLine(40, 30, 10, 30);
		//graphics2D.drawLine(arg0, arg1, arg2, arg3);
		//graphics2D.drawLine(-5, 10, 30, 20);	
		Rectangle2D.Double rect = new Rectangle2D.Double(5, 17, 30, 10);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(15, 10, 10, 37);
		
		graphics2D.draw(rect);
		graphics2D.draw(rect2);
	}
	
	private static void drawPawn(Graphics graphics , Rectangle bounds)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		Rectangle2D.Double rect = new Rectangle2D.Double(bounds.getX(), bounds.getY(), 
														 bounds.getWidth(), bounds.getHeight()); //magic numbers to be changed
		graphics2D.draw(rect);
	}
	
	private static void drawRook(Graphics graphics)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		Rectangle2D.Double rect = new Rectangle2D.Double(20, 20, 40, 40);  //magic numbers to be changed
		graphics2D.draw(rect);
	}
}
