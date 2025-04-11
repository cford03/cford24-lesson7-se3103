package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStatePaused implements GameState{

    public GameStatePaused(){
        App.win.startPauseButton.setText(AppWindow.START_ACTION);
        App.win.resartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true); 
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStatePlaying());

    }

    @Override
    public void animate() {
        
    }
    
}
