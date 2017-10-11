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
//    finalScore.setTextAlignment(TextAlignment.CENTER);
    finalScore.setWrappingWidth(Controller.WINDOW_WIDTH-50);
//    finalScore.setText("Final score is ");

    score.getChildren().add(finalScore);


    answerDescR.setFont(Font.font("Arial", FontWeight.BLACK, 24));
//    answerDescR.setTextAlignment(TextAlignment.CENTER);
    answerDescR.setWrappingWidth(Controller.WINDOW_WIDTH-50);
    answerDescR.setText("You've Got");

    answerRight.setFont(Font.font("Arial", FontWeight.BLACK, 16));
//    answerRight.setTextAlignment(TextAlignment.CENTER);
    answerRight.setWrappingWidth(Controller.WINDOW_WIDTH-100);
    answerRight.setFill(Color.BLACK);
    answerRight.setText("");


    answerDescM.setFont(Font.font("Arial", FontWeight.BLACK, 24));
//    answerDescM.setTextAlignment(TextAlignment.CENTER);
    answerDescM.setWrappingWidth(Controller.WINDOW_WIDTH-50);
    answerDescM.setText("You've missed");

    answerMissed.setFont(Font.font("Arial", FontWeight.BLACK, 16));
//    answerMissed.setTextAlignment(TextAlignment.CENTER);
    answerMissed.setWrappingWidth(Controller.WINDOW_WIDTH-100);
    answerMissed.setFill(Color.RED);
    answerMissed.setText("");

    answerDR.getChildren().add(answerDescR);
    answerR.getChildren().add(answerRight);
    answerDM.getChildren().add(answerDescM);
    answerM.getChildren().add(answerMissed);

    playMoreDesc.setFont(Font.font("Arial", FontWeight.BLACK, 30));
//    playMoreDesc.setTextAlignment(TextAlignment.CENTER);
    playMoreDesc.setWrappingWidth(Controller.WINDOW_WIDTH-50);
    playMoreDesc.setText("Wanna Play More?");

    playMore.getChildren().add(playMoreDesc);

    btnYes.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/yes.png"))));
    btnYes.setId("yes");
    btnYes.setPadding(new Insets(2, 2, 2, 2));

    btnNo.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resource/no.png"))));
    btnNo.setId("no");
    btnNo.setPadding(new Insets(2, 2, 2, 2));

    btns.getChildren().addAll(btnYes, btnNo);
    btns.setSpacing(10);

    score.setPrefWidth(Controller.WINDOW_WIDTH-50);
    score.setPrefHeight(45);
    score.setAlignment(Pos.CENTER_LEFT);

    answerDR.setPrefWidth(Controller.WINDOW_WIDTH-50);
    answerDR.setAlignment(Pos.CENTER_LEFT);

    answerR.setPrefWidth(Controller.WINDOW_WIDTH-100);
    answerR.setAlignment(Pos.CENTER_LEFT);

    answerDM.setPrefWidth(Controller.WINDOW_WIDTH-50);
    answerDM.setAlignment(Pos.CENTER_LEFT);

    answerM.setPrefWidth(Controller.WINDOW_WIDTH-100);
    answerM.setAlignment(Pos.CENTER_LEFT);

    playMore.setPrefWidth(Controller.WINDOW_WIDTH-50);
    playMore.setPrefHeight(45);
    playMore.setAlignment(Pos.CENTER_LEFT);

    btns.setPrefWidth(Controller.WINDOW_WIDTH-50);
    btns.setPrefHeight(45);
    btns.setAlignment(Pos.CENTER_LEFT);

    vBox.getChildren().addAll(score, answerDR, answerR, answerDM, answerM, playMore, btns);

  }

  public VBox getEndingSceneVBox(int score, ArrayList<String> userFound, ArrayList<String> answerWords)
  {
    this.finalScore.setText("Final score is " + Integer.toString(score));


    int countRight = 0, countMissed = 0;
    for(int i = 0; i < answerWords.size(); i ++)
    {
      if(userFound.contains(answerWords.get(i)))
      {
        countRight++;
        if (countRight < 30) answerRight.setText(answerRight.getText() + " " + answerWords.get(i)); // 29
      }
      else
      {
        countMissed++;
        if (countMissed < 30) answerMissed.setText(answerMissed.getText() + " " + answerWords.get(i)); // 29
      }
    }

    if (countRight >= 30)
    {
      if (countRight == 30) answerRight.setText(answerRight.getText() + "\n... MORE " + (countRight - 29) + " WORD!");
      else answerRight.setText(answerRight.getText() + "\n... MORE " + (countRight - 29) + " WORDS!");
    }
    if (countMissed >= 30)
    {
      if (countMissed == 30) answerMissed.setText(answerMissed.getText() + "\n... MORE " + (countMissed - 29) + " WORD!");
      else answerMissed.setText(answerMissed.getText() + "\n... MORE " + (countMissed - 29) + " WORDS!");
    }
    Double rightH = this.answerRight.getBoundsInParent().getHeight();
    Double rightM = this.answerMissed.getBoundsInParent().getHeight();

    Double val = (95 - (rightH+rightM)/2);
    if (val < 10) val = 10.0;

    vBox.setMargin(this.score, new Insets(val, 0, 20, 50));
    vBox.setMargin(answerDR, new Insets(15, 0, 0, 50));
    vBox.setMargin(answerR, new Insets(0, 0, 0, 50));
    vBox.setMargin(answerDM, new Insets(5, 0, 0, 50));
    vBox.setMargin(answerM, new Insets(5, 0, 0, 50));
    vBox.setMargin(playMore, new Insets(30, 0, 5, 50));
    vBox.setMargin(btns, new Insets(0, 0, 0, 50));
    return this.vBox;
  }

  public Button[] getBtnArr()
  {
    Button[] btnArr = {btnYes, btnNo};
    return btnArr;
  }

  public void resetAnswers()
  {
    this.answerRight.setText("");
    this.answerMissed.setText("");
  }
}
