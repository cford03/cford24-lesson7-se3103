package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

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
    }
}
