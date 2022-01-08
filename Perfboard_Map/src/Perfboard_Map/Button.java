package Perfboard_Map;

import java.awt.Point;
import javax.swing.JButton;

public class Button extends JButton{
   private Point point;
   
   Button(int x , int y){
      point = new Point(x,y);
   }
   
   protected Point getPoint() {
      return point;
   }

}
