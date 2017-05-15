package com.lacaz.katas.gol;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestEngineDisplay
{
	private Engine engine;
	private Grid grid;

	@Before
	public void setUp() throws Exception
	{
		grid = new Grid(4, 8);

		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new AliveCellWithLessThanTwoLiveNeighbourRule());
		rules.add(new AliveCellWithMoreThanThreeLiveNeighbourRule());
		rules.add(new AliveCellWithTwoOrThreeLiveNeighbourRule());
		rules.add(new ADeadCellWithThreeLiveNeighbourRule());
		engine = new Engine(rules);

	}

	@Test
	public void display()
	{

		grid.getCell(1, 4).setAlive(true);
		grid.getCell(2, 3).setAlive(true);
		grid.getCell(2, 4).setAlive(true);

		Grid nextGenerationGrid = engine.calculateNextGeneration(grid);
		Assert.assertEquals("4 8\n" + "........\n" + "...**...\n" + "...**...\n" + "........\n", nextGenerationGrid.toString());

	}
}