package Model.tiles.units.enemies;

import utilsGeneral.MessageCallBackToView;

public class Trap extends Enemy{

    private int visibilityTime;
    private int invisibilityTime;
    private int tickCount;
    private boolean isVisible;

    public Trap(int x, int y, String name, char symbol, int health , int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime, MessageCallBackToView messageCallBackToView) {
        super( x, y, name, symbol, health, attack, defense, experienceValue,messageCallBackToView);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.tickCount = 0;//
        this.isVisible = true;//
    }
}
