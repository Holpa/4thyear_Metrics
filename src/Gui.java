import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.Box;

public class Gui {

	private JFrame frmPi;
	private JTextField txtProcessor;
	private JTextField txtMemory;
	private JTextField txtTemprature;
	private JTextField txtData;
	private JTextField txtX;
	private JTextField txtX_1;
	private JTextField txtX_2;
	private JTextField txtX_3;
	private JButton btnNewButton_1;



	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPi = new JFrame();
		frmPi.setTitle("Pi");
		frmPi.setBackground(Color.BLACK);
		frmPi.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frmPi.setSize(273, 235);
		frmPi.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frmPi.getContentPane().add(panel, BorderLayout.NORTH);
		
		txtProcessor = new JTextField();
		txtProcessor.setEditable(false);
		txtProcessor.setText("Processor");
		panel.add(txtProcessor);
		txtProcessor.setColumns(10);
		
		txtX = new JTextField();
		panel.add(txtX);
		txtX.setText("X");
		txtX.setColumns(10);
		
		txtMemory = new JTextField();
		txtMemory.setEditable(false);
		txtMemory.setText("Memory");
		panel.add(txtMemory);
		txtMemory.setColumns(10);
		
		txtX_1 = new JTextField();
		panel.add(txtX_1);
		txtX_1.setText("X2");
		txtX_1.setColumns(10);
		
		txtTemprature = new JTextField();
		txtTemprature.setEditable(false);
		txtTemprature.setText("Temprature");
		panel.add(txtTemprature);
		txtTemprature.setColumns(10);
		
		txtX_2 = new JTextField();
		txtX_2.setEditable(false);
		panel.add(txtX_2);
		txtX_2.setText("X3");
		txtX_2.setColumns(10);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setText("Data");
		panel.add(txtData);
		txtData.setColumns(10);
		
		txtX_3 = new JTextField();
		panel.add(txtX_3);
		txtX_3.setText("X4");
		txtX_3.setColumns(10);
		
		btnNewButton_1 = new JButton("SnapShot");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_1);
	}
	public JFrame getFrame()
	{
		return this.frmPi;
	}
	public void setJtext_2(String s)
	{
		this.txtX_2.setText(s);
	}

}
