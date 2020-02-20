import java.util.Scanner;
import java.awt.Point;

public class Prompt
{

  public void display()
  {
    System.out.printf("\n\n\n    _______________________________________________________________\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 7 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 6 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 5 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 4 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 3 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 2 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 1 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("   |       |       |       |       |       |       |       |       |\n");
    System.out.printf(" 0 |       |       |       |       |       |       |       |       |\n");
    System.out.printf("   |_______|_______|_______|_______|_______|_______|_______|_______|\n");
    System.out.printf("\n       0       1       2       3       4       5       6       7  \n\n\n");
  }

  public void message()
  {
    System.out.println("\n\n\nKnights Tour Demo\n\n\n");
    System.out.println("\nI would like to get the starting position from the user\n");
    System.out.println("Please note how the chess board is labeled above.\n\n\n");
  }

  public int askY()
  {
    boolean isValid;
    String input;
    int inputY = 0;
    Scanner Sy_input = new Scanner(System.in);
    do
    {
      isValid = true;
      System.out.println("\nPlease enter a numeric value from (0-7)   ");
      System.out.println("    as a starting position for the Y-Axis.");
      input = Sy_input.nextLine();
      try
      {
        inputY = Integer.parseInt(input);
        if (inputY < 0 || inputY > 7)
        {
          isValid = false;
          System.out.println("Invalid. Try again.");
        }
      } // end Try
      catch (NumberFormatException e)
      {
        isValid = false;
        System.out.println("Invalid. Not a number. Try again.");
      } //close catch
    } while (!isValid);
    return inputY;
  }

  public int askX()
  {
    boolean isValid;
    String input;
    int inputX = 0;
    Scanner Sx_input = new Scanner(System.in);
    do
    {
      isValid = true;
      System.out.println("\nPlease enter a numeric value from (0-7)   ");
      System.out.println("    as a starting position for the X-Axis.");
      input = Sx_input.nextLine();
      try
      {
        inputX = Integer.parseInt(input);
        if (inputX < 0 || inputX > 7)
        {
          isValid = false;
          System.out.println("Invalid. Try again.");
        }
      } // end Try
      catch (NumberFormatException e)
      {
        isValid = false;
        System.out.println("Invalid. Not a number. Try again.");
      } //close catch
    } while (!isValid);
    return inputX;
    }
}
