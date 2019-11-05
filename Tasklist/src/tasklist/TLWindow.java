package tasklist;

import java.awt.*;

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
}
