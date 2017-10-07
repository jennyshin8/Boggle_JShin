import java.util.ArrayList;

/**
 * Created by jh on 10/6/17.
 */
public class Tree<T>
{
  private Node<T> root;

  public Tree(Node<T> root)
  {
    this.root = root;
  }

  public Tree(String coord, T rootData)
  {
    root = new Node<T>(coord, rootData);
  }

  public static class Node<T>
  {
    private String coordinate;
    private T data;
    private Node<T> parent;
    private ArrayList<Node<T>> children;
    public String word = "";
    private Dictionary dict = new Dictionary();

    public Node()
    {

    }

    public Node(String coordinate, T nodeDate)
    {
      this.coordinate = coordinate;
      this.data = nodeDate;

      this.children = new ArrayList<Node<T>>();
      this.parent = new Node<T>();
    }

    public void setParent(Node<T> parent)
    {
      this.parent = parent;
    }

    public Node<T> getParent()
    {
      return this.parent;
    }

    public void setChildren(Node<T> child)
    {
      this.children.add(child);
    }

    public ArrayList<Node<T>> getChildren()
    {
      return this.children;
    }

    public Node<T> getChild(int i)
    {
      return this.children.get(i);
    }

    public String getCoordinate()
    {
      return this.coordinate;
    }

    public T getData()
    {
      return this.data;
    }

    public T recursive(Node<T> node)
    {
      Node<T> child;
      word += node.getData();
      for (int i = 0; i < node.getChildren().size(); i++)
      {
        child = node.getChild(i);
        if(node.getParent().equals(child) || (word.length()>2 && !dict.findWord(word)))
        {
          if(word.length()>2) word = word.substring(0, word.length()-2);
          continue;
        }
        System.out.println(node.getCoordinate() + " : " + node.getData() + " => " + child.getCoordinate() + " : " + child.getData());
        System.out.println(word);
        child.setParent(node);
        recursive(child);
      }
      return node.getData();
    }
  }


}