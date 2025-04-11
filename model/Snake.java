package model;

import java.util.ArrayList;

import model.observerPattern.SnakeEvent;
import model.observerPattern.SnakeObserver;
import model.observerPattern.Subject;
import view.AppCanvas;
import view.AppWindow;

public class Snake implements Subject{
    
    public ArrayList<SnakeNode> nodes = new ArrayList<>();
    
    private final int INIT_XLOC = AppWindow.GRID_SIZE * 7;
    private final int INIT_YLOC = AppWindow.GRID_SIZE * 3;
    private final int INT_NODES = 6;
    private Direction direction;
    private ArrayList<SnakeObserver> observers = new ArrayList<>();

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

    public void falling(){
        if(nodes.get(0).y >= AppCanvas.HEIGHT - AppWindow.GRID_SIZE) return;
        for(int i =0; i < nodes.size(); i++){
            nodes.get(i).y +=5;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void addObserver(SnakeObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(SnakeObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObeserver(SnakeEvent e) {
        switch (e) {
            case HIT_FOOD:
                    for(var o: observers)
                    o.hitFood();
                break;
            case HIT_SELF:
                    for(var o: observers)
                    o.hitSelf();
                    break;
            case HIT_WALL:
                    for(var o: observers)
                    o.hitWall();
           
        }
    }
}
