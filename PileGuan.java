import java.util.Random;

/**
 * The pile of tiles yet to be taken from in the game of Nim.
 * @author Orion Guan
 * @version October 24th, 2016
 */
public class PileGuan
{
  private Random rng;
  private int numberOfTiles;

  private final int MINIMUM_STARTING_TILES = 10;
  private final int MAXIMUM_STARTING_TILES = 100;

  /**
   * Constructs the PileGuan object starting with a number of tiles randomly
   * generated in number, between the minimum and maximum inclusive.
   */
  public PileGuan(Random rng)
  {
    this.rng = rng;
    numberOfTiles = rng.nextInt(MAXIMUM_STARTING_TILES
      - MINIMUM_STARTING_TILES + 1) + MINIMUM_STARTING_TILES;
  }

  /**
   * Returns whether or not there are no more tiles in the pile.
   * @return Whether or not there are no more tiles in the pile.
   */
  public boolean isEmpty()
  {
    return (numberOfTiles == 0);
  }

  /**
   * Returns the number of tiles in the pile.
   * @return The number of tiles in the pile.
   */
  public int getTilesRemaining()
  {
    return numberOfTiles;
  }

  /**
   * Returns the maximum legal move that a player may make, which is the highest
   * integer less than half of the remaining tiles. If there is only one tile
   * however, a player must take one tile.
   * @return The highest legal move a player may make.
   */
  public int getMaxLegalMove()
  {
    return (numberOfTiles > 1) ? (numberOfTiles / 2) : 1;
  }

  /**
   * Removes tiles from the pile.
   */
  public void deleteTiles(int numberOfTilesRemoved)
  {
    numberOfTiles -= numberOfTilesRemoved;
  }
}