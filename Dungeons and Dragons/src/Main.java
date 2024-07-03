import Controller.Controller;
import View.commendLineView.CLI;
import Model.board.Board;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("file only accepts 1 argument.");
        }
        else{
            Controller controller = new Controller();
            CLI cli = new CLI(controller.getNessageCallback());
            Board b = new Board(args[0], cli.getMessageCallBack());

        }

    }
}
