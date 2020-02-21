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
  public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
  public static final String ANSI_BLINK = "\u001B[5m";
  public static final String RAPID_BLINK = "\u001B[6m";

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
        else if (array[j][i] == 32)
        {
          System.out.printf(ANSI_BRIGHT_CYAN + "%2d " + ANSI_RESET, array[j][i]);
        }
        else if (array[j][i] > 32)
        {
          System.out.printf(ANSI_GREEN + "%2d " + ANSI_RESET, array[j][i]);
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

  public void look2(int[][] array)
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
        else if (array[j][i] == 32)
        {
          System.out.printf(ANSI_CYAN + ANSI_BLINK + "%2d " + ANSI_RESET, array[j][i]);
        }
        else if (array[j][i] > 32)
        {
          System.out.printf(ANSI_GREEN + "%2d " + ANSI_RESET, array[j][i]);
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
