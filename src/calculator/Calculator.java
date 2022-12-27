package calculator;
import javax.swing.*;

import javax.swing.JFrame;



import java.awt.*;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menubar;
	private JMenu file;
	private JMenuItem close;
	private JMenu edit;
	private JMenu help;
	private JMenuItem copy;
	private JMenuItem view;
	private JMenuItem about;
	private JTextArea display;
	private JButton zero;
	private JButton decimal;
	private JButton posneg;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton clear;
	private JButton equal;
	private JButton plus;
	private JButton moins;
	private JButton multip;
	private JButton div;	
	private double tempfirst=0.0;
	private double tempsecond=0.0;
	private boolean [] op = new boolean[4];
	
	
	public static void main (String[] args){
	try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// ajouter
		JFrame.setDefaultLookAndFeelDecorated(true);// la liste de
		
		
	}catch(Exception e){// fichier
		System.out.println("could not load system look");// exemple ficher-> ..close(espace)
		
	}
	
		new Calculator();
	}
	public  Calculator()
	{
		super("Calculator");
		senddisplay();
		sendMenuBar();
		sendbuttons();
		sendUI(this);
	}
	private void sendMenuBar()
	{
		menubar = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu ("Help");
		close = new JMenuItem("Close");
		copy = new JMenuItem("Copy");
		view = new JMenuItem("View Help");
		about = new JMenuItem("About the calculator");
		setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		close.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
					});
		copy.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String display="";
				StringSelection string = new StringSelection(display);
				Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
				system.setContents(string, string);
				JOptionPane.showMessageDialog(null,"there are currently no help topics to views  ","calculator", JOptionPane.OK_OPTION);
				
				
				
			}
		});
		view.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		about.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String display="";
				StringSelection string = new StringSelection(display);
				Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
				system.setContents(string, string);
				JOptionPane.showMessageDialog(null,"calculator 2015 ","calculator", JOptionPane.OK_OPTION);
				
		
				
			}
		});

		file.add(close);
		edit.add(copy);
		help.add(view);
		help.add(about);
		
	}
	private void senddisplay(){
		display =new JTextArea("0");
		
		display.setBounds(10, 10, 310, 50);
		display.setEditable(false);
		
		add(display);
	}
	private void sendbuttons(){
		equal = new JButton("=");
		equal.setBounds(10,312,66,55);
	
		equal.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if (op[0])
					
					display.setText(Double.toString(getTempfirst() / Double.parseDouble(display.getText())));
				else if (op[1])
					display.setText(Double.toString(getTempfirst() * Double.parseDouble(display.getText())));
				else if (op[2])
					display.setText(Double.toString(getTempfirst() - Double.parseDouble(display.getText())));
				else if (op[3])
					display.setText(Double.toString(getTempfirst() + Double.parseDouble(display.getText())));
				if (display.getText().endsWith(".0")) 
					display.getText().replaceAll(".0"," ");
				setTempfirst(0.0);
				for (int i=0 ; i<=3 ;i++)
					op[i]=false;
			}
			
		});
		add(equal);
		clear = new JButton("CE");
		clear.setBounds(154,312,66,55);
		add(clear);
		clear.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				display.setText("0");
				for (int i=0 ; i<=3 ;i++)
					op[i]=false;
			}
			
		});
		decimal =new JButton(".");
		decimal.setBounds(82, 256, 65, 55);
		add(decimal);
		decimal.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				//if(display.getText().contains("."))
					return;
				//display.append(".");
			}
			
			
		});
		
		posneg =new JButton("+/-");
		posneg.setBounds(154, 256, 65, 55);
		add(posneg);
		posneg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(display.getText().equalsIgnoreCase("0"))
					return;
				display.setText(Double.toString(Double.parseDouble(display.getText())* (-1)));
				if (display.getText().endsWith(".0"))
					display.setText(display.getText().replaceAll(".0", ""));
			}
		});
		plus = new JButton("+");
		plus.setBounds(230, 70, 65, 55);
		add(plus);
		plus.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setTempfirst(Double.parseDouble(display.getText()));
				display.setText("0");
				op[3]=true;
				
			}
			
		});
		moins = new JButton("-");
		moins.setBounds(230, 194, 65, 55);
		add(moins);
		moins.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setTempfirst(Double.parseDouble(display.getText()));
				display.setText("0");
				op[2]=true;
			}
		
		});
		div = new JButton("/");
		div.setBounds(230, 132, 65, 55);
		add(div);
		div.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				setTempfirst(Double.parseDouble(display.getText()));
				display.setText("0");
				op[0]=true;
				System.out.println(getTempfirst());
				
			}
			
		});
		multip = new JButton("*");
		multip.setBounds(230, 256, 65, 55);
		add(multip);
		multip.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setTempfirst(Double.parseDouble(display.getText()));
				display.setText("0");
				op[1]=true;
				
			}
		
		});
		
		
		zero =new JButton("0");
		zero.setBounds(10, 256, 65, 55);
		add(zero);
		zero.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0") || display.getText().length() >10)
				{
					
					return;
				}
				display.append("0");
			}
			
		});
		one =new JButton("1");
		one.setBounds(10, 194, 65, 55);
		add(one);
		one.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("1");
					return;
				}
				display.append("1");
			}
			
		});
		two =new JButton("2");
		two.setBounds(82, 194, 65, 55);
		add(two);
		two.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("2");
					return;
				}
				display.append("2");
			}
			
		});
		three =new JButton("3");
		three.setBounds(154, 194, 65, 55);
		add(three);
		three.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("3");
					return;
				}
				display.append("3");
			}
			
		});
		four =new JButton("4");
		four.setBounds(10, 132, 65, 55);
		add(four);
		four.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("4");
					return;
				}
				display.append("4");
			}
			
		});
		five =new JButton("5");
		five.setBounds(82, 132, 65, 55);
		add(five);
		five.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("5");
					return;
				}
				display.append("5");
			}
			
		});
		six =new JButton("6");
		six.setBounds(154, 132, 65, 55);
		add(six);
		six.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("6");
					return;
				}
				display.append("6");
			}
			
		});
		seven =new JButton("7");
		seven.setBounds(10, 70, 65, 55);
		add(seven);
		seven.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("7");
					return;
				}
				display.append("7");
			}
			
		});
		eight =new JButton("8");
		eight.setBounds(82, 70, 65, 55);
		add(eight);
		eight.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("8");
					return;
				}
				display.append("8");
			}
		});
		nine =new JButton("9");
		nine.setBounds(154, 70, 65, 55);
		add(nine);
		nine.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(display.getText().length()>10)
					return;
				if(display.getText().equalsIgnoreCase("0"))
				{
					display.setText("9");
					return;
				}
				display.append("9");
			}
		});
	}
	
	
	private void sendUI(Calculator app) {
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(350, 450);
		app.setResizable(false);
		app.setLayout(null);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
	}
	public void setTempfirst(double tempfirst) {
		this.tempfirst = tempfirst;
	}
	public double getTempfirst() {
		return tempfirst;
	}
	public void setTempsecond(double tempsecond) {
		this.tempsecond = tempsecond;
	}
	public double getTempsecond() {
		return tempsecond;
	}
	
}
