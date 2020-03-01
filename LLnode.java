import java.io.*;
import java.util.*;
import java.awt.Point;

public class LLnode
{
  private Point pCoords;
  private int order_data;
  private LLnode tail_LLnode;
  private int x;
  private int y;
  Boolean head_bool;
  Boolean end_bool;

  LLnode()
  {
    pCoords = null;
    order_data = -1;
    tail_LLnode = null;
    int x = 0;
    int y = 0;
    head_bool = false;
    end_bool = false;
  }

  LLnode(Point p, LLnode t)
  {
    pCoords = p;
    order_data = 1 + t.get_order_data();
    head_bool = false;
    if (order_data == 63)
    {
      end_bool = true;
    }
    else
    {
      end_bool = false;
    }
    tail_LLnode = t;
    x = (int)p.getX();
    y = (int)p.getY();
  }

  LLnode(LLnode l)
  {
    pCoords = l.get_Point();
    order_data = l.get_order_data();
    head_bool = false;
    if (order_data == 63)
    {
      end_bool = true;
    }
    else
    {
      end_bool = false;
    }
    tail_LLnode = l.get_tail();
    x = (int)pCoords.getX();
    y = (int)pCoords.getY();
  }

//head node
  LLnode(Point p)
  {
    pCoords = p;
    order_data = 31;
    tail_LLnode = null;
    x = (int)p.getX();
    y = (int)p.getY();
    Boolean head_bool = true;
    Boolean end_bool = false;
  }

  public int get_order_data()
  {
    return order_data;
  }

  public String toString()
  {
    return pCoords.toString();
  }

  public Point get_Point()
  {
    return pCoords;
  }

  public LLnode get_tail()
  {
    return tail_LLnode;
  }

  public int get_x()
  {
    return (int)pCoords.getX();
  }

  public int get_y()
  {
    return (int)pCoords.getY();
  }
}
