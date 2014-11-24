package geometri;

import java.awt.Graphics;
import java.awt.*;

public class Oval extends AbstractGeometricalForm{
		/** Sets width and height of elips*/
		private int width;
		private int height;
	/**
	 * Creates a square.
	 * @param x, horizontal pos.
	 * @param y, vertical pos.
	 * @param c, The fill color.
	 * @param width.
	 * @param height.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 */
	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x,y,c);
		this.width=width;
		this.height=height;
	}
	/**
	 * Creates a elips from an already existing form. Copys the position.
	 * @param f from with coordinates.
	 * @param c The fill color.
	 * @param width.
	 * @param height.
	 */
	public Oval(GeometricalForm f, int width, int height, Color c){
		super(f,c);
		this.width=width;
		this.height=height;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(x, y, width, height);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return (int) Math.PI*width*height;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPerimeter() {
		// approximativ formel
		return (int) (Math.PI*(3*(width+height-Math.sqrt((3*width+height)*(height+3*width)))));
	}

}
