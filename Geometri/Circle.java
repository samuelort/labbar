package geometri;

import java.awt.*;
import java.awt.Graphics;
import java.lang.Math;

public class Circle extends AbstractGeometricalForm {
	/** Sets the diameter of the circle */ 
	private int diameter;
	/**
	 * Creates a circle.
	 * @param dimeter, sets the deiameter of circle.
	 * @param x, horizontal pos.
	 * @param y, vertical pos.
	 * @param c, The fill color.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 */
	public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
		super(x, y, c);
		this.diameter = diameter;
	}
	 /**
	 * Creates a rectangle from an already existing form.
	 * @param f from with coordinates. Copys the position.
	 * @param diameter, sets diameter of circle.
	 * @param c,The fill color.
	 */
	public Circle(GeometricalForm f, int diameter, Color c){
		super(f, c);
		this.diameter = diameter;

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea(){
		return (int) Math.round((Math.pow(diameter/2, 2) * Math.PI)); 
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPerimeter(){
		return (int) Math.round((Math.PI*diameter));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g){
		g.setColor(getColor());
		g.fillOval(getX(), getY(), diameter, diameter);
	}
	
}
