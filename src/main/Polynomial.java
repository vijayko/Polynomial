package main;

import java.util.*;
import java.lang.*;
/**
 * This is the "Polynomial" class. This class is about writing a polynomial using the terms. 
 * It uses the class "Term". 
 * 1. It has two fields. 
 * 2. It has six methods.
 * @author Vijay Chaudhary
 *
 */
public class Polynomial{
	private Term terms;
	private ArrayList<Term> list;
	
	/**
	 * This is the constructor of the class. It creates an empty ArrayList with each element of type "Term". 
	 * I am using a generic ArrayList here. 
	 */
	public Polynomial(){
		list = new ArrayList<Term>();
	}
	
	/**
	 * This is the "Insert" method. 
	 * It takes two parameters, the coefficient and the exponent for the terms of a polynomial. 
	 * It takes those two parameters of a term, creates a term and insert those terms in an ascending order of exponent. 
	 * @param X
	 * @param Y
	 */
	public void Insert(int X, int Y){
		if(Y < 0){
			System.out.println("Message: The exponent of a term for any polynomial is greater than or equal to zero.");
		}
		else {
			Term item = new Term(X,Y);
			if (list.size() == 0){
				list.add(item);
			}
			else{
				//In this part, I am looking for an proper place to insert a term so that the polynomial is in ascending order of exponent.
				int index = 0;
				for(Term iter : list){
					if (Y > iter.GetExp()){
						//
					}
					else{
						list.add(index, item);
						break;
					}
					index++;
				}
				if(index == list.size()){
					list.add(index, item);
				}
			}
		}
	}
	
	/**
	 * This is the Delete method. It takes two parameters, the coefficient and the exponent of a term. 
	 * Here, I am looking for a matching term for given coefficient and exponent, and removing it from the list. 
	 * I am using built-in method "remove" to remove the given term. 
	 * If there is no such term, then this method throws a message. 
	 * @param X = coefficient
	 * @param Y = exponent
	 */
	public void Delete(int X, int Y){
		Term item = new Term(X, Y);
		Iterator<Term> it = list.iterator();
		int index = 0;
		while(it.hasNext()){
			if ((it.next()).equals(item)){
				list.remove(index);
				break;
			}
			index++;
		}
		if(index == list.size()){
			System.out.println("There is no such term in the polynomial.");
		}
	}
	
	/**
	 * This is GetPolynomial method. It simply forms a proper polynomial and prints it on the screen. 
	 * For eg: (1, 2), (3, 4) are the two terms of polynomial with (coeff, exp), then it returns x^2 + 3x^4.
	 * The return type is String.
	 * @return polynomial
	 */
	public String GetPolynomial(){
		String expression = "", s;
		Term temp;
		Iterator<Term> it = list.iterator();
		int index = 0;
		while((index < list.size() -1)){
			temp = it.next();
			s = temp.toString();
			expression = expression + s + " " ;
			index++;
		}
		expression = expression + it.next();
		if (expression.charAt(0) == '-'){
			return expression;
		}
		else{
			return expression.substring(1);
		}
		
	}
	
	/**
	 * This is Product method. It simply returns the product of terms of a polynomial in String type.
	 * @return product_value
	 */
	public String Product(){
		Iterator<Term> it = list.iterator();
		Term temp;
		String value = "";
		int e,c;
		int product_c = 1;
		int sum_e = 0;
		while(it.hasNext()){
			temp = it.next();
			c = temp.GetCoeff();
			e = temp.GetExp();
			if(c != 0){
				product_c = product_c * c;
			}
			sum_e += e;
		}
		String str_c = "" + product_c;
		String str_e = "" + sum_e;
		value = (str_c) + "x" + "^" + (str_e);
		
		return value;
	}
	
	/**
	 * This is Reverse method. It reverses the ascending ordered polynomial to descending order. 
	 * It has a String return type.
	 * @return
	 */
	public String Reverse(){
		int list_size = list.size();
		Term temp = null;
		String value = "", s;
		Iterator<Term> it = list.iterator();
		int index = 0;
		while(index < list_size - 1){
			temp = it.next();
			s = temp.toString();
			value = s + " " + value ;
			index++;
		}
		value = it.next()+ " " + value;
		if(value.charAt(0) == '-'){
			return value;
		}
		else{
			return value.substring(1);
		}
		
	}
}