import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

/**
 * Created by jh on 9/23/17.
 */
public class Controller extends Application
{
  public static final int WINDOW_WIDTH = 500;
  public static final int WINDOW_HEIGHT = 500;
  private Scene scene = new Scene(new Group());

  private VBox vbox = new VBox();
  private VBox startVBox = new VBox();
  private VBox endingVBox = new VBox();
  private Button[] btnStart;
  private Button[] btnEnding;

  private HBox headerLabel = new HBox();
  private HBox headerValue = new HBox();
  private HBox[] boardRows;
  private HBox footerLabel = new HBox();
  private HBox footerValue = new HBox();
  private VBox footerValueWrong = new VBox();
  private VBox footerValueValid = new VBox();
//  private VBox footerValue = new VBox();

  private StartSceneView startSceneView;
  private BoardView boardView;
  private ScoreView scoreView = new ScoreView();
  private WordListView wordListView = new WordListView();
  private GameTimerView gameTimerView = new GameTimerView();
  private EndingSceneView endingSceneView;

  private Dictionary dictionary = new Dictionary();
  private Board board;
  private Score score = new Score(scoreView);
  private WordList wordList = new WordList(wordListView);
  private AnswerWords answerWords;
  private GameTimer gameTimer = new GameTimer(this, gameTimerView);

  private int num;
  private Stack<Node> stacked = new Stack<>();
  private String draggedWord = "";

  private boolean spaceDragged = false;

  /**==========================*
   *  1. LOAD THE START
   *
   *  -> StartScene
   **==========================*/
  @Override
  public void init() throws Exception
  {
    startSceneView = new StartSceneView();
    endingSceneView = new EndingSceneView();

    startVBox = startSceneView.getStartSceneVBox();

    btnStart = startSceneView.getBtnArr();
    btnStart[0].setOnMouseClicked(this::handleClickedStart);
    btnStart[1].setOnMouseClicked(this::handleClickedStart);

    btnEnding = endingSceneView.getBtnArr();
    btnEnding[0].setOnMouseClicked(this::handleClickedEnding);
    btnEnding[1].setOnMouseClicked(this::handleClickedEnding);

    vbox.setId("vbox");
    vbox.getChildren().add(startVBox);

    super.init();
  }

  @Override
  public void stop()
  {
    System.out.println("GAME STOPPED BY USER");
    System.exit(9);
  }

  @Override
  public void start(Stage stage)
  {
    System.out.println("start");

    stage.setTitle("Boggle_JShin");
    stage.setWidth(WINDOW_WIDTH);
    stage.setHeight(WINDOW_HEIGHT);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }

  /**==========================*
   *  2. JUMP INTO THE GAME
   *
   *  StartScene -> GameScene
   **==========================*/
  private void handleClickedStart(MouseEvent event)
  {
    Node node = (Node) event.getSource();
    this.num = Integer.parseInt(node.getId());

    vbox.getChildren().clear();

    board = new Board(this.num);
    boardView = new BoardView(board.getBoggleArr());
    answerWords = new AnswerWords(board.getBoggleArr());
    for(int i = 0; i < this.num*this.num; i++) answerWords.findAnswer(answerWords.getNodes().getNode(i));
    score.setAnswerN(answerWords.getFoundSize());

    setHeader();
    setBoard();
    setFooter();
    alignVBox();
/********
 *
 * setFooter changes the aligning
 */
    gameTimer.start();
  }

  /**==========================*
   *  3. GAME TIMEOUT
   *
   *  GameScene -> EndingScene
   **==========================*/
  public void timeOut()
  {
    for (int i = 0; i < num; i++)
    {
      boardRows[i].getChildren().clear();
      vbox.clearConstraints(boardRows[i]);
    }
    setFinale();
  }

  private void setFinale()
  {
    endingVBox = endingSceneView.getEndingSceneVBox(score.getTotalScore(), wordList.getAcceptedWord(), answerWords.getFound());

    vbox.getChildren().clear();
    vbox.getChildren().add(endingVBox);
  }

  /**========================================*
   *  4. ASK USER "You wanna play more?"
   *
   *  EndingScene -> StartScene OR STOP GAME
   **========================================*/
  private void handleClickedEnding(MouseEvent event)
  {
    Node node = (Node) event.getSource();
    if(node.getId()=="no") this.stop();
    else
    {
      vbox.getChildren().clear();
      vbox.getChildren().add(startVBox);

      board = new Board(this.num);
      boardView = new BoardView(board.getBoggleArr());

      resetHeader();
      resetFooter();
      score.resetScore();
      wordList.resetWordList();
      endingSceneView.resetAnswers();
    }
  }

