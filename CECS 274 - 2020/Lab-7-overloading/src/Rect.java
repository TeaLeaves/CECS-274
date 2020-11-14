/**
 * Tina L Vu
 * 03/11/20
 * create a rectangle with a width and height value
 */

public class Rect {
    //instance variables
    private int width;
    private  int height;

    //constructor

    /**
     * given no param
     */
    public Rect(){
        width = 0;
        height = 0;
    }

    //override constructors

    /**
     * @param value: pass on to as height and width value
     */
    public Rect(int value){
        //make sure that value is valid
        if(value>=0) {
            width = value;
            height = value;
        } else{
            width = 0;
            height = 0;
        }
    }

    /**
     * @param widthValue: value given to width
     * @param heightValue: value given to height
     */
    public Rect(int widthValue, int heightValue){
        //make sure widthValue is valid
        if(widthValue>=0) {
            width = widthValue;
        } else{
            width = 0;
        }
        //make sure heightValue is valid
        if(heightValue>=0) {
            height = heightValue;
        } else{
            height = 0;
        }
    }

    /**
     * take the width and height from this rectangle and copy it over
     * @param rectangle: has width and height
     */
    public Rect(Rect rectangle){
        width = rectangle.getWidth();
        height = rectangle.getHeight();
    }

    //methods

    /**
     * get the width of the rectangle
     * @return the width value
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * get the height of the rectangle
     * @return the height value
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * @override: check if two rectangles have the same values for height and width
     * @param rectangle: the rectangle being compared with
     * @return: true if width and height are same, and false if not
     */
    public boolean equals(Rect rectangle){
        if(this.height == rectangle.getHeight() && this.width == rectangle.getWidth()){
            return true;
        } else{
            return false;
        }
    }

    /**
     * check whether the implicit rectangle height is greater than, less than, or equal to
     * the explicit rectangle. If the implicit rectangle height is equal to the explicit rectangle
     * ,then check whether the implicit rectangle width is greater than, less than, or equal to
     * the explicit rectangle.
     * @param rectangle: the explicit rectangle with the height and width we are comparing to
     * @return: -1 if less than, +1 if greater than, 0 if the rectangles height and width are same
     */
    public int compareTo(Rect rectangle){
        //if heights are the same
        if(this.height == rectangle.getHeight()){
            //compare the width
            if(this.width == rectangle.getWidth()){
                return 0;
            } else if(this.width > rectangle.getWidth()){
                return 1;
            } else {
                return -1;
            }
        } else if(this.height > rectangle.getHeight()){
            return 1;
        } else{
            return -1;
        }
    }

    /**
     * pass a scale value to enlarge the rectangle by multiplying
     * width and height by the scale value
     * @param scale: the value being used to enlarge the rectangle
     */
    public void scale(int scale){
        //check to see if scale is valid
        if(scale>1){
            width = width*scale;
            height = height*scale;
        }
    }

    /**
     * pass two scale values to enlarge the rectangle by multiplying the
     * width with its given scale and the height with it's own given scale
     * @param widthScale
     * @param heightScale
     */
    public void scale(int widthScale, int heightScale){
        //check if value for widthScale is valid or nah
        if(widthScale > 1){
            width = width * widthScale;
        }
        //check if value for heightScale is valid or nah
        if(heightScale > 1){
            height = height * heightScale;
        }
    }

    /**
     * enlarge the rectangle by adding the explicit rectangle's
     * width and height to the implicit rectangle width and height
     * @param rectangle
     */
    public void scale(Rect rectangle){
        width = width + rectangle.getWidth();
        height = height + rectangle.getHeight();
    }
}
