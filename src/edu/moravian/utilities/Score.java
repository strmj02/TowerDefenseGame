package edu.moravian.utilities;

import edu.moravian.entities.Creep;
import java.util.ArrayList;

public class Score {

    private int lives;
    private int gold;
    private ArrayList<Creep> creeps;

    /**
     *
     * @param gold the amount of gold the player starts the game with
     * @param lives the amount of lives the player starts the game with
     */
    public Score(int gold, int lives) {
        this.lives = lives;
        this.gold = gold;
    }

    /**
     *
     * @return number of lives the player has
     */
    public int getLives() {

        return lives;
    }

    /**
     * 
     * @param lives the number of lives to change the players lives to
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    
    /**
     * 
     * @param lives the number of lives to add to the players current lives
     */
    public void addLives(int lives) {
        this.lives += lives;
    }
    
    /**
     * 
     * @return the amount of gold the player has
     */
    public int getGold() {
        return gold;
    }
    
    /**
     * 
     * @param gold the amount of gold to change the players gold to
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    /**
     * 
     * @param gold the amount of gold to add to the players available gold
     */
    public void addGold(int gold) {
        this.gold += gold;
    }

    /**
     * 
     * @param creeps and arrayList of creeps in the game,
     * to use to see if the lives or gold of the player needs to be updated.
     */
    public void update(ArrayList<Creep> creeps) {
        this.creeps = creeps;
        for (int i = 0; i < creeps.size(); i++) {
            Creep creep = creeps.get(i);

            if (creep.isAlive() == false && (creep.getLocation().getX() < 800 || creep.getLocation().getY() < 600)) {
                gold += 50;
            }
            
            
            if (creep.getLocation().getX() >= 800 || creep.getLocation().getY() >= 600) {
                lives--;
            }
        }
    }
}
