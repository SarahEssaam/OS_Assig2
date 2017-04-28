/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

public class outPanel {
    static CardLayout cards;
    public static JPanel cardPanel;
//    static int current;
//JButton previous;
//JButton next;
//public static JPanel hPa;    
    public outPanel()
    { 
        cards = new CardLayout();
        cardPanel = new JPanel();
//        current = 0;
       // Border outline = BorderFactory.createLineBorder(Color.black);
      //  cardPanel.setBorder(outline);
        cardPanel.setLayout(new BoxLayout(cardPanel,BoxLayout.Y_AXIS));
        cardPanel.setLayout(cards);
        
  //      previous = new JButton("< Previous");
    //    next = new JButton("Next >");  
//        hPa = new JPanel();
//        hPa.setLayout(new BoxLayout(hPa, BoxLayout.X_AXIS));
//        hPa.add(previous);
//        hPa.add(next);
//        
//        previous.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cards.show(cardPanel,String.valueOf(current));
//                cardPanel.revalidate();
//            }
//        });
//        next.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cards.show(cardPanel,String.valueOf(current));
//                cardPanel.revalidate();
//            }
//        });
    }
    
   static void addCard(JPanel p,String name){
  //     current = Integer.valueOf(name);
       cardPanel.add(p,name);
       cards.show(cardPanel, name);
       cardPanel.revalidate();
   }
    
    
}