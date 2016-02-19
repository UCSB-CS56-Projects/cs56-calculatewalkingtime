import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ImagePaneTest extends JFrame
{
  ImageIcon ic = new   ImageIcon("map.jpg");
  JDesktopPane dp = new JDesktopPane();
  JLabel lbl = new JLabel(ic);
  JPanel transparentPanel = new JPanel();
   
  public ImagePaneTest()
   {
     
      lbl.setBounds(0,0,850,1100); 
      
       
      transparentPanel.setOpaque(false);
      transparentPanel.setBounds(0,0,1000,1000);
       
      JCheckBox2 HFH = new JCheckBox2();


      HFH.Name = "HFH";
      this.setLayout(null);
       transparentPanel.setLayout(null);
       //HFH.setSize(50,50);
       HFH.setBounds(690,410,20,20);
       transparentPanel.add(HFH); 



       //add DAVDIDSON
       
       JCheckBox2 LIB = new JCheckBox2();
       LIB.Name = "LIB";
       LIB.setBounds(460, 430, 20,20);
       transparentPanel.add(LIB);

       super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      dp.add(lbl,new Integer(50));
      dp.add(transparentPanel,new Integer(350));
     
      setLayeredPane(dp);
       
   }
   public static void main(String a[])
   {
       ImagePaneTest fr = new ImagePaneTest();
       fr.setSize(850, 1050); 
       fr.setVisible(true); 
   }
     
}
