package source;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements Runnable {
	
	private boolean running=false;
	private Thread gameThread;
	private ArrayList<Ball> balls;
	private Random rand = new Random();
	
	
	public Game(int ballCount)
	{
		setPreferredSize(new Dimension(800,600));
		setBackground(Color.BLACK);
		balls = new ArrayList<>();
		
		for (int i=0; i < ballCount; i++)
		{
			int size = rand.nextInt(20) + 30; // 30-50 px arası boyut
			int x = rand.nextInt(800 - size);
			int y = rand.nextInt(600 - size);
			int speedX = rand.nextInt(4) + 2; // 2-5px hız
			int speedY = rand.nextInt(4) + 2;
			Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			
			balls.add(new Ball(x, y, size, speedX, speedY, color));
		}
	
	}
	public void startGame() 
	{
		running = true;
		gameThread = new Thread(this);		
		gameThread.start();
	}
	
	@Override
	public void run()
	{
		while(running)
		{
			update();
			repaint();
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	
	private void update()
	{
		for (Ball ball : balls )
		{
			ball.update(getWidth(), getHeight());
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Ball ball : balls)
		{
			ball.draw(g);
		}
	}

}
