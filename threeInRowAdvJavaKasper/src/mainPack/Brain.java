package mainPack;

import boardPack.Board;
import guiPack.Gui;
import minMaxPack.MinMax;

public class Brain {
	
	// True if brain is currently loading
	private boolean currentlyChewing = false;
	
	// 2D array representing playing board inside board class
	String[][] squaresArray = {
			{"E", "E", "E"},
			{"E", "E", "E" },
			{"E", "E", "E" }
	};
	
	// Class of the current playing board
	Board currentBoard = new Board(squaresArray);
	
	// Class to show the player the playing board
	Gui gui = new Gui(currentBoard, this);
	public void initialize() {
		gui.createAndDisplay();
	}
	
	// When player chooses it´s next move this method checks and finalises the move
	public void prepareMinMax(int row, int col) {
		
		// Makes sure the player can´t make a new move before the old one is done.
		if (!currentlyChewing) {
			currentlyChewing = true;
			
			// Checks if the move is valid and if no one has already won
			if (currentBoard.isValidMove(row, col) && 
					currentBoard.isWinner().equals("N")) {
				
				// If it is valid an X is placed on correct square
				currentBoard.placeMark("X", row, col);
				// Then the AI makes it´s move through an minMax algorithm, the ai´s move is saved as the current boards child.
				MinMax.minMax(currentBoard, 0, true);
				// Then the board and GUI is updated
				currentBoard = currentBoard.getChildBoard();
				gui.updateGui(currentBoard);
				// For testing, prints the AIs intended path in console
				currentBoard.printBoard();
				
			}
			
			currentlyChewing = false;
		}
		
	}
	
	
}

