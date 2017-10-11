import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by jh on 9/29/17.
 */
public class GameTimerView
{
  private Text timerLbl;
  private Text timerVal;


  public GameTimerView()
  {
    timerLbl = new Text();
    timerVal = new Text();

    timerLbl.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
    timerLbl.setTextAlignment(TextAlignment.CENTER);
    timerLbl.setWrappingWidth(90);
    timerLbl.setText("Timer");

    timerVal.setFont(Font.font("Arial Red", FontWeight.BLACK, 20));
    timerVal.setTextAlignment(TextAlignment.LEFT);
    timerVal.setWrappingWidth(70);
    timerVal.setText("3:00");
  }

  public void update(String updatedTime) { timerVal.setText(updatedTime); }

  public Text getLabel()
  {
    return this.timerLbl;
  }

  public Text getValue()
  {
    return this.timerVal;
  }
}
