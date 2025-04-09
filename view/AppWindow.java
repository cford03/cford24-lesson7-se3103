package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class AppWindow extends JFrame{
    
    private AppCanvas canvas;

    public void init(){
        Container cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);
        

    }
}
