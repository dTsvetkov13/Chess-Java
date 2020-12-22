package views.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class Screen extends JPanel
{
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 500;
	public static final Color BACKGROUND = new Color(238,232,170);
	
	private String name;
	
	public Screen(String name)
	{
		this.name = name;
		this.setBackground(BACKGROUND);
	}
	
	public String getName()
	{
		return this.name;
	}
	/*
	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		super.paintComponent(g);
		
	}*/
}
