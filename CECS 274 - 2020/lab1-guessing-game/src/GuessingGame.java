/* Author: Tina L Vu
 * Date: 1/24/20
 * Description: computer will generate a number btw 1-100, then
 * the user will try to guess the number by inputting a value,
 * the computer will continue to tell the user whether the inputted
 * value is to high or to low until the user successfully guess the
 * number
 */
public class GuessingGame{
    public static void main( String [] args ){

        //computer generate a random value
        int value = randomValue();

        //initialize
        boolean correct = false;        //if user guess is correct or incorrect
        int guess;                      //users guessed number
        int rep = 0;                    //number of times the user guessed


        System.out.print("Please Guess a Value (1-100): ");
        //program CheckInput will make sure the users value is correct type
        guess = CheckInput.getIntRange(1,100);


        //check if the guess is correct
        while(correct == false){

            //comparing guessed value and actual value
            correct = checkValue(guess, value);
            rep++;

            //if guess is incorrect
            if(correct == false){
                //ask for another guessed value
                guess = CheckInput.getIntRange(1,100);
            }
            //if guess is correct, end program
            else{
                System.out.println("Correct! You got it in " + rep + " tries.");
            }
        }

    }

    /** computer generate a random number
     * @return the random number
     */
    public static int randomValue(){
        return (int) (Math.random()*100) + 1;
    }

    /** check if user's guess is less than, greater than, or
     *  equal to the value. Also check if guess is out of range
     * @return true if guess is correct or false is guess is incorrect
     */
    public static boolean checkValue( int guess, int value){

        boolean correct;

        //check if lower
        if( guess < value ){
            System.out.print("Too low: ");
            correct = false;
        }
        //check if higher
        else if( guess > value ){
            System.out.print("Too high: ");
            correct = false;
        }
        //you guessed correctly
        else{
            correct = true;
        }

        return correct;
    }
}