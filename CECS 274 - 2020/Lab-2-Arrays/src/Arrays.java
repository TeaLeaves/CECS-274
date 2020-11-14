/* author: Tina L Vu
 * date: 02/03/20
 * description: in this program, the computer will prompt the user for 10 integers which
 * would be put into an array. Then the user will have a choice from 8 options in a menu.
 * The 8th option is quit, which is the only way to exit the program. Otherwise the menu
 * will continue to pop-up after every option completed.
 */
public class Arrays {

    /*
     * ask for 10 ints, then display menu
     * run through which ever program the user ask for
     * @param: possible string args
     */
    public static void main( String[] args ){

        //make an array, array declared
        int[] array = populateArray();
        //initializer
        boolean exit = false;


        //repeat menu until user quit
        while(exit == false){
            displayMenu();

            System.out.print("Please Select from Options: ");
            //make sure users input is in the range
            int play = CheckInput.getIntRange(1, 8);

            //display array values
            if( play == 1){
                displayValues(array);

            //display array values in reverse
            } else if( play == 2){
                displayReverse(array);

            //display sum of the array
            } else if( play == 3){
                System.out.println(computeSum(array));

            //display the maximum value in the array
            } else if( play == 4){
                System.out.println(maxValue(array));

            //find the users value, in the array
            } else if( play == 5) {
                System.out.print("Please Enter a Value: ");
                int value = CheckInput.getInt();
                //find the value
                int present = findValue(array,value);

                //value not found
                if( present == -1){
                    System.out.println("Value Not Found");
                //value found
                } else{
                    System.out.println("Value is found at the " + (present+1) + " location");
                }

            //replace a value in the array
            } else if( play == 6) {
                System.out.print("Please Enter a New Value: ");
                int value = CheckInput.getInt();
                System.out.print("Location of the New Value (1-10): ");
                int location = CheckInput.getIntRange(1,10);

                //replace the value of the array
                array = insertValue(array, value, location);

            //make a new array
            } else if( play == 7) {
                array = populateArray();

            //exit
            } else{
                exit = true;
            }

        }

    }


    /*
     * ask the user for 10 integers
     * @return: the 10 integers in an array
     * @param array: the 10 integers in an array
     */
    public static int[] populateArray( ){
        //create empty array
        int [] array = new int [10];

        //ask user for numbers to fill into array
        for( int i = 0; i<10; i++){
            System.out.print("Please Enter the " + (i+1) + " integer: ");
            //make sure value is an int
            array[i] = CheckInput.getInt();
        }

        return array;
    }


    /*
     * display the content of the array
     * @param array: given 10 ints in an array
     */
    public static void displayValues( int[] array ){
        for( int i = 0; i< array.length; i++){
            if( i<array.length-1) {
                System.out.print(array[i] + ", ");
            }else{
                System.out.println(array[i]);
            }
        }
    }


    /*
     * display the content of the array in reverse
     * @param array: given 10 ints in an array
     */
    public static void displayReverse( int[] array){
        for( int i = 1; i< array.length+1; i++){
            if(i<array.length){
                System.out.print(array[array.length - i] + ", ");
            } else{
                System.out.println(array[array.length - i]);
            }
        }
    }


    /*
     * find the placement of the value
     * @param array: given 10 ints in an array
     * @param value: given value to search for in the array
     * @return: the number placement of the value
     */
    public static int findValue( int[] array, int value ){
        //initializer
        boolean found = false;
        int gotValue = -1;

        //until value is found or value does not exist, continue loop
        while(found == false){
            for( int i = 0; i < array.length; i++){
                if( array[i] == value ){
                    found = true;
                    gotValue = i;
                }
            }

            //value does not exist so exit
            found = true;
        }

        return gotValue;
    }


    /*
     * overwrite the old value at the placement given, with the new given value
     * @param array: given 10 ints in an array
     * @param value: the new value that is being inserted
     * @param location: the position in the array(-1) of where to replace the value
     * @return: new array, with the replaced integer
     */
    public static int[] insertValue( int[] array, int value, int location){

        array[location-1] = value;

        return array;
    }


    /*
     * find the largest value in the array
     * @param: given 10 ints in an array
     * @return: the largest integer found in the array
     */
    public static int maxValue( int[] array ){
        int max = array[0];

        for( int i = 0; i < array.length; i++){
            if( array[i] > max){
                max = array[i];
            }
        }

        return max;
    }


    /*
     * add the values in the array
     * @param: given 10 ints in an array
     * @return: sum of values
     */
    public static int computeSum( int[] array ){

        int sum = 0;

        for( int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }

        return sum;
    }


    /*
     * display the menu to the user
     */
    public static void displayMenu(){
        System.out.println(" 1. Display Values ");
        System.out.println(" 2. Display Reversed ");
        System.out.println(" 3. Display Sum ");
        System.out.println(" 4. Display Maximum ");
        System.out.println(" 5. Search for a Value ");
        System.out.println(" 6. Insert new Value ");
        System.out.println(" 7. Reset Values ");
        System.out.println(" 8. Quit ");

    }

}
