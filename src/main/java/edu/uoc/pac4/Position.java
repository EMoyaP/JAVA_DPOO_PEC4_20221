package edu.uoc.pac4;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addOffset(int xOffset, int yOffset) {
        this.x += xOffset;
        this.y += yOffset;
    }

    public boolean isCloseTo(Position target, int MIN_TARGET_DISTANCE){
        int differenceX = Math.abs(this.x - target.x);
        int differenceY = Math.abs(this.y - target.y);
        return  differenceX < MIN_TARGET_DISTANCE && differenceY < MIN_TARGET_DISTANCE;
    }
    public int getXOrientation(Position target){
        if (this.x < target.x) {
            return 1;
        } else if (this.x > target.x) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getYOrientation(Position target){
        if (this.y < target.y) {
            return 1;
        } else if (this.y > target.y) {
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public boolean equals(Object obj) {
        super.equals(obj);

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}


