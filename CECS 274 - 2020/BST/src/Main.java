/**
 * Tina L Vu
 * 05/06/2020
 * read word.txt and construct a bst for it,
 * print out menu of actions, follow through action
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create way to exit menu
        boolean exit = true;
        //create binary search tree
        BST tree = new BST();

        //try to scan the word file
        try {
            //scan file
            Scanner read = new Scanner(new File("words.txt"));
            //repeat until end of file
            while (read.hasNext()) {
                //read from the file
                String line = read.nextLine();
                //create word object
                Word word = new Word(line);
                //add word to binary tree
                if(tree.contains(word) == word){
                    word.incFrequency();
                } else {
                    tree.add(word);
                }
            }
            //if the file is not found
        } catch (FileNotFoundException fnf) {
            System.out.println("File was not Found");
        }

        //continue program until prompt to exit
        while(exit == true) {
            //print out the menu
            System.out.println("Menu:");
            System.out.println("1. Display");
            System.out.println("2. Search");
            System.out.println("3. Quit");

            //get user's input
            int userInput = CheckInput.getIntRange(1, 3);

            //go to what ever function chosen
            //display list of word in alphabetical order with frequencies
            if (userInput == 1) {
                System.out.println(tree.toSortedString());

                //search for a specific word and its frequency
            } else if( userInput == 2){
                //ask for word
                System.out.print("Please Enter a Word: ");
                String userInput2 = CheckInput.getString();
                Word search = new Word(userInput2);

                //try to scan the word file
                try {
                    //scan file
                    Scanner read = new Scanner(new File("words.txt"));
                    //repeat until end of file
                    while (read.hasNext()) {
                        //read from the file
                        String line = read.nextLine();
                        //if word is same as word we are searching for, increment
                        if(line.equals(userInput2)){
                            search.incFrequency();
                        }
                    }
                    //if the file is not found
                } catch (FileNotFoundException fnf) {
                    System.out.println("File was not Found");
                }
                    //output word search for with its frequency
                    System.out.println(search);

            //exit program
            } else {
                System.out.println("Good Bye");
                exit = false;
            }
        }
    }

}
