
package assig2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.ITALIC;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Style;

public class Location {
    int start;
    int size;
    String name;
    Color color;
    JPanel panel;
    JPanel vPanel1;
    JPanel vPanel2;
    JLabel lblEnd;
    JLabel lblsize;
    JLabel lblStart;
    JTextField txt;
    float ratio;
    public Location(int _start,int _size){
        this(_start , _size,"",new Color(0,0,0));
    }
    
    public Location(int _start,int _size,String n,Color c){
        start = _start;
        size = _size;
        ratio = 0.5f;
        name = n;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        color = c;
        confPanel();
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
        lblStart.setText(String.valueOf(start));
        lblsize.setText(String.valueOf(size));
      //  lblEnd.setText(String.valueOf(start+size));
        txt.setText(name);
        vPanel2.setPreferredSize(new Dimension(100, (int)(ratio*size)));
        vPanel1.setPreferredSize(new Dimension(50, (int)(ratio*size)));
        return panel;
    }
    void setName(int i){
        name += String.valueOf(i);
    }
    void confPanel(){
        vPanel1 = new JPanel();
        vPanel1.setLayout(new BorderLayout());
        
        vPanel2 = new JPanel();
        vPanel2.setLayout(new BoxLayout(vPanel2, BoxLayout.Y_AXIS));
        
        lblStart = new JLabel(String.valueOf(start));
    //    lblStart.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        lblStart.setForeground(Color.BLACK);
        vPanel1.add(lblStart,BorderLayout.NORTH);
        
        lblsize = new JLabel(String.valueOf(size));
     //   lblsize.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblsize.setForeground(Color.blue);
        vPanel1.add(lblsize,BorderLayout.CENTER);
        
     //   lblEnd = new JLabel(String.valueOf(size+start));
     //   lblEnd.setAlignmentX(Component.RIGHT_ALIGNMENT);
       // vPanel1.add(lblEnd,BorderLayout.SOUTH);
        
        
        txt = new JTextField(name);
        txt.setBackground(color);
        
        vPanel2.add(txt);
        vPanel2.setPreferredSize(new Dimension(100,(int)(ratio*size)));
        vPanel1.setPreferredSize(new Dimension(50,(int)(ratio*size)));
        panel.add(vPanel1);
        panel.add(vPanel2);
    }

}

