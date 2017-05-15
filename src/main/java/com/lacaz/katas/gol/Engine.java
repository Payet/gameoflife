package com.lacaz.katas.gol;

import java.util.List;


public class Engine
{
	private List<Rule> rules;

	public Engine(List<Rule> rules)
	{
		this.rules = rules;
	}

	public Grid calculateNextGeneration(Grid grid)
	{
		Grid nextGenerationGrid = new Grid(grid.getNumberRows(), grid.getNumberColumns());

		for (int row = 0;row < grid.getNumberRows(); row++)
		{
			for (int column = 0; column < grid.getNumberColumns(); column++)
			{
				Cell cell = grid.getCell(row, column);
				List<Cell> neighbourCells = grid.getNeighbourCells(row, column);

				for (Rule rule : rules)
				{
					if (rule.doesRuleApply(cell, neighbourCells)){
						nextGenerationGrid.getCell(row, column).setAlive(rule.getNextGenerationCell(cell, neighbourCells));
					}
				}
			}
		}
		return nextGenerationGrid;
	}
}
