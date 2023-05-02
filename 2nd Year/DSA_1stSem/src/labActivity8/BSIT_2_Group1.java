package labActivity8;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class BSIT_2_Group1 extends JFrame {
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					BSIT_2_Group1 gui = new BSIT_2_Group1();
					gui.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	// Array Variables Declarations
	Integer arrSize; // Array Size
	String[] strArray; // String Array, temporary holder of split "elements" input
	Integer[] intArray; // int Array

	// Font Styles used in GUI Declarations
	Font guiFont = new Font("Consolas", Font.PLAIN, 14);
	Font titleFont = new Font("Century Gothic", Font.BOLD, 25);
	
	// Colors used in GUI Declarations
	Color crayolaOuterSpace = new Color(0x2C3639);
	Color outerSpace = new Color(0x3F4E4F);
	Color antiFlashWhite = new Color(0xEFF5F5);
	Color boneWhite = new Color(0xDCD7C9);
	
	// Input Panel Components Declarations
	JPanel inputPanel = new JPanel(); // InputPanel
	JLabel inputPanelLabel = new JLabel("ARRAY INPUT"); // Array Size Label
	JLabel arrSizeLabel = new JLabel("Enter Array Size"); // Array Size Label
	JTextField arrSizeInput = new JTextField(); // Array Size Text Field
	JLabel arrElementsLabel = new JLabel("Enter Array Elements"); // Array Elements Label
	JTextField arrElementsInput = new JTextField(); // Array Elements Text Field
	
	// Output Area Components Declarations
	Border outputPadding = BorderFactory.createEmptyBorder(8,8,8,8); // Output Padding
	JTextPane output = new JTextPane(); // Output TextPane
	JScrollPane scroll = new JScrollPane(output); // ScrollPane for Output TextPane
	
	// Sorting Menu Components Declarations
	JPanel menuPanel = new JPanel(); // Menu Panel
	JLabel menuPanelLabel = new JLabel("SORTING OPTIONS"); // Menu Panel Label
	JButton bubbleSortBtn = new JButton("Bubble Sort"); // Bubble Sort Button
	JButton insertionSortBtn = new JButton("Insertion Sort"); // Insertion Sort Button
	JButton selectionSortBtn = new JButton("Selection Sort"); // Selection Sort Button
	JButton mergeSortBtn = new JButton("Merge Sort"); // Merge Sort Button
	JButton quickSortBtn = new JButton("Quick Sort"); // Quick Sort Button
	JButton heapSortBtn = new JButton("Heap Sort"); // Heap Sort Button
	
	// Exit Frame Components Declartions
	JButton exitBtn = new JButton("Exit"); // Exit Program Button
	
	// GUI Constructor Method. Coded by Colonia, Kurt Robin
	public BSIT_2_Group1() {
		
		// Frame Main Code
		setTitle("2BSIT-2 | Sorting Program By Colonia, David, Pilapil, Ramos, Ubias");
		setSize(650, 650);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null); // Sets frame position to center of screen upon launch
		getContentPane().setBackground(crayolaOuterSpace);
	
		/*-----------------------------------------------------------------------------*/
	
		// Input Panel
		inputPanel.setBackground(outerSpace);
		inputPanel.setBounds(10, 10, 220, 170);
		inputPanel.setLayout(null);
		
		add(inputPanel);
		setLayout(null);
		
		// Array Size Label
		inputPanelLabel.setFont(titleFont);
		inputPanelLabel.setForeground(antiFlashWhite);
		inputPanelLabel.setBounds(33, 25, 160, 25);
		inputPanel.add(inputPanelLabel);

		// Array Size Label
		arrSizeLabel.setFont(guiFont);
		arrSizeLabel.setForeground(antiFlashWhite);
		arrSizeLabel.setBounds(25, 60, 150, 20);
		inputPanel.add(arrSizeLabel);
		
		// Array Size Text Field
		arrSizeInput.setBounds(160, 57, 35, 20);
		arrSizeInput.setBackground(antiFlashWhite);
		inputPanel.add(arrSizeInput);
		
		// Array Elements Label
		arrElementsLabel.setFont(guiFont);
		arrElementsLabel.setForeground(antiFlashWhite);
		arrElementsLabel.setVerticalAlignment(JLabel.CENTER);
		arrElementsLabel.setBounds(25, 90, 200, 20);
		inputPanel.add(arrElementsLabel);
		
		// Array Elements Text Field
		arrElementsInput.setBounds(25, 115, 170, 20);
		arrElementsInput.setBackground(antiFlashWhite);
		inputPanel.add(arrElementsInput);
		
		/*----------------------------------------------------------------*/
		
		// Output Area
		
		String titleString = "Data Structures and Algorithms"
				+ "\nSorting Program\n"
				+ "\nProgrammed by Colonia, David, Pilapil, Ramos, and Ubias\n" 
				+ "\n2BSIT-2, A.Y. 2022-2023";
		
		scroll.setBounds(240, 10, 385, 590);
		
		output.setBackground(antiFlashWhite);
		output.setFont(new Font("Consolas", Font.BOLD, 20));
		output.setBorder(outputPadding);
		output.setText(titleString);
		output.setEditable(false);
		add(scroll);
		
		/*----------------------------------------------------------------*/
		
		// Menu Panel
		menuPanel.setBackground(outerSpace);
		menuPanel.setBounds(10, 192, 220, 410);
		menuPanel.setLayout(null);
		
		add(menuPanel);
		
		// Menu Panel Label
		menuPanelLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		menuPanelLabel.setForeground(antiFlashWhite);
		menuPanelLabel.setBounds(23, 15, 180, 25);
		menuPanel.add(menuPanelLabel);
		
		// Bubble Sort Button
		bubbleSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		bubbleSortBtn.setBackground(boneWhite);
		bubbleSortBtn.setBounds(35, 50, 150, 35);
		menuPanel.add(bubbleSortBtn);
		bubbleSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
					
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
					
					JOptionPane.showMessageDialog(null, "Sorting Array using Bubble Sort", "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.bubbleSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "ERROR: Data Type Mismatch", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		// Insertion Sort Button
		insertionSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		insertionSortBtn.setBackground(boneWhite);
		insertionSortBtn.setBounds(35, 100, 150, 35);
		menuPanel.add(insertionSortBtn);
		insertionSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
							
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
							
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
							
					JOptionPane.showMessageDialog(null, "Sorting Array using Insertion Sort", "Insertion Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.insertionSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "Error!", JOptionPane.ERROR_MESSAGE);
					}
						
						
				}
			});
		
		// Selection Sort Button
		selectionSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		selectionSortBtn.setBackground(boneWhite);
		selectionSortBtn.setBounds(35, 150, 150, 35);
		menuPanel.add(selectionSortBtn);
		selectionSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
							
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
							
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
							
					JOptionPane.showMessageDialog(null, "Sorting Array using Selection Sort", "Selection Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.selectionSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "Error!", JOptionPane.ERROR_MESSAGE);
					}
								
								
				}
		});
		
		// Merge Sort Button
		mergeSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		mergeSortBtn.setBackground(boneWhite);
		mergeSortBtn.setBounds(35, 200, 150, 35);
		menuPanel.add(mergeSortBtn);
		mergeSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
							
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
							
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
							
					JOptionPane.showMessageDialog(null, "Sorting Array using Merge Sort", "Merge Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.mergeSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "Error!", JOptionPane.ERROR_MESSAGE);
					}
								
								
				}
		});
		
		// Quick Sort Button
		quickSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		quickSortBtn.setBackground(boneWhite);
		quickSortBtn.setBounds(35, 250, 150, 35);
		menuPanel.add(quickSortBtn);
		quickSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
							
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
							
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
							
					JOptionPane.showMessageDialog(null, "Sorting Array using Quick Sort", "Quick Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.quickSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "Error!", JOptionPane.ERROR_MESSAGE);
					}
								
								
				}
		});

		// Heap Sort Button
		heapSortBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		heapSortBtn.setBackground(boneWhite);
		heapSortBtn.setBounds(35, 300, 150, 35);
		menuPanel.add(heapSortBtn);
		heapSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrSize = Integer.parseInt(arrSizeInput.getText());
					
					strArray = arrElementsInput.getText().split(" ");
					intArray = new Integer[arrSize];
							
					if(strArray.length > arrSize || strArray.length < arrSize) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input the proper amount of elements", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
							
					for(int i = 0; i < arrSize; i++) {
						intArray[i] = Integer.parseInt(strArray[i]);
					}
							
					JOptionPane.showMessageDialog(null, "Sorting Array using Heap Sort", "Heap Sort", JOptionPane.INFORMATION_MESSAGE);
					
					SortingTechniques.heapSort(intArray, arrSize);
					
					output.setText(SortingTechniques.outputString);
					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR: Please only input Integer values", "Error!", JOptionPane.ERROR_MESSAGE);
					}
								
								
				}
		});
		
		// Exit Sort Button
		exitBtn.setFont(new Font("Consolas", Font.BOLD, 13));
		exitBtn.setBackground(boneWhite);
		exitBtn.setBounds(35, 350, 150, 35);
		menuPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				exitFrame();
			}
		});
	}
	
	public void exitFrame() {
		
		JFrame exitWindow = new JFrame();
		
		exitWindow.setTitle("Exiting Program...");
		exitWindow.setSize(500,240);
		exitWindow.setResizable(false);
		exitWindow.setUndecorated(true);
		exitWindow.setLocationRelativeTo(null); // Sets frame position to center of screen upon launch
		exitWindow.getContentPane().setBackground(crayolaOuterSpace);
		exitWindow.setLayout(null);
		exitWindow.setVisible(true);
		
		JPanel exitPanel = new JPanel();
		
		exitPanel.setBounds(10,10,480,220);
		exitPanel.setBackground(outerSpace);
		exitPanel.setLayout(null);
		exitWindow.add(exitPanel);
		
		JLabel exitTitle = new JLabel();
		
		exitTitle.setText("Exiting Program");
		exitTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
		exitTitle.setForeground(antiFlashWhite);
		exitTitle.setBounds(130, 40, 500, 35);
		exitPanel.add(exitTitle);
		
		JLabel exitCredits = new JLabel();
		
		exitCredits.setText("Coded By Colonia, David, Pilapil, Ramos, Ubias");
		exitCredits.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		exitCredits.setForeground(antiFlashWhite);
		exitCredits.setBounds(25, 110, 500, 20);
		exitPanel.add(exitCredits);
		
		JLabel exitSection = new JLabel();
		
		exitSection.setText("2BSIT-2, A.Y. 2022-2023");
		exitSection.setFont(new Font("Century Gothic", Font.ITALIC, 12));
		exitSection.setForeground(antiFlashWhite);
		exitSection.setBounds(175, 160, 500, 20);
		exitPanel.add(exitSection);
		
		Timer t = new Timer(4000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		
		t.start();
		
	}
}

