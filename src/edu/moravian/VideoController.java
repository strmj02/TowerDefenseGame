package edu.moravian;

import edu.moravian.math.CoordinateTranslator;
import edu.moravian.math.Point2D;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * @author Rachel
 *
 * This class encapsulates a graphics loop for a full-screen game.
 *
 * The class implements Runnable, and is intended to be used as
 * a thread.
 *
 */
class VideoController extends JFrame implements Runnable, MouseListener, MouseMotionListener, KeyListener{
    // Convience references to the Graphics system
    private GraphicsEnvironment genv;
    private GraphicsDevice gdev;
    CoordinateTranslator ct;

    // The parameters specified by the user
    private int width;
    private int height;
    private int depth;
    private Game game;
    private Timer timer;
    double timepast = 0;

    /**
     * Create an instance of the class with the specified screen
     * configuration using the given game.
     * 
     * @param width the width of the desired screen resolution
     * @param height the height of the desired screen resolution
     * @param depth the color depth of the desired screen resolution
     * @param theGame the game to use in the update loop
     * @throws VideoConfigurationException if the desired video mode is
     *         not available or if fullscreen mode is not allowed
     */
    public VideoController(int width, int height, int depth, Game theGame, CoordinateTranslator ct)
            throws VideoConfigurationException
    {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.game = theGame;
        this.ct = ct;
        
        // Save references to the graphics environment and device
        // for future reference
        genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gdev = genv.getDefaultScreenDevice();

        if(!hasResolution(width, height, depth))
            throw new VideoConfigurationException("unsupported resolution:");

        if(!hasFullScreen())
            throw new VideoConfigurationException("fullscreen unsupported");

        // Full-screen applications should not be resizable, they
        // should not have decorations (title bar, etc.)
        setResizable(false);
        setUndecorated(true);

        // Because we are going to use active rendering (control the video
        // directly), our program should not respond to the normal
        // repaint requests.
        setIgnoreRepaint(true);
        
        //add our Mouse/MouseMotion Listeners so that we can register different events
        //such as the player following the mouse
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        
        //add our important time keeper
        timer = new Timer();
        
        setVisible(true);
      
    }

    /**
     * Determines whether fullscreen mode is available
     * @return true if fullscreen is available
     */
    private boolean hasFullScreen()
    {
        return gdev.isFullScreenSupported();
    }

    /**
     * Determines whether the specified resolution is available
     * @param width the desired width
     * @param height the desired height
     * @param bitDepth the desired color depth
     * @return true if the specifed resolution is available
     */
    private boolean hasResolution(int width, int height, int bitDepth)
    {
        DisplayMode[] modes = gdev.getDisplayModes();

        for(int i = 0; i < modes.length; i++)
        {
            int w = modes[i].getWidth();
            int h = modes[i].getHeight();
            int b = modes[i].getBitDepth();

            if(width == w && height == h && bitDepth == b)
                return true;
        }

        return false;
    }

