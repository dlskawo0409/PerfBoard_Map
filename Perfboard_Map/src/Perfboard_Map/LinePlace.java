package Perfboard_Map;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

public class LinePlace extends JPanel{
   
   private int width;
   private int height;
   private int magnification;
   
   LinePlace(int width, int height,int magnification){
      this.width=width;
      this.height=height;
      this.magnification = magnification;
      
      
   }
   
    protected void paintComponent(Graphics g) {
       Graphics2D g2=(Graphics2D)g;

       float dash0[] = {1,0f};
       drawDottedLines(g2);
       drawSolidLines(g2);
    
   
    }
    
    protected void drawDottedLines(Graphics2D g2) {
       float dash2[] = {2,2f};
       g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash2,0));
        for (int i=0; i<=width*magnification; i = i+magnification) {
            g2.draw(new Line2D.Float(0, i, width*magnification, i));     // x축과 평행선을 그린다.
            }
         
       for (int j=0; j<=height*magnification; j = j+20) {
            g2.draw(new Line2D.Float(j, 0, j, height*magnification));     // y축과 평행선을 그린다.
             }
    }
    
    protected void drawSolidLines(Graphics2D g2) {
       float dash0[] = {1,0f};
       
       g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash0,0));

        for (int i=0; i<width*magnification; i = i+100) {
           g2.draw(new Line2D.Float(0, i, width*magnification, i));     // x축과 평행선을 그린다.
           }
        
        for (int j=0; j<=height*magnification; j = j+100) {
           g2.draw(new Line2D.Float(j, 0, j, height*magnification));     // y축과 평행선을 그린다.
           }

        }
    
    
}