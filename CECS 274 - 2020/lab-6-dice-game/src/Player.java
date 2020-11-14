/**
 * tallies player's points, contains the 3 dice
 */
public class Player {

    //Instance Variables
    private Die[] dice = new Die[3];
    private int points;

    //Constructor
    /**
     *array of 3 die objects
     */
    public Player(){
        //get dice
        for(int i = 0; i<3; i++){
            dice[i] = new Die(6);
        }

        //get points
        //if its a pair
        if( pair(dice) == true && matchingSet(dice) == false){
            points++;
            //if its 3-of-a-kind
        } else if( matchingSet(dice) == true ){
            points+=3;
            //if its in a row
        } else if( inARow(dice) == true ){
            points+=2;
            //or you get no points
        } else{
            points+=0;
        }
    }

    //Methods

    /**
     * sorting the array in least to greatest order
     */
    public void sort(Die[] dice){
        //sort twice to make sure it is in order
        for(int i = 0; i<2; i++) {
            //if not in order, switch
            if (dice[i].compareTo(dice[i + 1]) == -1) {
                Die greater = dice[i];
                dice[i] = dice[i+1];
                dice[i+1] = greater;
            }
        }
    }

    /**
     *  definition: find out if the 3 dices has a pair or not
     * @param dice: the array of dice numbers
     * @return true if ONLY 2 dices match; false for any other outcome
     */
    public boolean pair(Die[] dice){
        //sort the die
        sort(dice);
        //if dice1 == dice2 AND dice2 does NOT = dice3; its a pair
        if(dice[0].equals(dice[1]) == true && dice[1].equals(dice[2]) == false){
            return true;
            //if dice1 is NOT = dice2 AND dice2 == dice3; its a pair
        } else if(dice[0].equals(dice[1]) == false && dice[1].equals(dice[2]) == true){
            return true;
        } else{
            return false;
        }
    }

    /**
     * definition: find out if all of the 3 dice values are same
     * @param dice: the array of dice numbers
     * @return true if ALL 3 dice match; false otherwise
     */
    public boolean matchingSet(Die[] dice){
        //if they all match
        if(dice[0].equals(dice[1]) == true && dice[1].equals(dice[2]) == true){
            return true;
            //they dont all match
        } else {
            return false;
        }
    }

    /**
     * definition: find out if the dices are in consecutive order
     * @param dice: the array of dice numbers
     * @return true if the dice values are in consecutive order; false otherwise
     */
    public boolean inARow(Die[] dice){
        //sort so it is in order
        sort(dice);
        //see if its in consecutive order
        if(dice[0].compareTo(dice[1]) == 1 && dice[1].compareTo(dice[2]) == 1){
            return true;
        } else{
            return false;
        }
    }

    /**
     * display dice rolls
     * @return: all of the dice values that was rolled
     */
    public String toString(){
        return "D1 = " + dice[0].getDieVal() + " ♥ D2 = " + dice[1].getDieVal() + " ♥ D3 = " + dice[2].getDieVal();
    }

    /**
     * get the points from the game and return it
     * @return points
     */
    public int getPoints(){
        return points;
    }

    /**
     * roll the dice and see if you got any points
     */
    public void takeTurn(){
        //get dice
        for(int i = 0; i<3; i++){
            dice[i] = new Die(6);
        }

        //get points
        //if its a pair
        if( pair(dice) == true && matchingSet(dice) == false){
            points++;
            //if its 3-of-a-kind
        } else if( matchingSet(dice) == true ){
            points+=3;
            //if its in a row
        } else if( inARow(dice) == true ){
            points+=2;
            //or you get no points
        } else{
            points+=0;
            System.out.println("Aww. Maybe Next Time");
        }

        //display points
        System.out.println(getPoints());

    }
}
