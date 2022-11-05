import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scanner {
    SymbolTable symbolTableConstants;
    SymbolTable symbolTableIdentifiers;
    ArrayList<String> tokens;
    ArrayList<Pair<String, Integer>> pif;

    private final String ONLY_DIGITS_REGEX = "(^(\\+|-)?([1-9]+[0-9]*)(?=[\\n:;+\\-*/%, ()}{\\]\\[\"]|$))|0";
    private final String CHAR_CONSTANT_REGEX = "^\'[0-9a-zA-Z]\'";
    private final String STRING_CONSTANT_REGEX = "^\"[0-9a-zA-Z ]*\"";
    private final String IDENTIFIER_REGEX = "^[A-Za-z][A-Za-z0-9]*";
    private final String OPERATOR_REGEX = "^\\+|-|\\*|/|%|<=?|>=?|!=|={1,2}";
    private final String SEPARATOR_REGEX = "^[\\n;,()}{\\]\\[]";
    private final String RESERVED_WORDS_REGEX = "^(var|readInt|readReal|readString|and|AND|or|OR|not|NOT|readChar|if|else|while|write|of|array)";

    public Scanner(SymbolTable symbolTableConstants, SymbolTable symbolTableIdentifiers, String tokenFile) throws Exception {
        this.symbolTableConstants = symbolTableConstants;
        this.symbolTableIdentifiers = symbolTableIdentifiers;
        pif = new ArrayList<>();
        readTokens(tokenFile);
    }

    private void readTokens(String tokenFile) {
        tokens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(tokenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                tokens.add(line.strip());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scan(String filePath) throws IOException{
        boolean correct = true;

        try(BufferedReader bufferedReader = new LineNumberReader(new FileReader(filePath))){
            String line;
            int lineNumber = 1;
            boolean found;
            while((line = bufferedReader.readLine()) != null && correct){
                while(!line.isEmpty()){
//                    System.out.println(lineNumber + " " + line);
                    found = false;
                    line = line.strip();

                    Pattern pattern = Pattern.compile(RESERVED_WORDS_REGEX);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        pif.add(new Pair(matcher.group(), -1));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(SEPARATOR_REGEX);
                    matcher = pattern.matcher(line);
                    if(matcher.find() && matcher.start() == 0){
                        pif.add(new Pair(matcher.group(), -1));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(OPERATOR_REGEX);
                    matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        pif.add(new Pair(matcher.group(), -1));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(IDENTIFIER_REGEX);
                    matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        int pos = symbolTableIdentifiers.addSymbol(matcher.group());
                        int posInBucket = symbolTableIdentifiers.getPositionInBucket(matcher.group());
                        pif.add(new Pair("id", new Pair<>(pos, posInBucket)));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(ONLY_DIGITS_REGEX);
                    matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        int pos = symbolTableConstants.addSymbol(matcher.group());
                        int posInBucket = symbolTableConstants.getPositionInBucket(matcher.group());
                        pif.add(new Pair("const", new Pair<>(pos, posInBucket)));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(CHAR_CONSTANT_REGEX);
                    matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        int pos = symbolTableConstants.addSymbol(matcher.group());
                        int posInBucket = symbolTableConstants.getPositionInBucket(matcher.group());
                        pif.add(new Pair("const", new Pair<>(pos, posInBucket)));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    pattern = Pattern.compile(STRING_CONSTANT_REGEX);
                    matcher = pattern.matcher(line);
                    if (matcher.find() && matcher.start() == 0) {
                        int pos = symbolTableConstants.addSymbol(matcher.group());
                        int posInBucket = symbolTableConstants.getPositionInBucket(matcher.group());
                        pif.add(new Pair("const", new Pair<>(pos, posInBucket)));
                        line = line.substring(matcher.end());
                        found = true;
                    }

                    if(!found){
                        System.out.println("Lexical error! Undefined token on line " + lineNumber);
                        correct = false;
                        break;
                    }
                }
                lineNumber += 1;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        if(correct){
            System.out.println("Lexically correct");
            writePif();
            writeST();
        }

    }

    private void writePif() throws IOException {
        FileWriter outputfile = new FileWriter("PIF.out");

        for (int i = 0; i < pif.size(); ++i) {
            outputfile.write(pif.get(i) + "\n");
        }
        outputfile.flush();
        outputfile.close();
    }

    private void writeST() throws IOException {
        FileWriter outputfile = new FileWriter("ST.out");

        outputfile.write("ST for identifiers: \n" + String.valueOf(symbolTableIdentifiers));
        outputfile.write("\n");
        outputfile.write("ST for constants: \n" + String.valueOf(symbolTableConstants));

        outputfile.flush();
        outputfile.close();
    }
}
