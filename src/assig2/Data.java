/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;


import java.awt.Button;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Data {
    private static ArrayList<Location> list;
    private static JPanel outputPanel;
    private static JPanel verticalList;
    private static int pCount;
    private static int hCount;
    Data(JPanel p){
        list = new ArrayList<>();
        outputPanel = p;
//        verticalList = new JPanel();
//        verticalList.setLayout(new BoxLayout(verticalList, BoxLayout.Y_AXIS));
        pCount = 0;
        hCount = 0;
    }
    static void addHole(int start,int size){
        Hole h = new Hole(start,size);
        h.setName(hCount++);
        list.add(h);
    }
    static void finishHole(){
        Collections.sort(list,new LocationComparator());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getStart());
        }
        //error check
        int firstEnd;
        int secondStart;
        for(int i = 0; i<list.size()-1; i++){
            secondStart = list.get(i+1).getStart();
            firstEnd = list.get(i).getEnd();
            if(secondStart>firstEnd){
                System.out.println("h1"+i);
                list.add(i+1, new Location(firstEnd, secondStart-firstEnd));
                i++;
            }
            else{
                System.out.println("h2"+i);
                //join the two holes in 1
                firstEnd = (list.get(i+1).getEnd()>firstEnd)?list.get(i+1).getEnd():firstEnd;
                
                list.remove(i+1);
                list.get(i).setSize(firstEnd-list.get(i).getStart());
                hCount--;
                i--;
            }
        }
        updatePanel();
    }
    static void addProcess(int size,String logic){
        if(logic.compareTo("First")==0){
           addFProcess(size);
        }
        else if(logic.compareTo("Base")==0){
            addBProcess(size);
        }
        updatePanel();
    }
    private static void addFProcess(int size){
        int s = list.size();
        for(int i =0; i<s;i++){
            if((list.get(i) instanceof Hole)&&(list.get(i).getSize()>=size)){
                //allocate
                Process_ p = new Process_(list.get(i).getStart(), size, pCount++);
                p.setName(pCount);
                list.add(i,p);
                
                if(size==list.get(i+1).getSize()){
                    //the process took the whole hole space
                    list.remove(i+1);
                    hCount--;
                }
                else{
                    list.get(i+1).setStart(list.get(i).getEnd());
                    list.get(i+1).setSize(list.get(i+1).getSize()-size);
                }
                break;
            }
        }
    }
    private static void addBProcess(int size){
        int s = list.size();
        ArrayList<Integer> sizes = new ArrayList<>(hCount+1);
        for(int i = 0;i < s;i++){
            if(list.get(i) instanceof Hole)
            sizes.set(i, list.get(i).getSize());
        }
        Collections.sort(sizes);
        System.out.println(sizes.get(0));
        
    }
    static void removeProcess(int i){
        
        updatePanel();
    }
    private static void updatePanel(){
       verticalList = new JPanel();
       verticalList.setLayout(new BoxLayout(verticalList,BoxLayout.Y_AXIS));
        outputPanel.removeAll();
//        outputPanel.repaint();
//        outputPanel.revalidate();
        for(int i = 0;i < list.size();i++){
            verticalList.add(list.get(i).getPanel());
        }
        
       outputPanel.add(verticalList);
       outputPanel.repaint();
       outputPanel.revalidate();
       
    }
    static void clear(){
        
    }

}
