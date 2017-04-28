/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Data {
    private static ArrayList<Location> list;
    private static JPanel verticalList;
    private static int pCount;
    private static int n;
    Data(){
        list = new ArrayList<>();
        pCount = 0;
        n = 0;
    }
    static void addHole(int start,int size){
        Hole h = new Hole(start,size);
        list.add(h);
    }
    static void finishHole(){
        Collections.sort(list,new LocationComparator());
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
                i--;
            }
        }
        
        updatePanel();
    }
    static void addProcess(int size,String logic){
        if(logic.compareTo("First")==0){
           addFProcess(size);
        }
        else if(logic.compareTo("Best")==0){
            addBProcess(size);
        }
        else if(logic.compareTo("Worst")==0){
            addWProcess(size);
        }
        updatePanel();
    }
    private static void addFProcess(int size){
        int s = list.size();
        for(int i =0; i<s;i++){
            if((list.get(i) instanceof Hole)&&(list.get(i).getSize()>=size)){
                //allocate
                Process_ p = new Process_(list.get(i).getStart(), size, pCount);
                p.setName(pCount++);
                list.add(i,p);
                
                if(size==list.get(i+1).getSize()){
                    //the process took the whole hole space
                    list.remove(i+1);
                }
                else{
                    list.get(i+1).setStart(list.get(i).getEnd());
                    list.get(i+1).setSize(list.get(i+1).getSize()-size);
                }
                break;
            }
        }
    }
     private static void addWProcess(int size){
        int s = list.size();
        int difference = -1;
        int newDiff, index = 0;
        for(int i = 0;i < s;i++){
            if(list.get(i) instanceof Hole){
                newDiff = list.get(i).getSize()-size;
                if(newDiff > difference){
                    difference = newDiff;
                    index = i;
                }
            }
        }
        
        if(difference!=-1){
            //allocate process at index
            Process_ p = new Process_(list.get(index).getStart(), size, pCount);
            p.setName(pCount++);
            if(size==list.get(index).getSize()){
                    //the process took the whole hole space
                    list.remove(index);
                    list.add(index,p);
                }
                else{
                    list.add(index,p);
                    list.get(index+1).setStart(list.get(index).getEnd());
                    list.get(index+1).setSize(list.get(index+1).getSize()-size);
                }
        }
    }
    private static void addBProcess(int size){
        int s = list.size();
        int difference = 1000000;
        int newDiff, index = 0;
        for(int i = 0;i < s;i++){
            if(list.get(i) instanceof Hole){
                newDiff = list.get(i).getSize()-size;
                if((newDiff < difference)&&(newDiff>=0)){
                    difference = newDiff;
                    index = i;
                }
            }
        }
        
        if(difference!=1000000){
            //allocate process at index
            Process_ p = new Process_(list.get(index).getStart(), size, pCount);
            p.setName(pCount++);
            if(size==list.get(index).getSize()){
                    //the process took the whole hole space
                    list.remove(index);
                    list.add(index,p);
                }
                else{
                list.add(index,p);
                    list.get(index+1).setStart(list.get(index).getEnd());
                    list.get(index+1).setSize(list.get(index+1).getSize()-size);
                }
        }
    }
    static void removeProcess(int i){
        //remove process numper i
        //first find it in list
        int s = list.size();
        Process_ tmp;
        for(int j = 0; j<s; j++){
            if(list.get(j) instanceof Process_){
                tmp = (Process_)list.get(j);
                 if(tmp.getID()==i){
                     i = j;
                     break;
                 }
            }
        }
        try{
        Hole h = new Hole(list.get(i).getStart(),list.get(i).getSize());
        list.add(i,h);
        list.remove(i+1);
        if(i==0){
            if(list.size()>1)
            if(list.get(1) instanceof Hole){
                //hole count unchanged
                list.get(0).setSize(list.get(0).getSize()+list.get(1).getSize());
                list.remove(1);
            }
        }
        else if (i==s-1){
            if(list.get(i-1) instanceof Hole){
                list.get(i-1).setSize(list.get(i).getSize()+list.get(i-1).getSize());
                list.remove(i);
            }
        }
        else{
            if((list.get(i-1) instanceof Hole)&&(list.get(i+1) instanceof Hole)){
                list.get(i-1).setSize(list.get(i-1).getSize()+list.get(i).getSize()+list.get(i+1).getSize());
                list.remove(i);
                list.remove(i);
            }
            else if(list.get(i-1) instanceof Hole){
                list.get(i-1).setSize(list.get(i).getSize()+list.get(i-1).getSize());
                list.remove(i);
            }
            else if(list.get(i+1) instanceof Hole){
                list.get(i).setSize(list.get(i).getSize()+list.get(i+1).getSize());
                list.remove(i+1);
            }
        }
        }
         catch(IndexOutOfBoundsException e){
        }
        updatePanel();
    }
    private static void updatePanel(){
        JPanel p ;
        verticalList = new JPanel();
        verticalList.setLayout(new BoxLayout(verticalList,BoxLayout.Y_AXIS));
        for(int i = 0;i < list.size();i++){
            p = list.get(i).getPanel();
            p.setAlignmentX(Component.CENTER_ALIGNMENT);
            verticalList.add(p);
        }
 
      outPanel.addCard(verticalList,String.valueOf(n++));
    }

}
