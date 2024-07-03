package View.commendLineView;

import utilsGeneral.MessageCallBackViewController;
import View.utils.View;

public class CLI implements View{

    private MessageCallBackViewController messageCallBackViewController;
    private MessageCallBackViewController messageCallBackfromControllerViewController;

    public CLI(MessageCallBackViewController messageCallBackfromControllerViewController){
        messageCallBackViewController = new MessageCallBackViewController() {
            @Override
            public void nextTick() {
                //TODO: Implement
            }
        };
        this.messageCallBackfromControllerViewController = messageCallBackfromControllerViewController;
    }


    public MessageCallBackViewController getMessageCallBack(){
        return this.messageCallBackViewController;
    }

}
