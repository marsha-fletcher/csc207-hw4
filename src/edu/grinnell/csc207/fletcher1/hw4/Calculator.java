package edu.grinnell.csc207.fletcher1.hw4;


public class Calculator {

    Fraction[] memory;
    
    public Calculator(){
	this.memory = new Fraction[8];
    }//Constructor



	/**
	 * eval0
	 * Given a mathematical expression, calculates the value
	 * (without paying attention to order of operations)
	 * Operations supported: +, -, *, /, ^ (exponent)
	 * Returns 0 if given a null string
	 * Expressions must only contain numerals and operators
	 * @param expression, a string containing numerals and operators
	 * @return result, a BigInteger that is the result of evaluating expression
	 * @author Marsha Fletcher
	 * @author Evan Manuella
	 */

	Fraction[] r = new Fraction[10];


	public static Fraction[] evaluate(String[] expressions){
		Fraction[] toReturn = new Fraction[expressions.length] ;
		int counter = 0;
		for (String lineExpression : expressions){
			toReturn[counter] = evaluate(lineExpression);
			counter ++;
		}
		return toReturn;
	}
	public static Fraction evaluate(String expression){
		Fraction toReturn;
		try{
			toReturn = calculate(expression);

		}
		catch(Exception e){
			System.err.println("Improper input: given " + e);
			return null;
		}

		return toReturn;
	}



	public static Fraction calculate(String expression) throws Exception{

		expression = expression.trim();
		int ind;
		char operatorChar;
		String fracStr;
		ind = expression.indexOf(' ');
		if (ind == -1){
			Fraction runningTotal = new Fraction(expression);
			return runningTotal;
		}
		String operator;
		fracStr = expression.substring(0, ind);
		Fraction runningTotal = new Fraction(fracStr);
		expression = expression.substring(ind + 1);
		int power;
		while(!(expression.equals(""))){
			ind = expression.indexOf(' ');
			if (ind == -1){
				return runningTotal;
			}
			operator = expression.substring(0, ind);
			operatorChar = operator.charAt(0);

			expression = expression.substring(ind + 1);

			ind = expression.indexOf(' ');
			if (ind == -1 ){
			fracStr = expression.substring(0);
			}
			else{
			fracStr = expression.substring(0, ind);
			}

			Fraction current = new Fraction(fracStr);



			switch (operatorChar){
			case '+':
				runningTotal = runningTotal.add(current);
				break;
			case '-':
				runningTotal = runningTotal.subtract(current);
				break;
			case '*':
				runningTotal = runningTotal.multiply(current);
				break;
			case '/':
				runningTotal = runningTotal.divide(current);
				break;
			case '^':
				power = current.numerator().intValue();
				runningTotal = runningTotal.pow(power);
				break;
			}//switch

			expression = expression.substring(ind + 1);


		}

		return runningTotal;
	}

}//Calculator
