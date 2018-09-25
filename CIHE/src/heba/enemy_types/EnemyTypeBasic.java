package heba.enemy_types;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import heba.display.Display;
import heba.game_screen.BasicBlocks;
import heba.game_screen.Player;
import heba.sprite.SpriteAnimation;

public class EnemyTypeBasic implements EnemyType
{
	private double speed = 1.0d;
	
	private Rectangle rect;
	private SpriteAnimation enemySprite;
	
	
	public EnemyTypeBasic(double xPos, double yPos, int width, int height, String imgPath) 
	{
		enemySprite = new SpriteAnimation(xPos, yPos, width, height ,300);
		
		try 
		{
			URL url = this.getClass().getResource(imgPath);
			BufferedImage pSprite = ImageIO.read(url);
			//stc
			for(int i = 0; i < 2; i++) 
			{
				enemySprite.addSprite(pSprite, 0 + (i * 51), 0, 51, 64); //all gonna be changed to sigma with pixe width and height
			}
			
		}catch(IOException e){}; 
		
		this.setRect(new Rectangle((int) enemySprite.getxPos(), (int) enemySprite.getyPos(), width, height));
		enemySprite.setLoop(true);
	}
	
	
	@Override
	public void draw(Graphics2D g) 
	{
		enemySprite.draw(g);
	}

	@Override
	public void update(double delta, Player player, BasicBlocks blocks) 
	{
		enemySprite.update(delta);	
		
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
	}

	@Override
	public void changeDirection(double delta) 
	{
		speed *= -1.05d;
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		
		enemySprite.setyPos(enemySprite.getyPos() + (delta * 5)); //moves down might take out
		this.getRect().y = (int) enemySprite.getyPos();
	}

	@Override
	public boolean deathScene() 
	{
		return false;
	}

	@Override
	public boolean collide(int i, Player player, BasicBlocks blocks, ArrayList<EnemyType> enemys) 
	{
		return false;
	}

	@Override
	public boolean isOutofBounds() 
	{
		if(rect.x > 0 && rect.x < Display.WIDTH - rect.width)
			return false;
		return true;
	}


	public Rectangle getRect() 
	{
		return rect;
	}


	public void setRect(Rectangle rect) 
	{
		this.rect = rect;
	}

}
