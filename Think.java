import java.io.*;
import java.util.*;
import java.awt.Point;

public class Think
{
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

  public LLnode next_move_node(LLnode node_at, int[][] board, View theView, Think theThink, Stack<int[][]> bs, Stack<LLnode> ls, Stack<Point> s)
  {
        int markX;
        int markY;
        int order_count = 1 + node_at.get_order_data();
        Point p = new Point(node_at.get_Point());
        Point Next_p = new Point();
        int i = (int)p.getX();
        int j = (int)p.getY();

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
          System.out.println("\n\n\n        KNIGHT IS TRAPPED!!            \n\n");
          System.out.println("No next move from:  " + p.toString());
          System.out.println("  ... ReCalculating ...  BackTracking w/ the Stack!\n");
          try{Thread.sleep(600);}catch(InterruptedException e) {}

          markX = node_at.get_x();
          markY = node_at.get_y();
          node_at = new LLnode(node_at.get_tail());
          order_count = 1 + node_at.get_order_data();
          p = new Point(node_at.get_Point());
          i = (int)p.getX();
          j = (int)p.getY();
          ls.pop();
          bs.pop();
          board[markX][markY] = -2;
          bs.push(board);
          if (     0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1) {Next_p.setLocation(p.getX()-2,p.getY()+1);}
          else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1) {Next_p.setLocation(p.getX()-1,p.getY()+2);}
          else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1) {Next_p.setLocation(p.getX()+1,p.getY()+2);}
          else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1) {Next_p.setLocation(p.getX()+2,p.getY()+1);}
          else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1) {Next_p.setLocation(p.getX()+2,p.getY()-1);}
          else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1) {Next_p.setLocation(p.getX()+1,p.getY()-2);}
          else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1) {Next_p.setLocation(p.getX()-1,p.getY()-2);}
          else if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1) {Next_p.setLocation(p.getX()-2,p.getY()-1);}
          else{
            theThink.next_move_node(node_at, board, theView, theThink, bs, ls, s);
          }
          board[markX][markY] = -1;
        }

        LLnode next_node = new LLnode(Next_p, node_at);
        ls.push(next_node);
        s.push(next_node.get_Point());
        int laps = 0;
        laps++;
        board[(int)Next_p.getX()][(int)Next_p.getY()] = 1 + node_at.get_order_data();
        bs.push(board);
        theView.look(board);
        try{Thread.sleep(300);}catch(InterruptedException e) {}

        return next_node;

  }

  //from base
  public LLnode find_move(Point p, Driver theDriver, LLnode base, int[][] board, Stack<Point> s, Stack<int[][]> bs, Stack<LLnode> ls)
  {
    int i = (int)p.getX();
    int j = (int)p.getY();
    LLnode goNode = new LLnode(p);

    if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i-2][j+1] == -1)
    {
      Point p0 = new Point(i-2,j+1);
      goNode = new LLnode(p0, base); //
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p0);  // add number to p_  if still popping point
    }
    else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i-1][j+2] == -1)
    {
      Point p1 = new Point(i-1,j+2);
      goNode = new LLnode(p1, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p1);  // add number to p_  if still popping points
    }
    else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i+1][j+2] == -1)
    {
      Point p2 = new Point(i+1,j+2);
      goNode = new LLnode(p2, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p2);  // add number to p_  if still popping points
    }
    else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i+2][j+1] == -1)
    {
      Point p3 = new Point(i+2,j+1);
      goNode = new LLnode(p3, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p3);  // add number to p_  if still popping points
    }
    else if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i+2][j-1] == -1)
    {
      Point p4 = new Point(i+2,j-1);
      goNode = new LLnode(p4, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p4);  // add number to p_  if still popping points
    }
    else if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i+1][j-2] == -1)
    {
      Point p5 = new Point(i+1,j-2);
      goNode = new LLnode(p5, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p5);  // add number to p_  if still popping points
    }
    else if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i-1][j-2] == -1)
    {
      Point p6 = new Point(i-1,j-2);
      goNode = new LLnode(p6, base);
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p6);  // add number to p_  if still popping points
    }
    else if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i-2][j-1] == -1)
    {
      Point p7 = new Point(i-2,j-1);
      goNode = new LLnode(p7, base); //
      ls.push(goNode);
      board[goNode.get_x()][goNode.get_y()] = goNode.get_order_data();
      bs.push(board);
      s.push(p7);  // add number to p_  if still popping points
    }
    else {
      goNode = new LLnode(base);
    }
    return goNode;
  } // end find move
}
