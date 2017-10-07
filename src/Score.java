/**
 * Created by jh on 9/28/17.
 */
public class Score
{
  private int score;
  private ScoreView scoreView;

  public Score(ScoreView scoreView)
  {
    score = 0;
    this.scoreView = scoreView;
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
    }

    scoreView.update(score);
    return value;
  }

  public int getTotalScore()
  {
    return this.score;
  }

  public void resetScore()
  {
    this.score = 0;
    this.scoreView.resetScoreView();
  }
}
