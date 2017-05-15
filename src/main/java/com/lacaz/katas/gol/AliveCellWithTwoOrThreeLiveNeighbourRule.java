package com.lacaz.katas.gol;

import java.util.List;


public class AliveCellWithTwoOrThreeLiveNeighbourRule extends Rule
{
	public boolean doesRuleApply(Cell cell, List<Cell> neighbours)
	{

		long numberOfLivingNeighbours = neighbours.stream().filter(neighbour -> (neighbour.isAlive() == true)).count();
		if (cell.isAlive() && (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3)){
			return true;
		}
		return false;
	}

	public boolean getNextGenerationCell(Cell cell, List<Cell> neighbours)
	{
		return true;
	}
}
