package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Board board = new Board();
        Scanner scanner = new Scanner(System.in);


        boolean gameOver = false;
        
        board.printGrid();
        
        while (!gameOver) {

        	System.out.println("Enter the column and row sperated by a space: ");
        	int col; 
        	int row;

        	try { 
        		col = scanner.nextInt();
        		row = scanner.nextInt();

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


            gameOver = board.end(row, col);
            board.printGrid();
            if(gameOver) {
                System.out.print("BOOM!");
            }
            
            int remaining = board.gameWin();
            
            if(remaining == 0) {
                System.out.print("Complete!");

            }
        }
        scanner.close();
    }
}

