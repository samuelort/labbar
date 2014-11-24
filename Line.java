package geometri;

import java.awt.Graphics;
import java.awt.*;

public class Line extends AbstractGeometricalForm{
	private int x2;
	private int y2;
	private int k;
	
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(Math.min(x1, x2),Math.min(y1, y2),c);
		this.x2=Math.max(x1,x2);
		this.y2=Math.max(x1, x2);
		
		this.k=(int)(y2-y1)/(x2-x1);
	}
	
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(Math.min(f1.getX(), f2.getX()),Math.min(f1.getY(), f2.getY()),c);
		this.x2=Math.max(f1.getX(),f2.getX());
		this.y2=Math.max(f1.getY(), f2.getY());
	}
	
	@Override
	public void fill(Graphics g) { //har inte med så att lutningen spelar någon roll. får fixa det sen
		g.setColor(getColor());
		g.drawLine(getX(), getY(), x2, y2);
	}

	@Override
	public int getArea() {
		return 0;
	}

	@Override
	public int getPerimeter() {
		int deltaX = this.x2 - getX();
		int deltaY = this.y2 - getY();
		return (int) Math.round(Math.sqrt((deltaX*deltaX) + (deltaY*deltaY))); //Pythagoras
	}

}
