package view.statePattern;

import view.AppWindow;

public interface GameState {
    void goNext(AppWindow context);
    void animate();

    
    
}
