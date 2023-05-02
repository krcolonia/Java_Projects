package finalProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class BSIT2_Group1_Final extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSIT2_Group1_Final gui = new BSIT2_Group1_Final();
					gui.setVisible(true);
				}
				catch (Exception e) {
					
				}
			}
		});
	}
	
	// Stack Variables Declaration
	Integer stackSize = 0, pushValue;
	Integer[] stack;
	
	// Color Palette Declaration
	Color spanishViolet = new Color(0x432C7A);
	Color cadmiumViolet = new Color(0x80489C);
	Color bakerMillerPink = new Color(0xFF8FB1);
	Color mistyRose = new Color(0xFCE2DB);
	Color antiFlashWhite = new Color(0xEFF5F5);
	
	// Font Style Declaration
	Font titleFont = new Font("Century Gothic", Font.BOLD, 20);
	Font mainGuiFont = new Font("Century Gothic", Font.PLAIN, 15);
	Font outputFont = new Font("Consolas", Font.BOLD, 18);
	
	// Input Panel Components Declaration
	JPanel menuPanel = new JPanel(); // Panel for Inputs
	JLabel menuPanelLabel = new JLabel("STACK APPLET"); // Label for the Input Panel
	
	JTextField pushInput = new JTextField();
	
	// Output Panel Components Declaration
	Border outputPadding = BorderFactory.createEmptyBorder(8,8,8,8);
	JTextPane outputPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane(outputPane);
	
	// Stack Operation Buttons
	JButton popButton = new JButton("Pop");
	JButton pushButton = new JButton("Push");
	JButton topButton = new JButton("Top");
	JButton sizeButton = new JButton("Set Size");
	
	// Console TextPane
	JTextPane console = new JTextPane();
	
	public BSIT2_Group1_Final() {
		
		sizeFrame();
		
		// Main Frame
		setTitle("2BSIT-2 | Stack Applet by Group 1");
		setSize(360, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(spanishViolet);
		
		// Input Panel
		menuPanel.setBackground(cadmiumViolet);
		menuPanel.setBounds(10, 10, 325, 120);
		menuPanel.setLayout(null);
		add(menuPanel);
		
		menuPanelLabel.setFont(titleFont);
		menuPanelLabel.setForeground(mistyRose);
		menuPanelLabel.setBounds(100, 10, 180, 25);
		menuPanel.add(menuPanelLabel);
		
		pushInput.setBounds(30, 40, 35, 30);
		pushInput.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		menuPanel.add(pushInput);
		
		pushButton.setFont(mainGuiFont);
		pushButton.setBackground(mistyRose);
		pushButton.setBounds(70, 40, 70, 30);
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pushValue = Integer.parseInt(pushInput.getText());
					
					if(stack == null) {
						JOptionPane.showMessageDialog(null, "ERROR: Stack currently has no size.", "ERROR: No Stack Size", JOptionPane.ERROR_MESSAGE);
						console.setText("CONSOLE: Push Operation Unsuccessful");
						return;
					}
					
					StackOperations.push(stack, stackSize, pushValue);
					
					outputPane.setText(StackOperations.display(stack, stackSize));
					
					boolean isFull = StackOperations.full(stack, stackSize);
					
					if(!isFull) {
						console.setText("CONSOLE: Pushed " + pushValue + " into Stack Successfully");
					}
					else {
						console.setText("CONSOLE: Stack is Full");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "ERROR: Data Type Mismatch", JOptionPane.ERROR_MESSAGE);
					console.setText("CONSOLE: Push Operation Unsuccessful");
				}
				
			}
		});
		menuPanel.add(pushButton);
		
		popButton.setFont(mainGuiFont);
		popButton.setBackground(mistyRose);
		popButton.setBounds(145, 40, 70, 30);
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				StackOperations.pop(stack, stackSize);
				
				if(stack == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Stack currently has no size.", "ERROR: No Stack Size", JOptionPane.ERROR_MESSAGE);
					console.setText("CONSOLE: Pop Operation Unsuccessful");
					return;
				}
				
				outputPane.setText(StackOperations.display(stack, stackSize));
				
				boolean isEmpty = StackOperations.empty(stack, stackSize);
				
				if(!isEmpty) {
					console.setText("CONSOLE: Popped Stack Successfully");
				}
				else {
					console.setText("CONSOLE: Stack is Empty");
				}
				
			}
		});
		menuPanel.add(popButton);
		
		topButton.setFont(mainGuiFont);
		topButton.setBackground(mistyRose);
		topButton.setBounds(220, 40, 70, 30);
		topButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(stack == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Stack currently has no size.", "ERROR: No Stack Size", JOptionPane.ERROR_MESSAGE);
					console.setText("CONSOLE: Top Operation Unsuccessful");
					return;
				}
				
				Integer topValue = StackOperations.top(stack, stackSize);
				
				boolean isEmpty = StackOperations.empty(stack, stackSize);
				
				if(!isEmpty) {
					console.setText("CONSOLE: Top Element of Stack is " + topValue);
				}
				else {
					console.setText("CONSOLE: Stack is Empty");
				}
			}
		});
		menuPanel.add(topButton);
		
		sizeButton.setFont(mainGuiFont);
		sizeButton.setBackground(mistyRose);
		sizeButton.setBounds(20, 80, 280, 30);
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
				sizeWindow.setVisible(true);
			}
		});
		menuPanel.add(sizeButton);
		
		stackSizeButton.setBounds(35, 85, 100, 25);
		stackSizeButton.setBackground(mistyRose);
		stackSizeButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		stackSizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stackSize = Integer.parseInt(stackSizeInput.getText());
					stack = new Integer[stackSize];
					
					outputPadding = BorderFactory.createEmptyBorder(8,105,8,8);
					outputFont = new Font("Consolas", Font.BOLD, 30);
					outputPane.setFont(outputFont);
					outputPane.setBorder(outputPadding);
					outputPane.setText(StackOperations.display(stack, stackSize));
					
					console.setText("CONSOLE: Stack with size of " + stackSize + " created");
					
					setVisible(true);				
					sizeWindow.setVisible(false);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "ERROR: Data Type Mismatch", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		sizePanel.add(stackSizeButton);
		
		
		// Output Area
		String titleString = "Data Structures and Algorithms\n"
						   + "Stack Applet\n"
						   + "Programmed by Colonia, David, Pilapil, Ramos and Ubias\n"
						   + "2BSIT-2, A.Y. 2022-2023";
		
		
		
		scrollPane.setBounds(10, 140, 325, 440);
		outputPane.setBackground(antiFlashWhite);
		outputPane.setFont(outputFont);
		outputPane.setBorder(outputPadding);
		outputPane.setText(titleString);
		outputPane.setEditable(false);
		add(scrollPane);
		
		console.setBounds(10, 590, 325, 40);
		console.setBackground(Color.BLACK);
		console.setForeground(Color.WHITE);
		console.setFont(new Font("Consolas", Font.PLAIN, 15));
		console.setEditable(false);
		add(console);
		
	}
	
	// Set Size Window Variables
	
	// Font Variables
	Font sizeFont = new Font("Century Gothic", Font.PLAIN, 20);
	Font sizeTitleFont = new Font("Century Gothic", Font.BOLD, 25);
	
	// Size Set Window Frame
	JFrame sizeWindow = new JFrame();
	
	// Size Set Window Panel and Label
	JPanel sizePanel = new JPanel();
	JLabel sizeLabel = new JLabel("STACK SIZE");
	
	// Size Set Window Variables Declaration
	JLabel stackSizeLabel = new JLabel("Set Size");
	JTextField stackSizeInput = new JTextField();
	JButton stackSizeButton = new JButton("Submit");
	
	public void sizeFrame() {
		sizeWindow.setTitle("Set Stack Size");
		sizeWindow.setUndecorated(true);
		sizeWindow.setSize(190, 140);
		sizeWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		sizeWindow.setLocationRelativeTo(null);
		sizeWindow.getContentPane().setBackground(spanishViolet);
		sizeWindow.setLayout(null);
		
		sizePanel.setBackground(cadmiumViolet);
		sizePanel.setBounds(10, 10, 170, 120);
		sizePanel.setLayout(null);
		sizeWindow.add(sizePanel);
		
		sizeLabel.setBounds(20, 15, 150, 21);
		sizeLabel.setFont(sizeTitleFont);
		sizeLabel.setForeground(mistyRose);
		
		sizePanel.add(sizeLabel);
		
		stackSizeLabel.setFont(sizeFont);
		stackSizeLabel.setForeground(mistyRose);
		stackSizeLabel.setBounds(30, 50, 150, 21);
		sizePanel.add(stackSizeLabel);
		
		stackSizeInput.setBounds(105, 50, 35, 25);
		stackSizeLabel.setBackground(mistyRose);
		stackSizeInput.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		sizePanel.add(stackSizeInput);
	}
}

