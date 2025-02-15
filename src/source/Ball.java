package source;

import javax.swing.*;
import java.awt.*;

class Ball {
	int x, y, size, speedX, speedY;
	Color color;
	
	public Ball (int x, int y, int size, int speedX, int speedY , Color color)
	{
		this.x=x;
		this.y = y;
		this.size = size;
		this.speedX = speedX;
		this.speedY = speedY;
		this.color = color;
	}
	
	public void update(int width, int height)
	{
		x += speedX;
		y += speedY;
		
		if (x <= 0 || x >= width - size) speedX *= -1;
		if (y <= 0 || y >= height - size) speedY *= -1;
	}
	
	public void draw(Graphics g )
	{
		g.setColor(color);
		g.fillOval(x, y, size, size);
		
		
	}
	
}
