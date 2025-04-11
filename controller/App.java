package controller;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameModel;
import view.AppWindow;

public class App {
    public static AppWindow win = new AppWindow();
    public static GameModel model = new GameModel();
    public static Timer timer;
    
    public static final int FPS = 4;
    public static final int DELAY = 1000 / FPS;

    public static void main(String[] args) {
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("Snake Game");
        win.setLocation(300, 200);
        win.pack();
        win.setVisible(true);

        SnakeEventListener listener = new SnakeEventListener();
        App.model.snake.addObserver(listener);
        
        timer = new Timer(DELAY,new TimerListener());
    }
}
