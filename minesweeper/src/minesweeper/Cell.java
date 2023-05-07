package minesweeper;

public class Cell {
	
	
	public boolean isMine;
	public boolean isHidden;
	public int adjacentMines;
	public char display;
	
	
	
	public Cell() { 
		isMine = false;
		isHidden = true;
		adjacentMines = 0;
		display = '?';
	}

	
	
	public char getDisplay() {
		return display;
	}



	public void setDisplay(char display) {
		this.display = display;
	}



	public boolean isMine() {
		return isMine;
	}



	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}



	public boolean isHidden() {
		return isHidden;
	}



	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}



	public int getAdjacentMines() {
		return adjacentMines;
	}



	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}

}
