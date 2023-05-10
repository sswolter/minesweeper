package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    static Board board = new Board();
    static Scanner scanner = new Scanner(System.in);


    static boolean gameOver = false;
    
    

    public static void main(String[] args) {

    	
        
        board.printGrid();
        
        while (!gameOver) {

        	System.out.println();
        	int col; 
        	int row;

        	try { 
            	System.out.print("Row: ");
            	row = scanner.nextInt();
            	System.out.print("Column: ");
        		col = scanner.nextInt();

        		if (col < 0 || col > board.numberOfColumns - 1 || row < 0 || row > board.numberOfRows - 1) {
        			System.out.println("Please enter a number between 0 and " + (board.numberOfColumns - 1) + ". \n");
        			continue;
        			}
        		} catch (InputMismatchException e) {
        			System.out.println("Invalid input. Please enter a number. \n");
        			scanner.next();
        			continue;
        		}

        	

    

            board.unhide(row, col);
            board.getAdjMineNumber(row, col);
            board.getAmountToWin();
            System.out.print(board.amountToWin);
            board.setAmountToWin();


            gameOver = board.end(row, col);
            board.printGrid();
            if(gameOver) {
                System.out.print("BOOM!");
            }
            
            int remaining = board.getAmountToWin();
            
            if(remaining == 0) {
                System.out.print("Complete!");

            }
        }
        scanner.close();
    }
}

