import java.io.*;
import java.util.*;
import java.awt.Point;
import java.lang.*;

public class Brain
{
/*
  public Boolean hasNextMoveWrong(LLnode l, int[][] board, Brain theBrain)
  {
      LLnode tempNext = new LLnode(theBrain.next_move_node(l, board, theBrain));
      Point p = new Point(tempNext.get_Point());
      int i = (int)p.getX();
      int j = (int)p.getY();
      int count = 0;

      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1 && board[i-2][j+1] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1 && board[i-1][j+2] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1 && board[i+1][j+2] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1 && board[i+2][j+1] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1 && board[i+2][j-1] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1 && board[i+1][j-2] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1 && board[i-1][j-2] == -1) {count++;}
      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1 && board[i-2][j-1] == -1) {count++;}

      if (count > 0) {return true;}
      return false;
  }
*/
  public LLnode next_move_node(LLnode node_at, int[][] board)
  {
      int order_count = 1 + node_at.get_order_data();
      Point p = new Point(node_at.get_Point());
      Point Next_p = new Point();
      int i = (int)p.getX();
      int j = (int)p.getY();
      //int location = 8;
      if (     0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {Next_p.setLocation(p.getX()-2,p.getY()+1);}
      else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {Next_p.setLocation(p.getX()-1,p.getY()+2);}
      else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {Next_p.setLocation(p.getX()+1,p.getY()+2);}
      else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {Next_p.setLocation(p.getX()+2,p.getY()+1);}
      else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {Next_p.setLocation(p.getX()+2,p.getY()-1);}
      else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {Next_p.setLocation(p.getX()+1,p.getY()-2);}
      else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {Next_p.setLocation(p.getX()-1,p.getY()-2);}
      else if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {Next_p.setLocation(p.getX()-2,p.getY()-1);}
      else
      {
        System.out.println("No next move from:  " + p.toString() + " probably use get_tail");
      }
      //if (theBrain.hasNextMove(node_at, ))
      LLnode next_node = new LLnode(Next_p, node_at);

      return next_node;
  }


/*

    public int set_next_move_REVERB(Point p, int[][] board)
    {
        int i = (int)p.getX();
        int j = (int)p.getY();
        int value = 8;
        if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {value = 0;}
        if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {value = 1;}
        if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {value = 2;}
        if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {value = 3;}
        if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {value = 4;}
        if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {value = 5;}
        if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {value = 6;}
        if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {value = 7;}

        //reversed order nice!!!
        System.out.println("no moves");  //remove later
        //
        //LLnode(Point p, LLnode t)

        if (value == 0) {LLnode(p, LL_next);}
        if (value == 1) {LLnode(p, LL_next);}
        if (value == 2) {LLnode(p, LL_next);}
        if (value == 3) {LLnode(p, LL_next);}
        if (value == 4) {LLnode(p, LL_next);}
        if (value == 5) {LLnode(p, LL_next);}
        if (value == 6) {LLnode(p, LL_next);}
        if (value == 7) {LLnode(p, LL_next);}
        if (value == 8) {System.out.println("fucked!");}

        return value;
    }

  */

public Boolean hasNextMove(LLnode l, int[][] board)
{
    int i = (int)l.get_Point().getX();
    int j = (int)l.get_Point().getY();
    int count = 0;

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {count++;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {count++;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {count++;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {count++;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {count++;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {count++;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {count++;}
    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {count++;}

    if (count > 0) {return true;}
    return false;
}

public int NextMoveCount(LLnode l, int[][] board)
{
    int i = (int)l.get_Point().getX();
    int j = (int)l.get_Point().getY();
    int count = 0;

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {count++;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {count++;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {count++;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {count++;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {count++;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {count++;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {count++;}
    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {count++;}

    return count;
}

//nope
public int[] moveArrayOptions(LLnode l, int[][] board)
{
    int[] myArray = new int[8];
    int i = (int)l.get_Point().getX();
    int j = (int)l.get_Point().getY();
    int count = 0;

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {myArray[0] = 1;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {myArray[1] = 1;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {myArray[2] = 1;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {myArray[3] = 1;}
    if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {myArray[4] = 1;}
    if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {myArray[5] = 1;}
    if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {myArray[6] = 1;}
    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {myArray[7] = 1;}

    return myArray;
}

public int countArrayVals(int[] arr)
{
  int j = 0;
  for (int i = 0; i < arr.length; i++)
  {
    j+= arr[i];
  }
  return j;
}

public void fakeMark(int myIndexInput, int[][] board, Stack<int[][]> bs, Stack<LLnode> ls)
{
    int i=ls.peek().get_x();
    int j=ls.peek().get_y();
    if (myIndexInput == 0) {board[i-2][j+1]++;}
    if (myIndexInput == 1) {board[i-1][j+2]++;}
    if (myIndexInput == 2) {board[i+1][j+2]++;}
    if (myIndexInput == 3) {board[i+2][j+1]++;}
    if (myIndexInput == 4) {board[i+2][j-1]++;}
    if (myIndexInput == 5) {board[i+1][j-2]++;}
    if (myIndexInput == 6) {board[i-1][j-2]++;}
    if (myIndexInput == 7) {board[i-2][j-1]++;}
    bs.push(board);
}

public void unFake(int myIndexInput, int[][] board, Stack<int[][]> bs, Stack<LLnode> ls)
{
    int i=ls.peek().get_x();
    int j=ls.peek().get_y();
    if (myIndexInput == 0) {board[i-2][j+1]--;}
    if (myIndexInput == 1) {board[i-1][j+2]--;}
    if (myIndexInput == 2) {board[i+1][j+2]--;}
    if (myIndexInput == 3) {board[i+2][j+1]--;}
    if (myIndexInput == 4) {board[i+2][j-1]--;}
    if (myIndexInput == 5) {board[i+1][j-2]--;}
    if (myIndexInput == 6) {board[i-1][j-2]--;}
    if (myIndexInput == 7) {board[i-2][j-1]--;}
    bs.push(board);
}

/*
public LLnode fakeMark_broke(LLnode node_at, int[][] board)
{
    int order_count = 1 + node_at.get_order_data();
    Point p = new Point(node_at.get_Point());
    Point Next_p = new Point();
    int i = (int)p.getX();
    int j = (int)p.getY();
    //int location = 8;
    if (     0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {board[i-2][j+1];}
    else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {board[i-1][j+2];}
    else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {board[i+1][j+2];}
    else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {board[i+2][j+1];}
    else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {board[i+2][j-1];}
    else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {board[i+1][j-2];}
    else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {board[i-1][j-2];}
    else if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {board[i-2][j-1];}
    else
    {
      System.out.println("No next move from:  " + p.toString() + " probably use get_tail");
    }
    //if (theBrain.hasNextMove(node_at, ))
    LLnode next_node = new LLnode(Next_p, order_count, node_at);

    return next_node;
}
*/

}
