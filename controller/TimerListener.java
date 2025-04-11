package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.observerPattern.SnakeEvent;
import view.statePattern.GameState;
import view.statePattern.GameStatePlaying;

public class TimerListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();
        if(state instanceof GameStatePlaying){
            detectCollison();
        }
        App.win.getCanvas().repaint();
    }

    private void detectCollison(){
        //snake vs. food
        if(App.model.snakeGotFood()){
            App.model.snake.notifyObeserver(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }

        //snake vs. walls
        if(App.model.snakeLeftScene()){
            App.model.snake.notifyObeserver(SnakeEvent.HIT_WALL);
        }

        //snake vs. self body
        if(App.model.snakeHitsItsBody()){
            App.model.snake.notifyObeserver(SnakeEvent.HIT_SELF);
        }
    }
    
}
