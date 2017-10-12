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
  private Text wordLblWrong;
  private Text wordValWrong;

  private Text wordLblValid;
  private Text wordValValid;


  public WordListView()
  {
    wordLblWrong = new Text();
    wordValWrong = new Text();

    wordLblWrong.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
    wordLblWrong.setTextAlignment(TextAlignment.CENTER);
    wordLblWrong.setWrappingWidth(220);
    wordLblWrong.setText("Invalid Input");


    wordValWrong.setFont(Font.font("Arial", FontWeight.BLACK, 16));
    wordValWrong.setTextAlignment(TextAlignment.LEFT);
    wordValWrong.setWrappingWidth(220);
    wordValWrong.setFill(Color.RED);


    wordLblValid = new Text();
    wordValValid = new Text();

    wordLblValid.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
    wordLblValid.setTextAlignment(TextAlignment.CENTER);
    wordLblValid.setWrappingWidth(220);
    wordLblValid.setText("Valid Input");


    wordValValid.setFont(Font.font("Arial", FontWeight.BLACK, 16));
    wordValValid.setTextAlignment(TextAlignment.LEFT);
    wordValValid.setWrappingWidth(220);
    wordValValid.setFill(Color.GREEN);
  }

  public void updateWrong(String wrongWord) { wordValWrong.setText(wordValWrong.getText() + " " + wrongWord); }

  public void updateValid(String validWord) { wordValValid.setText(wordValValid.getText() + " " + validWord); }

  public void resetWrong() { wordValWrong.setText(""); }

  public void resetValid() { wordValValid.setText(""); }

  public Text getLabelWrong()
  {
    return this.wordLblWrong;
  }

  public Text getValueWrong()
  {
    return this.wordValWrong;
  }

  public Text getLabelValid()
  {
    return this.wordLblValid;
  }

  public Text getValueValid() { return this.wordValValid; }

//  public void warning(String msg)
//  {
//    wordLbl.setTextAlignment(TextAlignment.CENTER);
//    wordLbl.setFill(Color.valueOf("#e60000"));
//    wordLbl.setText(msg);
//  }
//
//  public void encourage(String msg)
//  {
//    wordLbl.setTextAlignment(TextAlignment.CENTER);
//    wordLbl.setFill(Color.valueOf("#0f54ad"));
//    wordLbl.setText(msg);
//  }

  public void resetWordListView()
  {
    this.wordValWrong.setText("");
    this.wordValValid.setText("");
  }
}
