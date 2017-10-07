import java.util.Random;

/**
 * Created by jh on 9/26/17.
 */
public class Board
{
  private String[][] boggleArr;
  private String[] manual = {"A", "B", "C", "D", "E", "F", "G", "H",
          "I", "J", "K", "L", "M", "N", "O", "P",
          "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
  private int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  // manual[16] = "Q", manual[20] = "U"

  Board(int i)
  {
    boggleArr = new String[i][i];
    this.shuffleBoggleArr(i);
  }

  public String[][] getBoggleArr()
  {
    return boggleArr;
  }

  public void shuffleBoggleArr(int input)
  {
    String tmp = "";
    int limit = input * input, row, col;

    for (int i = 0; i < limit; i++)
    {
      while (true)
      {
        Random r = new Random();
        int rand = r.nextInt(26);

//        if (count[rand] < 1)
        if (count[rand] < 3)
        {
          if (rand == 16 && !((i+1)%input == 0))
          {
            Random rU = new Random();
            if (rU.nextInt(26) % 2 == 0)
            {
              tmp += manual[20];
              count[20]++;
            }
          }
          tmp += manual[rand];
          count[rand]++;
          break;
        }
      }
      row = i / input;
      col = i % input;

      boggleArr[row][col] = tmp.substring(i, i + 1);
    }
  }
}