package fileHandlePackage;

import java.io.File;

public class Attributes {
	public static void main(String[] args) {
		File file = new File("src/Attributes.java");
		// Initialization of File object to be used.
		
		System.out.println("exists: " + file.exists());
		// The exists() method checks whether or not the file specified in the given pathname in the declared File exists.
		
		System.out.println("path: " + file.getPath());
		// The getPath() method gets the given pathname to the file into a String.
		
		System.out.println("length: " + file.length());
		// The length() method gets and displays the size of the file in bytes.
		
		System.out.println("isDirectory: " + file.isDirectory());
		// The isDirectory() method checks whether or not the given pathname in the declared File is a directory
		
		System.out.println("isFile: " + file.isFile());
		// The isFile() method checks whether or not the file specified in the given pathname in the declared File is a normal file.
		
		System.out.println("canRead: " + file.canRead());
		// the canRead() method checks whether or not the file specified in the given pathname in the declared File is readable by the Java program.
	}
}
