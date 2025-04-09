package model;

import java.util.Random;

import view.AppCanvas;
import view.AppWindow;

public class GameModel {

    public Snake snake;
    public Food food;
    public String messages;
    public int score;

    public GameModel() {
        snake = new Snake();
        init();

    }

    public void init() {
        snake.init();
        score = 0;
        messages = "Click <Start> to Play!";
        food = createFood();

    }

    public Food createFood() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
            y = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        } while (isInsideSnake(x, y));
        return new Food(x, y);
    }

    private boolean isInsideSnake(int x, int y) {
        for (var node : snake.nodes) {
            if (node.x == x && node.y == y)
                return true;

        }
        return false;
    }
}
