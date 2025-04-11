package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStatePlaying implements GameState{

    public GameStatePlaying(){
        App.win.startPauseButton.setText(AppWindow.PAUSE_ACTION);
        App.win.resartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
    }

    @Override
    public void goNext(AppWindow context) {
    
        if(App.model.snakeHitsItsBody() || App.model.snakeLeftScene())
            context.setGameState(new GameStateOver());
        else
            context.setGameState(new GameStatePaused());
    }

    @Override
    public void animate() {
       App.model.snake.move();
    }
    
}
