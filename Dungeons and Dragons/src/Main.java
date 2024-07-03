import Controller.main.MainController;
import View.commendLineView.CLI;
import View.utils.View;

public class Main {

    public static void main(String[] args) {


        MainController mainController = new MainController();

        View v = new CLI(mainController.getMessageCallBack());


    }
}
