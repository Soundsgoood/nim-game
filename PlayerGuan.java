import java.util.Random;

/** An abstract class encompassing both human and computer types of players.
  * @author Orion Guan
  * @version November 2nd, 2016
  */
public abstract class PlayerGuan
{
  private String playerName;
  public Random rng;
  
  public PlayerGuan(String playerName, Random rng)
  {
    this.playerName = playerName;
    this.rng = rng;
  }
  
  /**
   * Prompts the player to make a move on a pile of tiles, giving the player
   * the range of possible tiles and checking for illegal moves. Automatically
   * moves for the player if there is only one legal move.
   * @param pile The pile of tiles that the player is prompted to remove from.
   * @return The number of tiles the player has legally chosen or has been
   * forced to to take from the pile.
   */
  public abstract int makeMove(PileGuan pile);
  
  /**
   * Returns the name of the player.
   * @return The name of the player.
   */
  public String getName()
  {
    return playerName;
  }
}