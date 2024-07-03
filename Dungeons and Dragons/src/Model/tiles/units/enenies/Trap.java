package Model.tiles.units.enenies;

import utilsGeneral.MessageCallBackToView;

public class Trap extends Enemy{

    private int visibilityTime;
    private int invisibilityTime;
    private int tickCount;
    private boolean isVisible;

    public Trap(String name, char symbol, int health , int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime, MessageCallBackToView messageCallBackToView) {
        super(name, symbol, health, attack, defense, experienceValue,messageCallBackToView);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.tickCount = 0;//
        this.isVisible = true;//
    }
}
