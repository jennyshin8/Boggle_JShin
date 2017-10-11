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

    wordLbl.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
    wordLbl.setTextAlignment(TextAlignment.LEFT);
    wordLbl.setWrappingWidth(300);
    wordLbl.setText("Unacceptable Input");


    wordVal.setFont(Font.font("Arial", FontWeight.BLACK, 16));
    wordVal.setTextAlignment(TextAlignment.LEFT);
    wordVal.setWrappingWidth(Controller.WINDOW_WIDTH - 50);
    wordVal.setFill(Color.RED);
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

  public void resetWordListView()
  {
    this.wordVal.setText("");
  }
}
