/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian;

/**
 *
 * @author Rachel
 */
public class Timer {
    long beginTime;
    long frameLength;
    
    //makes a timer with a startime of whatever the current time is when the
    //object is made.  Framelength is set to 0
    public Timer(){
        beginTime = System.currentTimeMillis();
        frameLength = 0;              
    }
    //advances the clock to the next moment in time, calculating the time
    //between the two, as the framelength 
    public void tick(){
        long oldTime = beginTime;
        beginTime = System.currentTimeMillis();
        frameLength = Math.abs(beginTime - oldTime);
    }
    //returns the framerate per second
    public double getFPS(){
        return 1/getDelta();
    }
    //returns the length of a frame in seconds
    public double getDelta(){
        return frameLength/1000.0;
    }
}
