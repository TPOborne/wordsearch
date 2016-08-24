package wordsearch;
import java.util.Random;

public class Wordsearch {
  
  String keyword;
  char[][] grid;
  int x, y, successCount, generations;
  Random rn;
  
  public Wordsearch(String keyword, int x, int y) {
    rn = new Random();
    this.keyword = keyword;
    this.x = x;
    this.y = y;
    
    while (successCount == 0) {
      generations++;
      System.out.println("gen: " + generations);
      initGrid();
      checkGrid();
    }
    
    

  }
  
  void initGrid() {
    grid = new char[y][x];
    for (int yCord=0; yCord<y; yCord++) {
      for (int xCord=0; xCord<x; xCord++) {
        grid[yCord][xCord] = randomLetter();
      }
    }
  }
  
  void checkGrid() {
    successCount = 0;
    
    //horizontal check l r
    
    for (int yCord=0; yCord<y; yCord++) {
      String word = "";
      for (int xCord=0; xCord<x; xCord++) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            System.out.println("Success LR - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }
    
    //horizontal check r l
    
    for (int yCord=0; yCord<y; yCord++) {
      String word = "";
      for (int xCord=x-1; xCord>=0; xCord--) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            System.out.println("Success RL - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }
    
    //vertical check t b
    
    for (int xCord=0; xCord<x; xCord++) {
      String word = "";
      for (int yCord=0; yCord<y; yCord++) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            System.out.println("Success TB - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }
    
    //vertical check b t
    
    for (int xCord=0; xCord<x; xCord++) {
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            System.out.println("Success BT - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }
    
    //diagonal check tl br
    
    for (int yCord=0; yCord<y; yCord++) {
      int tempY = yCord;
      String word = "";
      for (int xCord=0; xCord<x; xCord++) {
        if(tempY != y){
          word += grid[tempY][xCord];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              System.out.println("Success TL BR - (" + xCord + ", " + tempY + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempY++;
        } 
      }
    }
    
    //diagonal check tr bl
    
    for (int yCord=0; yCord<y; yCord++) {
      int tempY = yCord;
      String word = "";
      for (int xCord=x-1; xCord>=0; xCord--) {
        if(tempY != y){
          word += grid[tempY][xCord];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              System.out.println("Success TR BL - (" + xCord + ", " + tempY + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempY++;
        } 
      }
    }
    
    //diagonal check bl tr
    
    for (int xCord=0; xCord<x; xCord++) {
      int tempX = xCord;
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        if(tempX != x){
          word += grid[yCord][tempX];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              System.out.println("Success BL TR - (" + tempX + ", " + yCord + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempX++;
        } 
      }
    }
    
    //diagonal check br tl
    
    for (int xCord=x-1; xCord>=0; xCord--) {
      int tempX = xCord;
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        if(tempX != 0){
          word += grid[yCord][tempX];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              System.out.println("Success BR TL - (" + tempX + ", " + yCord + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempX--;
        } 
      }
    }

    
  }
  
  boolean charMatch(String word) {
    for (int i=0; i<word.length(); i++) {
      if (word.charAt(i) != keyword.charAt(i)) {
        return false;
      }  
    } return true;
  }
  
  void printGrid() {
    System.out.println("===================");
    for (int yCord=0; yCord<y; yCord++) {
      for (int xCord=0; xCord<x; xCord++) {
        System.out.print(grid[yCord][xCord] + "  ");
      }
      System.out.println("\n      ");
    }
  }
  
  char randomLetter() {
    int number = rn.nextInt(keyword.length());
    return keyword.charAt(number);
  }
  
  
  

}
