

package edu.moravian.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Rachel
 */
public class Vector2D {
    //TOL is used if a vector has a x or y component with an absolute value less than TOL then it is called 0
    //also used to tell if two vectors are equal
    public static final double TOL = 1.0 * Math.pow(10, -8);
    //a zero vector
    public static final Vector2D zero = new Vector2D(0, 0);
    private double x;
    private double y;
    
    //constructs a 0 vector
    public Vector2D(){
        x = 0;
        y = 0;
    }
    //constructs the same vector as the vector in the parameter
    public Vector2D(Vector2D v2d){
        x = v2d.getX();
        y = v2d.getY();
    }
    //constructs a vector with the specified x and y component, using TOL to check if the 
    //component should go to 0
    public Vector2D(double x, double y){
        if(Math.abs(x)< TOL){
            x = 0;
        }
        else{
            this.x = x;
        }
        if(Math.abs(y)< TOL){
            y = 0;
        }
        else{
            this.y = y;
        }
    }
    
    public double checkComponent(double comp){
        if(Math.abs(comp) < TOL){
            comp = 0;
        }
        return comp;
    }
    //checks if the absolute value of x and y are less than TOL then they go to 0 
    public void checkXandY(){
        if(Math.abs(x) < TOL){
            x = 0;
        }
        if(Math.abs(y) < TOL){
            y = 0;
        }
    }
    //returns x component
    public double getX(){
        return x;
    }
    //returns y component
    public double getY(){
        return y;
    }
    //returns the anggle of the Vector from the positive x-axis, using arctan2
    public double angle(){
        checkXandY();
        if(x ==0 && y ==0){
            return 0;
        }
        return Math.atan2(y, x);
    }
    //returns the resulting vector of dividing each component by d, the parameter without mutating
    //the actual vector, throws exception when you try to divide by 0
    public Vector2D divide(double d) throws IllegalArgumentException{
        double xdiv, ydiv;
        if(d==0){
            throw new IllegalArgumentException();
        }
        xdiv = checkComponent(x/d); 
        ydiv = checkComponent(y/d);         
        return(new Vector2D(xdiv, ydiv));    
    }
    //mutates the vectors to be the result of the vector divided by d, the parameter
    //throws exception when trying to divide by 0
    public void divideEquals(double d) throws IllegalArgumentException{
        if(d==0){
            throw new IllegalArgumentException();
        }
        x = x/d;
        y = y/d;   
        checkXandY();    
        }
    
