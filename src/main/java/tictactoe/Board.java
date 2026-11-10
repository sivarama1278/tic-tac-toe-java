package tictactoe;

public class Board {

      private Symbol[][] cells;
      private int size;

      public Board(int size){

          if(size < 1){
              throw new IllegalArgumentException("Board size must be positive");
          }
          this.size = size;
          this.cells = new Symbol[size][size];

          initializeBoard();
      }

     private void initializeBoard(){

          for(int row=0; row<size; row++){
              for(int col=0; col<size; col++){
                  cells[row][col] = Symbol.EMPTY;
              }
          }
     }

     public boolean isCellEmpty(int row, int col){

            if(row < 0 || row >= size ||
               col < 0 || col >= size){
                 return false;
            }

            return cells[row][col] == Symbol.EMPTY;
     }

     public boolean isFull(){

          for(int row=0; row<size; row++){
              for(int col=0; col<size; col++){

                   if(cells[row][col] == Symbol.EMPTY){
                         return false;
                   }
              }
          }

          return true;
     }

     public void displayBoard(){

          for(int row=0; row<size; row++){
              for(int col=0; col<size; col++){

                  if(cells[row][col] == Symbol.X){
                       System.out.print(" X ");
                  }else if(cells[row][col] == Symbol.O){
                        System.out.print(" O ");
                  }else{
                      System.out.print(" - ");
                  }

                  if(col < size - 1){
                      System.out.print("|");
                  }
              }

              System.out.println();

              if(row < size -1){
                   for(int i=0; i<size; i++){
                       System.out.print("----");
                   }
                   System.out.println("-");
              }
          }
     }

     public boolean placeSymbol(int row, int col, Symbol symbol){

              //check whether the coordinates are valid
              if(row<0 || row>=size ||
                 col<0 || col>=size){

                    return false;
              }

              //check whether the cell is already occupied
              if(cells[row][col] != Symbol.EMPTY){
                   return false;
              }

              //place the player's symbol
              cells[row][col] = symbol;

              return true;
      }

      public int getSize(){
           return size;
      }

      public Symbol getCell(int row, int col){

             if(row < 0 || row>=size ||
                col < 0 || col>=size) {

                 throw new IndexOutOfBoundsException("Invalid board position");
             }

             return cells[row][col];
      }
}
