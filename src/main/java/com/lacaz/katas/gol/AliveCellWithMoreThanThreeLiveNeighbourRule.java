package com.lacaz.katas.gol;

import java.util.List;


public class AliveCellWithMoreThanThreeLiveNeighbourRule extends Rule
{

	public boolean doesRuleApply(Cell cell, List<Cell> neighbours)
	{

		return cell.isAlive() && neighbours.stream().filter(neighbour -> (neighbour.isAlive() == true)).count() > 3;
	}

	public boolean getNextGenerationCell(Cell cell, List<Cell> neighbours)
	{
		return false;
	}
}
