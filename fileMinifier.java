import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** 
 * @author Remel Kabir
 *
 */

public class fileMinifier {

	public static void main(String[] args) {
		
		//Declaring variables
		String oldFile = args[0]; //Getting the file that needs to minified from the user
		String currentLine; //to keep track of the current line that is being processed.
		//variable to store split files name and extension.
		String oldFileName;
		String oldFileExtention;
		
		//variable to hold the currentline temporarily
		String line;
		
		//checks if there is extension of the file or not
		if(oldFile.contains(".")){
			//splits the file into two component
			String[] token = oldFile.split("\\.(?=[^\\.]+$)");// this regex makes sure regardless of other dot(.) file is divided into two string.
			
			//this is necessary for naming the new file with oldFile.min.extension
			oldFileName = token[0]; //the name
			oldFileExtention = token[1]; // the extension
			
		}//if
		else{
			throw new IllegalArgumentException("Filename doesn't contain a extension");
		}//else
		
		
		try{
			//Java API to read file line by line.
			BufferedReader reader = new BufferedReader(new FileReader(oldFile));
			//Java API to write to a file.
			PrintWriter writer = new PrintWriter(new FileWriter(oldFileName +".min."+oldFileExtention));
			
			while ((currentLine = reader.readLine()) !=null){
				line = currentLine.replaceAll("\\s+", "");
				writer.write(line);
			}//while
			writer.close();
			reader.close();
		}//try
		catch(IOException e){
			System.out.println("File Not Found");
		}//catch
		
	}//main

}//class