class SortingTechniques {
	
	// Array Sort Checker Method. Coded by
	static boolean checkSorted(Integer[] A, Integer size) {
		for(int i = 0; i<size-1; i++) {
			if(A[i] > A[i+1])
				return false;
		}
		return true;
	}
	
	// Array Display Method. Coded by Ubias, John Louie
	static void displayArray(Integer[] A) {
		int size = A.length;
		for (int i = 0; i < size; ++i)
			outputString += A[i]+ " ";
		outputString += "\n";
	}
	
	// Array Reverser, used in Quick Sort.
	static Integer[] reverseArray(Integer[] A, Integer size) {
		
		Integer revA[] = new Integer[size];
		int i = 0;
		int j = size-1;
		
		while(i < size) {
			revA[i] = A[j];
			i++;
			j--;
		}
		
		return revA;
	}
	
	// Reverse Array Display Method, used in Quick Sort.
	static void reverseDisplayArray(Integer A[]){
        int size = A.length;
        for(int i=size-1; i>-1; i--)
            outputString += A[i]+" ";
        outputString += "\n";
    }
	
	static String outputString = "";
	static int swap=0;
	
	// Bubble Sort Method. Coded by Colonia, Kurt Robin
	static void bubbleSort(Integer[] A, Integer size) {
		
		outputString = "BUBBLE SORT\n\n";
		
		for(int i=0; i<size-1; i++) {
			
			outputString += "Pass No. " + (i+1) + "\n";
			
			for(int j=0; j<size-1;j++) {
				
				displayArray(A);
				
				if(A[j] > A[j+1]) {
					swap = A[j];
					A[j] = A[j+1];
					A[j+1]=swap;
				}
				checkSorted(A, size);
			}
			
			displayArray(A);
			
			outputString += "\n";
			
		}
		
		outputString += "Final Result\n";
		displayArray(A);
		System.out.print(outputString);
		
	}
	
