package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.statePattern.GameState;

public class TimerListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();
        App.win.getCanvas().repaint();
    }
    
}
