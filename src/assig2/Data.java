/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class Data {
    private static ArrayList<Location> list;
    private static JPanel outputPanel;
    Data(JPanel p){
        list = new ArrayList<>();
        outputPanel = p;
    }
    static void addHole(int start,int size){
        
        updatePanel();
    }
    static void addProcess(int start,int size){
        
        updatePanel();
    }
    private static void updatePanel(){
        JPanel verticalList = new JPanel();
        verticalList.setLayout(new BoxLayout(verticalList, BoxLayout.Y_AXIS));
        //   list.sort();
     //fill unfilled with locations
     
    }
 //   static JPanel getOutput(){
   //     return outputPanel;
  //  }
}
