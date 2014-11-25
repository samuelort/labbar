package geometri;

import java.awt.*;

public abstract class AbstractGeometricalForm implements GeometricalForm{
	/** The objects position*/
	protected int x;
	protected int y;
	/** The objects width and height*/
	protected int width;
	protected int height;
	/** The objects color*/
	protected Color c;
	
	public AbstractGeometricalForm(int x, int y, Color c) throws IllegalPositionException {
		if(x < 0 || y < 0){
    		throw new IllegalPositionException();
    	}
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	public AbstractGeometricalForm(GeometricalForm f, Color c){
		x=f.getX();
		y=f.getY();
		this.c=c;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		int a=0;
		if(getArea()==f.getArea()){
			if(getPerimeter()==f.getPerimeter()){
				a= 0;
			}
			else if(getPerimeter()<f.getPerimeter()){
				a= -1;
			}
			else if(getPerimeter()>f.getPerimeter()){
				a= 1;
			}
		}
		else {
			if(getArea()<f.getArea()){
				a= -1;
			}
			else if(getArea()>f.getArea()){
				a= 1;
			}
		}
		return a;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void fill(Graphics g);
	 /**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor(){
		return c;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
    public abstract int getArea();
	/**
	 * {@inheritDoc}
	 */
	@Override
    public int getHeight(){
    	return height;
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
    public abstract int getPerimeter();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWidth(){
    	return width;
    }
    	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX(){
    	return x;
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
    public int getY(){
    	return y;
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
    public void move(int dx, int dy) throws IllegalPositionException{
		if(x < 0 || y < 0){
		place(this.x+dx,this.y + dy);
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
    public void place(int x, int y) throws IllegalPositionException{
		if(x < 0 || y < 0){
    		throw new IllegalPositionException();
    	}
    	this.x=x;
    	this.y=y;
    }
	
	
}
