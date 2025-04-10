package controller;

import javax.swing.JFrame;

import model.GameModel;
import view.AppWindow;

public class App {
    public static AppWindow win = new AppWindow();
    public static GameModel model = new GameModel();
    

    public static void main(String[] args) {
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("Snake Game");
        win.setLocation(300, 200);
        win.pack();
        win.setVisible(true);
    }
}
