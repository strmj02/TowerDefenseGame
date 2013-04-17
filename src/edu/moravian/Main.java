package edu.moravian;

/**
 * The start-up for our game.
 * 
 * @author mebjc01
 */
public class Main
{
    private final static int DWIDTH = 800;
    private final static int DHEIGHT = 600;
    private final static int DBITDEPTH = 32;

    public static void main(String[] args) 
    {
        // Create our game with a world size equal to
        // the screen size
        TowerDefenseGame g = new TowerDefenseGame(DWIDTH, DHEIGHT);
         
        try
        {
            // Create the video controller.  This will throw if something
            // goes wrong
            VideoController video = new VideoController(DWIDTH, DHEIGHT, DBITDEPTH, g);

            // And run the game
            new Thread(video).start();
        }
        catch (VideoConfigurationException ex)
        {
            System.out.println("Unable to display " + DWIDTH + "x" + DHEIGHT +
                    "x" + DBITDEPTH + " in full screen mode");
        }
    }
}
