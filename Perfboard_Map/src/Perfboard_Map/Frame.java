package Perfboard_Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseWheelListener;

public class Frame extends JFrame{
   private Container contentPane;
   PerfBoard perfBoard;
   
   public Frame() {
      setTitle("PerfBoard Map");
      setSize(1200,700);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPane =getContentPane();
      this.setLayout(new BorderLayout());
      
      toolBar();
      //addToolBar();
      
     AddComponent addComponent = new AddComponent();
     add(addComponent,BorderLayout.EAST);
     addComponent.setPreferredSize(new Dimension(50,super.getHeight()));
      
      perfBoard = new PerfBoard();
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
   
   private void addToolBar() {
      JToolBar addToolBar =new JToolBar();
      addToolBar.setFloatable(false);
      addToolBar.setBackground(java.awt.Color.CYAN);
      addToolBar.setLayout(new GridLayout(3,1,80,80));
      addToolBar.setSize(30, super.getHeight());
      
      ButtonGroup buttonGroup = new ButtonGroup();
      
      JToggleButton add6Pin = new JToggleButton(new ImageIcon("images/6Pin.png"));   //<div>Icons made by <a href="https://www.flaticon.com/authors/shmai" title="shmai">shmai</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
      add6Pin.setToolTipText("6�� icĨ�� ǥ���մϴ�.");
      addToolBar.add(add6Pin);
      addToolBar.addSeparator();
      buttonGroup.add(add6Pin);
      
      JToggleButton add8Pin = new JToggleButton(new ImageIcon("images/8Pin.png"));   //<div>Icons made by <a href="https://www.flaticon.com/authors/payungkead" title="Payungkead">Payungkead</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>   
      add8Pin.setToolTipText("8�� icĨ�� ǥ���մϴ�.");
      addToolBar.add(add8Pin);
      addToolBar.addSeparator();
      buttonGroup.add(add8Pin);
      
      JToggleButton addLine = new JToggleButton(new ImageIcon("images/line.png"));   //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
      addLine.setToolTipText("���θ� �ս��ϴ�.");
      addToolBar.add(addLine);
      addToolBar.addSeparator();
      buttonGroup.add(addLine);
      
      contentPane.add(addToolBar,BorderLayout.EAST);
      
      addToolBar.setPreferredSize(new Dimension(100,100));
   }
   

   
   public static void main(String[] args) {
      new Frame();
      
   }
}