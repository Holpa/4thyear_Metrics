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
	private JButton btnTest;
	private JButton btnTest_1;
	private JButton btnDiscoverResourceBy;
	private JButton btnCreateDiscriptorContainer;
	private JButton btnCreateADescriotion;
	private JButton btnCreateAData;
	private JButton btnCreateAData_1;
	private JButton btnSubscribe;



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
		frmPi.setTitle("Metrics");
		frmPi.setBackground(Color.BLACK);
		frmPi.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frmPi.setSize(500, 337);
		frmPi.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frmPi.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		txtProcessor = new JTextField();
		txtProcessor.setEditable(false);
		txtProcessor.setText("Processor");
		panel.add(txtProcessor);
		txtProcessor.setColumns(10);

		txtX = new JTextField();
		txtX.setEditable(false);
		panel.add(txtX);
		txtX.setText("X");
		txtX.setColumns(10);

		txtMemory = new JTextField();
		txtMemory.setEditable(false);
		txtMemory.setText("Memory");
		panel.add(txtMemory);
		txtMemory.setColumns(10);

		txtX_1 = new JTextField();
		txtX_1.setEditable(false);
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
		txtX_3.setEditable(false);
		panel.add(txtX_3);
		txtX_3.setText("X4");
		txtX_3.setColumns(10);

		btnTest = new JButton("Retrieve a resource");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HTTPrequestManager http = new HTTPrequestManager();
				System.out.println("Testing  - Send Http GET request");
				try {
					http.retrieveResource();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
				
						btnTest_1 = new JButton("Create a sensor");
						btnTest_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								HTTPrequestManager http = new HTTPrequestManager();
								System.out.println("Testing  - Send Http POST request");
								try {
									http.createSensor();
								} catch (Exception f) {
									// TODO Auto-generated catch block
									f.printStackTrace();
								}
							}
						});
						panel.add(btnTest_1);
				
						btnNewButton_1 = new JButton("SnapShot");
						btnNewButton_1.setEnabled(false);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							}
						});
						panel.add(btnNewButton_1);
				
						btnCreateAData = new JButton("Create a Data Container");
						btnCreateAData.setEnabled(false);
						panel.add(btnCreateAData);
		
				btnSubscribe = new JButton("Subscribe ");
				btnSubscribe.setEnabled(false);
				panel.add(btnSubscribe);
		
				btnCreateDiscriptorContainer = new JButton("Create Discriptor Container");
				btnCreateDiscriptorContainer.setEnabled(false);
				panel.add(btnCreateDiscriptorContainer);
		panel.add(btnTest);

		btnDiscoverResourceBy = new JButton("Discover Resource by label");
		btnDiscoverResourceBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HTTPrequestManager http = new HTTPrequestManager();
				System.out.println("Testing  - Send Http GET request");
				try {
					http.discoverResourcesBasedOnLabel();
				} catch (Exception f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}

			}
		});
		
				btnCreateAData_1 = new JButton("Create a data contentInstance");
				btnCreateAData_1.setEnabled(false);
				panel.add(btnCreateAData_1);
		panel.add(btnDiscoverResourceBy);
				
						btnCreateADescriotion = new JButton("Create description contentInstance");
						btnCreateADescriotion.setEnabled(false);
						btnCreateADescriotion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						panel.add(btnCreateADescriotion);
	}
	public JFrame getFrame()
	{
		return this.frmPi;
	}
	public void setJtext(String s) {
		// TODO Auto-generated method stub
		this.txtX.setText(s);
	}

	public void setJtext_2(String s)
	{
		this.txtX_1.setText(s);
	}

	public void setJtext_3(String s) {
		// TODO Auto-generated method stub
		this.txtX_2.setText(s);
	}

	public void setJtext_4(String s) {
		// TODO Auto-generated method stub
		this.txtX_3.setText(s);
	}

}
