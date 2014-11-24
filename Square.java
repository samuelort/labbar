

import java.awt.*;

public class Square extends AbstractGeometricalForm{
	
	/** The lenght of the squers side */
	private int side;
	
	/**
	 * Creates a square.
	 * @param x, horizontal pos.
	 * @param y, vertical pos.
	 * @param c, The fill color.
	 * @param side, sidelength of square.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Square(int x, int y, int side, Color c) throws IllegalPositionException{

	}
	/**
	 * Creates a square from an already existing one. Copy's only position. 
	 * @param f, 
	 * @param c, The fill color.
	 * @param side, sidelength of square.
	 * @throws IllegalPositionException if any x/y coordinate is negative. 
	 * 
	 */
	public Square(GeometricalForm f, int side, Color c){
		
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(super.getColor());
		g.fillRect(super.getX(), super.getY(), side, side);
	}

	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return getWidth()*getWidth();
	}

	@Override
	public int getPerimeter() {
		// TODO Auto-generated method stub
		return 4*(getWidth());
	}

}
