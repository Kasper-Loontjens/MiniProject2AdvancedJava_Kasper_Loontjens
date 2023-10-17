package boardPack;

import java.util.Iterator;

public class Board implements BoardOperations {
	
	private Board childBoard;
	
	public String[][] squaresArray;	
	
	public Board(String[][] squaresArray) {
		// TODO Auto-generated constructor stub
		this.squaresArray = squaresArray;
	}
	
	
	@Override
	public boolean isValidMove(int row, int col) {
		if (squaresArray[row-1][col-1] == "E") {
			return true;
		}
		return false;
	}

	@Override
	public void placeMark(String mark, int row, int col) {
		// TODO Auto-generated method stub
		squaresArray[row-1][col-1] = mark;
		
	}

	@Override
	public String isWinner() {
		// TODO Auto-generated method stub
		
		if (squaresArray[0][0].equals("X")&&
				squaresArray[0][1].equals("X")&&
				squaresArray[0][2].equals("X")) {
			return "X";
		} else if (squaresArray[0][0].equals("O")&&
					squaresArray[0][1].equals("O")&&
					squaresArray[0][2].equals("O")) {
			return "O";
		}else if (squaresArray[1][0].equals("X")&&
					squaresArray[1][1].equals("X")&&
					squaresArray[1][2].equals("X")) {
			return "X";
		}else if (squaresArray[1][0].equals("O")&&
					squaresArray[1][1].equals("O")&&
					squaresArray[1][2].equals("O")) {
			return "O";
		}else if (squaresArray[2][0].equals("X")&&
					squaresArray[2][1].equals("X")&&
					squaresArray[2][2].equals("X")) {
			return "X";
		}else if (squaresArray[2][0].equals("O")&&
					squaresArray[2][1].equals("O")&&
					squaresArray[2][2].equals("O")) {
			return "O";
		}else if (squaresArray[0][0].equals("X")&&
					squaresArray[1][0].equals("X")&&
					squaresArray[2][0].equals("X")) {
			return "X";
		}else if (squaresArray[0][0].equals("O")&&
					squaresArray[1][0].equals("O")&&
					squaresArray[2][0].equals("O")) {
			return "O";
		}else if (squaresArray[0][1].equals("X")&&
					squaresArray[1][1].equals("X")&&
					squaresArray[2][1].equals("X")) {
			return "X";
		}else if (squaresArray[0][1].equals("O")&&
					squaresArray[1][1].equals("O")&&
					squaresArray[2][1].equals("O")) {
			return "O";
		}else if (squaresArray[0][2].equals("X")&&
					squaresArray[1][2].equals("X")&&
					squaresArray[2][2].equals("X")) {
			return "X";
		}else if (squaresArray[0][2].equals("O")&&
					squaresArray[1][2].equals("O")&&
					squaresArray[2][2].equals("O")) {
			return "O";
		}else if (squaresArray[0][0].equals("X")&&
					squaresArray[1][1].equals("X")&&
					squaresArray[2][2].equals("X")) {
			return "X";
		}else if (squaresArray[0][0].equals("O")&&
					squaresArray[1][1].equals("O")&&
					squaresArray[2][2].equals("O")) {
			return "O";
		}else if (squaresArray[0][2].equals("X")&&
					squaresArray[1][1].equals("X")&&
					squaresArray[2][0].equals("X")) {
			return "X";
		}else if (squaresArray[0][2].equals("O")&&
					squaresArray[1][1].equals("O")&&
					squaresArray[2][0].equals("O")) {
			return "O";
		}else if (hasEmptyCells()) {
			return "N";
		}else {
			return "D";
		}
		
		
	}

	@Override
	public boolean isDraw() {
		// TODO Auto-generated method stub
		if (isWinner().equals("D")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isXWinner() {
		// TODO Auto-generated method stub
		if (isWinner().equals("X")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isOWinner() {
		// TODO Auto-generated method stub
		if (isWinner().equals("O")) {
			return true;
		}
		return false;
	}

	@Override
	public Board copyBoard() {
		// TODO Auto-generated method stub
		String[][] copySquaresArray = new String[squaresArray.length][squaresArray[0].length];
		for (int i = 0; i < squaresArray.length; i++) {
			for (int j = 0; j < squaresArray[i].length; j++) {
				copySquaresArray[i][j] = squaresArray[i][j];
			}
		}
		Board copy = new Board(copySquaresArray);
		
		return copy;
	}

	@Override
	public boolean hasEmptyCells() {
		// TODO Auto-generated method stub
		for (int i = 0; i < squaresArray.length; i++) {
			for (int j = 0; j < squaresArray[i].length; j++) {
				if (squaresArray[i][j].equals("E")) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void printBoard() {
		System.out.println(" ");
		// TODO Auto-generated method stub
		
		// mainly for testing, prints the boards move and all of its childrens moves. That way we can see the AIs intended path
		for (int i = 0; i < squaresArray.length; i++) {
			System.out.println();
			for (int j = 0; j < squaresArray[i].length; j++) {
				System.out.print(squaresArray[i][j]);
			}
		}
		if (childBoard != null) {
			childBoard.printBoard();
		}
	}
	
	// Teachers method, never used
	@Override
	public void setPreviousCell() {
		// TODO Auto-generated method stub
		
	}

	// Teachers method, never used
	@Override
	public void setNexBoard() {
		// TODO Auto-generated method stub
		
	}

	// Teachers method, never used
	@Override
	public Board getChildBoards() {
		// TODO Auto-generated method stub
		return null;
	}

	// Teachers method, never used
	@Override
	public void createPossibleChildBoards() {
		// TODO Auto-generated method stub
		
	}

	// Getters and setters-----
	public Board getChildBoard() {
		return childBoard;
	}

	public void setChildBoard(Board childBoard) {
		this.childBoard = childBoard;
	}


}

