import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by jh on 9/23/17.
 */
public class Dictionary
{
  // Read .txt file save it to ArrayList<String> wordList
  private ArrayList<String> dictionary = new ArrayList<String>();
  private Hashtable<String, ArrayList<String>> hashtable = new Hashtable<>();


  protected Dictionary()
  {
    BufferedReader reader;

    try
    {
      reader = new BufferedReader(new FileReader("src/resource/OpenEnglishWordList.txt"));
      String line = reader.readLine();

      while (line != null)
      {
        dictionary.add(line);
        if(line.length()>2)
        {
          if(!hashtable.containsKey(line.substring(0,3)))
          {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(line);

            hashtable.put(line.substring(0,3), arrayList);
          }
          else
          {
            hashtable.get(line.substring(0,3)).add(line);
          }
        }
        line = reader.readLine();
      }
      reader.close();
    }
    catch (IOException e)
    {
      System.out.println("IO Exception: " + e.getMessage());
      System.exit(0);
    }
  }
  public boolean findWordHash(String word)
  {
//    for (Map.Entry<String, ArrayList<String>> entry : hashtable.entrySet()) {
//      System.out.println("=================================================================");
//      System.out.println("key   : " + entry.getKey() + "\nvalue : " + entry.getValue());
//    }
    if (word.length() >= 3)
    {
      if (hashtable.containsKey(word.substring(0, 3))) return hashtable.get(word.substring(0, 3)).contains(word);
      else return false;
    }
    else return false;

  }

  public boolean findWord(String findingWord)
  {
    // Read input to find a word
//    System.out.println("Enter your word: ");
//    Scanner scanner = new Scanner(System.in);
//    String findingWord = scanner.nextLine();


    boolean found = false, noValue = false;
    int start = 0, pivot = (dictionary.size() / 2), end = dictionary.size() - 1, idx = 0;

    if (dictionary.get(pivot).length() < findingWord.length())
    {
      idx = dictionary.get(pivot).length();
    }
    else
    {
      idx = findingWord.length();
    }


    while (!found)
    {
//      System.out.println(" -> " + dictionary.get(pivot) + " , pivot : " + pivot);
      for (int i = 0; i < idx; i++)
      {
        if(start == pivot || end == pivot)
        {
          noValue = true;
          break;
        }

        if (dictionary.get(pivot).charAt(i) == findingWord.charAt(i))
        {
          if (i == idx - 1 & idx == dictionary.get(pivot).length() & idx == findingWord.length())
          {
            System.out.println("****************************");
            System.out.println("wordList (" + (pivot+1)+ ") " + dictionary.get(pivot));
            found = true;
            break;
          }
          else continue;
        }
        else if (dictionary.get(pivot).charAt(i) < findingWord.charAt(i)) start = pivot;
        else if (dictionary.get(pivot).charAt(i) > findingWord.charAt(i)) end = pivot;

        pivot = (start + end) / 2;
        i = -1;

        if (dictionary.get(pivot).length() < findingWord.length()) idx = dictionary.get(pivot).length();
        else idx = findingWord.length();
      }

      // bad vs badass
      if (dictionary.get(pivot).length() != findingWord.length())
      {
        if (idx == dictionary.get(pivot).length()) start = pivot;
        else if (idx == findingWord.length()) end = pivot;

        pivot = (start + end) / 2;

        if (dictionary.get(pivot).length() < findingWord.length()) idx = dictionary.get(pivot).length();
        else idx = findingWord.length();
      }

      // if there is no word that user is looking for,
      if (noValue)
      {
        System.out.println("Sorry but no " + findingWord + " in dictionary...\n");
        break;
      }
    }

    return found;
  }

}
