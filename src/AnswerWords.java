import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jh on 10/8/17.
 */
public class AnswerWords extends Nodes
{
  private Dictionary dictionary = new Dictionary();
  private ArrayList<String> found = new ArrayList<>();
  private Stack<NodeElement> stack = new Stack<>();
  private Nodes nodes;


  public AnswerWords(String[][] board)
  {
    nodes = new Nodes(board);
  }

  public Nodes getNodes()
  {
    return this.nodes;
  }



  public void findAnswer(NodeElement node)
  {
    if (stack.contains(node)) return;
    else
    {
      stack.add(node);
      String word = "";
      for(int i = 0; i < stack.size(); i++)
      {
        word += stack.get(i).getData();
      }
      if (stack.size() > 2)
      {
        if (dictionary.findWordHash(word.toLowerCase()))
        {
          if (!found.contains(word))
          {
            System.out.println("We found " + word + " !");
            found.add(word);
          }
        }
        else
        {
          System.out.println("There is no " + word + " ...");
          stack.pop();
          return;
        }
      }
    }


    ArrayList<NodeElement> neighbors = node.getNeighbors();
    String ne = "";
    for(int i = 0; i < neighbors.size(); i++)
    {
      ne += neighbors.get(i).getData();
      ne += ",";
    }

    for (int i = 0; i < neighbors.size(); i++)
    {
      findAnswer(neighbors.get(i));
      if (i == neighbors.size()-1)
      {
        stack.pop();
      }
    }
  }

  public int getFoundSize()
  {
    return this.found.size();
  }

  public ArrayList<String> getFound()
  {
//    String[] anwser = new String[this.found.size()];
//    for(int i = 0; i < this.found.size(); i++)
//    {
//      anwser[i] = this.found.get(i);
//    }

    return this.found;
  }

}
