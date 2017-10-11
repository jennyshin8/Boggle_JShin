import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by jh on 9/28/17.
 */
public class Score
{
  private int score;
  private ScoreView scoreView;
  private int acceptedN;
  private int answerN;

  public Score(ScoreView scoreView)
  {
    score = 0;
    this.scoreView = scoreView;
    acceptedN = 0;
    answerN = 0;
  }

  public boolean isValid(Dictionary dictionary, String draggedWord)
  {
    if (getScore(dictionary, draggedWord) >= 1) return true;
    else return false;
  }

  public int getScore(Dictionary dictionary, String draggedWord)
  {
    int value = 0;

    if(dictionary.findWord(draggedWord.toLowerCase()))
    {
      score += draggedWord.length()-2;
      value = draggedWord.length()-2;
      this.acceptedN++;
    }

    scoreView.update(score, this.acceptedN, getAnswerN());
    return value;
  }

  public int getTotalScore()
  {
    return this.score;
  }

  public void setAnswerN(int n)
  {
    this.answerN = n;
    scoreView.update(0,0,n);
  }

  public int getAnswerN()
  {
    return this.answerN;
  }

  public void resetScore()
  {
    this.score = 0;
    this.acceptedN = 0;
    this.answerN = 0;
    this.scoreView.resetScoreView();
  }
}
