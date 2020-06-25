package Composite;

public class Position {

	  private int x;

	  private int y;

	  public Position(int x, int y)
	  {
	    this.setX(x);
	    this.setY(y);
	  }

	  public void setX(int x)
	  {
	    this.x = x;
	  }

	  public int getX()
	  {
	    return x;
	  }

	  public void setY(int y)
	  {
	    this.y = y;
	  }

	  public int getY()
	  {
	    return y;
	  }
	  
	  @Override
	  public boolean equals(Object obj) 
	  {
	    boolean res = false;
	    if (obj instanceof Position) 
	    {
	      Position p = (Position) obj;
	      if (this.getX() == p.getX()) 
	      {
	        if (this.getY() == p.getY()) 
	        {
	          res = true;
	        }
	      }
	    }
	    return res;
	  }
}
