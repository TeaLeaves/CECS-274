/**
 * provided on BeachBoard
 */
public class Main {
	public static void main( String[] args ) {
		Circle c1 = new Circle( 3, 4, 2 );
		Circle c2 = new Circle( 6, 3, 4 );
		Circle c3 = new Circle( 0, 0, 3 );
		Circle c4 = new Circle( 1, 2, 5 );
		Circle c5 = new Circle( 3, 4, 5 );
		Circle c6 = new Circle( 1, 2, 6 );
		Circle c7 = new Circle( 1, 2, 5 );
		Circle c8 = new Circle( 3, 4, 2 );

		if(c4.equals(c7) && !c4.equals(c6) && !c4.equals(c5)){
			System.out.println("1. CORRECT - Circles constructed & equals works");
		}
		
		LinkedList list = new LinkedList();
		if(list.isEmpty()){
			System.out.println("2. CORRECT - Linked List constructed");
		}

		list.add( c1 );
		list.add( 0, c2 );
		list.add( c3 );

		String s = "" + list;
		if(s.equals("(6,3) R = 4\n(3,4) R = 2\n(0,0) R = 3\n")){
			System.out.println("3. CORRECT - All circles added");
		}
		
		if(list.size() == 3){
			System.out.println("4. CORRECT - Size function works");
		}

		if(list.get( 1 ).equals(c8)){
			System.out.println("5. CORRECT - Get function works");
		}

		list.set(1, c4);
		s = "" + list;
		if(s.equals("(6,3) R = 4\n(1,2) R = 5\n(0,0) R = 3\n")){
			System.out.println("6. CORRECT - Set function works");
		}

		list.remove(0);
		list.remove(c7);
		s = "" + list;
		if(s.equals("(0,0) R = 3\n")){
			System.out.println("7. CORRECT - Remove functions work");
		}
	}
}
