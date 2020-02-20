import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Driver
{
  public static Stack<Point> s = new Stack<Point>();
  public static int[][] board = new int[8][8];
  public static int[] intArray = new int[8];

    public static void main(String[] args) {
      Driver theDriver = new Driver();
      View theView = new View();
      int counter = 0;
      Prompt thePrompt = new Prompt();
      thePrompt.display();
      thePrompt.message();
      int y = thePrompt.askY();
      int x = thePrompt.askX();
      Point top = new Point(x, y);
      s.push(top);
      //linked list stuff here
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          board[i][j] = -1;
        }
      }
      board[x][y] = counter++;
      theView.look(board);

      Point np1 = new Point(theDriver.find_move(top, intArray));
      s.push(np1);
      board[(int)np1.getX()][(int)np1.getY()] = counter++;
      //linked list stuff here
      theView.look(board);

      Point np2 = new Point(theDriver.find_move(np1, intArray));
      s.push(np2);
      board[(int)np2.getX()][(int)np2.getY()] = counter++;
      //lnked list action

      for (int r = 3; r < 32; r++)
      {
        np1.setLocation(np2);
        np2.setLocation(theDriver.find_move(np1, intArray));
        s.push(np2);
        board[(int)np2.getX()][(int)np2.getY()] = r;
        //linked list stuff here
        theView.look(board);
      }
  }//end main

  public Point find_move(Point p, int[] nArray)
  {
    Driver theDriver = new Driver();
    Point Next_p = new Point();
    for (int ind=0;ind<8;ind++){nArray[ind] = 0;}
    double x = p.getX();
    double y = p.getY();
    int i = (int)x;
    int j = (int)y;

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1)
    {
      Point p0 = new Point(i-2,j+1);
      intArray[0] = this.get_available_moves_count(p0, board);
    }

    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1)
    {
      Point p1 = new Point(i-1,j+2);
      intArray[1] = this.get_available_moves_count(p1, board);
    }

    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1)
    {
      Point p2 = new Point(i+1,j+2);
      intArray[2] = this.get_available_moves_count(p2, board);
    }

    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1)
    {
      Point p3 = new Point(i+2,j+1);
      intArray[3] = this.get_available_moves_count(p3, board);
    }

    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1)
    {
      Point p4 = new Point(i+2,j-1);
      intArray[4] = this.get_available_moves_count(p4, board);
    }

    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1)
    {
      Point p5 = new Point(i+1,j-2);
      intArray[5] = this.get_available_moves_count(p5, board);
    }

    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1)
    {
      Point p6 = new Point(i-1,j-2);
      intArray[6] = this.get_available_moves_count(p6, board);
    }

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1)
    {
      Point p7 = new Point(i-2,j-1);
      intArray[7] = this.get_available_moves_count(p7, board);
    }

    for (int z = 0; z < 8; z++ )
    {
      if(intArray[z] == 0) {intArray[z]+=10;}
    }
    int answer = 0;
    for(int q = 1; q < intArray.length; q++)
      if ( intArray[q] < intArray[answer] ) {answer = q;}

    if (answer == 0) {Next_p.setLocation(p.getX()-2,p.getY()+1);}
    if (answer == 1) {Next_p.setLocation(p.getX()-1,p.getY()+2);}
    if (answer == 2) {Next_p.setLocation(p.getX()+1,p.getY()+2);}
    if (answer == 3) {Next_p.setLocation(p.getX()+2,p.getY()+1);}
    if (answer == 4) {Next_p.setLocation(p.getX()+2,p.getY()-1);}
    if (answer == 5) {Next_p.setLocation(p.getX()+1,p.getY()-2);}
    if (answer == 6) {Next_p.setLocation(p.getX()-1,p.getY()-2);}
    if (answer == 7) {Next_p.setLocation(p.getX()-2,p.getY()-1);}

    return Next_p;
  } // end find move

  public int get_available_moves_count(Point p, int[][] board)
  {
      int i = (int)p.getX();
      int j = (int)p.getY();
      int count = 0;
      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1) {count++;}
      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1) {count++;}

      return count;
  }
}
