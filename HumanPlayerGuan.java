import java.util.Random;
import java.util.Scanner;

/**
 * A human player in this game of Nim.
 * @author Orion Guan
 * @version November 3rd, 2016
 */
public class HumanPlayerGuan extends PlayerGuan
{
  private Scanner in = new Scanner(System.in);
  
  /**
   * Constructs a HumanPlayerGuan object with a name, taking it from the
   * parameters it's given when the constructor is called. 
   * @param playerName The name associated with the player.
   * @param rng The Random object given to all PlayerGuan objects.
   */
  public HumanPlayerGuan(String playerName, Random rng)
  {
    super(playerName, rng);
  }

  /**
   * Prompts the player to make a move on a pile of tiles, giving the player
   * the range of possible tiles and checking for illegal moves. Automatically
   * moves for the player if there is only one legal move.
   * @param pile The pile of tiles that the player is prompted to remove from.
   * @return The number of tiles the player has legally chosen or has been
   * forced to to take from the pile.
   */
  public int makeMove(PileGuan pile)
  {
    boolean hasMadeLegalMove = false;
    int tilesTakenInMove = 0;

    if (pile.getMaxLegalMove() != 1)
    {
      while (hasMadeLegalMove == false)
      {
        System.out.print("Choose between 1 and "
                          + pile.getMaxLegalMove()
                          + " tiles: ");
        String tilesTakenInMoveInput = in.nextLine();
        tilesTakenInMove = Integer.parseInt(tilesTakenInMoveInput);
        if (tilesTakenInMove <= pile.getMaxLegalMove() && tilesTakenInMove >= 1)
        {
          hasMadeLegalMove = true;
        }
        else
        {
          System.out.print("Illegal choice. ");
        }
      }
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