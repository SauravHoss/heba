package heba.game_screen;

import java.awt.Canvas;
import java.awt.Graphics2D;

import heba.display.Display;
import heba.levels.Level1;
import heba.state.SuperStateMachine;

public class GameScreen implements SuperStateMachine
{
	private Player player;
	private BasicBlocks blocks;
	private Level1 level;
	
	public GameScreen() 
	{
		blocks = new BasicBlocks(); //shields
		player = new Player(Display.WIDTH/2-50, Display.HEIGHT-75, 50, 50, blocks);
		level = new Level1(player);
	}
	
	@Override
	public void update(double delta) 
	{
		player.update(delta);
		level.update(delta, blocks);
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		player.draw(g);
		blocks.draw(g);
		level.draw(g);
	}

	@Override
	public void init(Canvas canvas) 
	{
		canvas.addKeyListener(player);
	}

}
