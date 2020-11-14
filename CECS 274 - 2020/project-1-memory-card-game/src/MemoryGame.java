/**
 * Name: Tina L Vu
 * Date: 02/22/2020
 * Description: Create a children's memory game, that prompt user a choice of cards to use from menu
 */

import java.util.Scanner;
import java.io.*;

public class MemoryGame {
    public static void main(String args[]){
        //initialize
        int matchesleft = 8;
        String valueChoice = null;
        String valueChoice2 = null;
        // false = face-down, true = face-up
        boolean[][] bool = { {false,false,false,false},{false,false,false,false},
                {false,false,false,false},{false,false,false,false}};
        //empty string array
        String[][] empty = { {"","","",""},{"","","",""},
                {"","","",""},{"","","",""}};

        //get choice
        System.out.println("Memory Game");
        int selection = getFileChoice();

        //read file of cards choice
        String[][] cards = readFile(selection,empty);

        //shuffle the cards 100 times
        for(int i = 0; i<100; i++){
            shuffle(cards);
        }

        //display the cards
        displayBoard(cards,bool);

        //loop until all matches are found
        while(matchesleft != 0) {
            //ask user for card to flip
            int choice = getChoice();

            //check if it had been flipped yet
            boolean flipped = checkedFlipped(choice,bool);
            while(flipped == true){
                System.out.print("Already Flipped. ");
                choice = getChoice();
                System.out.println();
                flipped = checkedFlipped(choice,bool);
            }

            //flip the card they chose
            flipChoice(choice, bool);

            //display the cards again
            displayBoard(cards, bool);

            //ask user for another card to flip
            int choice2 = getChoice();

            //check if it had been flipped yet
            flipped = checkedFlipped(choice2,bool);
            while(flipped == true){
                System.out.print("Already Flipped. ");
                choice2 = getChoice();
                System.out.println();
                flipped = checkedFlipped(choice2,bool);
            }

            //flip the card they chose
            flipChoice(choice2, bool);

            //display the cards again
            displayBoard(cards, bool);

            //get the value of choice1 and choice2
            //rows
            for( int i = 0; i<=3; i++) {
                //columns
                for (int j = 0; j <= 3; j++) {

                    if (choice == (i * 4) + j + 1) {
                        valueChoice = cards[i][j];
                    }
                    if (choice2 == (i * 4) + j + 1) {
                        valueChoice2 = cards[i][j];
                    }
                }
            }

            //check if they match
            boolean match = isMatch(valueChoice, valueChoice2);

            //if not a match, flip back
            if(match == false){
                System.out.println("Not A Match");
                //flip the card they chose
                flipChoice(choice, bool);
                //flip the card back down
                flipChoice(choice2, bool);

                //space to make it clean
                System.out.println();
                System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
                System.out.println();


                //display the cards again
                displayBoard(cards, bool);
            } else{
                System.out.println("Is A Match!!");
                matchesleft--;
            }
        }

        System.out.println("Congrats! You Finished the Game!");
        System.out.println("Would You Like To Play Again? (Y/N) ");
        boolean reply = CheckInput.getYesNo();

        //re-initializing bool & matchesLeft
        //bool
        //row
        for( int i = 0; i<=3; i++) {
            //columns
            for (int j = 0; j <= 3; j++) {
                bool[i][j] = false;
            }
        }
        //matches remaining
        matchesleft = 8;


        while(reply == true){
            selection = getFileChoice();

            //read file of cards choice
            cards = readFile(selection, empty);

            //shuffle the cards 100 times
            for(int i = 0; i<100; i++){
                shuffle(cards);
            }

            //display the cards
            displayBoard(cards,bool);

            //loop until all matches are found
            while(matchesleft != 0) {
                //ask user for card to flip
                int choice = getChoice();

                //check if it had been flipped yet
                boolean flipped = checkedFlipped(choice,bool);
                while(flipped == true){
                    System.out.print("Already Flipped. ");
                    choice = getChoice();
                    System.out.println();
                    flipped = checkedFlipped(choice,bool);
                }

                //flip the card they chose
                flipChoice(choice, bool);

                //display the cards again
                displayBoard(cards, bool);

                //ask user for another card to flip
                int choice2 = getChoice();

                //check if it had been flipped yet
                flipped = checkedFlipped(choice2,bool);
                while(flipped == true){
                    System.out.print("Already Flipped. ");
                    choice2 = getChoice();
                    System.out.println();
                    flipped = checkedFlipped(choice2,bool);
                }

                //flip the card they chose
                flipChoice(choice2, bool);

                //display the cards again
                displayBoard(cards, bool);

                //get the value of choice1 and choice2
                //rows
                for( int i = 0; i<=3; i++) {
                    //columns
                    for (int j = 0; j <= 3; j++) {

                        if (choice == (i * 4) + j + 1) {
                            valueChoice = cards[i][j];
                        }
                        if (choice2 == (i * 4) + j + 1) {
                            valueChoice2 = cards[i][j];
                        }
                    }
                }

                boolean match = isMatch(valueChoice, valueChoice2);

                //if not a match, flip back
                if(match == false){
                    System.out.println("Not A Match");
                    //flip the card they chose
                    flipChoice(choice, bool);
                    //flip the card back down
                    flipChoice(choice2, bool);

                    //space to make it clean
                    System.out.println();
                    System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
                    System.out.println();


                    //display the cards again
                    displayBoard(cards, bool);
                } else{
                    System.out.println("Is A Match!!");
                    matchesleft--;
                }
            }

            System.out.println("Congrats! You Finished the Game!");
            System.out.println("Would You Like To Play Again? (Y/N) ");
            reply = CheckInput.getYesNo();

            //re-initializing bool
            //row
            for( int i = 0; i<=3; i++) {
                //columns
                for (int j = 0; j <= 3; j++) {
                    bool[i][j] = false;
                }
            }
            //matches remaining
            matchesleft = 8;

        }

    }


