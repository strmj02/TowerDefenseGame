/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.readers;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author johnson
 */
//public class GeneralReader {

    /*private BufferedReader read;
    private int maxEnemies;
    private int minEnemies;
    private int numPlayersLives;
    private int numLevels;
    private int creepsLives;
    private double spawnTime;
    private int money;

    public int getMaxEnemies() {
        return maxEnemies;
    }

    public int getMinEnemies() {
        return minEnemies;
    }

    public int getNumPlayersLives() {
        return numPlayersLives;
    }

    public int getNumLevels() {
        return numLevels;
    }

    public int getCreepsLives() {
        return creepsLives;
    }

    public double getSpawnTime() {
        return spawnTime;
    }
    
    public int getMoney(){
        return money;
    }
    

    
    public GeneralReader(File file){
        String text;
        try{
        read = new BufferedReader(new FileReader(file));
        text = read.readLine();
         while(text !=null){
                if(text.startsWith("#")){
                }
                else{
                    String[] array =text.split("=");
                    
                        if(array[0] == "maxEnemies"){
                           maxEnemies = Integer.valueOf(array[1]); 
                        }
                        if(array[0] == "minEnemies"){
                            minEnemies = Integer.valueOf(array[1]);
                        }
                       if(array[0] == "numPlayersLives"){
                            numPlayersLives = Integer.valueOf(array[1]);
                       }
                       if(array[0] == "numLevels"){
                            numLevels = Integer.valueOf(array[1]);
                       }
                       if(array[0] == "creepsLives"){
                            creepsLives = Integer.valueOf(array[1]);
                       }
                       if(array[0] == "spawnTime"){
                            spawnTime = Double.valueOf(array[1]);
                       }
                       if(array[0] == "money"){
                           money = Integer.valueOf(array[1]);
                       }
                    }
                    
                 text = read.readLine();
                }
        }
                catch(IOException e){
                    System.out.println("EXCEPTION");
                }
        }*/

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
