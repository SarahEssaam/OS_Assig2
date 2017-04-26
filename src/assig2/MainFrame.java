/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Dell
 */
public class MainFrame {
        static JFrame frame;
        inputPanel in;
        static JPanel out;
    public MainFrame() {
        frame = new JFrame("Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setSize(650,450);
        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        in = new inputPanel();
        out = new JPanel();
        out.setPreferredSize(new Dimension(200, 400));
        out.setBorder(new TitledBorder("Output"));
        c.add(in);
        c.add(out);
        frame.pack();
        frame.setVisible(true);
        new Data(out); 
    }
  
}
