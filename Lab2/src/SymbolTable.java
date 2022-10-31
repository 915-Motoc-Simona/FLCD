import java.util.ArrayList;

public class SymbolTable{
    private ArrayList<ArrayList<String>> symbols;
    private int size;

    public SymbolTable(int size){
        this.size = size;
        this.symbols = new ArrayList<>();
        for(int i=0; i < size; i++)
            this.symbols.add(new ArrayList<>());
    }

    public int addSymbol(String symbol){
        int hashValue = hash(symbol);

        if(!symbols.get(hashValue).contains(symbol)) {
            symbols.get(hashValue).add(symbol);
        }

        return hash(symbol);
    }

    public int hash(String symbol){
        return symbol.codePoints().sum() % size;
    }

    public int getPositionInBucket(String symbol){
        return symbols.get(hash(symbol)).indexOf(symbol);
    }

}
