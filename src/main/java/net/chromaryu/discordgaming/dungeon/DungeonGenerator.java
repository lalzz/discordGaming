package net.chromaryu.discordgaming.dungeon;

import java.util.Random;


public class DungeonGenerator {
  static String seed = "";
  static Random gen = new Random(seed);
  private final static char BLANK = ' ';
  private static final int MAXROW = 12;
  private static final int MAXCOL = 12;
  private int myMaxRow;
  private int myMaxCol;
  private char [][] myMaze;
  public static void setSeed(String s)
  {
    this.seed = s;
    this.gen = new Random(seed);
  }
  
  public static Dungeon generateDungeon()
  {
    Dungeon d = new Dungeon();
    if(testValid(d))
    return d;
  }
  public static boolean testValid(Dungeon d)
  {

  public void doTraceMaze() {
   loadMaze();
   traceMaze(myMaze, myMaxRow/2, myMaxCol/2);
  }

  /**
   * Description of the Method
   *
   * @param maze Description of Parameter
   */
  public void printMaze(char[][] maze){
    Scanner console = new Scanner(System.in);

    for (int row = 1; row <= myMaxRow; row++){
      for (int col = 1; col <= myMaxCol; col++){
        System.out.print("" + maze[row][col]);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("Hit enter to see if there are more solutions.");
    String anything = console.nextLine();
  }
  public void traceMaze(char[][] maze, int row, int col){
    //char[][] mazeCopy = (char[][])maze.clone();

    char[][] mazeCopy = new char[maze.length][maze[0].length];
    for (int r = 0; r < mazeCopy.length; r++){
      for (int c = 0; c < mazeCopy[0].length; c++){
        mazeCopy[r][c] = maze[r][c];
      }
    }

    if (1 <= row && row <= myMaxRow && 1 <= col && col <= myMaxCol){
      // boundary check, if false, a base case
      if (BLANK == mazeCopy[row][col]){
        // if false, base case
        mazeCopy[row][col] = '!';
        if (1 == row || myMaxRow == row || 1 == col || myMaxCol == col){
          printMaze(mazeCopy); // base case
        }else{
          traceMaze(mazeCopy, row - 1, col);
          traceMaze(mazeCopy, row, col + 1);
          traceMaze(mazeCopy, row + 1, col);
          traceMaze(mazeCopy, row, col - 1);
        }
      }
    }
  }

}
  }
}
