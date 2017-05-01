import java.util.Random;

/**
 * The computer player in this game of Nim.
 * @author Orion Guan
 * @version October 24th, 2016
 */
public class ComputerPlayerGuan extends PlayerGuan
{
  
  /**
   * Constructs a ComputerPlayerGuan object with a name given from parameters
   * in the constructor.
   * @param playerName The name associated with the player.
   * @param rng The Random object given to all PlayerGuan objects, allowing the
   * computer to make random moves.
   */
  public ComputerPlayerGuan(String playerName, Random rng)
  {
    super(playerName, rng);
  }
  
  
  /**
   * Prompts the computer to make a move on a pile of tiles, using a random
   * number generator to select one of the legal moves. Prints a note saying so
   * if the computer had only one legal move.
   * @param pile The pile of tiles that the computer removes from.
   * @return The number of tiles the computer has randomly chosen or has been
   * forced to take from the pile.
   */
  public int makeMove(PileGuan pile)
  {
    int tilesTakenInMove;
    if (pile.getMaxLegalMove() != 1)
    {
      tilesTakenInMove = rng.nextInt(pile.getMaxLegalMove()) + 1;
    }
    else
    {
      System.out.println(
      "The only legal move is 1 tile, so I am choosing 1 for you.");
      tilesTakenInMove = 1;
    }
    pile.deleteTiles(tilesTakenInMove);
    return tilesTakenInMove;
  }
}