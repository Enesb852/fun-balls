package source;

import javax.swing.*;

public class Window {
	
	
	public static void main(String[] args)
	{
		JFrame  window = new JFrame("fun balls");
		Game game= new Game(50);
		
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		game.startGame();
		
		
	}
		

}
