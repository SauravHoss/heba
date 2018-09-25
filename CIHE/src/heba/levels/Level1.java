package heba.levels;

import java.awt.Graphics2D;
import java.util.ArrayList;

import heba.enemy_types.EnemyType;
import heba.enemy_types.EnemyTypeBasic;
import heba.game_screen.BasicBlocks;
import heba.game_screen.Player;

public class Level1 implements SuperLevel
{

	private Player player;
	private ArrayList<EnemyType> enemies= new ArrayList<EnemyType>();
	
	public Level1(Player player) 
	{
		this.player = player;
		
		for(int i = 0; i < 5; i++) 
		{
			for(int j = 0; j < 10; j++) 
			{
				EnemyType e = new EnemyTypeBasic(150 + (j  *  40), 25 + (i * 40), 25, 25, "/heba/images/hebachickyexp.png"); // fix the spacing
				enemies.add(e);
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) 
	{
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++) 
		{
			enemies.get(i).draw(g);
		}
	}

	@Override
	public void update(double delta, BasicBlocks blocks) 
	{
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++) 
		{
			enemies.get(i).update(delta, player, blocks);
		}
		
		for(int i = 0; i < enemies.size(); i++) 
		{
			enemies.get(i).collide(i, player, blocks, enemies);
		}
		hasDirectionChange(delta);
	}

	@Override
	public void hasDirectionChange(double delta) 
	{
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.size(); i++) 
		{
			if(enemies.get(i).isOutofBounds())
			{
				changeDirectionAllEnemys(delta);
			}
				
		}
	}

	@Override
	public void changeDirectionAllEnemys(double delta) 
	{		
		for(int i = 0; i < enemies.size(); i++) 
		{
			enemies.get(i).changeDirection(delta);
		}
		
	}

	@Override
	public boolean isGameOver() 
	{
		return false;
	}

	@Override
	public void destroy() 
	{
		
	}

	@Override
	public void reset() 
	{
		
	}

}