    /**
     * description: display a menu listing the types of cards to play
     * @return users selection (int)
     */
    public static int getFileChoice(){
        //print options
        System.out.println("1. Letters");
        System.out.println("2. Numbers");
        System.out.println("3. Animals");
        System.out.println("4. Objects");

        System.out.print("Enter Choice: ");
        //get users choice
        int selection = CheckInput.getIntRange(1,4);
        //return that choice
        return selection;
    }


    /**
     * description: open file of choice and add into a 2D array
     * @param selection: the file of choice
     * @return the 2D array of Strings that is going to be used
     */
    public static String[][] readFile(int selection, String[][] cards){

//        //initialize
//        final int ROWS = 4;
//        final int COLS = 4;
//        String[][] cards = new String [ROWS][COLS];

        try {
            if (selection == 1) {
                //read letters.txt
                Scanner read = new Scanner( new File("letters.txt") );

                //add into array list
                while(read.hasNext()){

                    //rows
                    for( int i = 0; i<=1; i++){
                        //columns
                        for( int j = 0; j<=3; j++){
                            String line = read.nextLine();

                            cards[i][j]= line;
                            cards[i+2][j]= line;
                        }
                    }

                }
                read.close();

            } else if (selection == 2) {
                //read numbers.txt
                Scanner read = new Scanner( new File("numbers.txt") );

                //add into array list
                while(read.hasNext()){

                    //rows
                    for( int i = 0; i<=1; i++){
                        //columns
                        for( int j = 0; j<=3; j++){
                            String line = read.nextLine();

                            cards[i][j]= line;
                            cards[i+2][j]= line;
                        }
                    }

                }
                read.close();

            } else if (selection == 3) {
                //read animals.txt
                Scanner read = new Scanner( new File("animals.txt") );

                //add into array list
                while(read.hasNext()){

                    //rows
                    for( int i = 0; i<=1; i++){
                        //columns
                        for( int j = 0; j<=3; j++){
                            String line = read.nextLine();

                            cards[i][j]= line;
                            cards[i+2][j]= line;
                        }
                    }

                }
                read.close();

            } else {
                //read object.txt
                Scanner read = new Scanner( new File("objects.txt") );

                //add into array list
                while(read.hasNext()){

                    //rows
                    for( int i = 0; i<=1; i++){
                        //columns
                        for( int j = 0; j<=3; j++){
                            String line = read.nextLine();

                            cards[i][j]= line;
                            cards[i+2][j]= line;
                        }
                    }

                }
                read.close();

            }
            //file not found
        } catch(FileNotFoundException fnf){
            System.out.println("File Not Found");
        }

        return cards;
    }

