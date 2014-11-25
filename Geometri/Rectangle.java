

import java.awt.Graphics;
import java.awt.*;

public class Rectangle extends AbstractGeometricalForm{

	/** Width and height of the rectangle */
	private int width;
	private int height;

	/**
	 * Creates a rectangle.
	 * @param x, horizontal pos.
	 * @param y, vertical pos.
	 * @param c, The fill color.
	 * @param width.
	 * @param height.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		super(x,y,c);
		this.height = height;
		this.width = width;
		}
	/**
	 * Creates a rectangle from an already existing form.
	 * @param f, from with coordinates.
	 * @param c, The fill color.
	 * @param width.
	 * @param height.
	 */
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		super(f,c);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), width, height);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return width*height;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPerimeter() {
		return 2*(width*height);
	}

}
