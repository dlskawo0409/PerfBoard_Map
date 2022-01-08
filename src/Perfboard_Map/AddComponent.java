package Perfboard_Map;

import javax.swing.*;
import java.awt.event.*;


public class AddComponent extends JPanel{
   JButton add6Pin;
   JButton add8Pin;
   JButton addLine;
   
   Component component; 
   
   
   AddComponent(){
      ButtonGroup buttonGroup = new ButtonGroup();
         
      JToggleButton add6Pin = new JToggleButton(new ImageIcon("images/6Pin.png"));   //<div>Icons made by <a href="https://www.flaticon.com/authors/shmai" title="shmai">shmai</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
      add6Pin.setToolTipText("6핀 ic칩을 표시합니다.");
      buttonGroup.add(add6Pin);
      add(add6Pin);
      add6Pin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            component = Component.PIN6;
         }
      });
         
      JToggleButton add8Pin = new JToggleButton(new ImageIcon("images/8Pin.png"));   //<div>Icons made by <a href="https://www.flaticon.com/authors/payungkead" title="Payungkead">Payungkead</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>   
      add8Pin.setToolTipText("8핀 ic칩을 표시합니다.");
      buttonGroup.add(add8Pin);
      add(add8Pin);
      add8Pin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            component = Component.PIN8;
         }
      });
         
      JToggleButton addLine = new JToggleButton(new ImageIcon("images/line.png"));   //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
      addLine.setToolTipText("서로를 잇습니다.");
      buttonGroup.add(addLine);
      add(addLine);
      add6Pin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            component = Component.LINE;
         }
      });
      
      JToggleButton unSelectedButton = new JToggleButton(); //ButtonGroup은 한번 선택되면 돌아가지지 않기 때문
      buttonGroup.add(unSelectedButton);
      unSelectedButton.setSelected(true);
      component = Component.NON;   //don't want to return null of method of getButtonSelected();
      
      JButton selectInitialization = new JButton("초기화");
      selectInitialization.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            unSelectedButton.setSelected(true);
            component = Component.NON;
         }
      });
      
      add(selectInitialization);
      
         
      setVisible(true);
   }
   
   
   
   public Component getButtonSelected(){
       return component;
   }
}