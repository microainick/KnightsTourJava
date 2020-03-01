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
  public static Stack<LLnode> ls = new Stack<LLnode>(); //LLnode stack
  public static Stack<Point> ips = new Stack<Point>(); //initial position Stack

    public static void main(String[] args) {
      Driver theDriver = new Driver();
      View theView = new View();
      Think theThink = new Think();
      Scanner scuba = new Scanner(System.in);
      Show theShow = new Show();
      Prompt thePrompt = new Prompt();


      System.out.println("\n\n            Knights Tour by Nicholas Marien\n\n");
      System.out.println("\nA black background or dark theme works the best for this demo!\n\n");
      System.out.println("Shall I set that for you now? Enter y for yes.");


      char inputAnswer = scuba.next().charAt(0);
      if (inputAnswer == 'y' || inputAnswer == 'Y')
      {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Awesome!");
      }
      try{Thread.sleep(720);} catch(InterruptedException e) {}


      int cycle = thePrompt.get_IPV_num();
      thePrompt.display();
      thePrompt.message();
      Point pip = new Point();
      for (int indexP = cycle; indexP > 0; indexP--)
      {
        System.out.println("\n\nPositions for iteration # " + indexP + " Please:  \n\n");
        int y = thePrompt.askY();
        int x = thePrompt.askX();
        pip = new Point(x,y);
        ips.push(pip);
      }
      Point top = new Point();
      Point np1 = new Point();
      Point np2 = new Point();
      LLnode Next_induct = new LLnode();
      int counter = 0;
      for (int ic = 0; ic < cycle; ic++)
      {
        top = new Point(ips.pop());
        s.push(top);

        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            board[i][j] = -1;
          }
        }

        counter = 0;
        board[(int)top.getX()][(int)top.getY()] = counter++;
        bs.push(board);

        theShow.show(top);
        System.out.println("\n\n\nPress a key\n");
        System.out.println("Then Press Enter to view!");
        scuba.next();
        System.out.println(" ");
        theView.look(bs.peek());

        //I made np1 and two seperately because I thought it would be cool to
        //use them for consecutive initial positions.
        np1 = new Point(theDriver.find_move(top, intArray));
        s.push(np1);
        board[(int)np1.getX()][(int)np1.getY()] = counter++;
        bs.push(board);
        theView.look(bs.peek());
        try{Thread.sleep(1220);} catch(InterruptedException e) {}

        np2 = new Point(theDriver.find_move(np1, intArray));
        s.push(np2);
        board[(int)np2.getX()][(int)np2.getY()] = counter++;
        bs.push(board);
        theView.look(bs.peek());
        try{Thread.sleep(920);} catch(InterruptedException e) {}

        for (int r = 3; r < 32; r++)
        {
          np1.setLocation(np2);
          np2.setLocation(theDriver.find_move(np1, intArray));
          s.push(np2);
          board[(int)np2.getX()][(int)np2.getY()] = r;
          bs.push(board);
          theView.look(bs.peek());
          try
          {Thread.sleep(350-5*r);}catch(InterruptedException e){}
        }

        LLnode preBase = new LLnode(s.peek());
        LLnode base = theThink.find_move(s.peek(), theDriver, preBase, board, s, bs, ls);
        //first option from begin of 2nd half, point picked
        theView.look(bs.peek());
        try{Thread.sleep(720);} catch(InterruptedException e) {}
        Next_induct = new LLnode(theThink.next_move_node(ls.peek(), bs.peek(), theView, theThink, bs, ls, s));

        for (int indexVal = ls.size(); indexVal < 32; indexVal++)
        {
          Next_induct = new LLnode(theThink.next_move_node(ls.peek(), bs.peek(), theView, theThink, bs, ls, s));
          try{Thread.sleep(320);} catch(InterruptedException e) {}
        }

    ls.clear();
    s.clear();
    bs.clear();

  } //for loop
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