  private void setHeader()
  {
    headerLabel.getChildren().addAll(gameTimerView.getLabel(), scoreView.getLabel());
    headerValue.getChildren().addAll(gameTimerView.getValue(), scoreView.getValue());
    headerLabel.setSpacing(236);
    headerValue.setSpacing(238);
    vbox.setMargin(headerLabel, new Insets(10, 10, 0, 13));
    vbox.setMargin(headerValue, new Insets(0, 0, 10, 30));
  }

  private void setBoard()
  {
    boardRows = boardView.getBoard(num);
    for (int i = 0; i < num; i++)
    {
      for (int j = 0; j < num; j++)
      {
        boardRows[i].getChildren().get(j).setOnDragDetected(this::handleDetected);
        boardRows[i].getChildren().get(j).setOnMouseDragOver(this::handleDragOver);
        boardRows[i].getChildren().get(j).setOnMouseDragReleased(this::handleReleased);
      }
    }
    vbox.setOnMouseDragOver(this::handleDragOver);
    vbox.setOnMouseDragReleased(this::handleReleased);
  }

  private void setFooter()
  {
    footerLabel.getChildren().addAll(wordListView.getLabelWrong(), wordListView.getLabelValid());
    footerValueWrong.getChildren().add(wordListView.getValueWrong());
    footerValueValid.getChildren().add(wordListView.getValueValid());
    footerValue.getChildren().addAll(footerValueWrong, footerValueValid);
    vbox.setMargin(footerLabel, new Insets(20, 10, 0, 30));
    vbox.setMargin(footerValue, new Insets(0, 10, 10, 30));
    footerValue.setSpacing(10);
  }

  private void resetHeader()
  {
    headerLabel.getChildren().clear();
    headerValue.getChildren().clear();
  }

  private void resetFooter()
  {
    footerLabel.getChildren().clear();
    footerValueWrong.getChildren().clear();
    footerValueValid.getChildren().clear();
    footerValue.getChildren().clear();
  }

  private void alignVBox()
  {
    vbox.getChildren().add(headerLabel);
    vbox.getChildren().add(headerValue);
    vbox.getChildren().addAll(boardRows);
    if (num == 4)
    {
      vbox.setMargin(boardRows[0], new Insets(23, 0, 0, 0));
      vbox.setMargin(boardRows[3], new Insets(0, 0, 22, 0));
    }
    vbox.getChildren().add(footerLabel);
    vbox.getChildren().add(footerValue);

  }

  private void handleDetected(MouseEvent event)
  {
    Node node = (Node) event.getSource();
    node.startFullDrag();
    boardView.addNode(node, stacked);
    boardView.paint(node);
  }

  private void handleDragOver(MouseEvent event)
  {
    Node node = (Node) event.getSource();

    // Check if unnecessary space is dragged
    if (node.getId().equals("vbox") && !boardView.checkBoundary(event, boardRows, num-1)) spaceDragged = true;

    // Check invalid input (UI)
    if (event.getX() < 5 || event.getY() < 5 || event.getX() > 35 || event.getY() > 35) return;
    if (!node.getId().equals("vbox") && spaceDragged)
    {
      boardView.removeAllPaint(stacked);
      spaceDragged = false;
      return;
    }

    // Check invalid input (Not accept duplicates to prevent turning around)
    if (stacked.size() >= 1 && boardView.addNode(node, stacked)) boardView.paint(node);
    else boardView.removeAllPaint(stacked);
  }

  private void handleReleased(MouseEvent event)
  {
    Node node = (Node) event.getSource();

    // Check invalid input (UI)
    if (!(event.getX() < 5 || event.getY() < 5 || event.getX() > 35 || event.getY() > 35))
    {
      boardView.addNode(node, stacked);
      boardView.paint(node);
    }

    draggedWord = boardView.removeAllPaint(stacked);
    draggedWord = boardView.flipWord(draggedWord);

    // Check invalid input (word's length -> duplicated words -> look up dictionary)
    if (draggedWord.length() >= 3)
    {
      if (!wordList.isDuplicate(draggedWord))
      {
        if (score.isValid(dictionary, draggedWord)) wordList.addAcceptedWord(draggedWord);
        else wordList.addWrongWord(draggedWord);
      }
    }
    draggedWord = "";
    spaceDragged = false;
  }
}
