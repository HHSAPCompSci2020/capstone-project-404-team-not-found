import java.util.ArrayList;

/**
 * 
 * @author Tarini Maram
 *
 */
public class Tetris {

	private ArrayList<TetrisBlock> placedBlocks;
	private TetrisBlock fallingBlock;
	private int points;
	
	public Tetris() {
		placedBlocks = new ArrayList<TetrisBlock>();
		points = 0;
	}
}
