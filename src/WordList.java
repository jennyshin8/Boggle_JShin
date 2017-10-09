import java.util.ArrayList;

/**
 * Created by jh on 9/26/17.
 */
public class WordList
{
  private ArrayList<String> accepted;
  private ArrayList<String> notAccepted;
  private WordListView wordListView;

  WordList(WordListView wordListView)
  {
    accepted = new ArrayList<>();
    notAccepted = new ArrayList<>();

    this.wordListView = wordListView;
  }

  public void addAcceptedWord(String rightWord)
  {
    accepted.add(rightWord);
    //wordListView.encourage(rightWord);
  }

  public void addWrongWord(String wrongWord)
  {
    notAccepted.add(wrongWord);
    wordListView.update(wrongWord);
  }

  public boolean isDuplicate(String input)
  {
    if (accepted.contains(input))
    {
      //wordListView.warning("You've already picked this word!");
      return true;
    }
    else
    {
      wordListView.setDefaultLbl();
      return false;
    }
  }

  public ArrayList<String> getAcceptedWord()
  {
    return this.accepted;
  }

  public void resetWordList()
  {
    this.accepted.clear();
    this.notAccepted.clear();
    this.wordListView.resetWordListView();
  }

}
