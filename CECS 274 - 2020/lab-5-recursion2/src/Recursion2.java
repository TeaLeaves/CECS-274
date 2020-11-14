/**Four recursive problems.  * Add your two facade functions. * Add your code to the four functions given below. * Do not change any part of the function headers (name, parameters, or return type). * Do not change any part of the main. */public class Recursion2 {	public static void main( String[] args ) {		int [] array = { 46, 22, 7, 58, 91, 55, 31, 84, 12, 78 };		if( findMax( array ) == 91 ) {			System.out.println( "findMax is correct!" );		}		if( reverseStr( "Hello" ).equals( "olleH" ) ) {			System.out.println( "reverseString1 is correct!" );		}			if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'o' ) == 4 ) {			System.out.println( "charFrequency1 is correct!" );		}		if( findMin( array ) == 7 ) {			System.out.println( "findMin is correct!" );		}		if( reverseStr( "pupils" ).equals( "slipup" ) ) {			System.out.println( "reverseString2 is correct!" );		}			if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'e' ) == 3 ) {			System.out.println( "charFrequency2 is correct!" );		}	}	//Write your facade functions here	/** Finds the maximum value in an array	 * @param array array of values (sorted or unsorted)	 * @param i iterator	 * @param max maximum value found so far	 * @return maximum value	 */	private static int maxArray( int [] array, int i, int max ) {		//base case		if(i == array.length){			return max;			//run through array		} else{			//if current value in arraylist is greatest			if(array[i] > max){				//make it the max value				max = array[i];			}			//recursion			return maxArray( array, i+1, max );		}	}	/**	 * description: facade function made to call maxArray	 * @param array array of values (sorted or unsorted)	 * @return maximum value	 */	private static int findMax( int [] array){		//initialize		int max = array[0];		int i = 0;		//recursion to find max value		int foundMax = maxArray(array, i, max);		return foundMax;	}	/** Finds the maximum value in an array	 * @param array array of values (sorted or unsorted)	 * @param i iterator	 * @param min maximum value found so far	 * @return minimum value	 */	private static int minArray( int [] array, int i, int min ) {		//base case		if(i == array.length){			return min;			//run through array		} else{			//if current value in arraylist is lowest			if(array[i] < min){				//make it the min value				min = array[i];			}			//recursion			return minArray( array, i+1, min );		}	}	/**	 * description: facade function made to call minArray	 * @param array array of values (sorted or unsorted)	 * @return minimum value	 */	private static int findMin( int [] array){		//initialize		int min = array[0];		int i = 0;		//recursion to find min value		int foundMin = minArray(array, i, min);		return foundMin;	}	/** Reverses a string	 * @param s the string to reverse	 * @return the reversed string	 */	public static String reverseStr( String s ) {		//base case		if(s.length() == 0){			return s;		}else{			// recursion with rest of string(s-1) + single character			return reverseStr(s.substring(1))+s.charAt(0);		}	}	/** Returns the number of times c appears in the string str	 * @param str string to test	 * @param c character to find	 * @return number of times the character appeared in the string	 */	public static int charFrequency( String str, char c ) {		//base case		if(str.length() == 0){			return 0;			//everything else		} else{			//if character equals c			if(str.charAt(0) == c){				//loop again with rest of string and return 1				return charFrequency( str.substring(1), c )+1;			}			//if character does not equal c, just loop again w/rest of string			return charFrequency( str.substring(1), c );		}	}}