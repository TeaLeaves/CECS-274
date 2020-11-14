/**
 * Tina L Vu
 * 04/20/2020
 * create a program that ask the user to input points to create a 2D array matrix;
 * first create a stack them transfer that stack into the array
 */

import java.awt.Point;

public class Main {
    public static void main( String[] args ) {

        //create 5x5 2D character array filled with '.'
        char[][] charArray = {{'.','.','.','.','.'},{'.','.','.','.','.'}
        ,{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};

        //create empty linked stack
        LinkedStack stack = new LinkedStack();

        //ask user for 5 points
        System.out.println("Enter 5 Locations (0-4): ");
        //rows = x, cols = y
        for(int i = 1; i < 6; i++){

            //ask for a value for row
            System.out.print("r" + i + ": ");
            int x = CheckInput.getIntRange(0,4);
            //ask for a value for column
            System.out.print("c" + i + ": ");
            int y = CheckInput.getIntRange(0,4);

            //create the point
            Point location = new Point(x,y);

            //add the point into stacked list
            stack.push(location);
        }

        //just to make it look neat when outputted
        System.out.println("");

        //if stack is not empty...
        if(!stack.isEmpty()) {
            //remove 1 point from the stack
            Point charPoint = stack.pop();

            //place a number at that location in CharArray
            int row = charPoint.x;
            int cols = charPoint.y;
            charArray[row][cols] = '1';

            //place same number to the 4 neighboring spots:
            //down
            if (cols < 4) {
                charArray[row][cols + 1] = '1';
            }
            //up
            if(cols > 0){
                charArray[row][cols - 1] = '1';
            }
            //right
            if (row < 4) {
                charArray[row + 1][cols] = '1';
            }
            //left
            if(row > 0){
                charArray[row - 1][cols] = '1';
            }
        }

        //if stack is not empty...
        if(!stack.isEmpty()) {
            //remove 1 point from the stack
            Point charPoint = stack.pop();

            //place a number at that location in CharArray
            int row = charPoint.x;
            int cols = charPoint.y;
            charArray[row][cols] = '2';

            //place same number to the 4 neighboring spots(up,down,left,right)
            if (cols < 4) {
                charArray[row][cols + 1] = '2';
            }
            if(cols > 0){
                charArray[row][cols - 1] = '2';
            }
            if (row < 4) {
                charArray[row + 1][cols] = '2';
            }
            if(row > 0){
                charArray[row - 1][cols] = '2';
            }
        }

        //if stack is not empty...
        if(!stack.isEmpty()) {
            //remove 1 point from the stack
            Point charPoint = stack.pop();

            //place a number at that location in CharArray
            int row = charPoint.x;
            int cols = charPoint.y;
            charArray[row][cols] = '3';

            //place same number to the 4 neighboring spots(up,down,left,right)
            if (cols < 4) {
                charArray[row][cols + 1] = '3';
            }
            if(cols > 0){
                charArray[row][cols - 1] = '3';
            }
            if (row < 4) {
                charArray[row + 1][cols] = '3';
            }
            if(row > 0){
                charArray[row - 1][cols] = '3';
            }
        }

        //if stack is not empty...
        if(!stack.isEmpty()) {
            //remove 1 point from the stack
            Point charPoint = stack.pop();

            //place a number at that location in CharArray
            int row = charPoint.x;
            int cols = charPoint.y;
            charArray[row][cols] = '4';

            //place same number to the 4 neighboring spots(up,down,left,right)
            if (cols < 4) {
                charArray[row][cols + 1] = '4';
            }
            if(cols > 0){
                charArray[row][cols - 1] = '4';
            }
            if (row < 4) {
                charArray[row + 1][cols] = '4';
            }
            if(row > 0){
                charArray[row - 1][cols] = '4';
            }
        }

        //if stack is not empty...
        if(!stack.isEmpty()) {
            //remove 1 point from the stack
            Point charPoint = stack.pop();

            //place a number at that location in CharArray
            int row = charPoint.x;
            int cols = charPoint.y;
            charArray[row][cols] = '5';

            //place same number to the 4 neighboring spots(up,down,left,right)
            if (cols < 4) {
                charArray[row][cols + 1] = '5';
            }
            if(cols > 0){
                charArray[row][cols - 1] = '5';
            }
            if (row < 4) {
                charArray[row + 1][cols] = '5';
            }
            if(row > 0){
                charArray[row - 1][cols] = '5';
            }
        }


        //output the array matrix
        for(int i = 0; i<charArray.length; i++){
            for(int j = 0; j<charArray[i].length; j++){
                //space to keep it neat when outputted
                System.out.print(charArray[i][j]+" ");
            }
            //next line
            System.out.println();
        }
    }
}
