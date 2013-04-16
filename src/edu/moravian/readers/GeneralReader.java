/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;



   public class GeneralReader {

    Properties properties;
    private double mmoney;
    private int playerLife;
    ArrayList<Level> levels = new ArrayList<Level>();

    /**
     * handle reading in the file and setting the information to the appropriate
     * variables
     */
    public GeneralReader(String filenam) {
        levels = new ArrayList<Level>();
        properties = new Properties();
        String fileName = filenam;
        try {
            InputStream input = new FileInputStream(fileName);
            properties.load(input);
        } catch (Exception exceptin) {
            System.out.println("Cannot read File");
        }
        String lives = properties.getProperty("Creep Life Points");
        String numCreeps = properties.getProperty("number Of Creeps");
        String timeBet = properties.getProperty("Time Between Spawns");
        String money = properties.getProperty("Money");
        String playerLives = properties.getProperty("Player lives");

        playerLife = Integer.parseInt(playerLives);
        int creepLives = Integer.parseInt(lives);
        int creeps = Integer.parseInt(numCreeps);
        double time = Double.parseDouble(timeBet);
        mmoney = Double.parseDouble(money);

        Level level = new Level(creeps, creepLives, time);
        levels.add(level);
    }

    /**
     *
     * @return the value to start the score at
     */
    public double getMoney() {
        return mmoney;
}
    public int getPlayerLife(){
        return playerLife;
    }
    
    public ArrayList<Level> getLevels(){
        return levels;
    }
}
