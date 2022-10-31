public class Main {
    public static void main(String[] args) {

        SymbolTable st = new SymbolTable(3);
        String[] symbols = {"a", "a", "b", "b", "c", "d"};

        for (String symbol : symbols)
            System.out.println(symbol + " " + st.addSymbol(symbol) + " " + st.getPositionInBucket(symbol));
    }
}