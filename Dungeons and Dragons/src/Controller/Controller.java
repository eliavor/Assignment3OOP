package Controller;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Model.board.Board;
import utilsGeneral.MessageCallBackToController;

public class Controller {
    Board b;
    Scanner sc = new Scanner(System.in);
    private MessageCallBackToController messageCallBackViewController;



    public Controller() {
        messageCallBackViewController = this::nextTick;
    }
    public void setB(Board b){
        this.b =b;
    }

    public void nextTick(boolean isFirstRound){
        if(isFirstRound){
            handleUserFirstInput();
        }
        else {
            handleUserInput();
        }
    }

    private void handleUserFirstInput(){
        String userInput = sc.nextLine();
        while (userInput.length() != 1 || userInput.charAt(0) >'6' || userInput.charAt(0) < '1'){
            userInput = sc.nextLine();
        }
        b.startGame(Character.getNumericValue(userInput.charAt(0)));
    }

    private void handleUserInput(){
        List<Character> validInput = new LinkedList<>();
        validInput.add('w');
        validInput.add('a');
        validInput.add('s');
        validInput.add('d');
        validInput.add('e');
        validInput.add('q');
        String userInput = sc.nextLine();
        while (userInput.length() != 1 || !validInput.contains(userInput.charAt(0))){
            userInput = sc.nextLine();
        }
        b.handleUserInput(userInput.charAt(0));
    }

    public MessageCallBackToController getMessageCallback(){
        return messageCallBackViewController;
    }
}