    /**
     * description: choose 2 random location to swap card values
     * @param cards the 2D array of Strings that is used
     */
    public static void shuffle(String[][] cards){
        int random = (int) (Math.random()*10);
        int random2 = (int) (Math.random()*10);
        int random3 = (int) (Math.random()*10);
        int random4 = (int) (Math.random()*10);

        //make sure the number is from 0-3
        while(random > 3){
            random = (int) (Math.random()*10);
        }
        while( random2 > 3){
            random2 = (int) (Math.random()*10);
        }
        while(random3 > 3){
            random3 = (int) (Math.random()*10);
        }
        while(random4 > 3){
            random4 = (int) (Math.random()*10);
        }

        //hold the value of arr1, tempValue
        String tempValue = cards[random][random2];

        //arr1 value is now arr2
        cards[random][random2] = cards[random3][random4];

        //arr2 value is now tempValue
        cards[random3][random4] = tempValue;
    }


    /**
     * display board of cards in a 4x4 configuration
     * @param cards: the 2D array of Strings that is used
     */
    public static void displayBoard(String[][] cards, boolean[][] bool){

        //initialize
        String[][] downCards = { {"1","2","3","4"},{"5","6","7","8"},
                {"9","10","11","12"},{"13","14","15","16"}};



        //1 row of cards
        System.out.println("+------+   +------+   +------+   +------+");
        System.out.println("|      |   |      |   |      |   |      |");
        for(int i = 0; i<3; i++) {
            //check bool
            if(bool[0][i] == true) {
                //length 1
                if (cards[0][i].length() == 1) {
                    System.out.print("|  " + cards[0][i] + "   |   ");
                }
                //length 2
                else if (cards[0][i].length() == 2) {
                    System.out.print("|  " + cards[0][i] + "  |   ");
                }
                //length 3
                else if (cards[0][i].length() == 3) {
                    System.out.print("|  " + cards[0][i] + " |   ");

                }
                //length 4
                else if (cards[0][i].length() == 4) {
                    System.out.print("| " + cards[0][i] + " |   ");
                }
                //check bool
            } else{
                //length 1
                if (downCards[0][i].length() == 1) {
                    System.out.print("|  " + downCards[0][i] + "   |   ");
                }
                //length 2
                else if (downCards[0][i].length() == 2) {
                    System.out.print("|  " + downCards[0][i] + "  |   ");
                }
            }
        }
        //LAST COL OF THE ROW
        //check bool
        //check bool
        if(bool[0][3] == true) {
            //length 1
            if (cards[0][3].length() == 1) {
                System.out.println("|  " + cards[0][3] + "   |   ");
            }
            //length 2
            else if (cards[0][3].length() == 2) {
                System.out.println("|  " + cards[0][3] + "  |   ");
            }
            //length 3
            else if (cards[0][3].length() == 3) {
                System.out.println("|  " + cards[0][3] + " |   ");

            }
            //length 4
            else if (cards[0][3].length() == 4) {
                System.out.println("| " + cards[0][3] + " |   ");
            }
        } else{
            System.out.println("|  " + downCards[0][3] + "   |   ");
        }
        System.out.println("|      |   |      |   |      |   |      |");
        System.out.println("+------+   +------+   + -----+   +------+");



        //2 row of cards
        System.out.println("+------+   +------+   +------+   +------+");
        System.out.println("|      |   |      |   |      |   |      |");
        for(int i = 0; i<3; i++) {
            //check bool
            if(bool[1][i] == true) {
                //length 1
                if (cards[1][i].length() == 1) {
                    System.out.print("|  " + cards[1][i] + "   |   ");
                }
                //length 2
                else if (cards[1][i].length() == 2) {
                    System.out.print("|  " + cards[1][i] + "  |   ");
                }
                //length 3
                else if (cards[1][i].length() == 3) {
                    System.out.print("|  " + cards[1][i] + " |   ");

                }
                //length 4
                else if (cards[1][i].length() == 4) {
                    System.out.print("| " + cards[1][i] + " |   ");
                }
            } else{
                //length 1
                if (downCards[1][i].length() == 1) {
                    System.out.print("|  " + downCards[1][i] + "   |   ");
                }
                //length 2
                else if (downCards[1][i].length() == 2) {
                    System.out.print("|  " + downCards[1][i] + "  |   ");
                }
            }
        }
        //LAST COL OF THE ROW
        //check bool
        //check bool
        if(bool[1][3] == true) {
            //length 1
            if (cards[1][3].length() == 1) {
                System.out.println("|  " + cards[1][3] + "   |   ");
            }
            //length 2
            else if (cards[1][3].length() == 2) {
                System.out.println("|  " + cards[1][3] + "  |   ");
            }
            //length 3
            else if (cards[1][3].length() == 3) {
                System.out.println("|  " + cards[1][3] + " |   ");

            }
            //length 4
            else if (cards[1][3].length() == 4) {
                System.out.println("| " + cards[1][3] + " |   ");
            }
        } else{
            System.out.println("|  " + downCards[1][3] + "   |   ");
        }
        System.out.println("|      |   |      |   |      |   |      |");
        System.out.println("+------+   +------+   +------+   +------+");



        //3 row of cards
        System.out.println("+------+   +------+   +------+   +------+");
        System.out.println("|      |   |      |   |      |   |      |");
        for(int i = 0; i<3; i++) {
            //check bool
            if(bool[2][i] == true) {
                //length 1
                if (cards[2][i].length() == 1) {
                    System.out.print("|  " + cards[2][i] + "   |   ");
                }
                //length 2
                else if (cards[2][i].length() == 2) {
                    System.out.print("|  " + cards[2][i] + "  |   ");
                }
                //length 3
                else if (cards[2][i].length() == 3) {
                    System.out.print("|  " + cards[2][i] + " |   ");

                }
                //length 4
                else if (cards[2][i].length() == 4) {
                    System.out.print("| " + cards[2][i] + " |   ");
                }
                //check bool
            } else{
                //length 1
                if (downCards[2][i].length() == 1) {
                    System.out.print("|  " + downCards[2][i] + "   |   ");
                }
                //length 2
                else if (downCards[2][i].length() == 2) {
                    System.out.print("|  " + downCards[2][i] + "  |   ");
                }
            }
        }
        //LAST COL OF THE ROW
        //check bool
        //check bool
        if(bool[2][3] == true) {
            //length 1
            if (cards[2][3].length() == 1) {
                System.out.println("|  " + cards[2][3] + "   |   ");
            }
            //length 2
            else if (cards[2][3].length() == 2) {
                System.out.println("|  " + cards[2][3] + "  |   ");
            }
            //length 3
            else if (cards[2][3].length() == 3) {
                System.out.println("|  " + cards[2][3] + " |   ");

            }
            //length 4
            else if (cards[2][3].length() == 4) {
                System.out.println("| " + cards[2][3] + " |   ");
            }
        } else{
            System.out.println("|  " + downCards[2][3] + "  |   ");
        }
        System.out.println("|      |   |      |   |      |   |      |");
        System.out.println("+------+   +------+   +------+   +------+");



        //4 row of cards
        System.out.println("+------+   +------+   +------+   +------+");
        System.out.println("|      |   |      |   |      |   |      |");
        for(int i = 0; i<3; i++) {
            //check bool
            if(bool[3][i] == true) {
                //length 1
                if (cards[3][i].length() == 1) {
                    System.out.print("|  " + cards[3][i] + "   |   ");
                }
                //length 2
                else if (cards[3][i].length() == 2) {
                    System.out.print("|  " + cards[3][i] + "  |   ");
                }
                //length 3
                else if (cards[3][i].length() == 3) {
                    System.out.print("|  " + cards[3][i] + " |   ");

                }
                //length 4
                else if (cards[3][i].length() == 4) {
                    System.out.print("| " + cards[3][i] + " |   ");
                }
                //check bool
            } else{
                //length 1
                if (downCards[3][i].length() == 1) {
                    System.out.print("|  " + downCards[3][i] + "   |   ");
                }
                //length 2
                else if (downCards[3][i].length() == 2) {
                    System.out.print("|  " + downCards[3][i] + "  |   ");
                }
            }
        }
        //LAST COL OF THE ROW
        //check bool
        //check bool
        if(bool[3][3] == true) {
            //length 1
            if (cards[3][3].length() == 1) {
                System.out.println("|  " + cards[3][3] + "   |   ");
            }
            //length 2
            else if (cards[3][3].length() == 2) {
                System.out.println("|  " + cards[3][3] + "  |   ");
            }
            //length 3
            else if (cards[3][3].length() == 3) {
                System.out.println("|  " + cards[3][3] + " |   ");

            }
            //length 4
            else if (cards[3][3].length() == 4) {
                System.out.println("| " + cards[3][3] + " |   ");
            }
        } else{
            System.out.println("|  " + downCards[3][3] + "  |   ");
        }
        System.out.println("|      |   |      |   |      |   |      |");
        System.out.println("+------+   +------+   +------+   +------+");

    }


