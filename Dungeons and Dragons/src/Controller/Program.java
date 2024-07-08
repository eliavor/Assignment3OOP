package Controller;
import View.commendLineView.CLI;
import View.utils.View;

public class Program {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("file only accepts 1 argument.");
            return;
        }

        args = new String[1];
        args[0] = "C:\\Users\\oreli\\Downloads\\levels_dir\\levels_dir";

        Controller controller = new Controller(args[0]);
        View view = new CLI(controller.getMessageCallback());
        controller.setView(view);
    }
}
