package task;

public enum Direction {
    North(0,-1),
    West(-1,0),
    South(0,1),
    East(1,0);
    private int offsetX;
    private int offsetY;
    Direction(int offsetX,int offsetY){
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
    public Vector2 move(Vector2 start, double distance){
        return new Vector2(start.getX()+distance*offsetX,start.getY()+distance*offsetY);
    }
}

