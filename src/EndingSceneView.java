import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * Created by jh on 10/1/17.
 */
public class EndingSceneView
{
  private VBox vBox = new VBox();
  private HBox score = new HBox();
  private HBox answerDR = new HBox();
  private VBox answerR = new VBox();
  private HBox answerDM = new HBox();
  private VBox answerM = new VBox();
  private HBox playMore = new HBox();
  private HBox btns = new HBox();

  private Text finalScore = new Text();
  private Text answerDescR = new Text();
  private Text answerRight = new Text();
  private Text answerDescM = new Text();
  private Text answerMissed = new Text();
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


    answerDescR.setFont(Font.font("Arial", FontWeight.BLACK, 30));
    answerDescR.setTextAlignment(TextAlignment.CENTER);
    answerDescR.setWrappingWidth(Controller.WINDOW_WIDTH);
    answerDescR.setText("You've Got");

    answerRight.setFont(Font.font("Arial", FontWeight.BLACK, 16));
    answerRight.setTextAlignment(TextAlignment.CENTER);
    answerRight.setWrappingWidth(Controller.WINDOW_WIDTH);
    answerRight.setFill(Color.BLACK);
    answerRight.setText("");


    answerDescM.setFont(Font.font("Arial", FontWeight.BLACK, 30));
    answerDescM.setTextAlignment(TextAlignment.CENTER);
    answerDescM.setWrappingWidth(Controller.WINDOW_WIDTH);
    answerDescM.setText("You've missed");

    answerMissed.setFont(Font.font("Arial", FontWeight.BLACK, 16));
    answerMissed.setTextAlignment(TextAlignment.CENTER);
    answerMissed.setWrappingWidth(Controller.WINDOW_WIDTH);
    answerMissed.setFill(Color.RED);
    answerMissed.setText("");

    answerDR.getChildren().add(answerDescR);
    answerR.getChildren().add(answerRight);
    answerDM.getChildren().add(answerDescM);
    answerM.getChildren().add(answerMissed);

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

    answerDR.setPrefWidth(Controller.WINDOW_WIDTH);
//    answerDR.setPrefHeight(45);
    answerDR.setAlignment(Pos.CENTER);

    answerR.setPrefWidth(Controller.WINDOW_WIDTH);
//    answerR.setPrefHeight(45);
    answerR.setAlignment(Pos.CENTER);

    answerDM.setPrefWidth(Controller.WINDOW_WIDTH);
//    answerDM.setPrefHeight(45);
    answerDM.setAlignment(Pos.CENTER);

    answerM.setPrefWidth(Controller.WINDOW_WIDTH);
//    answerM.setPrefHeight(45);
    answerM.setAlignment(Pos.CENTER);

    playMore.setPrefWidth(Controller.WINDOW_WIDTH);
    playMore.setPrefHeight(45);
    playMore.setAlignment(Pos.CENTER);

    btns.setPrefWidth(Controller.WINDOW_WIDTH);
    btns.setPrefHeight(45);
    btns.setAlignment(Pos.CENTER);

    vBox.getChildren().addAll(score, answerDR, answerR, answerDM, answerM, playMore, btns);
    vBox.setMargin(score, new Insets(80, 0, 0, 0));
    vBox.setMargin(answerDR, new Insets(15, 0, 0, 0));
    vBox.setMargin(answerR, new Insets(5, 0, 0, 0));
    vBox.setMargin(answerDM, new Insets(10, 0, 0, 0));
    vBox.setMargin(answerM, new Insets(5, 0, 30, 0));
    vBox.setMargin(btns, new Insets(0, 0, 7, 0));
  }

  public VBox getEndingSceneVBox(int score, ArrayList<String> userFound, ArrayList<String> answerWords)
  {
    this.finalScore.setText("Your final score is " + Integer.toString(score));

    for(int i = 0; i < answerWords.size(); i ++)
    {
      if(userFound.contains(answerWords.get(i)))
      {
        answerRight.setText(answerRight.getText() + " " + answerWords.get(i));
      }
      else
      {
        answerMissed.setText(answerMissed.getText() + " " + answerWords.get(i));
      }
    }

    return this.vBox;
  }

  public Button[] getBtnArr()
  {
    Button[] btnArr = {btnYes, btnNo};

    return btnArr;
  }
}
