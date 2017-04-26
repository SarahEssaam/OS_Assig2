/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class test {
    test(){
       JPanel p = new JPanel();
       p.setLayout(new FlowLayout());
       p.add(new JButton("button1"));
       // p.add(new JButton("button2"));
       JFrame f = new JFrame();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.add(p);
     // f.pack();
     f.setSize(500,500);  
     f.setVisible(true);
       p.add(new JButton("button2"));
       f.add(p); 
//f.repaint();
//f.revalidate();
    
    }
}
