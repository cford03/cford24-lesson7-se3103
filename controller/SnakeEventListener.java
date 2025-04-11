package controller;

import model.SnakeNode;
import model.observerPattern.SnakeObserver;

public class SnakeEventListener implements SnakeObserver {

    @Override
    public void hitFood() {
        App.model.score += 10;
        App.model.snake.nodes.add(new SnakeNode(-100,-100));
        
    }

    @Override
    public void hitWall() {
        App.model.messages = "Hit the Wall - Press <Restart>";
        App.win.goNextState();
    }

    @Override
    public void hitSelf() {
        App.model.messages = "Hit self body - Press <Restart>";
        App.win.goNextState();
    }
    
}
