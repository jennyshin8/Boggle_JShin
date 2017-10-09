import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jh on 10/7/17.
 */
public class Nodes
{
  private String[][] board;
  private int n;
  private ArrayList<NodeElement> nodeList = new ArrayList<>();

  public Nodes()
  {
  }

  public Nodes(String[][] board)
  {
    this.board = board;
    this.n = board.length;

    for(int i = 0; i < n; i++)
    {
      for(int j = 0; j < n; j++)
      {
        NodeElement node = new NodeElement(board[i][j]);
        this.nodeList.add(node);
      }
    }

    setNodeNeighbors();
  }

  public void setNodeNeighbors()
  {
    for(int i = 0; i < n*n; i++)
    {
      if(i<n)
      {
        if(i%n == 0)
        {
          nodeList.get(i).setNeighbor(nodeList.get(i+1));
          nodeList.get(i).setNeighbor(nodeList.get(n+(i+1)));
          nodeList.get(i).setNeighbor(nodeList.get(i+n));
        }
        else if(i%n == (n-1))
        {
          nodeList.get(i).setNeighbor(nodeList.get(i-1));
          nodeList.get(i).setNeighbor(nodeList.get(n+(i-1)));
          nodeList.get(i).setNeighbor(nodeList.get(i+n));
        }
        else
        {
          nodeList.get(i).setNeighbor(nodeList.get(i-1));
          nodeList.get(i).setNeighbor(nodeList.get(i+1));
          nodeList.get(i).setNeighbor(nodeList.get(n+(i+1)));
          nodeList.get(i).setNeighbor(nodeList.get(n+i));
          nodeList.get(i).setNeighbor(nodeList.get(n+i-1));
        }
      }
      else if (i+n >= n*n)
      {
        if(i%n == 0)
        {
          nodeList.get(i).setNeighbor(nodeList.get(i-n));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)+1));
          nodeList.get(i).setNeighbor(nodeList.get(i+1));
        }
        else if(i%n == (n-1))
        {
          nodeList.get(i).setNeighbor(nodeList.get(i-n));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)-1));
          nodeList.get(i).setNeighbor(nodeList.get(i-1));
        }
        else
        {
          nodeList.get(i).setNeighbor(nodeList.get((i-n)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i-1)));
          nodeList.get(i).setNeighbor(nodeList.get((i+1)));
        }
      }
      else
      {
        if(i%n == 0)
        {
          nodeList.get(i).setNeighbor(nodeList.get((i-n)));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)));

        }
        else if(i%n == (n-1))
        {
          nodeList.get(i).setNeighbor(nodeList.get((i-n)));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)));
        }
        else
        {
          nodeList.get(i).setNeighbor(nodeList.get((i-n)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)));
          nodeList.get(i).setNeighbor(nodeList.get((i-n)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i)+1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)-1));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)));
          nodeList.get(i).setNeighbor(nodeList.get((i+n)+1));
        }
      }
    }
  }

  public NodeElement getNode(int i)
  {
    return this.nodeList.get(i);
  }
  public class NodeElement
  {
    private String data;
    private ArrayList<NodeElement> neighbors;

    public NodeElement(String data)
    {
      this.data = data;
      this.neighbors = new ArrayList<>();
    }

    public String getData()
    {
      return this.data;
    }

    public void setNeighbor(NodeElement neighbor)
    {
      this.neighbors.add(neighbor);
    }

    public NodeElement getNeighbor(int i)
    {
      return this.neighbors.get(i);
    }

    public ArrayList<NodeElement> getNeighbors()
    {
      return this.neighbors;
    }

  }

}
