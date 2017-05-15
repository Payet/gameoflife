package com.lacaz.katas.gol;

public class Cell
{
	private boolean isAlive;

	public boolean isAlive()
	{
		return isAlive;
	}

	public void setAlive(boolean alive)
	{
		isAlive = alive;
	}

	public String toString(){
		return isAlive() ? "*" : ".";
	}
}
