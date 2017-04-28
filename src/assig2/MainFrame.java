package assig2;

import static assig2.outPanel.cardPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainFrame {
        static JFrame frame;
        inputPanel in;
        static JPanel out;
        
    public MainFrame() {
        frame = new JFrame("Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame .setLocationRelativeTo(null);
        frame.setSize(650,450);
        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        in = new inputPanel();
        out = new JPanel();
        out.setLayout(new BoxLayout(out, BoxLayout.Y_AXIS));
    new outPanel();
        out.add(cardPanel);
        out.setBorder(new TitledBorder("Output"));
        out.setPreferredSize(new Dimension(200,650));
        c.add(in);
        c.add(out);
       // frame.pack();
        frame.setVisible(true);
        new Data(); 
    }
     
    static void updateOut(JPanel newOut,String name){
        outPanel.addCard(newOut, name);
        out.revalidate();
        frame.revalidate();
    }
}
