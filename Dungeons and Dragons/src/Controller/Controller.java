package Controller;

import utilsGeneral.MessageCallBackViewController;

public class Controller {

    private MessageCallBackViewController messageCallBackViewController;

    public Controller() {
        messageCallBackViewController = this::nextTick;
    }

    public void nextTick(){
        //when the method is called, the next tick begins. no need for the message.
    }
    public MessageCallBackViewController getNessageCallback(){
        return messageCallBackViewController;
    }
}
