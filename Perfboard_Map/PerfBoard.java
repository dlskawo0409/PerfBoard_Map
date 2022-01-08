package Perfboard_Map;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfBoard extends JPanel{
   private int width ;
   private int height;
   private int stringSize;
   private int magnification;
   private AddComponent addComponent;
   
   PerfBoard(int width, int height, AddComponent addComponent){
      this.width = width;
      this.height = height;
      this.stringSize=23;
      this.magnification = 23; //because of distinguishing text.
      this.setLayout(null);
      this.addComponent = addComponent;
      
     /* addMouseListener(new MouseAdapter() {
        public void  mousePressed(MouseEvent e) {
           
           if(addComponent.getButtonSelected().equals(Component.PIN6)) {
              System.out.println("pin6");
              draw6Pin(e.getX(), getY());
              }
           else if (addComponent.getButtonSelected().equals(Component.PIN8)) {
              
            }
           else if(addComponent.getButtonSelected().equals(Component.LINE)) {
              
            }
        }
        
       public void mouseEntered(MouseEvent e) {
          Point P = e.getPoint();
          if(addComponent.getButtonSelected().equals(Component.PIN6)) {
             followMouse(e.getPoint(),Component.PIN6);
             }
          else if (addComponent.getButtonSelected().equals(Component.PIN8)) {
             
          }
       }
      
      });*/
       
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
      
      
      Graphics2D g2=(Graphics2D)g;
      drawDottedLines(g2);
      drawSolidLines(g2);
      
   }

   protected void drawVerticalLineNum(Graphics g) {
      g.setFont(new Font("Arial",Font.ITALIC,stringSize));
      for(int i = 1;i<=height;i++) {
         g.setColor(Color.BLACK);
         if(i%5==0)
            g.setColor(Color.GREEN);
         g.drawString(Integer.toString(i), 0, (i+1)*magnification);

      }
   }
   
   protected void drawHorizontalLineNum(Graphics g) {
      g.setFont(new Font("Arial",Font.ITALIC,stringSize));
      for(int i = 1;i<=width;i++) {
         g.setColor(Color.GRAY);
         if(i%5==0)
            g.setColor(Color.CYAN);
         g.drawString(Integer.toString(i), i*magnification, 15);
         
      }
   }

   protected void drawDottedLines(Graphics2D g2) { 
      float dash2[] = {2,2f};
          g2.setColor(Color.BLACK);
          g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash2,0));
           for (int i=stringSize; i<=width*magnification+stringSize; i = i+magnification) {
               g2.draw(new Line2D.Float(stringSize, i, width*magnification+stringSize, i));     // draw horizontal line
               }
            
          for (int j=stringSize; j<=height*magnification+stringSize; j = j+magnification) {
               g2.draw(new Line2D.Float(j, stringSize, j, height*magnification+stringSize));     // draw vertical line
                }
       }
       
       protected void drawSolidLines(Graphics2D g2) {
          float dash0[] = {1,0f};
          g2.setColor(Color.BLACK);
          g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash0,0));

           for (int i=stringSize; i<width*magnification+stringSize; i = i+magnification*5) {
              g2.draw(new Line2D.Float(stringSize, i, width*magnification+stringSize, i));     // draw horizontal line
              }
           
           for (int j=stringSize; j<=height*magnification+stringSize; j = j+magnification*5) {
              g2.draw(new Line2D.Float(j, stringSize, j, height*magnification+stringSize));     // draw horizontal line
              }

           }
       
       protected void draw6Pin(int x, int y) {
          
       }
       
       protected void followMouse(Point p , Component component ) {
          JLabel PinLabel = new JLabel();
          add(PinLabel);
          if(component.equals(Component.PIN6)) {
             PinLabel.setBounds(100,100,magnification*6,magnification*4);
          }
          PinLabel.setLocation(p);
       }
       
   
}
