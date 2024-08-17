package Controller;
import View.commendLineView.CLI;
import View.utils.View;

public class Program {
    public static void main(String[] args) {

        args = new String[1];
        args[0] = "E:\\blender\\OOP\\Assignment3OOP\\levels_dir";

        if (args.length != 1) {
            System.out.println("file only accepts 1 argument.");
            return;
        }


        Controller controller = new Controller(args[0]);
        View view = new CLI(controller.getMessageCallback());
        controller.setView(view);
    }
}
