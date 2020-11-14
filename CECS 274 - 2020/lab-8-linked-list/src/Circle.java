/**
 * Tina L Vu
 * 04/13/2020
 * create a circle; a circle object contains values for x and y cordinates
 * for the center of the circle, and a radius for the size of the circle
 */

public class Circle {

    //instance variable
    private int x;
    private int y;
    private int radius;

    //constructors
    /**
     * given no param, place 0 for x,y, and radius
     */
    public Circle(){
        x = 0;
        y = 0;
        radius = 0;
    }

    //override constructors
    /**
     * given 3 integers, place them as values for x, y, and radius
     * @param xVal value for x
     * @param yVal value for y
     * @param rVal value for radius
     */
    public Circle(int xVal, int yVal, int rVal){
        x = xVal;
        y = yVal;
        radius = rVal;
    }

    //methods
    /**
     * @Override toString()
     * @return a circle in the format (x,y) R = radius
     */
    public String toString() {
        return "(" + x + "," + y + ") R = " + radius +"\n";
    }

    /**
     * @override: check if two circles have the same values
     * @param c: the circle being compared with
     * @return true if width, height, and radius are the same
     */
    public boolean equals(Circle c){
        if(this.x == c.x && this.y == c.y && this.radius == c.radius){
            return true;
        } else{
            return false;
        }
    }
}
