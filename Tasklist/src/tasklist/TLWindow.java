package tasklist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TLWindow extends JFrame {

	public static void main(String[] args) {
		
		TLWindow w = new TLWindow();
		
	}
	
	public TLWindow() {
		
		setBounds( 100, 100, 500, 500);
		setTitle( "Task List" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setContentPane( new Panel() );
		setVisible( true );
		
	}
	
	public class Panel extends JPanel implements ActionListener {
		
		private JButton completed, postpone, addTask, submit, quit;
		private JTextField left, current, complete, month, day, year, hour, minute, task;
		private JLabel lblLeft, lblCurrent, lblComplete, lblAT, lblPT, lblDate, lblTime, lblTask;
		private boolean panel1 = true;

		public Panel() {
			
			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			
			lblLeft = new JLabel( "Tasks Left:" );
			left = new JTextField( "12" );
			
			lblCurrent = new JLabel( "Current Task:" );
			current = new JTextField( "Grocery Shopping" );
			
			lblComplete = new JLabel( "Complete By:" );
			complete = new JTextField( "12/20/2019 16:00" );
			
			completed = new JButton( "Completed!" );
			postpone = new JButton( "Postpone" );
			addTask = new JButton( "Add Task" );
			
			lblAT = new JLabel( "Add Task:" );
			lblPT = new JLabel( "Postpone Task:" );
			
			lblDate = new JLabel ( "Date:" );
			month = new JTextField( "MM" );
			day = new JTextField( "DD" );
			year = new JTextField( "YYYY" );
			
			lblTime = new JLabel( "Time:" );
			hour = new JTextField( "HH" );
			minute = new JTextField( "MM" );
			
			lblTask = new JLabel( "Task:" );
			task = new JTextField( "New Task" );
			
			submit = new JButton( "Submit" );
			quit = new JButton( "Quit" );
			
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
							.addComponent(postpone))
					.addComponent(lblAT)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(lblDate)
							.addComponent(month)
							.addComponent(day)
							.addComponent(year))
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
							.addComponent(completed))
						.addComponent(postpone)
					.addGroup(layout.createParallelGroup()
							.addComponent(lblAT)
							.addComponent(lblDate))
					.addComponent(month)
					.addComponent(day)
					.addComponent(year)
					);
		}
		
		public void actionPerformed ( ActionEvent a ) {
			
		}
		
	}
}