    //calculates the dot product of the vector and the vector in the parameter
    //dot product is both vectors' x components multiplied, and added to the y components multiplied
    public double dot(Vector2D rhs){
        double xx = checkComponent(rhs.getX() * x);
        double yy = checkComponent(rhs.getY() * y);
        return (xx+ yy);
    }
    //check to see if two vectors are equal
    public boolean equals(Object obj){
        if(obj instanceof Vector2D){
            Vector2D temp = (Vector2D)obj;
            double tempX = temp.getX() - x;
            double tempY = temp.getY() - y;
            if(Math.abs(tempX) < TOL){
                if(Math.abs(tempY) < TOL){
                    return true;
                }
            }
        }
            return false;
        }
    //return the left orthogonal vector
    public Vector2D getLeftOrtho(){
        return (new Vector2D(-y, x));
    }
    //returs the right orthogonal vector
    public Vector2D getRightOrtho(){
        return (new Vector2D(y, -x));
    }
    //returns the normalized vector without changing the original vector
    public Vector2D getNormalized(){ 
        if(x==0 && y ==0 ){
            return(new Vector2D());
        }
         for(int i=0; i<10; i++){
             double tempx = x;
             double tempy = y;
            if(tempx < 1 ){           
            tempx = 10 * tempx;
            }
          if (tempy<1){
            tempy = 10 * tempy;
        }
         }
        
        double temp = magnitude();
        double xx = checkComponent(x/magnitude());
        double yy = checkComponent(y/magnitude());
        
        return(new Vector2D(xx, yy));
    
    }
//hascode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    //returns the magnitude of the vector, or the "hypotenuse" of the two components of the vector
    public double magnitude(){
        if(x == 0 && y ==0){
            return(0);
        }
        return Math.sqrt((x * x) + (y * y));
    }
    //returns the square root of the magnitude
    public double magnitudeSq(){
        return (x * x) + (y * y);
    }
    //returns the resulting vector from substracting the vector in the parameter from the current vector
    //doesn't mutate originial vector
    public Vector2D minus(Vector2D rhs){
        BigDecimal x1 = BigDecimal.valueOf(x);
        BigDecimal x2 = BigDecimal.valueOf(rhs.getX());
        BigDecimal y1 = BigDecimal.valueOf(y);
        BigDecimal y2 = BigDecimal.valueOf(rhs.getY());
        BigDecimal tempX = x1.subtract(x2);
        BigDecimal tempY = y1.subtract(y2);
        double xx = tempX.doubleValue();
        double yy = tempY.doubleValue();
        xx = checkComponent(xx);
        yy = checkComponent(yy);
        return (new Vector2D(xx, yy));
    }
    //mutates the original vector to the result of subtracting the vector in the parameter by the original vector
    public void minusEquals(Vector2D rhs){
        BigDecimal x1 = BigDecimal.valueOf(x);
        BigDecimal x2 = BigDecimal.valueOf(rhs.getX());
        BigDecimal y1 = BigDecimal.valueOf(y);
        BigDecimal y2 = BigDecimal.valueOf(rhs.getY());
        BigDecimal tempX = x1.subtract(x2);
        BigDecimal tempY = y1.subtract(y2); 
        x = tempX.doubleValue();
        y = tempY.doubleValue();
        checkXandY();
    }
    //changes the sign of the x and y components
    public void negate(){
        x = -x;
        y = -y;
    }
    //normalizes the vector, or makes it a 'unit vector'
    public void normalize(){
        if(x<TOL && y ==TOL){
            x= 0;
            y= 0;
        }
       else{
           for(int i=0; i<10; i++){
            if(x < 1 ){           
            x = 10 * x;
            }
          if (y<1){
            y = 10 * y;
        } 
        }
        }
        double mag = magnitude();
        x = x/mag;
        y = y/mag;
        checkXandY();
    //}
        
    }
    //returns the vector that results from adding the vector in the parameter to this vector
    public Vector2D plus(Vector2D rhs){
        return (new Vector2D(rhs.getX() + x, rhs.getY() + y));
        
    }
    //mutates the current vector to be the result of adding the vector in the parameter to the current one
    public void plusEquals(Vector2D rhs){
        x = rhs.getX() + x;
        y = rhs.getY() + y;
        checkXandY();
 
    }
    //creates a random vector with the magnitude passed as the parameter
    public static Vector2D randomVectorFixedMagnitude(double magnitude){
        double temp = Math.random() * Math.PI * 2;
        double xx = Math.sin(temp) * magnitude;
        double yy = Math.cos(temp) * magnitude;
        return (new Vector2D(xx, yy));  
    }
    //creates a random vector with a magnitude less than what is passed in the parameter
    public static Vector2D randomVectorMaxMagnitude(double maxMagnitude){
        double temp = Math.random() * (Math.PI * 2);
        double xx = Math.sin(temp) * maxMagnitude * Math.random() ;
        double yy = Math.cos(temp) * maxMagnitude * Math.random();
        return (new Vector2D(xx, yy));  
    }
    //changes the sign of the x component
    public void reflectX(){
        x = -x;
    }
    //changes the sign of the y component
    public void reflectY(){
        y = -y;
    }
    //returns the resulting vector from adding the x component to the product of the vector 
    //in the parameter and the scalar, does the same for y
    public Vector2D scalePlus(double scalar, Vector2D v){
       double yy = (v.getY() * scalar) + y;
       double xx = (v.getX() * scalar) + x;
       return (new Vector2D(xx, yy));
    }
    //does the same as the above method, only it mutates the current vector
    public void scalePlusEquals(double scalar, Vector2D v){
       x = v.getX() * scalar + x;
       y = v.getY() * scalar + y;
       checkXandY();
    }
    //change the vector's x and y components to the specified values
    public void set(double x, double y){
        this.x = x;
        this.y = y;      
    }
    //change the vector to have the same components as another vector
    public void set(Vector2D v){
        x = v.getX();
        y = v.getY();
    }
    //change the vector to the left orthogonal vector
    public void setLeftOrtho(){
        double temp = x;
        x = -y;
        y = temp;  
    }
    //change the vector to the right orthogonal vector
    public void setRightOrtho(){
        double temp = x;
        x = y;
        y = -temp;
    }
    //returns the resulting vector of multiplying the x, y components by d
    public Vector2D times(double d){
        return (new Vector2D(x * d,y * d));
    }
    //mutates the vector to the result of multiplying the x, y components by d 
    public void timesEquals(double d){
        x = x * d;
        y = y * d;
        checkXandY();
    }
    //returns the vector as a String
    public String toString(){
        //return ("(" + x + "," + y + ")").format;
        return String.format("(%s, %s)", x, y);
    }
    //truncates the vector so that its magnitude is less than max
    public void truncate(double max){
        if(magnitude()< max){ 
        }
        else{
            x = max/magnitude() * x;
            y = max/magnitude() * y;
        }
        checkXandY();
    }
}
