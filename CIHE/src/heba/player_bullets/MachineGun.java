package heba.player_bullets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import heba.display.Display;
import heba.game_screen.BasicBlocks;

public class MachineGun extends PlayerWeaponType
{

	private Rectangle bullet;
	private final double speed = 2.5d;
	private BufferedImage bSprite;

	
	public MachineGun(double xPos, double yPos, int width, int height) 
	{
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setWidth(width);
		this.setHeight(height);
		
		this.bullet = new Rectangle((int) getxPos(),(int) getyPos(), getWidth(), getHeight());
		//add image here with try and catch
		
		try 
		{
			URL url = this.getClass().getResource("/heba/images/hebachicken.png");
			bSprite = ImageIO.read(url);
		}catch(IOException e){};
		
	}
	
	@Override
	public void draw(Graphics2D g) 
	{
		if(bullet == null)
			return;
		
		g.drawImage(bSprite,(int) xPos,(int) yPos, width, height, null);
		//would comment off if pic and use draw image
		//g.setColor(Color.GREEN);
		//g.fill(bullet);
	}

	@Override
	public void update(double delta, BasicBlocks blocks) 
	{
		if(bullet == null)
			return;
		
		this.setyPos(getyPos()- (delta * speed));
		bullet.y = (int) this.getyPos();
		wallCollide(blocks);
		isOutofBounds();
		
	}

	@Override
	public boolean collisionRect(Rectangle rect) 
	{
		if(this.bullet == null)
			return false;
		if(bullet.intersects(rect))
		{
			this.bullet = null;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean collisionPoly(Polygon poly) 
	{
		return false;
	}

	@Override
	public boolean destroy() 
	{
		if(bullet == null)
			return true;
		
		return false;
	}

	@Override
	protected void wallCollide(BasicBlocks blocks) 
	{
		for(int i = 0; i < blocks.wall.size(); i++) 
		{
			if(bullet.intersects(blocks.wall.get(i))) 
			{
				blocks.wall.remove(i);
				bullet = null;
				return;

			}
		}
	}

	@Override
	protected void isOutofBounds() 
	{
		if(this.bullet == null)
			return;
		if(bullet.y < 0 || bullet.y > Display.HEIGHT || bullet.x < 0 || bullet.x > Display.WIDTH)
		{
			bullet = null;
		}
	}

}
