package tasklist;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.Date;
import javax.swing.*;

/**
 * Provides a task list so the user can keep track of due dates for
 * tasks they want to get done
 * @author Roman
 */
public class TLWindow extends JFrame {
	
	static Heap tasks = new Heap();
	static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	/**
	 * creates the window and reads in a list of tasks from a file
	 */
	public static void main(String[] args) {
		
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Roman\\CSULB-Projects\\Tasklist\\src\\tasklist\\taskList.txt"));
			String line = new String();
					
			while ( (line = reader.readLine()) != null )
			{
				String[] parts = line.split(",", 2);
				Date tempDate = formatter.parse(parts[1]);
				Task tempTask = new Task(parts[0], tempDate);
				tasks.addItem(tempTask);
			}
			
			reader.close();

		} catch  ( Exception e )
		{
			System.out.println("Error: File not found");
		}
		
		TLWindow w = new TLWindow();
		
	}
	
	/**
	 * constructs the window
	 */
	public TLWindow() {
		
		setBounds( 100, 100, 500, 500);
		setTitle( "Task List" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setContentPane( new Panel() );
		setVisible( true );
		
	}
	
	/**
	 * creates the panel of the window so that items can be added
	 * to the window and used
	 */
	public class Panel extends JPanel implements ActionListener {
		
		private JButton completed, postpone, addTask, submit, quit;
		private JTextField month, day, year, hour, minute, task;
		private JLabel left, current, complete, lblLeft, lblCurrent, lblComplete, lblAT, lblPT, lblDate, lblTime, lblTask;

		/**
		 * constructs the panel with all the GUI items
		 */
		public Panel() {
			
			Task currentTask = (Task) tasks.getCurrent();
			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);
			layout.setAutoCreateGaps(true);
			
			lblLeft = new JLabel( "Tasks Left:" );
			left = new JLabel( String.valueOf(tasks.size()) );
			
			lblCurrent = new JLabel( "Current Task:" );
			current = new JLabel( currentTask.getName() );
			
			lblComplete = new JLabel( "Complete By:" );
			complete = new JLabel( formatter.format(currentTask.getDate()) );
			
			completed = new JButton( "Completed!" );
			completed.addActionListener( this );
			postpone = new JButton( "Postpone" );
			postpone.addActionListener( this );
			postpone.setVisible(false);
			addTask = new JButton( "Add Task" );
			addTask.addActionListener( this );
			
			lblAT = new JLabel( "Add Task:" );
			lblPT = new JLabel( "Postpone Task:" );
			lblAT.setVisible(false);
			
			lblDate = new JLabel ( "Date:" );
			month = new JTextField( "MM" );
			day = new JTextField( "DD" );
			year = new JTextField( "YYYY" );
			
			lblTime = new JLabel( "Time:" );
			hour = new JTextField( "HH" );
			minute = new JTextField( "MM" );
			
			lblTask = new JLabel( "Task:" );
			task = new JTextField( "New Task" );
			lblTask.setVisible(false);
			task.setVisible(false);
			
			submit = new JButton( "Submit" );
			submit.addActionListener( this );
			quit = new JButton( "Quit" );
			quit.addActionListener( this );
			
			layout.setVerticalGroup(
					layout.createSequentialGroup()
					.addComponent(lblLeft)
					.addComponent(left)
					.addComponent(lblCurrent)
					.addComponent(current)
					.addComponent(lblComplete)
					.addComponent(complete)
					.addGroup(layout.createParallelGroup()
							.addComponent(completed)
							.addComponent(postpone)
							.addComponent(addTask))
					.addComponent(lblAT)
					.addComponent(lblPT)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(lblDate)
									.addComponent(month)
									.addComponent(day)
								.addComponent(year))
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(lblTime)
									.addComponent(hour)
									.addComponent(minute))
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(lblTask)
									.addComponent(task))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(submit)
							.addComponent(quit))
					);
			
			layout.setHorizontalGroup(
					layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(lblLeft)
							.addComponent(left)
							.addComponent(lblCurrent)
							.addComponent(current)
							.addComponent(lblComplete)
							.addComponent(complete)
							.addComponent(completed)
							.addComponent(lblAT)
							.addComponent(lblPT)
							.addGroup(layout.createSequentialGroup()
									.addComponent(lblDate)
									.addComponent(month)
									.addComponent(day)
									.addComponent(year))
							.addGroup(layout.createSequentialGroup()
									.addComponent(lblTime)
									.addComponent(hour)
									.addComponent(minute))
							.addGroup(layout.createSequentialGroup()
									.addComponent(lblTask)
									.addComponent(task))
							.addComponent(submit)
							)

					.addGroup(layout.createParallelGroup()
							.addComponent(postpone)
							.addComponent(addTask)
							.addComponent(quit))

					);
		}
		
		/**
		 * makes the buttons and text fields in the panel functional
		 */
		public void actionPerformed ( ActionEvent a ) {
			if ( a.getSource() == completed ) {
				if ( tasks.size() > 0 ) {
					tasks.removeItem();
					if ( tasks.size() > 0 ) {
						Task currentTask = (Task) tasks.getCurrent();
						
						left.setText(String.valueOf(tasks.size()));
						current.setText( currentTask.getName() );
						complete.setText( formatter.format(currentTask.getDate()) );
					}
					else {
						left.setText("0");
						current.setText("none");
						complete.setText("---");
					}
				}

			}
			
			if ( a.getSource() == addTask ) {
				addTask.setVisible(false);
				postpone.setVisible(true);
				lblPT.setVisible(false);
				lblAT.setVisible(true);
				lblTask.setVisible(true);
				task.setVisible(true);
			}
			
			if ( a.getSource() == postpone ) {
				addTask.setVisible(true);
				postpone.setVisible(false);
				lblPT.setVisible(true);
				lblAT.setVisible(false);
				lblTask.setVisible(false);
				task.setVisible(false);
			}
						
			if ( a.getSource() == submit ) {
				if ( postpone.isVisible() ) {

					String date = (month.getText() + "/" + day.getText() + "/" + year.getText() +
							" " + hour.getText() + ":" + minute.getText() );
					String taskName = task.getText();
					try {
						Date newDate = formatter.parse(date);
						
						Task newTask = new Task(taskName, newDate);
						
						tasks.addItem(newTask);
						
					} catch ( ParseException e ) {
						System.out.println("not a valid due date");
					}
					
					month.setText("MM");
					year.setText("YYYY");
					day.setText("DD");
					hour.setText("HH");
					minute.setText("mm");
					task.setText("New Task");
				
				}
				else {
					System.out.println("hello");

					if ( tasks.size() > 0 ) {
						String date = (month.getText() + "/" + day.getText() + "/" + year.getText() +
								" " + hour.getText() + ":" + minute.getText() );
						Task currentTask = (Task) tasks.getCurrent();
						try {
							Date newDate = formatter.parse(date);
							
							Task newTask = new Task(currentTask.getName(), newDate);
								
								tasks.addItem(newTask);
								tasks.removeItem();
								
								currentTask = (Task) tasks.getCurrent();

								current.setText( currentTask.getName() );
								complete.setText( formatter.format(currentTask.getDate()) );

						} catch ( ParseException e ) {
							System.out.println("not a valid due date");
						}
					}
		
				}
			}
			
			if ( a.getSource() == quit ) {
				
				try 
				{
					FileWriter writer = new FileWriter("C:\\Users\\Roman\\CSULB-Projects\\Tasklist\\src\\tasklist\\newtaskList.txt");
					while ( tasks.size() > 0 ) {
						Task currentTask = (Task) tasks.getCurrent();
						writer.write(currentTask.getName() + "," + formatter.format(currentTask.getDate()) + "\n");
						tasks.removeItem();
					}
					
					writer.close();
				} catch ( IOException e ) 
				{
					e.printStackTrace();
				}
				
				dispose();
			}
			
		}
		
	}
}
