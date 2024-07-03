package View.commendLineView;

import utilsGeneral.MessageCallBack;
import View.utils.View;

public class CLI implements View{

    private MessageCallBack messageCallBack;
    private MessageCallBack messageCallBackfromController;

    public CLI(MessageCallBack messageCallBackfromController){
        messageCallBack = new MessageCallBack() {
            @Override
            public void sendMessage(String message) {
                //TODO: Implement
            }
        };
        this.messageCallBackfromController = messageCallBackfromController;
    }


    public MessageCallBack getMessageCallBack(){
        return this.messageCallBack;
    }

}
