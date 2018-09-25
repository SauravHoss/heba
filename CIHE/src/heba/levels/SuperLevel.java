package heba.levels;

import java.awt.Graphics2D;
import heba.game_screen.BasicBlocks;

public interface SuperLevel 
{
	void draw(Graphics2D g);
	void update(double delta, BasicBlocks blocks);
	void hasDirectionChange(double delta);
	void changeDirectionAllEnemys(double delta);
	
	boolean isGameOver();
	void destroy();
	void reset();
	
}
