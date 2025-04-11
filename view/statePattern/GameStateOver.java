package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState {

    public GameStateOver(){
        
        App.win.resartButton.setEnabled(true);
        App.win.startPauseButton.setEnabled(false);


    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateInIt());
    }

    @Override
    public void animate() {
        //snake falling effect
        App.model.snake.falling();
    }
    
}
