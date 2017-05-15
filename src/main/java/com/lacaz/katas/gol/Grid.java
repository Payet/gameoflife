package com.lacaz.katas.gol;

import java.util.ArrayList;
import java.util.List;


public class Grid
{
	private Cell matrix[][];

	public Grid(int rows, int columns)
	{
		matrix = new Cell[rows][columns];
		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				matrix[row][column] = new Cell();
			}
		}
	}

	public Cell getCell(int row, int column)
	{
		return matrix[row][column];
	}


	public int getNumberRows(){
		return matrix.length;
	}

	public int getNumberColumns(){
		return matrix[0].length;
	}

	public List<Cell> getNeighbourCells(int row, int column)
	{
		List<Cell> cells = new ArrayList<Cell>();
		if (row > 0){
			cells.add(getCell(row - 1, column));

			if (column > 0){
				cells.add(getCell(row - 1, column - 1));
			}

			if (column < (matrix[0].length-1)){
				cells.add(getCell(row - 1, column + 1));
			}
		}

		if (column > 0){
			cells.add(getCell(row, column - 1));
		}

		if (column < (matrix[0].length-1)){
			cells.add(getCell(row, column + 1));
		}

		if (row < (matrix.length - 1)){
			cells.add(getCell(row + 1, column));

			if (column > 0){
				cells.add(getCell(row + 1, column - 1));
			}

			if (column < (matrix[0].length-1)){
				cells.add(getCell(row + 1, column + 1));
			}
		}
		return  cells;
	}


	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(matrix.length + " " + matrix[0].length);
		sb.append("\n");
		for (int row = 0; row < matrix.length; row++){
			for (int column = 0; column < matrix[0].length; column++){
				sb.append(getCell(row, column));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
