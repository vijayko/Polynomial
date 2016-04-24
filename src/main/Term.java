package main;
/**
 * This is a "Term" class. 
 * 1. It has two fields.
 * 2. It has five different methods. All the methods were not required for the assignment. 
 * 3. I wrote "equals" method to compare two terms. 
 * @author Vijay Chaudhary
 *
 */

public class Term
{
	/**
	 * These are the two fields of the class. "coeff" is for the coefficient and "exp" is for the exponent a term.
	 */
	int coeff;
	int exp;
	
	/**
	 * This is the constructor of the class. It takes two parameters. Both are of 'int' type.
	 * @param newCoeff
	 * @param newExp
	 */
	public Term(int newCoeff, int newExp){
		this.coeff = newCoeff;
		this.exp = newExp;
	}
	
	/**
	 * This method is to access the coefficient of a term. It has an 'int' return type.
	 * @return coeff
	 */
	public int GetCoeff(){
		return coeff;
	}
	
	/**
	 * This method is to access the exponent of a term. It has an 'int' return type.
	 * @return exp
	 */
	public int GetExp(){
		return exp;
	}
	
	/**
	 * I wrote this method to override "equals" method. It made it easier to compare two terms. 
	 */
	@Override
	public boolean equals(Object ob){
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Term other = (Term)ob;
		if(other.coeff != coeff) return false;
		if(other.exp != exp) return false;
		return true;
	}
	
	/**
	 * This method is to write a proper term in terms of coefficient and exponent. 
	 * For eg: if coeff = -4 and exp = 3, then this method returns -4x^3. 
	 * It has a String return type.
	 */
	public String toString(){
		String c = "" + coeff;
		String e = "" + exp;
		String expression;
		if(this.coeff == 0){
			expression = "";
		}
		else if(this.exp == 0){
			if(this.coeff > 0){
				expression = "+" + c;
			}
			else{
				expression = c;
			}
		}
		else if (this.coeff == 1){
			expression = "+x" + "^" + e;
		}
		else if(this.coeff == -1){
			expression = "-x^" + e;
		}
		else{
			if(this.coeff > 0){
				expression = "+" + c + "x^" + e;
			}
			else{
				expression = c + "x^" + e;
			}
		}
		return expression;
	}
	
	
}
