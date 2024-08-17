package Model.utils;


public class Position implements Comparable<Position>{
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;

    }
    public Position(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public double distance(Position other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Position other) {
        if(other.getY() < getY()){
            return 1;
        }
        else if(other.getY() > getY()){
            return -1;
        }
        if(other.getX() < getX()){
            return 1;
        }
        else if(other.getX() > getX()){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Position){
            Position p = (Position) other;
            return x == p.getX() && y == p.getY();
        }
        return false;
    }
}
