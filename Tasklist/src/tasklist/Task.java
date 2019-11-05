package tasklist;

public class Task implements Comparable{

	private String taskName;
	private int dueDate;
	
	public Task(String n, int d) {
		taskName = n;
		dueDate = d;
	}
	
	public int compareTo( Object o ) {
		
		Task t = (Task) o;
		
		if ( dueDate > t.dueDate ) {
			return 1;
		}
		else if ( dueDate < t.dueDate ) {
			return -1;
		}
		else {
			
			if ( taskName.compareTo( t.taskName ) > 0 ) {
				return 1;
			}
			else if ( taskName.compareTo( t.taskName ) < 0 ) {
				return -1;
			}
			
			else {
				return 0;
			}		
			
		}	
		
	}
	
}
