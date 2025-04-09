package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppWindow extends JFrame{
    
    private AppCanvas canvas;
    public static final int GRID_SIZE = 20;

    public JButton startPauseButton;
    public JButton resartButton;
    public JButton exitButton;
    public static final String START_ACTION = "Start";
    public static final String PAUSE_ACTION = "Pause";
    public static final String RESART_ACTION = "App Restart";
    public static final String EXIT_ACTION = "Exit";


    public void init(){
        Container cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        startPauseButton = new JButton(START_ACTION);
        resartButton = new JButton(RESART_ACTION);
        exitButton = new JButton(EXIT_ACTION);
        southPanel.add(startPauseButton);
        southPanel.add(resartButton);
        southPanel.add(exitButton);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
}
