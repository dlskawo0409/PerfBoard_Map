package Perfboard_Map;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;


public class Frame extends JFrame{
   private Container contentPane;
   private PerfBoard perfBoard;
   private AddComponent addComponent;
   
   public Frame() {
      setTitle("PerfBoard Map");
      setSize(1500,1500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPane =getContentPane();
      this.setLayout(new BorderLayout());
      
      toolBar();
      
      AddComponent addComponent = new AddComponent();
      add(addComponent,BorderLayout.EAST);
      addComponent.setPreferredSize(new Dimension(70,super.getHeight()));
      
      perfBoard = new PerfBoard(50,50,addComponent);
      perfBoard.setPreferredSize(new Dimension(1200,1200));
      
      JScrollPane scroll = new JScrollPane(perfBoard);
      scroll.getVerticalScrollBar().setUnitIncrement(16);   //scroll speed
      scroll.getHorizontalScrollBar().setUnitIncrement(16);
      add(scroll,BorderLayout.CENTER);
      
      
      setVisible(true);
   }
   
   private void toolBar() { 
      JToolBar toolBar =new JToolBar();
      toolBar.setFloatable(false);
      toolBar.setBackground(java.awt.Color.LIGHT_GRAY);
      
      JButton newButton= new JButton("new");
      newButton.setToolTipText("새로운 만능기판을 생성합니다.");
      toolBar.add(newButton);
      toolBar.addSeparator();
      
      JButton saveButton = new JButton(new ImageIcon("images/save.png"));
      saveButton.setToolTipText("기본()으로 저장됩니다.");
      toolBar.add(saveButton);
      toolBar.addSeparator();
      
     JButton saveOtherName =new JButton("다른이름으로 저장");
      saveOtherName.setToolTipText("다른이름으로 저장합니다.");
      toolBar.add(saveOtherName);
      toolBar.addSeparator();
      
      toolBar.add(new JButton("불러오기"));
      
      contentPane.add(toolBar, java.awt.BorderLayout.NORTH);
   }
   

   public static void main(String[] args) {
      new Frame();
      
   }
}
