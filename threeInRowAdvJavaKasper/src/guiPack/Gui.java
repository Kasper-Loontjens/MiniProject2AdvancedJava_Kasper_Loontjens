package guiPack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Position;

import boardPack.Board;
import mainPack.Brain;

public class Gui {
	JFrame frame = new JFrame("Three in a row");
	JPanel panel = new JPanel();
	SquareButtonClass squareButtons[] = new SquareButtonClass[9];
	
	Board board;
	Brain brain;
	
	public Gui(Board board, Brain brain) {
		// TODO Auto-generated constructor stub
		this.board = board;
		this.brain = brain;
	}

	public void createAndDisplay(){
		// Adds and positions GUI elements
		
		panel.setLayout(null);
		
		frame.setSize(605,625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		int count = 0;
		for (int i = 0; i < board.squaresArray.length; i++) {
			for(int j = 0; j < board.squaresArray[i].length; j++) {
				squareButtons[count] = new SquareButtonClass(
						panel,
						10 + (j * 190),
						10 + (i * 190),
						board.squaresArray[i][j],
						i,
						j,
						brain);
				count++;
			}
			
		}
		
		frame.setVisible(true);		
	}
	
	public void updateGui(Board newBoard){
		board = newBoard;
		int count = 0;
		for (int i = 0; i < board.squaresArray.length; i++) {
			for(int j = 0; j < board.squaresArray[i].length; j++) {
				squareButtons[count].updateMark(board.squaresArray[i][j]);
				count++;
			}
			
		}
		paintMe();
	}
	
	public void paintMe(){
		frame.repaint();
		frame.revalidate();
	}
	
}
class SquareButtonClass{
	
	JPanel container;
	int height = 190;
	int width = 190;
	int xPos;
	int yPos;
	int row;
	int col;
	Brain brain;
	JButton button = new JButton("Add");
	String mark;
	

	
	public SquareButtonClass(JPanel container, int xPos, int yPos, String mark, int row, int col, Brain brain) {
		// TODO Auto-generated constructor stub
		this.container = container;
		this.xPos = xPos;
		this.yPos = yPos;
		this.mark = mark;
		this.row = row +1;
		this.col = col +1;
		this.brain = brain;
		positionAndStyle();
	}
	
	public void positionAndStyle() {
		button.setBounds(xPos, yPos, height, width);
		
		button.setFont(new Font("Arial", Font.PLAIN, 100));
		button.setText(mark);
		if (mark == "E") {
			button.setText("");
		}
		button.addActionListener(actionListener);
		container.add(button);
	}
	public void updateMark(String newMark) {
		mark = newMark;
		button.setText(mark);
		if (mark.equals("E")) {
			button.setText("");
		}

	}
	
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (mark.equals("E")) {
				brain.prepareMinMax(row, col);
			}
		}
	};
	
}
