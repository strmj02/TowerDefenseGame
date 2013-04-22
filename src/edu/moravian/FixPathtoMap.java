/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

/**
 *
 * @author johnson
 */
public class FixPathtoMap {
    Map map;
    
    public FixPathtoMap(Map map){
        this.map = map;
    }
    
    public void fix(Path p){
        map.fixPath(p);
    }
}
