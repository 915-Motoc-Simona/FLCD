import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FiniteAutomata finiteAutomata = new FiniteAutomata("D:\\ubb\\third-year\\FLCD\\Lab4\\lab4\\src\\FA.in");
        boolean exit = false;
        Scanner keyboard = new Scanner(System.in);
        while(!exit) {
            printMenu();
            int option = keyboard.nextInt();
            switch (option) {
                case 1:
                    System.out.println(finiteAutomata.getSetOfStates());
                    break;
                case 2:
                    System.out.println(finiteAutomata.getAlphabet());
                    break;
                case 3:
                    System.out.println(finiteAutomata.getTransitionFunctions());
                    break;
                case 4:
                    System.out.println(finiteAutomata.getInitialState());
                    break;
                case 5:
                    System.out.println(finiteAutomata.getFinalStates());
                    break;
                case 6:
                    if (finiteAutomata.isDFA()) {
                        System.out.println("It is DFA");
                    } else {
                        System.out.println("It is not DFA");
                    }
                    break;
                case 7:
                    System.out.println("Enter sequence:");
                    keyboard.nextLine();
                    String sequence = keyboard.nextLine();
                    if (finiteAutomata.isAcceptedByFA(sequence)) {
                        System.out.println("Accepted by FA");
                    } else {
                        System.out.println("Rejected by FA");
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Print set of states");
        System.out.println("2. Print alphabet");
        System.out.println("3. Print transitions");
        System.out.println("4. Print initial state");
        System.out.println("5. Print the set of final states");
        System.out.println("6. Check if it is a DFA");
        System.out.println("7. Check a sequence");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }
}