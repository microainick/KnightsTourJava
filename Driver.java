import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Driver
{

  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

  public static Stack<Point> s = new Stack<Point>();  //stack
  public static Stack<int[][]> bs = new Stack<int[][]>();   //board stack
  public static int[][] board = new int[8][8];
  public static int[] intArray = new int[8];
  public static Stack<LLnode> ls = new Stack<LLnode>();

    public static void main(String[] args) {
      Driver theDriver = new Driver();
      View theView = new View();
      Think theThink = new Think();
      //Scanner theScanner = new Scanner();
      //Brain theBrain = new Brain();
      Scanner scuba = new Scanner( System.in );
      Show theShow = new Show();
      System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Knights Tour by Nicholas Marien");
      try{Thread.sleep(720);} catch(InterruptedException e) {}
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
      bs.push(board);

      theShow.show(top);
      System.out.println("\n\n\nPress a key\n");
      System.out.println("Then Press Enter to view!");
      scuba.next();
      System.out.println(" ");
      System.out.println("\nyo\n\n");
      //System.out.println(
      theView.look(bs.peek());

      Point np1 = new Point(theDriver.find_move(top, intArray));
      s.push(np1);
      board[(int)np1.getX()][(int)np1.getY()] = counter++;

      //linked list stuff here
      bs.push(board);
      theView.look(bs.peek());
      try{Thread.sleep(1220);} catch(InterruptedException e) {}
      Point np2 = new Point(theDriver.find_move(np1, intArray));
      s.push(np2);
      board[(int)np2.getX()][(int)np2.getY()] = counter++;
      bs.push(board);
      theView.look(bs.peek());
      try{Thread.sleep(920);} catch(InterruptedException e) {}
      //lnked list action

      //Point p_save_for_tail = new Point();
      for (int r = 3; r < 32; r++)
      {
        np1.setLocation(np2);
        np2.setLocation(theDriver.find_move(np1, intArray));
        //p_save_for_tail = new Point(s.peek());
        s.push(np2);
        board[(int)np2.getX()][(int)np2.getY()] = r;
        //linked list stuff here
        bs.push(board);
        theView.look(bs.peek());
        try
        {
          //Thread.sleep(2000);
          Thread.sleep(350-5*r);
        }
        catch(InterruptedException e){}
      }

      LLnode preBase = new LLnode(s.peek());

      //public LLnode find_move(Point p, int[] nArray, Driver theDriver, LLnode base,
        //                      + Stack<Point> s, Stack<int[][]> bs, Stack<LLnode> ls)
      //{
      System.out.println("s.peek()" + s.peek().toString());
      System.out.println("np2 " + np2.toString());
      //looking for 32
      //int nCount = 0;
      //Brain theBrain = new Brain();
      LLnode base = theThink.find_move(s.peek(), theDriver, preBase, board, s, bs, ls);
      //first option from begin of 2nd half, point picked
      //board marked bs ls and s push
      theView.look(bs.peek());

      System.out.println("s.peek()" + s.peek().toString());
      System.out.println("np2 " + np2.toString());
      // done new LLnode(s.peek());
      // no ls.push(base);

      System.out.println("Size of ls stack is:     ***********     " + ls.size());
      // done board[base.get_x()][base.get_y()] = base.get_order_data();
      // done s.push(base.get_Point());
      //no more printing points to stack here
      System.out.println("Size of s stack is:     ***********     " + s.size());
      // done bs.push(board);
      System.out.println("Size of bs stack is:     ***********     " + bs.size());
      System.out.println("ls " + ls.toString());
      System.out.println(ls);
      System.out.println("ls  with peek"    + ls.peek());
      System.out.println("ls above ^\n\n\n");
      theView.look2(bs.peek());
      try{Thread.sleep(920);} catch(InterruptedException e) {}


      System.out.println("Size of ls stack is:     ***********     " + ls.size());

      System.out.println("Size of s stack is:     ***********     " + s.size());

      System.out.println("Size of bs stack is:     ***********     " + bs.size());

      LLnode Next_induct = new LLnode(theThink.next_move_node(ls.peek(), bs.peek(), theView, theThink, bs, ls));

      System.out.println("Size of ls stack is:     ***********     " + ls.size());

      System.out.println("Size of s stack is:     ***********     " + s.size());

      System.out.println("Stopped s.pop(Points), because my ADT \"LLnodes\" contain Point data");
      System.out.println("Size of bs stack is:     ***********     " + bs.size());


      for (int indexVal = ls.size(); indexVal < 32; indexVal++)
      {
        Next_induct = new LLnode(theThink.next_move_node(ls.peek(), bs.peek(), theView, theThink, bs, ls));
        //theView.look(bs.peek());
        try{Thread.sleep(320);} catch(InterruptedException e) {}

      }
      System.out.println("Size of ls stack is:     ***********     " + ls.size());

      System.out.println("Size of s stack is:     ***********     " + s.size());

      System.out.println("Stopped s.pop(Points), because my ADT \"LLnodes\" contain Point data");
      System.out.println("Size of bs stack is:     ***********     " + bs.size());

  //    public LLnode next_move_node(LLnode node_at, int[][] board, View theView, Think theThink, Stack<int[][]> bs, Stack<LLnode> ls)
//      {






      //while (theBrain.hasNextMove(base, bs.peek()))

//base move

//recursive move


/*

      LLnode next = new LLnode(theBrain.next_move_node(base, bs.peek()));
      ls.push(next);

      //board[next.get_x()][next.get_y()] = next.get_order_data();  //or 32
      board[next.get_x()][next.get_y()] = 32;  //or 32
      theView.look(bs.peek());
      try{Thread.sleep(920);} catch(InterruptedException e) {}
      bs.push(board);

      //need base set to next
      int[] indexArray = new int[8];
      int var = 32;
      int index;
      while (theBrain.hasNextMove(next, board))
      {
        nCount++;
        var++;
        base = new LLnode(next);
        next = new LLnode(theBrain.next_move_node(base, bs.peek()));
        ls.push(next);
        board[next.get_x()][next.get_y()] = var;
        theView.look(bs.peek());
        try{Thread.sleep(220);} catch(InterruptedException e) {}
        bs.push(board);
      }
      for (int xx = 0; xx < nCount; xx++)
      {
        //nCount--;
        //var--;
        indexArray = theBrain.moveArrayOptions(ls.peek(),bs.peek());
        index = theDriver.getIndex(indexArray, 0);
        int ja = theBrain.countArrayVals(indexArray);
        for (int px = 0; px < ja; px++)
        {
          bs.pop();
          theBrain.fakeMark(index, board, bs, ls);
          ls.pop();
          nCount--;
          var--;
          base = new LLnode(ls.peek().get_tail());
          //next = new LLnode(ls.peek())
          next = new LLnode(theBrain.next_move_node(base, bs.peek()));
          //base = new LLnode()
          ls.push(next);
          theBrain.unFake(index, board, bs, ls);
          board[next.get_x()][next.get_y()] = var;
          nCount++;
          var++;
          bs.push(board);
          theView.look(bs.peek());
          try{Thread.sleep(220);} catch(InterruptedException e) {}
          while (theBrain.hasNextMove(next, board))
          {
            nCount++;
            var++;
            base = new LLnode(ls.peek().get_tail());
            //next = new LLnode(ls.peek())
            next = new LLnode(theBrain.next_move_node(base, bs.peek()));
            //base = new LLnode()
            ls.push(next);
            board[next.get_x()][next.get_y()] = var;
            bs.push(board);
            theView.look(bs.peek());
            try{Thread.sleep(220);} catch(InterruptedException e) {}
          }
        }
      }



        //ok so trying 2nd branch





*/
/*
      System.out.println("Heuristics Terminated at Yellow 31,  " + np2 + "\n\nBeginning exhaustive search.\n");
      Point np3 = new Point(theDriver.find_move(s.peek(), intArray));
      System.out.println("   Starting from currently blinking 32, point:  " + np3 + "\n\n\n");


      //counter = 32

      //now i have got the first half through heuristics
      //time to build the head node

      //Point p, int d_counter, LLnode t
      // 1 arg for head node

      //s.push(np3);
      //board[(int)np2.getX()][(int)np2.getY()] = counter++;
      //bs.push(board);
      //theView.look(bs.peek());

      //LLnode from = new LLnode(s.peak());

      LLnode base = new LLnode(np3);

      board[base.get_x()][base.get_y()] = base.get_order_data();
      bs.push(board);
      theView.look2(bs.peek());
      System.out.println("\n\n Same above and below\n\n");
      theView.look(board);
      Brain theBrain = new Brain();
      if (theBrain.hasNextMove(base, bs.peek()))
      {
        LLnode next_LLnode = new LLnode(theBrain.next_move_node(base, bs.peek(), theBrain));
        //LLnode next_LLnode = new LLnode()
        //theBrain.
        board[next_LLnode.get_x()][next_LLnode.get_y()] = next_LLnode.get_order_data();
        bs.push(board);
        theView.look(bs.peek());
      }
      else{System.out.println("Done");}

      //board[next_LLnode.get_x()][next_LLnode.get_y()] = LLnode.get_order_data();

      //LLnode(Point p, int d_counter, LLnode t)

      //public LLnode next_move_node(LLnode node_at, int[][] board)
*/
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

      //should probably include board[i-2][j+1] == -1

      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1 && board[i-2][j+1] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1 && board[i-1][j+2] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j+2) && (j+2) < 8 && board[i][j] == -1 && board[i+1][j+2] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j+1) && (j+1) < 8 && board[i][j] == -1 && board[i+2][j+1] == -1) {count++;}
      if (0 <= (i+2) && (i+2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1 && board[i+2][j-1] == -1) {count++;}
      if (0 <= (i+1) && (i+1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1 && board[i+1][j-2] == -1) {count++;}
      if (0 <= (i-1) && (i-1) < 8 && 0 <= (j-2) && (j-2) < 8 && board[i][j] == -1 && board[i-1][j-2] == -1) {count++;}
      if (0 <= (i-2) && (i-2) < 8 && 0 <= (j-1) && (j-1) < 8 && board[i][j] == -1 && board[i-2][j-1] == -1) {count++;}

      return count;
  }

  public static int getIndex(int[] a, int j)
  {
  	for (int i = j; i < a.length; i++)
  		if (a[i] > 0)
  			return i;

  	return -1;
  }

}
