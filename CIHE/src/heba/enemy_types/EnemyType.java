package heba.enemy_types;

import java.awt.Graphics2D;
import java.util.ArrayList;

import heba.game_screen.BasicBlocks;
import heba.game_screen.Player;

public interface EnemyType 
{
	void draw(Graphics2D g);
	void update(double delta, Player player, BasicBlocks blocks);
	void changeDirection(double delta);
	
	boolean deathScene();
	boolean collide(int i, Player player, BasicBlocks blocks, ArrayList<EnemyType> enemies);
	boolean isOutofBounds();
	
}
