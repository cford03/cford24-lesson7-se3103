package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;

public class KeyPressListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                App.model.snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                App.model.snake.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                App.model.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                App.model.snake.setDirection(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
