import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by jh on 9/29/17.
 */
public class ScoreView
{
  private Text scoreLbl;
  private Text scoreVal;


  public ScoreView()
  {
    scoreLbl = new Text();
    scoreVal = new Text();

    scoreLbl.setFont(Font.font("Arial Red", FontWeight.BLACK, 20));
    scoreLbl.setTextAlignment(TextAlignment.CENTER);
    scoreLbl.setWrappingWidth(55);
    scoreLbl.setText("Score");

    scoreVal.setFont(Font.font("Arial Red", FontWeight.BLACK, 20));
    scoreVal.setTextAlignment(TextAlignment.CENTER);
    scoreVal.setWrappingWidth(55);
    scoreVal.setText("0");
  }

  public void update(int updatedScore)
  {
    scoreVal.setText(Integer.toString(updatedScore));
  }

  public Text getLabel()
  {
    return this.scoreLbl;
  }

  public Text getValue()
  {
    return this.scoreVal;
  }


  public void resetScoreView()
  {
    this.scoreVal.setText("0");
  }
}
