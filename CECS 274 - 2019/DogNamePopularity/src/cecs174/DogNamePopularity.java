package cecs174; //package = folder in src

import java.util.Scanner;

/**
 * Program to demonstrate working with arrays, parallel arrays, linear search. 
 * @author Alvaro Monge alvaro.monge@csulb.edu
 * @author Tina L. Vu Tina.vu01@student.csulb.edu
 */
public class DogNamePopularity {
   // A class can have declarations of variables, constants, methods, ...

   public static final int MAX_DOG_NAMES = 50;
   //final = this value is final, cannot be changed, a CONSTANT not value

   public static Scanner userInput = new Scanner(System.in);
   //Scanner(system.in) = input     Scanner(system.out) = output

   public static void main(String[] args) {
      String[] dogNames = new String[MAX_DOG_NAMES];
      int[] dogNameFrequency = new int[MAX_DOG_NAMES];
      
      MainMenu.displayWelcome();

      int nameCount = readDogNamePopularity(dogNames, dogNameFrequency);

      System.out.println("The following are the dog name data scanned in:\n");
      displayDogData(dogNames, dogNameFrequency, nameCount);
      
      String userChoice;
      do {   // do-while loops are used when loop must iterate at least once

         MainMenu.displayMenu();
         userChoice = userInput.nextLine().toUpperCase();

         // switch statements often provide more clarity than if else-if else-if...
         switch (userChoice)
         {
         case MainMenu.SEARCH_OPTION: 
            System.out.println("Enter dog name to search: ");
            String dogName = userInput.nextLine();
            displayDogData(dogNames, dogNameFrequency, nameCount, dogName);
            break;

         case MainMenu.RANK_RANGE_OPTION:
            System.out.println("Enter rank to use for range lower bound: ");
            int lowerBoundRank = userInput.nextInt();
            System.out.println("Enter rank to use for range upper bound: ");
            int upperBoundRank = userInput.nextInt();
            userInput.nextLine(); // eliminates the left-over end-of-line
            displayRankRange(dogNames, dogNameFrequency, nameCount, lowerBoundRank, upperBoundRank);
            break;

         case MainMenu.QUIT_OPTION:
            System.out.println("Good bye...");
            break;

         default: // user didn't enter any of the options
            System.out.println("Please choose from one of the options in the menu");
         }
      } while (! userChoice.equalsIgnoreCase(MainMenu.QUIT_OPTION));
      
      userInput.close();
   }
   
   /**
    * Read information on dog names and popularity from the user.
    * @param names the array of dog names, ordered according to frequency 
    * @param frequency the array of how frequently the corresponding dog name has been used, ordered in descending value
    * @return the number of entries provided by the user
    */
   public static int readDogNamePopularity(String[] names, int[] frequency)
   {
      // TODO: Lab activity, add error checking
      int i = 0;
      boolean done = false;
      System.out.println("Enter the dog names and frequency, one per line separated by comma (e.g.: Lassie,258): ");
      while ( !done && i < names.length && userInput.hasNextLine() )
      {
         String lineOfInput = userInput.nextLine();
         if (lineOfInput.equalsIgnoreCase(MainMenu.DOG_NAMES_INPUT_DONE)) 
         {
            done = true;
         } 
         else {
            String[] fields = lineOfInput.split(",");
            names[i] = fields[0];
            frequency[i] = Integer.parseInt(fields[1]);
            i++;

            int j = 1;
            if (frequency[j] > frequency[j-1]){
            i++;}
            j++;
         }


      }
      

      return i;
   }
   
   /**
    * Display dog names that fall within a range of ranks in a list of the top dog names. The arrays with the
    * list of names and frequencies are assumed to be in order by frequency.
    * @param names the array of dog names, ordered according to frequency 
    * @param frequency the array of how frequently the corresponding dog name has been used, ordered in descending value
    * @param nameCount the number of entries in the names and frequency arrays
    * @param lowerBoundRank the lowerbound of the range of dog names to be displayed
    * @param upperBoundRank the upperbound of the range of dog names to be displayed
    */
   public static void displayRankRange(String[] names, int[] frequency, int nameCount, int lowerBoundRank, int upperBoundRank)
   {
      System.out.printf("Dog names ranked %d thru %d:\n", lowerBoundRank, upperBoundRank);
      // TODO: Lab activity, complete this method

      if(lowerBoundRank < 1|| upperBoundRank > names.length){
         System.out.println("ERROR: that is NOT within Range");
      }
      else{
         for(int i = lowerBoundRank-1; i<upperBoundRank;i++){
            System.out.println(names[i]);
         }
      }

   }
   
   /**
    * Finds a dog name in an array of dog names and displays its rank and frequency. 
    * @param names the array of dog names, ordered according to frequency 
    * @param frequency the array of how frequently the corresponding dog name has been used, ordered in descending value, frequency[i] is the frequency for name names[i]
    * @param nameCount the number of valid entries in the names and frequency arrays
    * @param dogName the name of the dog being searched.
    */
   public static void displayDogData(String[] names, int[] frequency, int nameCount, String dogName)
   {
      
      // TODO: live implementation of linear search   

      boolean isFound = false;
      int i = 0;

      // setup the while loop
      while ( i<nameCount && !isFound) {
         if(names[i].equals(dogName)){
            isFound = true;
            System.out.printf("Rank: %d    Frequency: %s\n",i+1, frequency[i]);
         }
         i++;

      }

   }
   
   /**
    * Displays the data on dog names and popularity.
    * @param names the array of dog names, ordered according to frequency 
    * @param frequency the array of how frequently the corresponding dog name has been used, ordered in descending value, frequency[i] is the frequency for name names[i]
    * @param nameCount the number of valid entries in the names and frequency arrays
    */
   public static void displayDogData(String[] names, int[] frequency, int nameCount)
   {
      for (int i=0; i < nameCount; i++)
      {
         System.out.printf("Rank %d: %s, frequency %d\n", i+1, names[i], frequency[i]);
      }
   }
}
