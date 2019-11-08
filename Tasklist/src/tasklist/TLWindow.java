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
		private JTextField month, day, year, hour, minute, task;
		private JLabel left, current, complete, lblLeft, lblCurrent, lblComplete, lblAT, lblPT, lblDate, lblTime, lblTask;

		public Panel() {
			
			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);
			layout.setAutoCreateGaps(true);
			
			lblLeft = new JLabel( "Tasks Left:" );
			left = new JLabel( "12" );
			
			lblCurrent = new JLabel( "Current Task:" );
			current = new JLabel( "Grocery Shopping" );
			
			lblComplete = new JLabel( "Complete By:" );
			complete = new JLabel( "12/20/2019 16:00" );
			
			completed = new JButton( "Completed!" );
			postpone = new JButton( "Postpone" );
			postpone.setVisible(false);
			addTask = new JButton( "Add Task" );
			
			lblAT = new JLabel( "Add Task:" );
			lblPT = new JLabel( "Postpone Task:" );
			lblPT.setVisible(false);
			
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
		
		public void actionPerformed ( ActionEvent a ) {
			if ( a.getSource() == addTask ) {
				addTask.setVisible(false);
				postpone.setVisible(true);
				lblAT.setVisible(false);
				lblPT.setVisible(true);
			}
			
			if ( a.getSource() == postpone ) {
				addTask.setVisible(true);
				postpone.setVisible(false);
				lblAT.setVisible(true);
				lblPT.setVisible(false);
			}
			
			if ( a.getSource() == submit ) {
				
			}
			
			if ( a.getSource() == quit ) {
				dispose();
			}
		}
		
	}
}
