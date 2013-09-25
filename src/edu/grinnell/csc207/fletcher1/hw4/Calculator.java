package edu.grinnell.csc207.fletcher1.hw4;


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

	/*	public static Fraction calculate(String expression) throws Exception{
		if (expression.length() == 0){
			return new Fraction("0");
		} else if (expression.indexOf(' ') < 0){
			return new Fraction(expression);
		} else {
			String[] expParts = StringUtils.splitAt(expression, ' ');
			Fraction result = new Fraction (expParts[0]);
			int maxIndex = expParts.length - 1;
			char operator;
			String nextElement;
			Fraction nextNum;

			for (int i = 1; i < maxIndex; i+=2){
				operator = expParts[i].charAt(0);
				nextNum = new Fraction(expParts[1 + i]);

				switch (operator){
				case '+':
					result = result.add(nextNum);
					break;
				case '-': //where be the comments?!?!?!?
					result = result.subtract(nextNum);
					break;
				case '*':
					result = result.multiply(nextNum);
					break;
				case '/':
					result = result.divide(nextNum);
					break;
				case '^':
					result = result.pow(nextNum.numerator().intValue());
				}//switch
			}//for

			return result;
		}//has spaces
	}//eval0
	 */
	//private

	public static Fraction calculate(String expression) throws Exception{
		/*Fraction result = new Fraction(0);
		String current;
		String operator; 
		String next;
		expression = expression.trim();
		int ind;
		int len = expression.length();
		while (! (expression.equals(""))){
			ind = expression.indexOf(     ' ');
			current = expression.substring(0, ind);
			expression = expression.substring(ind + 1);
			operator = expression.substring(0, ind);
		}

		 */
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
}