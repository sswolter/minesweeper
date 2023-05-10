package minesweeper;

import java.util.Random;





public class Board {
	
	public int numberOfRows = 10;
	public int numberOfColumns = 10;
	public int numberOfMines = 10;
	public int amountToWin = numberOfRows * numberOfColumns - numberOfMines;
	
	private Cell[][] cells;
	
	
	public Board() {
		
		cells = new Cell[numberOfRows][numberOfColumns];
		
        for(int i = 0; i < numberOfRows; i++) { 
            for(int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = new Cell();
            }
        }
        createMines();
	}
	
	
	public void createMines() {
		
    	int minesPlaced = 0;
  
    	Random random = new Random(); 
 
    	while (minesPlaced < numberOfMines) {
    	int row = random.nextInt(numberOfRows);
    	int col = random.nextInt(numberOfColumns);
        if (!cells[row][col].isMine()) {
            cells[row][col].setMine(true);
            minesPlaced++;
        	}
    	}
    }
	
	
	public void getAdjMineNumber(int row, int col) {
	    int mines = 0;

	    for (int i = row - 1; i <= row + 1; i++) {
	        for (int j = col - 1; j <= col + 1; j++) {
	            if (i >= 0 && i < numberOfRows && j >= 0 && j < numberOfColumns) { 
	                if (cells[i][j].isMine()) {
	                    mines++;
	                }
	            }
	        }
	    }
	    cells[row][col].setAdjacentMines(mines);
	}
	
	
	public void unhide(int row, int col) {
		Cell inputSquare = cells[row][col];
		
		if(inputSquare.isHidden()) {
			inputSquare.setHidden(false);
		}
	}
	
	public char displayValue(int row, int col) {
	    Cell inputSquare = cells[row][col];
	    
	    if (inputSquare.isHidden()) {
	        return '?';
	    } else {
	        if (inputSquare.isMine()) {
	            return '*';
	        } else {
	            return (char)(inputSquare.getAdjacentMines() + '0');
	        }
	    }
	}
	
	
	public boolean end(int row, int col) { 
	    Cell inputSquare = cells[row][col];
	    
	    if(inputSquare.isMine()) {
	    	return true;
	    }
		return false;

	}
	

	public int getAmountToWin() {
		return amountToWin;
	}


	public void setAmountToWin() {
		this.amountToWin = this.amountToWin - 1;
	}


	
	public void printGrid() {
        System.out.println();
	    System.out.print("      ");
	    for (int j = 0; j < numberOfColumns; j++) {
	        System.out.print(j + "   ");
	    }
	    System.out.println();
	    
	    
	    for (int i = 0; i < numberOfRows; i++) {
	    	System.out.print(" " + (i) + "  | ");
	        for (int j = 0; j < numberOfColumns; j++) {
	            getAdjMineNumber(i, j);
	            System.out.print(displayValue(i, j) + " | ");
	        }
	        System.out.println();

	    }
	}




}



