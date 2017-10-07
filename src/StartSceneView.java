import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by jh on 10/1/17.
 */
public class StartSceneView
{
  private VBox vBox = new VBox();
  private HBox desc = new HBox();
  private HBox hBox4x4 = new HBox();
  private HBox hBox5x5 = new HBox();

  private Text descText = new Text();
  private Button btn4x4 = new Button();
  private Button btn5x5 = new Button();

  public StartSceneView()
  {
    descText.setFont(Font.font("Arial", FontWeight.BLACK, 30));
    descText.setTextAlignment(TextAlignment.CENTER);
    descText.setWrappingWidth(Controller.WINDOW_WIDTH);
    descText.setText("Choose a Board");

    btn4x4.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/4x4.png"))));
    btn4x4.setId("4");
    btn4x4.setPadding(new Insets(2, 2, 2, 2));

    btn5x5.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/5x5.png"))));
    btn5x5.setId("5");
    btn5x5.setPadding(new Insets(2, 2, 2, 2));

    desc.getChildren().add(descText);
    hBox4x4.getChildren().add(btn4x4);
    hBox5x5.getChildren().add(btn5x5);

    desc.setPrefWidth(Controller.WINDOW_WIDTH);
    desc.setPrefHeight(45);
    desc.setAlignment(Pos.CENTER);

    hBox4x4.setPrefWidth(Controller.WINDOW_WIDTH);
    hBox4x4.setPrefHeight(45);
    hBox4x4.setAlignment(Pos.CENTER);

    hBox5x5.setPrefWidth(Controller.WINDOW_WIDTH);
    hBox5x5.setPrefHeight(45);
    hBox5x5.setAlignment(Pos.CENTER);

    vBox.getChildren().addAll(desc, hBox4x4, hBox5x5);
    vBox.setMargin(desc, new Insets(120, 0, 20, 0));
    vBox.setMargin(hBox4x4, new Insets(0, 0, 7, 0));
  }

  public VBox getStartSceneVBox()
  {
    return this.vBox;
  }

  public Button[] getBtnArr()
  {
    Button[] btnArr = {btn4x4, btn5x5};

    return btnArr;
  }
}
