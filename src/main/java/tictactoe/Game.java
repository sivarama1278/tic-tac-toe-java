package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

       private Board board;
       private List<Player> players;
       private int currentPlayerIndex;
       private GameStatus gameStatus;
       private Player winner;
       private WinningStrategy winningStrategy;

       public Game(int size, List<Player> players, WinningStrategy winningStrategy){

                    this.board = new Board(size);
                    this.players = new ArrayList<>(players);
                    this.winningStrategy = winningStrategy;

                    this.currentPlayerIndex = 0;
                    this.gameStatus = GameStatus.NOT_STARTED;
                    this.winner = null;
        }

        public void startGame(){

               if(gameStatus != GameStatus.NOT_STARTED){
                        throw new IllegalStateException("Game has already started");
               }

               if(players == null || players.size() != 2){
                     throw new IllegalStateException("Exactly two players are required");
               }

               if(winningStrategy == null){
                   throw new IllegalStateException("Winning strategy is required");
               }

               currentPlayerIndex = 0;
               gameStatus = GameStatus.IN_PROGRESS;

               board.displayBoard();

               System.out.println("Game started!");
               System.out.println("First player: " + getCurrentPlayer().getName());
        }

        public Player getCurrentPlayer(){
           return players.get(currentPlayerIndex);
        }

        public void switchPlayer(){
           currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        public void makeMove(int row, int col){

                 //check whether the game is in progress
                  if(gameStatus != GameStatus.IN_PROGRESS){
                          throw new IllegalStateException("Game is not in progress");
                  }

                  //get the current player
                  Player currentPlayer = getCurrentPlayer();

                  //create a move object
                  Move move = new Move(currentPlayer, row, col);

                  //place the player symbol on the board
                  boolean moveSuccessful = board.placeSymbol(row, col, currentPlayer.getSymbol());

                  if(!moveSuccessful){
                      System.out.println("Invalid move. Try again");
                      return;
                  }

                  //check whether the current player has won
                 if(winningStrategy.checkWinner(board, move)) {

                     winner = currentPlayer;


                     if (currentPlayer.getSymbol() == Symbol.X) {
                            gameStatus = GameStatus.X_WON;
                     }else{
                            gameStatus = GameStatus.O_WON;
                     }

                     System.out.println(currentPlayer.getName() + " wins!");
                     board.displayBoard();
                     return;

                 }

                 //check whether the board is full
                 if(board.isFull()){
                      gameStatus = GameStatus.DRAW;
                      System.out.println("Game is a draw");
                      board.displayBoard();
                      return;
                 }

                 //display the updated board
                 board.displayBoard();

                 //switch to the next player
                switchPlayer();

                System.out.println("Next player: " + getCurrentPlayer().getName());
        }

        public GameStatus getGameStatus(){
           return gameStatus;
        }
}
