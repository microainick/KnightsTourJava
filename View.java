import java.io.*;
import java.util.*;

public class View
{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

  public void look(int[][] array)
  {
    for (int i = 7; i > -1; i--)
    {
      System.out.println(" ");
      for (int j = 0; j < 8; j++)
      {
        if (array[j][i] == 31)
        {
          System.out.printf(ANSI_YELLOW + "%2d " + ANSI_RESET, array[j][i]);
        }
        else if (array[j][i] != -1)
        {
          System.out.printf(ANSI_PURPLE + "%2d " + ANSI_RESET, array[j][i]);
        }
        else
        {
          System.out.printf("%2d ", array[j][i]);
        }
        //System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j].getData());
      }
    }
    System.out.println("\n\n");
  }
}
