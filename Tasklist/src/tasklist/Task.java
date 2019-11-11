package tasklist;

import java.util.Date;

/**
 * Task Class - creates an object made up of a name and due
 * date for each task
 * @author Roman
 *
 */
public class Task implements Comparable<Task>{
	
	/** The name of the current task
	 */
	private String taskName;
	
	/** The date of the current task
	 */
	private Date dueDate;
	
	/** Constructor - sets an initial name and date
	 * for the task 
	 * @param n sets the name of the task
	 * @param d sets the date of the task
	 */
	public Task(String n, Date d) {
		taskName = n;
		dueDate = d;
	}
	
	/** Retrieve the name of the task
	 * @return the name of the task
	 */
	public String getName() {
		return taskName;
	}
	
	/** Retrieve the date of the task
	 * @return the date of the task
	 */
	public Date getDate() {
		return dueDate;
	}
	
	/** compares two tasks
	 * @return 1 if the dueDate of the first task is before the second,
	 * -1 if the dueDate of the first task is after the seconds,
	 * or if the dueDates are the same it will compare the alphabetical
	 * order of the names of the tasks
	 */
	public int compareTo( Task t ) {
		
		if ( dueDate.compareTo(t.dueDate) != 0 ) {
			return dueDate.compareTo(t.dueDate);
		}
		else {
			return taskName.compareTo(t.taskName);
		}
	

		
	}
	
}
