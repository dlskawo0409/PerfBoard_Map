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
      newButton.setToolTipText("���ο� ���ɱ����� �����մϴ�.");
      toolBar.add(newButton);
      toolBar.addSeparator();
      
      JButton saveButton = new JButton(new ImageIcon("images/save.png"));
      saveButton.setToolTipText("�⺻()���� ����˴ϴ�.");
      toolBar.add(saveButton);
      toolBar.addSeparator();
      
     JButton saveOtherName =new JButton("�ٸ��̸����� ����");
      saveOtherName.setToolTipText("�ٸ��̸����� �����մϴ�.");
      toolBar.add(saveOtherName);
      toolBar.addSeparator();
      
      toolBar.add(new JButton("�ҷ�����"));
      
      contentPane.add(toolBar, java.awt.BorderLayout.NORTH);
   }
   

   public static void main(String[] args) {
      new Frame();
      
   }
}
