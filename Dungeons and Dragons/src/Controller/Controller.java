package Controller;

import utilsGeneral.MessageCallBackToController;

public class Controller {

    private MessageCallBackToController messageCallBackViewController;

    public Controller() {
        messageCallBackViewController = this::nextTick;
    }

    public void nextTick(){
        //when the method is called, the next tick begins. no need for the message.
    }
    public MessageCallBackToController getNessageCallback(){
        return messageCallBackViewController;
    }
}
