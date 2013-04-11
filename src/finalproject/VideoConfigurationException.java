package edu.moravian;

/**
 * This class represents a video configuration exception.
 * Used when the desired resolution is not avilable or
 * the system cannot go into fullscreen mode.
 * 
 * @author mebjc01
 */
public class VideoConfigurationException extends Exception
{
    public VideoConfigurationException(String msg)
    {
        super(msg);
    }

    // There is nothing else to do.  This class inherits everything
    // it needs from Exception
}
