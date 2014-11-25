
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class SnakeModel extends GameModel {
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);
		
		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}
	
	
	
	private static final GameTile FRUIT_TILE = new RoundTile(Color.BLACK,Color.RED,1);

	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();
	
	private static final GameTile SNAKE_TILE = new RectangularTile(Color.GREEN);
	
	private final LinkedList<Position> snake = new LinkedList<Position>();
	
	/** The position of the collector. */
	private Position snakePosition;

	/** The direction of the collector. */
	private Directions direction = Directions.NORTH;

	/** The number of fruits found. */
	private int score;
	
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole game board
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Place the snake in the center of the board
		this.snakePosition = new Position(size.width / 2, size.height / 2);
		snake.push(this.snakePosition);
		setGameboardState(this.snakePosition, SNAKE_TILE);	

	// Insert a fruit at the start of the game
	addFruit();

	}
	
	
	private void addFruit() {
		Position newFruitPos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newFruitPos = new Position((int) (Math.random() * size.width),
										(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newFruitPos));

		// ... add a new fruit to the empty tile.
		setGameboardState(newFruitPos, FRUIT_TILE);
	}
	
	
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}
	
	// The snake can't turn 180°
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				if(this.direction != Directions.EAST){
					this.direction = Directions.WEST;
				}
				break;
			case KeyEvent.VK_UP:
				if(this.direction != Directions.SOUTH){
					this.direction = Directions.NORTH;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(this.direction != Directions.WEST){
					this.direction = Directions.EAST;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(this.direction != Directions.NORTH){
					this.direction = Directions.SOUTH;
				}
				break;
			default:
				// Don't change direction if another key is pressed
				break;
		}
	}
	
	// Calculates the next position of the snake
	private Position getNextSnakePos() {
		return new Position(
				this.snakePosition.getX() + this.direction.getXDelta(),
				this.snakePosition.getY() + this.direction.getYDelta());
	}
	
		
	
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);
		
		this.snakePosition = getNextSnakePos();
		
		// Has the snake hit a wall?
		if (isOutOfBounds(this.snakePosition)) {
			throw new GameOverException(this.score);
			
		}
		
		// If the snake eats a fruit
		if(getGameboardState(this.snakePosition) == FRUIT_TILE) {
			addFruit();
			score++;
		}
		
		else{
			// Erase the snake's tail.
			setGameboardState(this.snake.get(0), BLANK_TILE);
			this.snake.remove(0);
		}
		
		// Check if the snake has hit its tail
		if (getGameboardState(this.snakePosition) == SNAKE_TILE) {
			throw new GameOverException(this.score);
		}
		
		// Updates the snake list with the new position.
		this.snake.add(this.snakePosition);
		
		// Moves the snake
		setGameboardState(this.snake.getLast(), SNAKE_TILE);
		 
	}
	

	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;			
	}
	
	public int getScore(){
		return this.score;
	}

}
