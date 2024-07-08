package View.utils;

import utilsGeneral.MessageCallBackToController;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.List;

public interface View {

    public MessageCallBackToView getMessageCallBack();

    public void choosePlayer(List<Dictionary<String, String>> players);
    public void winGame();
}