    /**
     * get user to choose a card from 1 - 16
     * @return value between 1-16
     */
    public static int getChoice(){
        System.out.print("Please Enter Card: ");
        int num = CheckInput.getIntRange(1,16);
        System.out.println();

        return num;
    }


    /**
     * flip over the card that the user chose
     * @param choice: the card the user chose
     * @param bool: the (boolean) array of flipped and unflipped cards
     */
    public static void flipChoice(int choice, boolean[][] bool){

        // false == face down
        // true == face up
        //reversing at the position
        //rows
        for( int i = 0; i<=3; i++) {
            //columns
            for (int j = 0; j <= 3; j++) {

                if (choice == (i * 4) + j + 1) {
                    if( bool[i][j] == true ){
                        bool[i][j] = false;
                    } else{
                        bool[i][j] = true;
                    }
                }
            }
        }

    }


    /**
     * see if the two cards match
     * @param card1 value of first card flipped
     * @param card2 value of second card flipped
     * @return true if matched, or false if not a match
     */
    public static boolean isMatch(String card1, String card2){
        boolean match = false;

        if(card1 == card2) {
            match = true;
        }

        return match;
    }


    /**
     * check to see if the card that the user chose had already been flipped yet
     * @param choice: the card that the user choice
     * @param bool: true = already flipped, false = have not been flipped yet
     * @return: true if already flipped or false if it havent been flipped yet
     */
    public static boolean checkedFlipped(int choice, boolean[][] bool){
        if(choice == 1){
            if(bool[0][0] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 2){
            if(bool[0][1] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 3){
            if(bool[0][2] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 4){
            if(bool[0][3] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 5){
            if(bool[1][0] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 6){
            if(bool[1][1] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 7){
            if(bool[1][2] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 8){
            if(bool[1][3] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 9){
            if(bool[2][0] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 10){
            if(bool[2][1] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 11){
            if(bool[2][2] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 12){
            if(bool[2][3] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 13){
            if(bool[3][0] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 14){
            if(bool[3][1] == true){
                return true;
            } else{
                return false;
            }
        } else if( choice == 15){
            if(bool[3][2] == true){
                return true;
            } else{
                return false;
            }
        } else{
            if(bool[3][3] == true){
                return true;
            } else{
                return false;
            }
        }
    }
}

//vu-p1.zip