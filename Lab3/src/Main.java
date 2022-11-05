public class Main {
    public static void main(String[] args) throws Exception {
        SymbolTable symbolTableConstants = new SymbolTable(8);
        SymbolTable symbolTableIdentifiers = new SymbolTable(8);
        Scanner scanner = new Scanner(symbolTableConstants, symbolTableIdentifiers, "tokens.io");

        scanner.scan("p2.txt");
    }
}