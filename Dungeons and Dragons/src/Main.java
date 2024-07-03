import Controller.Controller;
import View.commendLineView.CLI;
import View.utils.View;
import Model.board.board;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("file only accepts 1 argument.");
        }
        else{
            Controller controller = new Controller();
            CLI cli = new CLI(controller.getNessageCallback());
            board b = new board(args[0], cli.getMessageCallBack());

        }

    }
}
