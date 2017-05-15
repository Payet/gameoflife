package com.lacaz.katas.gol;

import java.util.List;


public abstract class Rule
{
	public abstract boolean doesRuleApply(Cell cell, List<Cell> neighbours);
	public abstract boolean getNextGenerationCell(Cell cell, List<Cell> neighbours);
}
