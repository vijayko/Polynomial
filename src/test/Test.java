package test;

import main.Polynomial;
import java.io.*;
import java.util.Arrays;

/**
 * This is the Test class. 
 * Here I am reading the values of coefficient and exponent for a polynomial off a file, and constructing the corresponding polynomial. 
 * I am also applying different methods of class Polynomial.
 * @author Vijay Chaudhary
 *
 */
public class Test{
	public static void main(String[] args){
		/**
		 * This is the location of the file, "file.txt" which contains the values of coefficients and exponents. 
		 */
		String fileName = "/Users/vijay/Code/Polynomial/src/Resources/file.txt";
		String line = null;
		//Instantiating a Polynomial instance. 
		Polynomial newPolynomialObj = new Polynomial();
		String delimiter = ";";
		String[] temp_line1;
		String[] temp_line;
		String first_word;
		String coeff, exponent;
		try{
			/**
			 * Reading the file using FileReader class object and BufferedReader class object.
			 */
			FileReader file = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(file);
			/**
			 * This is to check whether the file is empty or not.
			 */
			while((line = bufferedReader.readLine()) != null){
				/**
				 * I am using a split method that produces an array of string values. Here, the regex is ";" for split method. 
				 */
				temp_line1 = line.split(delimiter);
				first_word = temp_line1[0];
				int length = temp_line1.length;
				temp_line = Arrays.copyOfRange(temp_line1, 1, length);
				
				/**
				 * Since, the coefficient were at even index, and exponents were at odd index, I iterated over the array in a similar way
				 *to get the right values for coefficient and exponent.
				*/
				int exp_index = 1;
				for(int i = 0; i < temp_line.length; i+=2){
					coeff = temp_line[i];
					exponent = temp_line[exp_index];
					int X = Integer.parseInt(coeff);
					int Y = Integer.parseInt(exponent);
					newPolynomialObj.Insert(X, Y);
					exp_index += 2;
				}
				System.out.println("Printing the polynomial");
				System.out.println(first_word + " (x) = " + newPolynomialObj.GetPolynomial());
				System.out.println("Printing the product of the terms of polynomial");
				System.out.println(first_word + " (x) = " + newPolynomialObj.Product());
				System.out.println("Printing the reverse of the polynomial");
				System.out.println(first_word + " (x) = " + newPolynomialObj.Reverse());
				newPolynomialObj.Delete(1, 1);
				newPolynomialObj.Insert(4, 10);
				newPolynomialObj.Insert(-2, -2);
				newPolynomialObj.Insert(0, 0);
				System.out.println("Printing the reverse of the polynomial");
				System.out.println(first_word + " (x) = " + newPolynomialObj.Reverse());
				System.out.println("\n\n");
				/**
				 * Here I am assigning the newPolynomialObj to a new empty list for the next line. 
				 */
				newPolynomialObj = new Polynomial();
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open " + fileName);
		}
		catch(IOException ex){
			System.out.println("Error reading file " + fileName);
		}
		
	}
}
