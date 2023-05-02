package fileHandlePackage;

import java.util.Scanner;
import java.io.*;

public class OutputFile {
	
	// Variables for OutputFile
	static Scanner fileInput, txtToConsole;
	static File fileOBJ;
	static PrintWriter printOBJ;
	static BufferedReader txtReader;
	static BufferedWriter appendOBJ;
	static FileWriter fileToAppend;
	static String words, data;
	static int wordCount=0, lines=0;
	
	
	public static void main(String[] args){
		
		try {
			fileOBJ = new File("../2ndSem_Finals_FileHandling/src/fileHandlePackage/SampleText.txt");
			fileInput = new Scanner(new FileReader("../2ndSem_Finals_FileHandling/src/fileHandlePackage/SampleText.txt"));
			printOBJ = new PrintWriter("../2ndSem_Finals_FileHandling/src/fileHandlePackage/SampleOutputText.txt");
			
			appendFile();
			filePrint();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}
		finally {
			fileInput.close();
			printOBJ.close();
		}
	}
	
	public static void wordChecker() {
		// While loop that checks for number of words
		while(fileInput.hasNext()) {
			words = fileInput.nextLine();
			
			String numberOfWords[] =  words.split(" ");
			
			wordCount = wordCount + numberOfWords.length;
		}
	}
	
	public static void filePrint() throws FileNotFoundException {
		try {
			txtToConsole = new Scanner(new File("src/fileHandlePackage/SampleText.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}
		while(txtToConsole.hasNextLine()) {
			System.out.println(txtToConsole.nextLine());
		}
		System.out.println();
		
		wordChecker(); // Calls the method that checks number of word in SampleText.txt
		
		// Prints to SampleOutputText.txt
		printOBJ.println("File Size: " + fileOBJ.length() + " bytes");
		printOBJ.println("Absolute Path: " + fileOBJ.getAbsolutePath());
		printOBJ.println("Number of Words: " + wordCount);
		
		// Prints to Console
		System.out.println("File Size: " + fileOBJ.length() + " bytes");
		System.out.println("Absolute Path: " + fileOBJ.getAbsolutePath());
		System.out.println("Number of Words: " + wordCount);
	}
	
	public static void appendFile() {
		
		// String of text to be appended to SampleText.txt
		data = "\nThis little light of mine, I'm gonna let it shine";
		
		try {
			txtReader = new BufferedReader(new FileReader("../2ndSem_Finals_FileHandling/src/fileHandlePackage/SampleText.txt"));
			fileToAppend = new FileWriter("../2ndSem_Finals_FileHandling/src/fileHandlePackage/SampleText.txt",true);
			appendOBJ = new BufferedWriter(fileToAppend);
			
			// Checks the number of lines in SampleText.txt
			while(txtReader.readLine() != null) {
				lines++;
			}
			
			if(lines<2) {
				appendOBJ.append(data);
			}
			
			appendOBJ.close();
			
		}
		catch(IOException ex) {
			System.out.println("Data Append Unsuccessful");
		}
		
	}
	
	/* Program coded by Kurt Robin Colonia
	 * from 1-BSIT-2
	 * 2nd Semester Finals Activity
	 * File Handling and Appending
	 */
	
}