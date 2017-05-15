package com.lacaz.katas.gol;

import java.util.ArrayList;
import java.util.List;


public class TestMain
{

	public static void main(String[] args){

		Grid grid = new Grid(4, 8);

		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new AliveCellWithLessThanTwoLiveNeighbourRule());
		rules.add(new AliveCellWithMoreThanThreeLiveNeighbourRule());
		rules.add(new AliveCellWithTwoOrThreeLiveNeighbourRule());
		rules.add(new ADeadCellWithThreeLiveNeighbourRule());
		Engine engine = new Engine(rules);

		grid.getCell(1, 2).setAlive(true);
		grid.getCell(2, 2).setAlive(true);
		grid.getCell(3, 2).setAlive(true);

		for (int i=0;i<10;i++){
			Grid newGrid = engine.calculateNextGeneration(grid);
			grid = newGrid;
			System.out.println(grid.toString());
			try
			{
				Thread.sleep(1000);
				Runtime.getRuntime().exec("clear");
				System.out.print("\033[H\033[2J");
				System.out.flush();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
