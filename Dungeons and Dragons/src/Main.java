import Controller.Controller;
import View.commendLineView.CLI;
import Model.board.Board;

public class Main {

    public static void main(String[] args) {
        args = new String[1];
        args[0] = "C:\\Users\\oreli\\Downloads\\levels_dir\\levels_dir";

        if (args.length != 1) {
            System.out.println("file only accepts 1 argument.");
            return;
        }

        Controller controller = new Controller();
        CLI cli = new CLI(controller.getMessageCallback());
        Board b = new Board(args[0], cli.getMessageCallBack());
        controller.setB(b);
        b.presentPlayerInfo();
    }
}
