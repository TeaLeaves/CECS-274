/*
 * Name: Tina L Vu
 * Date: 02/11/20
 * Description: make a program that runs through a txt of grades, add the grades into an
 * arraylist, then show a menu of options that the user may use
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Analysis {

    /*
     * description: run through grade.txt and add into an array list, sort the array list,
     * run through menu until user exit
     */
    public static void main( String[] args){
        //initialize
        boolean exit = false;

        //run text
        ArrayList<Integer> grades = populateGrades();
        //sort grades
        sortList(grades);

        //repeat until user decide to exit
        while(exit != true){
            //open menu
            displayMenu();
            System.out.println("Please Enter an Option: ");

            //receive an option from the user
            int option = CheckInput.getIntRange(1,6);

            //display sorted array list
            if(option == 1){
                //display the list
                displayGrades(grades);

            //display average grade
            } else if(option == 2 ){
                double sum = sumGrades(grades);
                double average = sum/(grades.size());
                System.out.printf("The Avg Grade is %.1f ", average);
                System.out.print("\n");

            //display maximum grade
            } else if( option == 3){
                int maxlocation = grades.size();
                int max = (int) grades.get(maxlocation-1);
                System.out.println("The Highest Grade is " + max);

            //display minimum grade
            } else if( option == 4 ){
                int min = (int) grades.get(0);
                System.out.println("The Lowest Grade is " + min);

            //display median grade
            } else if( option == 5 ){
                double median = findMedian(grades);
                System.out.printf("The Median is %.1f", median);
                System.out.print("\n");

            //exit
            } else if( option == 6 ){
                System.out.println("GoodBye");
                exit = true;
            }

        }
    }


    /*
     * description: construct an arraylist of grades
     * @return: arraylist with grades
     */
    public static ArrayList populateGrades(){
        //create array list
        ArrayList <Integer> list = new ArrayList<>();

        try{
            //read grade.txt
            Scanner read = new Scanner( new File("grades.txt") );

            //add into array list
            while(read.hasNext()){
                int line = read.nextInt();
                list.add(line);
            }
            read.close();

            //file not found
        } catch( FileNotFoundException fnf){
            System.out.println("File Not Found");
        }
        return list;
    }


    /*
     * description: display grades in rows of 10 numbers
     * @param grades: the arraylist of grades
     */
    public static void displayGrades( ArrayList grades ){
        //initializer
        int position = 0;

        //print grades
        for (int i = 0; i < grades.size(); i++) {
            System.out.print(grades.get(i) + " ");
            position++;

            //if there are 10 values, nextline
            if((position %10 == 0)){
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }


    /*
     * description: sort the grades from least to greatest
     * @param: the arraylist of grades
     */
    public static void sortList( ArrayList<Integer> grades ){

        int large = 0;

        //single number comparing others with
        for(int comparor = 0; comparor < grades.size(); comparor++){
            //the other numbers that we are comparing with
            for( int i = comparor; i < grades.size(); i++){
                if( grades.get(comparor) > grades.get(i) ){
                    large = grades.get(comparor);

                    //switch smaller number to front
                    grades.set(comparor, grades.get(i));
                    //switch larger number to back
                    grades.set( i, large);
                }
            }

        }
    }


    /*
     * description: calculate the sum of all values
     * @param: the arraylist of grades
     * @return: sum result
     */
    public static int sumGrades( ArrayList<Integer> grades ){
        int sum = 0;

        //add number from arraylist to sum
        for(int i = 0; i<grades.size(); i++){
            sum = (grades.get(i)) + sum;
        }

        return sum;
    }


    /*
     * description: find the median value of the list
     * @return: median result
     */
    public static double findMedian( ArrayList<Integer> grades ){
        //initialize
        double median = 0;

        //if even amount of grades
        if(grades.size()%2 == 0){
            //get locations
            int middle1location = grades.size() / 2;
            int middle2location = (grades.size() / 2)-1;

            //get median
            median = ((double)(grades.get(middle1location) + grades.get(middle2location)))/2;

        } else {
            //get location
            int middlelocation = grades.size() / 2;

            //get the median
            median = (double)(grades.get(middlelocation));

        }
        return median;
    }


    /*
     * description: display menu
     */
    public static void displayMenu(){
        System.out.println("1. Display Sorted Grades");
        System.out.println("2. Display Average Grades");
        System.out.println("3. Display Maximum Grades");
        System.out.println("4. Display Minimum Grades");
        System.out.println("5. Display Median Grades");
        System.out.println("6. Quit");
    }
}
