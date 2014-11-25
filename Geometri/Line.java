package geometri;

import java.awt.Graphics;
import java.awt.*;

public class Line extends AbstractGeometricalForm{
	/**
	 * x2,y2: the points at the end of the line
	 */
	private int x2;
	private int y2;
	
	/**
	 * k : the slope of the line between (x1,y1) and (x2,y2) 
	 */
	private int k;
	 /**
	 * Creates a line.
	 * @param x1,horizontal pos for first coordinate.
	 * @param y1, vertical pos for first coordinate.
	 * @param x2,horizontal pos for second coordinate.
	 * @param y2, vertical pos for second coordinate.
	 * @param c, The fill color.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
		super(Math.min(x1, x2),Math.min(y1, y2),c);
		this.x2=Math.max(x1,x2);
		this.y2=Math.max(x1, x2);
		
		this.k=(int)(y2-y1)/(x2-x1);
	}
    	 /**
	 * Creates a rectangle.
	 * @param f1, points from f1.
	 * @param f2, points from f2.
	 * @param c The fill color.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) throws IllegalPositionException{
		super(Math.min(f1.getX(), f2.getX()),Math.min(f1.getY(), f2.getY()),c);
		this.x2=Math.max(f1.getX(),f2.getX());
		this.y2=Math.max(f1.getY(), f2.getY());
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) { //har inte med så att lutningen spelar någon roll. får fixa det sen
		g.setColor(getColor());
		g.drawLine(getX(), getY(), x2, y2);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPerimeter() {
		int deltaX = this.x2 - getX();
		int deltaY = this.y2 - getY();
		return (int) Math.round(Math.sqrt((deltaX*deltaX) + (deltaY*deltaY))); //Pythagoras
	}

}
