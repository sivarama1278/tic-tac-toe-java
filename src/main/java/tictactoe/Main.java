package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

      public static void main(String[] args){

           Scanner scanner = new Scanner(System.in);

           //Create players
           Player player1 = new Player(1, "Siva", Symbol.X);
           Player player2 = new Player(2, "Sadhu", Symbol.O);

           //Store players in a list
           List<Player> players = new ArrayList<>();
           players.add(player1);
           players.add(player2);

           //Create winning Strategy
          WinningStrategy winningStrategy = new StandardWinningStrategy();

          //Create a game
          Game game = new Game(3, players, winningStrategy);

          //Start game
          game.startGame();

          //Continue until game finishes
          while(game.getGameStatus() == GameStatus.IN_PROGRESS){

                     Player currentPlayer = game.getCurrentPlayer();

                     System.out.println(currentPlayer.getName() + ", Enter row and column (0,2):");

                     int row = scanner.nextInt();
                     int col = scanner.nextInt();

                     //Make the move
                     game.makeMove(row, col);
          }

          //Game finished
          System.out.println("Game over!");

          scanner.close();
      }
}
