package model;

import java.util.ArrayList;

import view.AppWindow;

public class Snake {
    
    public ArrayList<SnakeNode> nodes = new ArrayList<>();
    
    private final int INIT_XLOC = AppWindow.GRID_SIZE * 7;
    private final int INIT_YLOC = AppWindow.GRID_SIZE * 3;
    private final int INT_NODES = 6;
    private Direction direction;

    public Snake(){
        init();

    }

    public void init(){
        nodes.clear();
        direction = Direction.RIGHT;
        for(int i =0; i < INT_NODES; i++){
            int x = INIT_XLOC - i * AppWindow.GRID_SIZE;
            int y = INIT_YLOC ;
            nodes.add(new SnakeNode(x, y));
        }
    }
    

    public void move(){
        for(int i =nodes.size() - 1 ; i > 0; i--){
            nodes.get(i).x = nodes.get(i-1).x;
            nodes.get(i).y = nodes.get(i-1).y;


        } 
        SnakeNode head = nodes.get(0);
        switch(direction){
            case LEFT:
                head.x -=AppWindow.GRID_SIZE;
                break;
            case RIGHT:

                head.x += AppWindow.GRID_SIZE;
                break;
            case UP:
                head.y -= AppWindow.GRID_SIZE;
                break;
            case DOWN:
                head.y += AppWindow.GRID_SIZE;
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
