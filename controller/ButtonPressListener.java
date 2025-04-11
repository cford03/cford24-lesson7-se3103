package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.AppWindow;

public class ButtonPressListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        JButton button = (JButton) e.getSource();
        switch (action){
            case AppWindow.START_ACTION:
                App.model.messages = null;
                
                App.win.goNextState();
                App.timer.start();
                break;
            case AppWindow.PAUSE_ACTION:
                App.win.goNextState();
                App.model.messages = "Paused - Press <Resume>";
                App.timer.stop();
                App.win.getCanvas().repaint();
            case AppWindow.RESART_ACTION:
                App.model.init();
                App.win.goNextState();
                App.timer.stop();
                App.win.getCanvas().repaint();
                break;
            case AppWindow.EXIT_ACTION:
                System.exit(0);
                break;

        }
    }
    
}
