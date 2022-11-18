import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FiniteAutomata {
    private List<String> Q;
    private List<String> E;
    private String q0;
    private List<String> F;
    private HashMap<Pair<String, String>, List<String>> T = new HashMap<>();

    public FiniteAutomata(String filename) throws Exception {
        readFiniteAutomata(filename);
    }

    public List<String> getSetOfStates() {
        return Q;
    }

    public List<String> getAlphabet() {
        return E;
    }

    public String getInitialState() {
        return q0;
    }

    public List<String> getFinalStates() {
        return F;
    }

    public HashMap<Pair<String, String>, List<String>> getTransitionFunctions() {
        return T;
    }

    private void readFiniteAutomata(String filename) throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            Q = readLine(br);
            E = readLine(br);
            q0 = readLine(br).get(0);
            F = readLine(br);

            br.readLine();
            String line = br.readLine();
            while(line != null){
                String source = line.split("->")[0].replace("(","").replace(")","").split(",")[0].trim();
                String transition = line.split("->")[0].replace("(","").replace(")","").split(",")[1].trim();
                String destination = line.split("->")[1].trim();
                Pair<String, String> pair = new Pair<>(source, transition);
                if(T.get(pair) != null){
                    List<String> destinationList = new ArrayList<>(T.get(pair));
                    destinationList.add(destination);
                    T.put(pair, destinationList);
                } else {
                    T.put(pair, Collections.singletonList(destination));
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> readLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        List <String> list =  Arrays.asList(line.split(" "));
        return list.subList(2, list.size());
    }

    public boolean isDFA(){
        for(Pair<String, String> key: T.keySet()){
            if(T.get(key).size() > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isAcceptedByFA(String sequence){
        if(!isDFA()) {
            return false;
        }
        String currentState = q0;
        for(int i=0; i<sequence.length(); i++){
            Pair<String, String> pair = new Pair<>(currentState, String.valueOf(sequence.charAt(i)));
            if(T.get(pair) != null){
                currentState = T.get(pair).get(0);
            } else {
                return false;
            }
        }
        return F.contains(currentState);
    }
}
