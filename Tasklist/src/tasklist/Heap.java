package tasklist;

import java.util.ArrayList;

public class Heap <T> {

	private ArrayList<T> heap;
	
	public Heap() {
		heap = new ArrayList<T>();
	}
	
	public int size() {
		return heap.size();
	}
	
	public T getCurrent() {
		return heap.get( 0 );
	}
	
	public int getPLoc( int i ) {
		return ( i - 1 ) / 2;
	}
	
	public int getLCLoc( int i ) {
		return 2 * i + 1;
	}
	
	public int getRLoc( int i ) {
		return 2 * i + 2;
	}
	
	public void addItem( int i ) {
		heap.add( 0 );
		int index = heap.size() - 1;
		while( index > 0 && heap.get( getPLoc(index) ) > i ) {
			heap.set( index,  heap.get( getPLoc(index) ) );
			index = getPLoc(index);
		}
	}
	
	@Override
	
	public String toString() {
		String s = "";
		for ( int i = 0; i < heap.size(); i++ ) {
			s += heap.get( i ) + ", ";
		}
		return s;
	}
	
	public int removeItem() {
		int min = heap.get( 0 );
		int index = heap.size() - 1;
		int last = heap.remove( index );
		
		if ( index > 0 ) {
			
			heap.set( 0,  last );
			int root = heap.get( 0 );
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			
			while( !done ) {
				
				if ( getCLoc( index ) <= end ) {
					
					int child = heap.get( getLCLoc( index ) );
					int childLoc = getLCLoc( index );
					
					if( getRLoc( index ) <= end ) {
						
						if( heap.get( getRCLoc( index ) ) < child ) {
							
							child = heap.get( getRCLoc( index ) );
							childLoc = getRCLoc( index );
							
						}
					}
					
					if ( child < root ) {
						
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
	}
}
