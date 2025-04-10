package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


import model.Food;
import model.Snake;
import model.SnakeNode;

public class AppCanvas extends JPanel{
    
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public AppCanvas(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.black);
    }
    @Override
    public void paintComponent(Graphics g){

        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawScore(g2, App.model.score);
        drawSnake(g2, App.model.snake);
        if(App.model.food != null)
            drawFood(g2, App.model.food);
        if(App.model.messages != null)
            drawMessages(g2, App.model.messages);

    }

    private void drawScore(Graphics2D g2, int score){
        g2.setColor(Color.white);
        g2.setFont(new Font("Courier New", Font.BOLD, 24));
        g2.drawString("Score: " + score, AppCanvas.WIDTH -180, 30);
    }

    private void drawSnake(Graphics2D g2, Snake snake){
        boolean filled = true;
        g2.setColor(Color.blue);
        drawSnakeHead(g2, snake.nodes.get(0));
        for(int i = 1; i < snake.nodes.size(); i++){
            drawSnakeBody(g2, snake.nodes.get(i), filled);
            filled = !filled;

        }

    }

    private void drawSnakeHead(Graphics2D g2, SnakeNode n){
        var h = new Ellipse2D.Float(n.x, n.y, AppWindow.GRID_SIZE, AppWindow.GRID_SIZE);
        g2.fill(h);
    }

    private void drawSnakeBody(Graphics2D g2, SnakeNode n, boolean filled){
        var r = new Rectangle2D.Float(n.x,n.y, AppWindow.GRID_SIZE, AppWindow.GRID_SIZE);
        if(filled) g2.fill(r);
        else g2.draw(r);
    }

    private void drawFood(Graphics2D g2, Food food){
        var e = new Ellipse2D.Float(food.x, food.y, AppWindow.GRID_SIZE, AppWindow.GRID_SIZE);
        g2.setColor(Color.pink);
        g2.fill(e);
    }

    private void drawMessages(Graphics2D g2, String messages){
        g2.setColor(Color.yellow);
        g2.setFont(new Font("Courier New", Font.PLAIN, 28));
        g2.drawString(messages, 50,140);
    }
}
