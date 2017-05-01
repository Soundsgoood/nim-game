import java.util.Random;

/**
 * A game of Nim, between two players or a player and computer.
 * @author Orion Guan
 * @version October 24th, 2016
 */
public class GameGuan
{
  private Random rng;
  private PlayerGuan player1;
  private PlayerGuan player2;

  /**
   * Constructs a game of Nim given one player name, creating a
   * ComputerPlayerGuan object to play with the one player.
   * @param playerName The name of the one human player.
   */
  public GameGuan(String playerName)
  {
    rng = new Random();
    player1 = new HumanPlayerGuan(playerName, rng);
    player2 = new ComputerPlayerGuan("Computer", rng);
  }
  /**
   * Constructs a game of Nim given two player names, creating two
   * HumanPlayerGuan objects for the players.
   * @param player1Name The name of the first player named.
   * @param player2Name The name of the second player named.
   */
  public GameGuan(String player1Name, String player2Name)
  {
    rng = new Random();
    player1 = new HumanPlayerGuan(player1Name, rng);
    player2 = new HumanPlayerGuan(player2Name, rng);
  }

  /**
   * Plays the game by making the pile, keeping track of turns, prompting each
   * player to make their moves, checking if the game is over, and declaring the
   * winner.
   */
  public void play()
  {
    PileGuan pile = new PileGuan(rng);
    boolean player1Turn = rng.nextBoolean();
    while (!pile.isEmpty())
    {
      if (player1Turn)
      {
        System.out.println("Pile now has "
                          + pile.getTilesRemaining()
                          + " tiles. It's "
                          + player1.getName()
                          + "'s turn.");
        System.out.println(player1.getName()
                          + " chose "
                          + player1.makeMove(pile));
        player1Turn = false;
      }
      else
      {
        System.out.println("Pile now has "
                          + pile.getTilesRemaining()
                          + " tiles. It's "
                          + player2.getName()
                          + "'s turn.");
        System.out.println(player2.getName()
                          + " chose "
                          + player2.makeMove(pile));
        player1Turn = true;
      }
    }
    
    String winnersName;
    
    if (player1Turn)
    {
      winnersName = player1.getName();
    }
    else
    {
      winnersName = player2.getName();
    }
    
    System.out.println("Game over -- "
                     + winnersName
                     + " wins!");
  }
}