package edu.grinnell.csc207.fletcher1.hw4;

import java.math.*;

public class Calculator {


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
	public static BigInteger[] evaluate(String[] expressions){
		BigInteger[] toReturn = new BigInteger[expressions.length] ;
		int counter = 0;
		for (String lineExpression : expressions){
			toReturn[counter] = evaluate(lineExpression);
			
		}
		return toReturn;
	}
	public static BigInteger evaluate(String expression){
		try 
		calculate
	}

	public static BigInteger calculate(String expression){
		if (expression.length() == 0){
			return new BigInteger("0");
		} else if (expression.indexOf(' ') < 0){
			return new BigInteger(expression);
		} else {
			String[] expParts = StringUtils.splitAt(expression, ' ');
			BigInteger result = new BigInteger (expParts[0]);
			int maxIndex = expParts.length - 1;
			char operator;
			BigInteger nextNum;

			for (int i = 1; i < maxIndex; i+=2){
				operator = expParts[i].charAt(0);
				nextNum = new BigInteger(expParts[1 + i]);
				switch (operator){
				case '+':
					result = result.add(nextNum);
					break;
				case '-':
					result = result.subtract(nextNum);
					break;
				case '*':
					result = result.multiply(nextNum);
					break;
				case '/':
					result = result.divide(nextNum);
					break;
				case '^':
					result = result.pow(nextNum.intValue());
				}//switch
			}//for

			return result;
		}//has spaces
	}//eval0


}//Calculator