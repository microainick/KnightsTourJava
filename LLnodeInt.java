public class LLnodeInt
{
  //Point pCord; 
  int data;
  LLnodeInt tail;

  LLnodeInt(int d, LLnodeInt t)
  {
    //p = point;
    data = d;
    tail = t;
  }

  public String toString()
  {
    return data + " ";
  }

}
