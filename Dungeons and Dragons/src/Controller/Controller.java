package Controller;
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

    public void nextTick(){
        handleUserInput();
    }
    private void handleUserInput(){
        String userInput = sc.nextLine();
        while (userInput.length() != 1){
            userInput = sc.nextLine();
        }
        b.handleUserInput(userInput.charAt(0));
    }

    public MessageCallBackToController getMessageCallback(){
        return messageCallBackViewController;
    }
}
