/**
 * Tina L Vu
 * 03/03/2020
 * Player rolls a set of 3 dice. Receives 1pt for a pair, 3pt for a matching set
 * (aka 3-of-a-kind), or 2pt for a series (EX. 1-2-3, 3-2-1, 2-1-3)
 */
public class Main {

    public static void main(String[] args){
        //initialize
        Player player = new Player();

        //start the game
        System.out.println("Yacht-z");

        //roll the dice
        System.out.println("Rolling the Dice! ");
        player.takeTurn();

        //print the value of the dice
        System.out.println(player.toString());

        //ask to play again
        System.out.println("Play Again?(Y/N) ");
        boolean loop = CheckInput.getYesNo();

        //continue to play the game until the player decide to exit
        while(loop == true){
            //roll dice
            System.out.println("Rolling the Dice! ");
            player.takeTurn();

            //print the value of the dice
            System.out.println(player.toString());

            //ask to play again or not
            System.out.println("Play Again?(Y/N) ");
            loop = CheckInput.getYesNo();
        }
    }
}
