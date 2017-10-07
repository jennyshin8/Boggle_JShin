import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

public class Main
{

  public static void main(String[] args)
  {
    Application.launch(new Controller().getClass());

/**************
    int n = 4;
    Board tree = new Board(n);
    String[][] treeArr = tree.getBoggleArr();
    ArrayList<Tree.Node<String>> arrayList = new ArrayList<>();
    for(int r = 0; r < n; r++)
    {
      for(int j = 0; j < n; j++)
      {
        String coord = Integer.toString(r) + Integer.toString(j);
        Tree.Node<String> node = new Tree.Node<String>(coord, treeArr[r][j]);
        arrayList.add(node);
      }
    }

    for(int i = 0; i < 4*4; i++)
    {
      if(i<n)
      {
        if(i%n == 0)
        {
          arrayList.get(i).setChildren(arrayList.get(i+1));
          arrayList.get(i).setChildren(arrayList.get(n+(i+1)));
          arrayList.get(i).setChildren(arrayList.get(i+n));
        }
        else if(i%n == (n-1))
        {
          arrayList.get(i).setChildren(arrayList.get(i-1));
          arrayList.get(i).setChildren(arrayList.get(n+(i-1)));
          arrayList.get(i).setChildren(arrayList.get(i+n));
        }
        else
        {
          arrayList.get(i).setChildren(arrayList.get(i-1));
          arrayList.get(i).setChildren(arrayList.get(i+1));
          arrayList.get(i).setChildren(arrayList.get(n+(i+1)));
          arrayList.get(i).setChildren(arrayList.get(n+i));
          arrayList.get(i).setChildren(arrayList.get(n+i-1));
        }
      }
      else if (i+n >= n*n)
      {
        if(i%n == 0)
        {
          arrayList.get(i).setChildren(arrayList.get(i-n));
          arrayList.get(i).setChildren(arrayList.get((i-n)+1));
          arrayList.get(i).setChildren(arrayList.get(i+1));
        }
        else if(i%n == (n-1))
        {
          arrayList.get(i).setChildren(arrayList.get(i-n));
          arrayList.get(i).setChildren(arrayList.get((i-n)-1));
          arrayList.get(i).setChildren(arrayList.get(i-1));
        }
        else
        {
          arrayList.get(i).setChildren(arrayList.get((i-n)-1));
          arrayList.get(i).setChildren(arrayList.get((i-n)));
          arrayList.get(i).setChildren(arrayList.get((i-n)+1));
          arrayList.get(i).setChildren(arrayList.get((i-1)));
          arrayList.get(i).setChildren(arrayList.get((i+1)));
        }
      }
      else
      {
        if(i%n == 0)
        {
          arrayList.get(i).setChildren(arrayList.get((i-n)));
          arrayList.get(i).setChildren(arrayList.get((i-n)+1));
          arrayList.get(i).setChildren(arrayList.get((i)+1));
          arrayList.get(i).setChildren(arrayList.get((i+n)+1));
          arrayList.get(i).setChildren(arrayList.get((i+n)));

        }
        else if(i%n == (n-1))
        {
          arrayList.get(i).setChildren(arrayList.get((i-n)));
          arrayList.get(i).setChildren(arrayList.get((i-n)-1));
          arrayList.get(i).setChildren(arrayList.get((i)-1));
          arrayList.get(i).setChildren(arrayList.get((i+n)-1));
          arrayList.get(i).setChildren(arrayList.get((i+n)));
        }
        else
        {
          arrayList.get(i).setChildren(arrayList.get((i-n)-1));
          arrayList.get(i).setChildren(arrayList.get((i-n)));
          arrayList.get(i).setChildren(arrayList.get((i-n)+1));
          arrayList.get(i).setChildren(arrayList.get((i)-1));
          arrayList.get(i).setChildren(arrayList.get((i)+1));
          arrayList.get(i).setChildren(arrayList.get((i+n)-1));
          arrayList.get(i).setChildren(arrayList.get((i+n)));
          arrayList.get(i).setChildren(arrayList.get((i+n)+1));
        }
      }
    }

    for(int i=0; i < n*n; i++)
    {
      System.out.println("***** " + arrayList.get(i).getCoordinate() + "," + arrayList.get(i).getData() + " *****");
      for(int c = 0; c < arrayList.get(i).getChildren().size(); c++)
      {
        Tree.Node<String> tmp = arrayList.get(i).getChild(c);
        System.out.println(tmp.getCoordinate() + " : " + tmp.getData());
      }
    }

    Tree.Node<String> first = arrayList.get(0);
    System.out.println(first.recursive(first));














    // Plant root
    Tree<String> boggleTree = new Tree<>(arrayList.get(0));
    Tree.Node<String> node = new Tree.Node<>("00", treeArr[0][0]);
**********/

  }
}


