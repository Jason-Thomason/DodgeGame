import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui extends JFrame{
	
	JButton button = new JButton("Transfer");
	JLabel label = new JLabel("Useless Label");
	JList colorselection = new JList();
	JTextField tf = new JTextField(15);
	JTextField df = new JTextField(15);
	
	String[] colornames = {"White","Black", "Cyan", "Red", "Yellow", "Green", "pink"};
	Color[] colors = {Color.white, Color.black, Color.cyan, Color.red, Color.yellow,  Color.green, Color.pink};
	
	public Gui(){
		super("Basic GUI");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setVisible(true);
		
		colorselection.setListData(colornames);
		
		colorselection.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		

		add(button);
		add(label, FlowLayout.LEFT);
		add(tf);
		add(df);
		add(colorselection);
		//colorselection.setLayoutOrientation(JList.VERTICAL_WRAP);
		colorselection.setVisibleRowCount(3);
		add(new JScrollPane(colorselection));
		
		df.setEditable(false);
		
		HandlerClass handler = new HandlerClass();
		tf.addKeyListener(handler);
		tf.addActionListener(handler);
		button.addActionListener(handler);
		colorselection.addListSelectionListener(handler);
		
	}
	
		public class HandlerClass implements KeyListener, ActionListener, ListSelectionListener{

			public void keyPressed(KeyEvent event) {
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void actionPerformed(ActionEvent event) {
				df.setText(tf.getText());
				tf.setText("");
			}

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				getContentPane().setBackground(colors[colorselection.getSelectedIndex()]);
				
			}
			
		}

}
