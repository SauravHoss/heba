package heba.game_screen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BasicBlocks 
{
	public ArrayList<Rectangle> wall = new ArrayList<Rectangle>();
	
	public BasicBlocks() 
	{
		basicBlocks(75, 450);
		basicBlocks(275, 450);
		basicBlocks(475, 450);
		basicBlocks(675, 450);
	}
	
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.GREEN);
		for(int i = 0; i < wall.size(); i++) 
		{
			g.fill(wall.get(i));
		}
	}
	
	public void basicBlocks(int xPos, int yPos) 
	{
		int wallwidth = 3;
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < 13; i++) 
		{
			if((14 + (i * 2) + wallwidth < 22 + wallwidth)) 
			{
				row(14 + (i * 2) + wallwidth, xPos - (i * 3), yPos + (i * 3));
				x = (i * 3) + 3;
			}
			else 
			{
				row(22 + wallwidth, xPos - x, yPos + (i * 3));
				y = (i * 3);
			}
			
		}
		
		//lh
		for(int i = 0; i < 5; i++) 
		{
			row(8 + wallwidth - i, xPos - x, (yPos + y) + (i * 3));
		}
		
		//rh
		for(int i = 0; i < 5; i++) 
		{
			row(8 + wallwidth - i, (xPos - x) + (14 * 3) + (i * 3), (yPos + y) + (i * 3));
		}
		
	}
	
	
	
	public void row(int rows, int xPos, int yPos) 
	{
		for(int i = 0; i < rows; i++) 
		{
			Rectangle brick = new Rectangle(xPos + (i * 3), yPos, 3, 3);
			wall.add(brick);
		}
	}
	
	public void reset() 
	{
		wall.clear();
		
		basicBlocks(75, 450);
		basicBlocks(275, 450);
		basicBlocks(475, 450);
		basicBlocks(675, 450);
	}
}