class StackOperations {
	
	static boolean isEmpty = false, isFull = false;
	
	static void push(Integer[] stack, Integer stackLength, Integer pushVal) {	
		for(int pushElement = 0; pushElement < stackLength; pushElement++) {
			if(stack[pushElement] == null) {
				stack[pushElement] = pushVal;
				break;
			}
			else if(pushElement == stackLength-1) {
				JOptionPane.showMessageDialog(null, "Stack is Full", "Stack Overflow", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
		return;
	}

	static void pop(Integer[] stack, Integer stackLength) {
		for(int popElement = stackLength-1; popElement >= 0; popElement--) {
			if(stack[popElement] != null) {
				stack[popElement] = null;
				break;
			}
			else if(stack[popElement] == null && popElement == 0){
				JOptionPane.showMessageDialog(null, "Stack is Empty", "Stack Underflow", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
		
		return;
	}
	
	static Integer top(Integer[] stack, Integer stackLength) {
		
		Integer topVal = 0;
		
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				topVal = stack[topElement];
				break;
			}
			else {
				topVal=null;
				continue;
			}
		}
		
		return topVal;
	}
	
	static String display(Integer[] stack, Integer stackLength) {
		
		String displayResult = "";
		
		for(int emptyElement = stackLength-1; emptyElement >=0; emptyElement--) {
			if(stack[emptyElement]!=null) {
				isEmpty = false;
			}
			else {
				isEmpty = true;
			}
		}
		
		for(int displayElement = stackLength-1; displayElement >= 0; displayElement--) {
			if(stack[displayElement] != null) {
				displayResult += displayElement + " [ " + stack[displayElement] + " ]\n";
			}
			else {
				displayResult += displayElement + " [   ]\n";
			}
		}
		
		return displayResult;
	}
	
	static boolean empty(Integer[] stack, Integer stackLength) {
		
		for(int emptyElement = stackLength-1; emptyElement >=0; emptyElement--) {
			if(stack[emptyElement]!=null) {
				isEmpty = false;
			}
			else {
				isEmpty = true;
			}
		}
		
		return isEmpty;
	}
	
	static boolean full(Integer[] stack, Integer stackLength) {
		for(int pushElement = 0; pushElement < stackLength; pushElement++) {
			if(stack[pushElement] == null) {
				isFull = false;
			}
			else {
				isFull = true;
			}
		}
		return isFull;
	}
}