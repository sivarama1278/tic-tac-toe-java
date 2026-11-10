package tictactoe;

public class StandardWinningStrategy implements WinningStrategy{

          @Override
          public boolean checkWinner(Board board, Move move){

                  int size = board.getSize();
                  int row = move.getRow();
                  int col = move.getCol();

                  Symbol symbol = move.getPlayer().getSymbol();

                  //check horizontal row
                  boolean rowWin = true;

              for(int i=0; i<size; i++){
                   if(board.getCell(row,i) != symbol){
                       rowWin = false;
                       break;
                   }
              }

              if(rowWin){
                  return true;
              }

              //check vertical column
              boolean colWin = true;

              for(int i=0; i<size; i++){
                 if(board.getCell(i, col) != symbol){
                     colWin = false;
                     break;
                 }
              }

              if(colWin){
                  return true;
              }

              //check main diagonal
              if(row == col){

                   boolean diagonalWin = true;

                   for(int i=0; i<size; i++){
                       if(board.getCell(i,i) != symbol){
                           diagonalWin = false;
                           break;
                       }
                   }

                   if(diagonalWin){
                        return true;
                   }
              }

              //check opposite diagonal
              if(row + col == size - 1){

                     boolean diagonalWin = true;

                     for(int i=0; i<size; i++){
                            if(board.getCell(i, size - 1 - i) != symbol){
                                diagonalWin = false;
                                break;
                            }
                     }

                     if(diagonalWin){
                          return true;
                     }
              }

              return false;
          }
}
