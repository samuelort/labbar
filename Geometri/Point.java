package geometri;

import java.awt.Graphics;
import java.awt.*;

public class Point extends AbstractGeometricalForm{
	 /**
	 * Creates a point.
	 * @param x horizontal pos.
	 * @param y vertical pos.
	 * @param c The fill color.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Point(int x, int y, Color c) throws IllegalPositionException{
		super(x,y,c);
	}
	 /**
	 * Creates a point.
	 * @param f, takes coordinates from existing point.
	 * @param c, The fill color.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Point(GeometricalForm f, Color c){
		super(f,c);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		final int width = 1;	//dimensions for a point, 1x1 pixels
		final int height = 1;
		g.setColor(getColor());
		g.fillRect(x, y, width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return 0;
	}
	
	/**
	 * {@interitDoc}
	 */
	@Override
	public int getPerimeter() {
		return 0;
	}

}
