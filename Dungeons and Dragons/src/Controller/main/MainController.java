package Controller.main;

import View.commendLineView.CLI;
import utilsGeneral.MessageCallBack;

import View.utils.View;

public class MainController {

    View Display;

    MessageCallBack messageCallBackToView;

    public MainController() {
        this.messageCallBackToView = new MessageCallBack() {
            @Override
            public void sendMessage(String message) {
                //TODO: Implement
            }
        };


        Display = new CLI(messageCallBackToView);
    }


    public MessageCallBack getMessageCallBack(){
        return this.messageCallBackToView;
    }

}
