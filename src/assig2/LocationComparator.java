/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.util.Comparator;

public class LocationComparator implements Comparator<Location>{
    public int compare(Location l1,Location l2){
        return l1.getStart()-l2.getStart();
    }
}
