/** 
 * Class to test the methods of Rect.java
 */
public class Main {
	public static void main(String [] args){
		boolean pass = false;
		pass = testConstructors();
		if(pass){ 
			pass = testEquals();
		}
		if(pass){
			testCompareTo();
			testScale();
		}
	}
	/**
	 * Tests the constructors and get functions of Rect
	 * 1. Default constructor
	 * 2. Overloaded constructor w/ one parameter (cannot be negative)
	 * 3. Overloaded constructor w/ width and height parameters (w & h cannot be negative)
	 * 4. Overloaded constructor w/ rectangle parameter
	 * @return returns true if constructors and get methods are correct
	 */
	public static boolean testConstructors(){
		Rect r1 = new Rect(); // w = 0, h = 0
		Rect r2 = new Rect(3); //w = 3, h = 3
		Rect r3 = new Rect(-3); //w = 0, h = 0
		Rect r4 = new Rect(3,4); //w = 3, h = 4
		Rect r5 = new Rect(-1,-2); //w = 0, h = 0
		Rect r6 = new Rect(1,-2); //w = 1, h = 0
		Rect r7 = new Rect(r2); //w = 3, h = 3
		if(r1.getWidth() == 0 && r1.getHeight()==0){
			if(r2.getWidth() == 3 && r2.getHeight()==3){
				if(r3.getWidth() == 0 && r3.getHeight()==0){
					if(r4.getWidth() == 3 && r4.getHeight()==4){
						if(r5.getWidth() == 0 && r5.getHeight()==0){
							if(r6.getWidth() == 1 && r6.getHeight()==0){
								if(r7.getWidth() == 3 && r7.getHeight()==3){
									System.out.println("1. All constructors are CORRECT.");
									System.out.println("2. All get functions are CORRECT.");
									return true;
								}else{
									System.out.println("Constructor 4 is incorrect.");
								}
							}else{
								System.out.println("Constructor 3 (negative height) is incorrect.");
							}
						}else{
							System.out.println("Constructor 3 (negative parameters) is incorrect.");
						}
					}else{
						System.out.println("Constructor 3 is incorrect.");
					}
				}else{
					System.out.println("Constructor 2 (negative) is incorrect");
				}
			}else{
				System.out.println("Constructor 2 is incorrect.");
			}
		}else{
			System.out.println("Default Constructor is incorrect.");
		}
		return false;
	}
	/** 
	 * Tests the equals method for the Rect class
	 * Compares several rectangles with different values
	 * @return returns true if equals methods are correct
	 */
	public static boolean testEquals(){
		Rect r1 = new Rect();
		Rect r2 = new Rect(3);
		Rect r3 = new Rect(3,4);
		Rect r4 = new Rect(3,3);
		Rect r5 = new Rect(r3);
		if(r3.equals(r5) && r2.equals(r4) && !r2.equals(r3) && !r1.equals(r2)){
			System.out.println("3. Equals function is CORRECT.");
			return true;
		}else{
			System.out.println("Equals function is incorrect.");
		}
		return false;
	}
	/** 
	 * Tests the compareTo method for the Rect class
	 * Compares several rectangles with different values
	 */
	public static void testCompareTo(){
		Rect r1 = new Rect(1,3);
		Rect r2 = new Rect(3,3);
		Rect r3 = new Rect(3,4); 
		Rect r4 = new Rect(3,4);
		if(r1.compareTo(r3)< 0 && r1.compareTo(r2)<0 ){
			if(r3.compareTo(r1) > 0 && r2.compareTo(r1)>0){
				if( r3.compareTo(r4) ==0 ){
					System.out.println("4. CompareTo function is CORRECT.");
				}else{
					System.out.println("CompareTo (==) function is incorrect.");
				}
			}else{
				System.out.println("CompareTo (>0) function is incorrect.");
			}
		}else{
			System.out.println("CompareTo (<0) function is incorrect.");
		}
	}
	/**
	 * Tests the scale methods of the Rect class
	 * Multiplies value to the width and height if positive 
	 */
	public static void testScale(){
		Rect r1 = new Rect(2,2);
		r1.scale(5); // w = 10, h = 10
		Rect r2 = new Rect(2,2);
		r2.scale(-2);// w = 2, h = 2
		Rect r3 = new Rect(2,2);
		r3.scale(3, 4);// w = 6, h = 8
		Rect r4 = new Rect(2,2);
		r4.scale(3, -4);// w = 6, h = 2
		Rect r5 = new Rect(r1);
		r5.scale(r3); // w = 16, h = 18
		if(r1.equals(new Rect(10,10)) && r2.equals(new Rect(2,2))){
			if(r3.equals(new Rect(6,8)) && r4.equals(new Rect(6,2))){
				if(r5.equals(new Rect(16, 18))){
					System.out.println("5. Scale functions are CORRECT.");
				}else{
					System.out.println("scale(r) is incorrect.");
				}
			}else{
				System.out.println("scale(w,h) is incorrect.");
			}
		}else{
			System.out.println("scale(l) is incorrect.");
		}
	}
}