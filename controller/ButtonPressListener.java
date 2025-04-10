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
                button.setText(AppWindow.PAUSE_ACTION);
                break;
            case AppWindow.PAUSE_ACTION:
                button.setText(AppWindow.START_ACTION);
                App.model.messages = "Paused - Press <Resume>";
                App.win.getCanvas().repaint();
            case AppWindow.RESART_ACTION:
                break;
            case AppWindow.EXIT_ACTION:
                System.exit(0);
                break;

        }
    }
    
}
