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
public class EndingSceneView
{
  private VBox vBox = new VBox();
  private HBox score = new HBox();
  private HBox playMore = new HBox();
  private HBox btns = new HBox();

  private Text finalScore = new Text();
  private Text playMoreDesc = new Text();
  private Button btnYes = new Button();
  private Button btnNo = new Button();

  public EndingSceneView()
  {
    finalScore.setFont(Font.font("Arial", FontWeight.BLACK, 30));
    finalScore.setTextAlignment(TextAlignment.CENTER);
    finalScore.setWrappingWidth(Controller.WINDOW_WIDTH);
    finalScore.setText("Your final score is ");

    score.getChildren().add(finalScore);

    playMoreDesc.setFont(Font.font("Arial", FontWeight.BLACK, 30));
    playMoreDesc.setTextAlignment(TextAlignment.CENTER);
    playMoreDesc.setWrappingWidth(Controller.WINDOW_WIDTH);
    playMoreDesc.setText("You Wanna Play More?");

    playMore.getChildren().add(playMoreDesc);

    btnYes.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/yes.png"))));
    btnYes.setId("yes");
    btnYes.setPadding(new Insets(2, 2, 2, 2));

    btnNo.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/no.png"))));
    btnNo.setId("no");
    btnNo.setPadding(new Insets(2, 2, 2, 2));

    btns.getChildren().addAll(btnYes, btnNo);
    btns.setSpacing(10);

    score.setPrefWidth(Controller.WINDOW_WIDTH);
    score.setPrefHeight(45);
    score.setAlignment(Pos.CENTER);

    playMore.setPrefWidth(Controller.WINDOW_WIDTH);
    playMore.setPrefHeight(45);
    playMore.setAlignment(Pos.CENTER);

    btns.setPrefWidth(Controller.WINDOW_WIDTH);
    btns.setPrefHeight(45);
    btns.setAlignment(Pos.CENTER);

    vBox.getChildren().addAll(score, playMore, btns);
    vBox.setMargin(score, new Insets(150, 0, 50, 0));
    vBox.setMargin(btns, new Insets(0, 0, 7, 0));
  }

  public VBox getEndingSceneVBox(int score)
  {
    this.finalScore.setText("Your final score is " + Integer.toString(score));

    return this.vBox;
  }

  public Button[] getBtnArr()
  {
    Button[] btnArr = {btnYes, btnNo};

    return btnArr;
  }
}
