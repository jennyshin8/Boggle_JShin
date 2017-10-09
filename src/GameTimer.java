import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * Created by jh on 9/29/17.
 */
public class GameTimer extends AnimationTimer
{
  private long startTime;
  private String timeS = "";
  private long now;
  private Double cumulated;
  private int minute;
  private int seconds;

  private IntegerProperty time = new SimpleIntegerProperty();
  private BooleanProperty running = new SimpleBooleanProperty();

  private GameTimerView gameTimerView;
  private Controller controller;

  public GameTimer(Controller controller, GameTimerView gameTimerView)
  {
    this.controller = controller;
    this.gameTimerView = gameTimerView;
  }

  @Override
  public void start()
  {
    startTime = System.currentTimeMillis();
    running.set(true);
    super.start();
  }

  @Override
  public void stop()
  {
    running.set(false);
    System.out.println("GameTimer Stop");
    super.stop();
  }

  @Override
  public void handle(long timestamp)
  {
    now = System.currentTimeMillis();
    cumulated = ((now - startTime) / 1000.0);
//    minute = 2 - (cumulated.intValue() / 60);
    minute = 0 - (cumulated.intValue() / 60);
    seconds =  59 - (cumulated.intValue() % 60);

    time.set(cumulated.intValue());

    if (minute < 0)
    {
      this.stop();
      this.controller.timeOut();
    }
    else
    {
      if (seconds < 10) timeS = " " + Integer.toString(minute) + ":0" + Integer.toString(seconds);
      else timeS = " " + Integer.toString(minute) + ":" + Integer.toString(seconds);
    }

    gameTimerView.update(timeS);
  }

}
