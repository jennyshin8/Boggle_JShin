import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by jh on 9/26/17.
 */
public class WordListView
{
  private Text wordLbl;
  private Text wordVal;

  public WordListView()
  {
    wordLbl = new Text();
    wordVal = new Text();

    wordLbl.setFont(Font.font("Arial Red", FontWeight.BLACK, 20));
    wordLbl.setTextAlignment(TextAlignment.LEFT);
    wordLbl.setWrappingWidth(Controller.WINDOW_WIDTH);
    wordLbl.setText("Not Allowed");

    wordVal.setFont(Font.font("Arial Red", FontWeight.BLACK, 20));
    wordVal.setTextAlignment(TextAlignment.LEFT);
    wordVal.setWrappingWidth(Controller.WINDOW_WIDTH);
    wordVal.setFill(Color.valueOf("#e60000"));
  }

  public void update(String wrongWord) { wordVal.setText(wordVal.getText() + " " + wrongWord); }

  public Text getLabel()
  {
    return this.wordLbl;
  }

  public Text getValue()
  {
    return this.wordVal;
  }

  public void warning(String msg)
  {
    wordLbl.setTextAlignment(TextAlignment.CENTER);
    wordLbl.setFill(Color.valueOf("#e60000"));
    wordLbl.setText(msg);
  }

  public void encourage(String msg)
  {
    wordLbl.setTextAlignment(TextAlignment.CENTER);
    wordLbl.setFill(Color.valueOf("#0f54ad"));
    wordLbl.setText(msg);
  }

  public void setDefaultLbl()
  {
    wordLbl.setTextAlignment(TextAlignment.LEFT);
    wordLbl.setFill(Color.valueOf("BLACK"));
    wordLbl.setText("Not Allowed");
  }

  public void resetWordListView()
  {
    this.wordVal.setText("");
  }
}
