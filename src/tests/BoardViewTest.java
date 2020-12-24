package tests;

import javax.swing.JFrame;

import views.BoardView;

public class BoardViewTest
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setBounds(0, 0, 900, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setVisible(true);
		
		BoardView boardView = new BoardView();
		boardView.setBounds(0, 0, 800, 800);
		boardView.setLayout(null);
		
		window.add(boardView);	
	}
}
