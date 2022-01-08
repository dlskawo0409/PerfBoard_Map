package Perfboard_Map;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPlace extends JPanel{
   private int width ;
   private int height;

   private boolean clicked = false;
   private Vector<Point> start = new Vector();
   private Vector<Point> end = new Vector();
   
   private Point prePoint ;
   
   ButtonPlace(int width, int height ,int Gap, int magnification){
      setBackground(Color.GREEN);
      setLayout(new GridLayout(width,height,Gap,Gap));
      
      int sizeOfButton = (width*magnification - (width+1)*Gap)/width; //calculate button size 
      // size of button width and height is same because gap is same width and height
      //int SizeOfButtonHeight = (height*magnification - (height+1)*Gap)/height;

      for(int i =0;i<width;i++) {
         for(int j = 0;j<height;j++) {
            int buttonX = Gap+(sizeOfButton + Gap)*i+ (sizeOfButton/2)*(i+1);
            int buttonY = Gap+(sizeOfButton + Gap)*j+ (sizeOfButton/2)*(j+1);
            
            Button tem = new Button(buttonX,buttonY);
            //JButton tem = new JButton();
            tem.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  System.out.println("button clicked");
                  if(clicked==false) {
                     prePoint = tem.getPoint();
                     start.add(prePoint);
                     System.out.println(start.size());
                     
                     clicked=true;
                  }
                  else {
                     checkSameWithPrePoint(tem.getPoint());
                     repaint();
                     System.out.println(end.size());
                     clicked=false;
                  }
               }
               
            });
            add(tem);
            tem.setLocation(width, height);
            
         }
      }
   }
   
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 =(Graphics2D)g;
      g2.setColor(Color.BLACK);
      System.out.println("a");
      for(int i = 0;i<end.size();i++) {
         Point startOfPoint = start.elementAt(i);
         Point endOfPoint = end.elementAt(i);
         g2.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,0));
        // g2.draw(new Line2D.Double((int)startOfPoint.getX(), (int)startOfPoint.getY(), (int)endOfPoint.getX(), (int)endOfPoint.getY());
         //g.drawLine((int)startOfPoint.getX(), (int)startOfPoint.getY(), (int)endOfPoint.getX(), (int)endOfPoint.getY());
      }
   }
   

   protected void checkSameWithPrePoint(Point nowPoint) {
      if(prePoint.equals(nowPoint))
         start.remove(prePoint);
      else {
         end.add(nowPoint);
      }
   }
   
   
   
}
