package heba.random;

import java.util.Random;

public class Bullet_Value 
{
	public int ns;

	public int getNs() 
	{
		return ns;
	}

	public void setNs(int ns) 
	{
		this.ns = ns;
	}
	
	public void bv() 
	{
		int max  = 10;
		int min  = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		setNs(randomNum);
	}
	
}
