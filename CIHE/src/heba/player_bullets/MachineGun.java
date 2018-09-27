package heba.player_bullets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import heba.display.Display;
import heba.game_screen.BasicBlocks;
import heba.random.Bullet_Value;

public class MachineGun extends PlayerWeaponType
{
	
	private BufferedImage pSprite;
	private Rectangle bullet;
	private final double speed = 2.5d;
	
	public MachineGun(double xPos, double yPos, int width,int height)
	{
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setWidth(width);
		this.setHeight(height);
		
		this.bullet = new Rectangle((int) getxPos(),(int) getyPos(), getWidth(), getHeight());
		
		
			try
			{
				URL url = this.getClass().getResource("/heba/images/bullet.png");
				pSprite = ImageIO.read(url);
			}
			catch(IOException e){};
		
		
	}
	
	@Override
	public void draw(Graphics2D g) 
	{
		if(bullet == null)
			return;
		g.drawImage(pSprite,(int) xPos,(int) yPos, width, height, null);
		//g.setColor(Color.GREEN);
		//g.fill(bullet);
	}

	@Override
	public void update(double delta, BasicBlocks blocks) 
	{
		if(bullet == null)
			return;
		
		this.setyPos(getyPos() - (delta * speed));
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
	public boolean destory() 
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
	
	public int bv() 
	{
		int max  = 10;
		int min  = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
