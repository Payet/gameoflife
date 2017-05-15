package com.lacaz.katas.gol;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestEngineRules
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
	public void calculateNextGeneration_When_livingCellHasLessThan2LiveNeighbours_Then_dies(){

		grid.getCell(0,0).setAlive(true);

		Grid nextGenerationGrid = engine.calculateNextGeneration(grid);

		Assert.assertEquals(false, nextGenerationGrid.getCell(0,1).isAlive());

	}

	@Test
	public void calculateNextGeneration_When_livingCellHasMoreThan3LiveNeighbours_Then_dies(){
		grid.getCell(1,1).setAlive(true);
		grid.getCell(0,0).setAlive(true);
		grid.getCell(0,1).setAlive(true);
		grid.getCell(1,0).setAlive(true);
		grid.getCell(2,0).setAlive(true);
		grid.getCell(0,2).setAlive(true);


		Grid nextGenerationGrid = engine.calculateNextGeneration(grid);

		Assert.assertEquals(false, nextGenerationGrid.getCell(1,1).isAlive());
	}



	@Test
	public void calculateNextGeneration_When_livingCellHasTwoOrThreeLiveNeighbours_Then_lives(){
		grid.getCell(0,0).setAlive(true);
		grid.getCell(0,1).setAlive(true);
		grid.getCell(1,1).setAlive(true);
		grid.getCell(2,0).setAlive(true);


		Grid nextGenerationGrid = engine.calculateNextGeneration(grid);

		Assert.assertEquals(true, nextGenerationGrid.getCell(1,1).isAlive());

	}

	@Test
	public void calculateNextGeneration_When_deadCellHasThreeLiveNeighbours_Then_lives(){
		grid.getCell(0,0).setAlive(true);
		grid.getCell(0,1).setAlive(true);
		grid.getCell(0,2).setAlive(true);

		grid.getCell(1,1).setAlive(false);


		Grid nextGenerationGrid = engine.calculateNextGeneration(grid);

		Assert.assertEquals(true, nextGenerationGrid.getCell(1,1).isAlive());

	}
}
