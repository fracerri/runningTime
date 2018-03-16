package views;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainView extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5204337033480381547L;
	JButton runButton;
	JTextField IN1, OUT1, IN2, OUT2;

      public void createMainView() {    
      JFrame frame = new JFrame();
      frame.setTitle("TimeToGo");
      ImageIcon imgIcon = Utils.createImageIcon(MainView.class,"img/run.png");
      frame.setIconImage(imgIcon.getImage());
      frame.setSize(200,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      //Inputs
      IN1 = new JTextField(15);
      IN1.addActionListener(this);
      IN1.requestFocus(); 
      IN1.setSize(100,100);
      JLabel labelProp = new JLabel("IN 1:");
	  labelProp.setLabelFor(IN1);
      
      OUT1 = new JTextField(15);
      OUT1.addActionListener(this);
      OUT1.requestFocus(); 
      OUT1.setSize(100,100);
      JLabel labelPropOUT1 = new JLabel("OUT 1:");
      labelPropOUT1.setLabelFor(OUT1);
      
      IN2 = new JTextField(15);
      IN2.addActionListener(this);
      IN2.requestFocus(); 
      IN2.setSize(100,100);
      JLabel labelPropIN2 = new JLabel("IN 2:");
	  labelPropIN2.setLabelFor(IN2);
      
      OUT2 = new JTextField(15);
      OUT2.addActionListener(this);
      OUT2.requestFocus(); 
      OUT2.setSize(100,100);
      OUT2.disable();
      JLabel labelPropOUT2 = new JLabel("OUT 2:");
      labelPropOUT2.setLabelFor(OUT2);
      
      
      JPanel inputPanles = new JPanel();
      inputPanles.add(labelProp);
      inputPanles.add(IN1);
      inputPanles.add(labelPropIN2);
      inputPanles.add(IN2);
      
      JPanel inputPanles2 = new JPanel();
      inputPanles2.add(labelPropOUT1);
      inputPanles2.add(OUT1);
      inputPanles2.add(labelPropOUT2);
      inputPanles2.add(OUT2);
      
      runButton = new JButton("Calculate", Utils.createImageIcon(MainView.class,"img/clock.png"));
      runButton.addActionListener(this);
      runButton.setSize(50, 20);
      
      //For layout purposes, put the buttons in a separate panel
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(runButton);
    
      
      //Add the buttons and the log to this panel.
      frame.add(inputPanles, BorderLayout.PAGE_START);
      frame.add(inputPanles2, BorderLayout.CENTER);
      frame.add(buttonPanel, BorderLayout.PAGE_END);
      
      frame.pack();
      frame.setVisible(true);
      }
      
      public void actionPerformed(ActionEvent e) {
    	  if (e.getSource() == runButton) {}
    	  		String result = "";
				try {
					result = Utils.calculate(IN1.getText(), OUT1.getText(),IN2.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
    	  		OUT2.setText(result);
          }
}