    /**
     * This method is the process of the loop.  After changing to the
     * specified resolution, the method executes the game as an
     * update loop.  When the game indicates it is done, the loop
     * terminates.
     */
    public void run()
    {
        // Save the old resolution so we can go back when we are done.
        DisplayMode oldMode = gdev.getDisplayMode();

        // Many of the following method calls can cause exceptions
        // to be thrown.  If unhandled, and exception will cause the program
        // to terminate, and depending on the system, the video system may
        // be left in a "bad" state.  Thus, we enclose all our code in a huge
        // try block with a "finally" clause.  A "finally" clause will *always*
        // execute even if an unhandled exception causes the program to
        // terminate.  We use this to make sure we "clean up" the video

        try
        {
            // Go full screen!  "this" is the object, which is a window
            gdev.setFullScreenWindow(this);
            // Change to our desired resolution
            gdev.setDisplayMode(new DisplayMode(width, height, depth,
                    DisplayMode.REFRESH_RATE_UNKNOWN));

            // We want our program to use two buffers for graphics - one
            // is the display on the screen, and the other is the one
            // we write to.  More than two buffers is possible, but not
            // needed for what we need.
            // NOTE:  This cannot be done until *after* we are fullscreen
            this.createBufferStrategy(2);

            // Now that the strategy is created, we safe a reference to it
            // so that we can draw (below)
            BufferStrategy bufStrat = this.getBufferStrategy();

            // prev will be the time of the last frame.
            long prev = 0;
            //keep track of the total time spent on the game
            double totaltime =0;
            
            //the lives you had on the previous frame, initially set to 5
           
            //advance the clock to the current moment so that we can begin with our 
            //keeping track of FPS
            timer.tick();
            
            //we play until we are done, or lose all of our lives
            while (!game.done())
            {
               //We keep track of the total time a person has been playing 
               totaltime += timer.getDelta();

               //here we keep track of our score, we check to see if we are not
               //at the same second, then increment the score, so one point per second
               //of survival
               
               //here we keep track of how long we have played with one life
               //if a life is lost, the timepast is set to 0.
               timepast += timer.getDelta();
                //we use the time past in a life to affect the speed changer in the 
                //game. When we loose a life, the speed is set to the lowest possible
               

                //make prevLives equal to the number of lives at the end of this frame
                //update the game itself
                game.update(timer.getDelta());
                Graphics g = bufStrat.getDrawGraphics();
                
                // Drawing is done through a Graphics object.  You can think
                // of this as the object representing the screen.
               

                // THe first thing we have to do is "clear" the screen.
                // Whatever was drawn perviously is still on the screen.
                // We'll use a solid white background here.
                //g.setColor(Color.WHITE);
                // Note that drawRect will only draw the rectangle outline
                //g.fillRect(0, 0, width, height);

                // Tell the game to draw itself using the graphics context
                game.draw((Graphics2D) g);

                // Write the FPS in the upper-left corner.  The coordinates
                // designate the lower left of the text, and so anything
                // written at (0,0) will end up being written above the
                // viewable region.
               
                //keep the score and show to the player
                g.drawString("FPS: " + 1 / timer.getDelta(), 20, 20);


                // Free up any resources being used.
                g.dispose();

                // This call *may* make the system wait for the monitor
                // to perform a vsync before continuing.  This could help
                // reduce flicker.  It doesn't seem to do anything on my Mac.
                //Toolkit.getDefaultToolkit().sync();

                // Now that we have drawn everything we want to see,
                // we "show" it, meaning tha the data in the 2nd buffer becomes
                // what is on the screen.
                bufStrat.show();

                // A monitor can only draw frames so fast.  If our frame rate
                // is faster than the monitor's refresh rate, frames will
                // either be dropped by the video system or they will be
                // drawn and cause video flicker.  To avoid this, we make
                // the program sleep.
                // If the OS forces the thread to wake up before the time,
                // then an exception will be thrown.  We can simply ignore
                // this exception and continue generating frames.
                
                //check if its less than 12.5 milliseconds per frame, because that is 
                //about the amount of milliseconds to keep it at 80 fps
                
                //if(timer.getDelta() < 1.0/90.0){
                try
                {
                    //sleep to keep timing correct and to have about evenly spaced frames
                    Thread.sleep(10);
                }
                catch (InterruptedException ex)
                {
                    System.err.print("Not supported");
                }
                //}
            timer.tick();
                    
            }

        }
        // A "finally" clause will always execute even if an unhandled
        // exception causes the program to terminate.  We use this to
        // make sure we "clean up" the video
        finally
        {
            // Before we exit, we want to change back to the original
            // video mode.
            gdev.setDisplayMode(oldMode);
            // This command returns the screen to non-full-screen.
            gdev.setFullScreenWindow(null);
            setVisible(false);
            dispose();
            System.exit(0);
            //this nicely wraps up our game
        }
    }
    
    //here we implement all methods from our MouseListener and MouseMotionListner
    //in this game we do not use most of them
    public void mouseClicked(MouseEvent e){
        Point2D here = ct.screenToWorld(e.getPoint());
        game.mouseClick(here);
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
        //want the player sprite to instantly be there, following mouse
    }
    public void mouseExited(MouseEvent e){
        //leave the sprite where you exited the window
    }
    //here we set the sprite to have the coordinates from the mouse event e, or
    //location of where that occured.
    public synchronized void mouseMoved(MouseEvent e){
        
        //want sprite from player to move along with mouse
    }
    public void mouseDragged(MouseEvent e){
        Point2D here = ct.screenToWorld(e.getPoint());
        game.mouseDragged(here);
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        game.keyPressed(ke.getKeyChar());
    }
    @Override
    public void keyReleased(KeyEvent ke) {}
            
    @Override
    public synchronized void keyTyped(KeyEvent ke){
        
    }
    
    
    
}
