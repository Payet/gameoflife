package com.lacaz.katas.gol;

import java.util.List;


public class AliveCellWithLessThanTwoLiveNeighbourRule extends Rule
{
	public boolean doesRuleApply(Cell cell, List<Cell> neighbours)
	{

		return cell.isAlive() && neighbours.stream().filter(neighbour -> (neighbour.isAlive() == true)).count() < 2;
	}

	public boolean getNextGenerationCell(Cell cell, List<Cell> neighbours)
	{
		return false;
	}
}
