/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;
import javax.swing.*;
import java.awt.*;
        
public class Assig2 {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel hp = new JPanel();
        hp.setLayout(new BoxLayout(hp, BoxLayout.X_AXIS));
        JPanel vp = new JPanel();
        vp.setLayout(new BoxLayout(vp, BoxLayout.Y_AXIS));
        vp.add(new Label("limit"));
        vp.add(new Label("base"));
        hp.add(vp);
        JTextField t = new JTextField("p");
        hp.add(t);
        JPanel hp1 = new JPanel();
        hp1.setLayout(new BoxLayout(hp1, BoxLayout.X_AXIS));
        JPanel vp1 = new JPanel();
        vp1.setLayout(new BoxLayout(vp1, BoxLayout.Y_AXIS));
        vp1.add(new Label("limit"));
        vp1.add(new Label("base"));
        hp1.add(vp1);
        JTextField t1 = new JTextField("p");
        hp1.add(t1);
        JPanel to = new JPanel();
        to.setLayout(new BoxLayout(to, BoxLayout.Y_AXIS));
        to.add(hp);
        to.add(hp1);
        f.getContentPane().add(to);
        f.pack();
        f.setVisible(true);
    }
    
}
