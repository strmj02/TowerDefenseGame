/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;

/**
 *
 * @author samson
 */

public class GameStates {

    private double money;
    private Level level;
    private GeneralReader generalReader;

    public GameStates() {
        //create our general reader to bring in our data values
        generalReader = new GeneralReader(level);
        //get our money value set by the user
        money = generalReader.getMoney();
    }
    //return the value we are holding on our money
    public double getMoney() {
        return money;
    }
    //add money to our saved value
    public void addMoney(double add) {
        money += add;
    }
    //subtract moeny from our saved value
    public void subtractMoney(double sub) {
        money -= sub;
    }
    //return the level we are on
    public Level getLevel() {
        return level;
    }
}

