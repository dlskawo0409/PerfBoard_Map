package Perfboard_Map;

import java.awt.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PerfBoard extends JPanel{
   private int width ;
   private int height;
   private int stringSize;
   private int magnification;
   
   private ButtonPlace buttonPlace;
   
   //private Vector<Vector> button;
   
   PerfBoard(){
      this(50,50);
   }
   
   
   PerfBoard(int width, int height){
      this.width = width;
      this.height = height;
      this.stringSize = 20;
      this.magnification = 20;
      this.setLayout(null);
      
      
      //buttonPlace = new ButtonPlace(width,height, 7, magnification);
      //this.add(buttonPlace);
      //buttonPlace.setLocation(stringSize, stringSize);
      //buttonPlace.setSize(width*magnification, height*magnification);
      
      LinePlace linePlace = new LinePlace(width,height,magnification);
      this.add(linePlace);
      linePlace.setLocation(stringSize, stringSize);
      linePlace.setSize(width*magnification, height*magnification);
   
      
   }
   
   public void setWidth(int width) {
      this.width=width;
   }
   
   public void setHeight(int height) {
      this.height = height;
   }
   
   public void setStringSize(int stringSize) {
      this.stringSize= stringSize;
   }
   
   
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.setColor(Color.BLACK);
      g.drawRect(stringSize, magnification, width*magnification, height*magnification);
      
      drawVerticalLineNum(g);
      drawHorizontalLineNum(g);
      
   }
   
   protected void drawVerticalLines(Graphics g) {
      g.setColor(Color.GRAY);
      for(int i = stringSize;i<height*magnification+stringSize;i=i+magnification) {
         for(int j = 5;j<width*magnification+stringSize;j=j+magnification) {
            g.drawLine(i,j,i,j+5);

         }
      }
   }
   
   protected void drawVerticalLineNum(Graphics g) {
      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial",Font.ITALIC,stringSize));
      for(int i = 1;i<=height;i++)
         
         g.drawString(Integer.toString(i), 0, (i+1)*magnification);
   }
   
   protected void drawHorizontalLineNum(Graphics g) {
      g.setColor(Color.RED);
      g.setFont(new Font("Arial",Font.ITALIC,stringSize));
      for(int i = 1;i<=width;i++)
         g.drawString(Integer.toString(i), i*magnification, 15);
   }

   
}