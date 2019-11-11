package tasklist;

import java.util.ArrayList;

/**
 * Heap Class - creates a container that can consist of any
 * type of comparable object
 * @author Roman
 */
public class Heap <T extends Comparable<T>> {

	/** The list of comparable objects
	 */
	private ArrayList<T> heap;
	
	/** Constructor - initializes the list of comparable objects
	 */
	public Heap() {
		heap = new ArrayList<T>();
	}
	
	/** finds the amount of objects in the container
	 * @return amount of objects in heap
	 */
	public int size() {
		return heap.size();
	}
	
	/** tests to see if the heap is empty
	 * @return true if the heap is empty and false if the heap
	 * is not empty
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	/** finds the current generic object in the heap
	 * @return the ojbect at the current index
	 */
	public T getCurrent() {
		return heap.get( 0 );
	}
	
	/** finds parent's location of the object
	 * @return index of parent
	 */
	public int getPLoc( int i ) {
		return ( i - 1 ) / 2;
	}
	
	/** finds left child's location of the object
	 * @return index of left child
	 */
	public int getLCLoc( int i ) {
		return 2 * i + 1;
	}
	
	/** finds right child's location of the object
	 * @return index of right child
	 */
	public int getRCLoc( int i ) {
		return 2 * i + 2;
	}
	
	/** adds an item and sorts it to the heap
	 * @param t item to be added to the heap
	 */
	public void addItem( T t ) {
		heap.add( null );
		int index = heap.size() - 1;
		while( index > 0 && heap.get( getPLoc(index)).compareTo(t) > 0 ) {
			heap.set( index,  heap.get( getPLoc(index) ) );
			index = getPLoc(index);
		}
		heap.set( index, t);
	}
	
	/** changes the heap into a string
	 * @return the items in the heap as a string separated by a comma
	 */
	public String toString() {
		String s = "";
		for ( int i = 0; i < heap.size(); i++ ) {
			s += heap.get( i ) + ", ";
		}
		return s;
	}
	
	/** removes an item in the heap
	 * @return the item that has been removed from the heap
	 */
	public T removeItem() {
		T min = heap.get( 0 );
		int index = heap.size() - 1;
		T last = heap.remove( index );
		
		if ( index > 0 ) {
			
			heap.set( 0,  last );
			T root = heap.get( 0 );
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			
			while( !done ) {
				
				if ( getLCLoc( index ) <= end ) {
					
					T child = heap.get( getLCLoc( index ) );
					int childLoc = getLCLoc( index );
					
					if( getRCLoc( index ) <= end ) {

						if( heap.get( getRCLoc( index ) ).compareTo(child) < 0 ) {
							
							child = heap.get( getRCLoc( index ) );
							childLoc = getRCLoc( index );
							
						}
					}

					if ( child.compareTo(root) < 0 ) {
						
						heap.set( index, child );
						index = childLoc;
						
					}
					
					else {
						
						done = true;
						
					}
				}
				
				else {
					
					done = true;
					
				}
				
				heap.set( index,  root );
				
			}
			
			return min;
			
			
		}
		
		return null;
	}
}
