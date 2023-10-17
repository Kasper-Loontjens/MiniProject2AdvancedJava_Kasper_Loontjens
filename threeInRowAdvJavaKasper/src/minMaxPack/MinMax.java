package minMaxPack;

import boardPack.Board;

public class MinMax {
	
	public static int minMax(Board board, int depth, boolean isMaximizing) {
		//base case 
		if (depth == 10) {
			return 0;
		}
		String checkWinString = board.isWinner();
		if (checkWinString.equals("O")) {
			// AI wins
			return 1;
		}else if (checkWinString.equals("X")) {
			// AI loses
			return (-1);
		}else if (checkWinString.equals("D")) {
			// Draw
			return 0;
		}
		depth++;
		
		//Recurrent case
		if (isMaximizing) {
			//initial lowest possible value
			int maxVal = Integer.MIN_VALUE;
			// all of the Squares on the board
			for (int i = 0; i < board.squaresArray.length; i++) {
				for (int j = 0; j < board.squaresArray[i].length; j++) {
				
				int eval = maxVal;
				
				// If the square is empty and available 
				if (board.isValidMove(i+1, j+1)) {
					// Creates a copy of the board
					Board copy = board.copyBoard();
					// Places mark on the empty square
					copy.placeMark("O", i+1, j+1);
					// Returns 0 1 or -1 for draw, win or loss
					eval = minMax(copy, depth, false);
					// Saves the board of the highest returned number as child of current board
					if (eval >= maxVal) {
						maxVal = eval;
						board.setChildBoard(copy);
						}
					}
				}
			}
			//Returns the highest number
			return maxVal;
			//else similar to maximizer but for the lowest values
			//it doesnt have the best next move logic 
			//since it is the computers choice
		} else {
			int minEval = Integer.MAX_VALUE;
			for (int i = 0; i < board.squaresArray.length; i++) {
				for (int j = 0; j < board.squaresArray[i].length; j++) {
				
				int eval = minEval;
				
				Board copy = board.copyBoard();
				if (copy.isValidMove(i+1, j+1)) {
					copy.placeMark("X", i+1, j+1);

					eval = minMax(copy, depth, true);
					if (eval <= minEval) {
						minEval = eval;
						board.setChildBoard(copy);

						}
					}
				}

				
			}
			return minEval;
		}
	}

}
