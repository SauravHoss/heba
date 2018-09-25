package heba.game_screen;

import java.awt.Graphics2D;
import java.util.ArrayList;

import heba.player_bullets.MachineGun;
import heba.player_bullets.PlayerWeaponType;
import heba.timer.Timer;

public class PlayerWeapons 
{
	private Timer timer;
	public ArrayList<PlayerWeaponType> weapons = new ArrayList<PlayerWeaponType>();
	
	public PlayerWeapons() 
	{
		timer = new Timer();
	}
	
	
	public void draw(Graphics2D g) 
	{
		for(int i = 0; i < weapons.size(); i++) 
		{
			weapons.get(i).draw(g);
		}
	}
	
	public void update(double delta, BasicBlocks blocks) 
	{
		for(int i = 0; i < weapons.size(); i++) 
		{
			weapons.get(i).update(delta, blocks);
			if(weapons.get(i).destroy()) 
				weapons.remove(i);
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height) 
	{
		if(timer.timerEvent(250))
			weapons.add(new MachineGun(xPos + 22, yPos + 15, width, height));
	}
	
}
