/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig2;

import java.awt.Color;

/**
 *
 * @author Dell
 */
public class Process_ extends Location{
    int ID;
    Process_(int st,int s,int id){
        super(st,s,"          P",new Color(255,175,175));
        name = "          P";
        ID = id;
    }
    int getID(){
        return ID;
    }
    
}