	// Insertion Sort Method. Coded by Ubias, John Louie
	static void insertionSort(Integer[] A, Integer size) {    
		
		outputString = "INSERTION SORT\n\n";
		
		for (int j = 1; j < size; j++) {  
				
				outputString += "Pass No." + (j) + "\n";
			
        		swap = A[j];  
        		int i = j - 1;        
        		
        		displayArray(A);
        
        		outputString += "\n";
        		
        		while ((i > - 1) && (A[i] > swap)) {  
        				A[i + 1] = A[i];  
        				i--;  
        		}  
        		
        		A[i + 1] = swap;   
        		
        		if(checkSorted(A, size)) {
        			outputString += "Final Result\n";
    				break;
    			}
        		
    		}  
		
		displayArray(A);
		System.out.println(outputString);
		
	}
	
	// Selection Sort Method. Coded by Pilapil, Miguel
	static void selectionSort(Integer A[], Integer size) {

		outputString = "SELECTION SORT\n\n";
		
        for (int i = 0; i < size-1; i++) {
        	
            int min = i;
            
            outputString += "Pass No." + (i+1) + "\n";
            
            displayArray(A);
            
            outputString+="\n";
            
            for (int j = i+1; j < size; j++)
                if (A[j] < A[min])
                    min = j;
            
            swap = A[min];
            A[min] = A[i];
            A[i] = swap;
            
        }
        
        outputString += "Final Result\n";
        
        displayArray(A);
        System.out.println(outputString);
    }
	
