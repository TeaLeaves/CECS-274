/**
 * This class represents a single die
 */
public class Die {

    //Instance Variables–(data members)-information about (or attributes of) the object.
    /** Represents the number of sides on the die*/
    private int sides;
    /** Represents the value of the die*/
    private int dieVal;


    //Constructor–sets the initial values of the data members.
    /** Constructor
     * @params The number of sides this die has
     */
    public Die( int s ) {
        sides = s;
        dieVal = roll( sides );
    }


    //Methods–actions (or operations) the object can perform.
    /**Rolls the die and returns the result
     * @return result of die roll
     */
    public int roll( int sides ) {
        dieVal = (int)(Math.random() * sides) + 1;
        return dieVal;
    }

    /**
     * compare the two dice values
     * @return difference, 0 = equals, -1 less than, +1 greater than
     */
    public int compareTo(Die v2){
        //difference btw the two values
        return this.dieVal-v2.dieVal;
    }

    /**
     * check if the die value is equal to the previous die value
     * @return true if equal
     */
    public boolean equals( Object value ){
        if( value instanceof Die){
            Die d = (Die) value;
            return this.dieVal==d.dieVal && this.sides == d.sides;
        } else {
            return false;
        }
    }


    //Accessor–retrieves the value of a data member.
    /** Retrieves the value of the die
     * @return value of the die
     */
    public int getDieVal() {
        return dieVal;
    }


    //Mutator–changes the value of a data member.
    /** Sets the die to the parameter value
     * @param value value to set die to
     * @return value of the die
     */
    public boolean setDiceVal( int value ) {
        if ( value > 0 && value <= sides ) {
            dieVal = value;
            return true;  //successfully set the value
        }
        return false; //failed to set the value
    }
}