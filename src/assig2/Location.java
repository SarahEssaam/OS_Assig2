
package assig2;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Location {
    int start;
    int size;
    String name;
    Color color;
    JPanel panel;
    float ratio;
    Location(int _start,int _size){
        start = _start;
        size = _size;
        ratio = 0.5f;
        name = "";
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        color = new Color(0,0,0);
    }
    int getStart(){
        return start;
    }
    int getEnd(){
        return start+size;
    }
    int getSize(){
        return size;
    }
    void setStart(int s){
        start = s;
    }
    void setSize(int s){
        size = s;
    }
    JPanel getPanel(){
        JPanel vPanel1 = new JPanel();
        vPanel1.setLayout(new BoxLayout(vPanel1, BoxLayout.Y_AXIS));
        JPanel vPanel2 = new JPanel();
        vPanel2.setLayout(new BoxLayout(vPanel2, BoxLayout.Y_AXIS));
        
        vPanel1.add(new JLabel(String.valueOf(start)));
       // vPanel1.add(new JLabel(String.valueOf(size)));
        vPanel1.add(new JLabel(String.valueOf(size+start)));
        
        JTextField t = new JTextField(name);
        t.setBackground(color);
        
        vPanel2.add(t);
        vPanel2.setPreferredSize(new Dimension(100, (int)(ratio*size)));
        vPanel1.setPreferredSize(new Dimension(50, (int)(ratio*size)));
        panel.add(vPanel1);
        panel.add(vPanel2);
        return panel;
    }
    void setName(int i){
        name += String.valueOf(i);
    }
}

