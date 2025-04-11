package model.observerPattern;

public interface SnakeObserver {
    void hitFood();
    void hitWall();
    void hitSelf();
}
