package tictactoe;

public class Player {

    private final String name;
    private final int id;
    private final Symbol symbol;

    public Player(int id, String name, Symbol symbol){

        this.name = name;
        this.id = id;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
