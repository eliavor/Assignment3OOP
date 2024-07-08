package Controller.utils;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Model.game.Board;

public class InputHandler {
    Board b;
    Scanner sc = new Scanner(System.in);



    public InputHandler() {
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

    public int handleUserFirstInput(){
        String userInput = sc.nextLine();
        while (userInput.length() != 1 || userInput.charAt(0) >'6' || userInput.charAt(0) < '1'){
            userInput = sc.nextLine();
        }
        return Character.getNumericValue(userInput.charAt(0));
    }

    public char handleUserInput(){
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
        return userInput.charAt(0);
    }



}
