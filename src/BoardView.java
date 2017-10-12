import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.Stack;

/**
 * Created by jh on 9/26/17.
 */
public class BoardView
{
  private HBox r1 = new HBox();
  private HBox r2 = new HBox();
  private HBox r3 = new HBox();
  private HBox r4 = new HBox();
  private HBox r5 = new HBox();

  private String[][] playboard;

  BoardView(String[][] playboard)
  {
    this.playboard = playboard;
  }

  public HBox[] getBoard(int n)
  {
    HBox[] tmp = {r1, r2, r3, r4, r5};

    for (int r = 0; r < n; r++)
    {
      for (int c = 0; c < n; c++)
      {
        Button btn = new Button();
        btn.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/" + playboard[r][c].toLowerCase() + ".png"))));
        btn.setId(playboard[r][c]);
        btn.setPadding(new Insets(2, 2, 2, 2));

        tmp[r].getChildren().add(btn);
      }
    }

    for (int i = 0; i < n; i++)
    {
      tmp[i].setPrefWidth(Controller.WINDOW_WIDTH);
      tmp[i].setPrefHeight(45);
      tmp[i].setAlignment(Pos.CENTER);
      tmp[i].setSpacing(2);
    }

    return tmp;
  }

  public void paint(Node node)
  {
    node.setEffect(new SepiaTone());
  }

  public String removeAllPaint(Stack<Node> stack)
  {
    String bucket = "";

    for (int i = stack.size() - 1; i >= 0; i--)
    {
      Node tmp = stack.pop();
      tmp.setEffect(null);

      bucket += tmp.getId();
    }
    return bucket;
  }



  public boolean addNode(Node node, Stack<Node> stack)
  {
    if (stack.size() == 0 || !stack.lastElement().equals(node))
    {
      if (stack.contains(node)) return false;
      stack.add(node);

      return true;
    }

    return true;
  }

  public String flipWord(String s)
  {
    String flipped = "";

    for (int i = s.length() - 1; i > 0; i--)
    {
      flipped += s.substring(i, i + 1);
      if (i == 1) flipped += s.substring(0, 1);
    }

    return flipped;
  }

  public boolean checkBoundary(MouseEvent event, HBox[] hBox, int lastIndex)
  {
    if(event.getEventType().getName().equals("MOUSE-DRAG_OVER"))
    {
      if (event.getX() < hBox[0].getChildren().get(0).getLayoutX() ||
              event.getX() > (hBox[0].getChildren().get(lastIndex).getLayoutX() + 45) ||
              event.getY() < hBox[0].getBoundsInParent().getMinY() ||
              event.getY() > hBox[lastIndex].getBoundsInParent().getMaxY())
      {
//        System.out.println("What am I missing? " + event.getX() + "," + event.getY());
//        double tmp = hBox[0].getChildren().get(lastIndex).getLayoutX() + 46;
//        System.out.println(hBox[0].getChildren().get(0).getLayoutX()  + "," + tmp
//        + "," + hBox[0].getBoundsInParent().getMinY()  + "," + hBox[lastIndex].getBoundsInParent().getMaxY());
        return false;
      }
      return true;
    }
    return true;
  }

}
