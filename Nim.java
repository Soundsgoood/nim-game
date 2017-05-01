/**
 * Program to set up and play a game of Nim
 * @author Jon Beck
 * @version 17 October 2016
 */
public class Nim
{
  public static void main(String[] args)
  {
    if (args.length == 0 || args.length > 2)
    {
      System.out.println("Usage: java Nim name [name]");
      System.exit(1);
    }

    GameGuan game;
    if (args.length == 1)
    {
        game = new GameGuan(args[0]);
    }
    else
    {
        game = new GameGuan(args[0], args[1]);
    }
    game.play();
  }
}