	// Merge Sort Method. Coded by Ramos, Dominic
	
	static Integer passNum;
	
	static void mergeSort(Integer[] A, Integer size) {
		
		passNum=0;
		
		outputString = "MERGE SORT\n\n";
		
		displayArray(A);
		
		mgSort(A, 0, size-1);
		
		outputString += "\nFinal Result\n";
		displayArray(A);
		System.out.println(outputString);
		
	}
	
	static void mgSort(Integer[] A, Integer p, Integer r)
    {
        if (p < r) {
            
            int q = (p + r)/2;
            
            mgSort(A, p, q);
            mgSort(A, q + 1, r);
            
            mgMerge(A, p, q, r);
            
        }
    }
	
	static void mgMerge(Integer[] A, Integer p, Integer q, Integer r)
    {
		
		passNum++;
		outputString += "\nPass No." + passNum + "\n";
		
        Integer size1 = q - p + 1;
        Integer size2 = r - q;

        int L[] = new int[size1];
        int R[] = new int[size2];

        for (int i = 0; i < size1; ++i) {
            L[i] = A[p + i];
            outputString += L[i] + " ";
        }
        for (int j = 0; j < size2; ++j) {
            R[j] = A[q + 1 + j];
            outputString += R[j] + " ";
        }
        outputString += "\n";

        int i, j, k;
        
        i = 0;
        j = 0;
        k = p;
        
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < size1) {
            A[k] = L[i];
            i++;
            k++;
        }
        
        while (j < size2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
	
	// Quick Sort Method. Coded by David, Rotsen
	static void quickSort(Integer[] A, Integer size) {
		
		passNum = 0;
		
		outputString = "QUICK SORT\n\n";
        
        A = reverseArray(A, size);
        
        reverseDisplayArray(A);
        
        qk_Sort(A, 0, size-1);
        
        outputString += "\nFinal Result\n";
        reverseDisplayArray(A);
        System.out.println(outputString);
        
	}
	
	static void qk_Sort(Integer[] A, Integer low, Integer high)
    {
        if (low < high) {
  
            int pi = qkPartition(A, low, high);
            
            qk_Sort(A, low, pi - 1);
            qk_Sort(A, pi + 1, high);
            
        }
    }
	
	static int qkPartition(Integer[] A, Integer low, Integer high)
    {
		passNum++;
		outputString += "\nPass No. " + passNum + "\n";
		
        int pivot = A[high];
  
        
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            if (A[j] > pivot) {
  
                i++;
                
                swap = A[i];
                A[i] = A[j];
                A[j] = swap;
            }
        }
        reverseDisplayArray(A);
        
        passNum++;
        outputString += "\nPass No. " + passNum + "\n";
        
        swap = A[i+1];
        A[i+1] = A[high];
        A[high] = swap;
        
        reverseDisplayArray(A);
        
        return (i + 1);
    }
	
	// Heap Sort Method. Coded by Ramos, Dominic
	static void heapSort(Integer A[], Integer size) {
	  
		passNum = 0;
		
		outputString = "HEAP SORT\n\n";
	 
		passNum++;
	    outputString += "Pass No. " + passNum + "\n";
		
	      for (int i = size / 2 - 1; i >= 0; i--) {
	        heapify(A, size, i);
	        //displayArray(A);
	      }
	      
	      outputString += "\n";
	    
	      for (int i = size - 1; i >= 0; i--) {
	    	  
	    	passNum++;
			outputString += "Pass No. " + passNum + "\n";
			
	        int temp = A[0];
	        A[0] = A[i];
	        A[i] = temp;
	 
	        heapify(A, i, 0);
	        
	        outputString += "\n";
	      }
	      
	      outputString += "Final Result\n";
	      displayArray(A);
	      System.out.println(outputString);
	}
	  
	static void heapify(Integer A[], Integer n, Integer i) {
	 
		displayArray(A);
		
	      int largest = i;
	      int l = 2 * i + 1;
	      int r = 2 * i + 2;
	  
	      if (l < n && A[l] > A[largest]) {
	        largest = l;
	      }
	  
	      if (r < n && A[r] > A[largest])
	        largest = r;
	  
	     
	      if (largest != i) {
	        int swap = A[i];
	        A[i] = A[largest];
	        A[largest] = swap;
	  
	        heapify(A, n, largest);
	        
	      }
	}
	
}