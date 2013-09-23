package edu.grinnell.csc207.fletcher1.hw4;

import java.math.*;

/**
 * 
 * @author Marsha Fletcher
 * @author Evan Manuella
 * @author Daniel Nanetti-Palacios
 * @author Brennan Wallace
 */

public class Fraction {
	BigInteger numerator;
	BigInteger denominator;

	/***************************************************************
	 * ------------------------Constructors-------------------------*
	 ***************************************************************/

	/**
	 * Fraction(int, int)
	 * 
	 * @param num
	 *            , an int
	 * @param denom
	 *            , a non zero int
	 * @throws Exception
	 *             when denom = 0
	 */
	public Fraction(int num, int denom) throws Exception {
		if (denom == 0) {
			throw new Exception("The denominator cannot be zero");
		}
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(denom);

		this.simplify();
	}// Fraction(int, int)

	/**
	 * Fraction(int)
	 * 
	 * @param num
	 *            , an int
	 */
	public Fraction(int num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
	}// Fraction(int)

	/**
	 * Fraction(BigInteger, BigInteger)
	 * 
	 * @param num
	 *            , a BigInteger
	 * @param denom
	 *            , a non zero BigInteger
	 * @throws Exception
	 *             when denom = 0
	 */
	public Fraction(BigInteger num, BigInteger denom) throws Exception {
		if (denom == BigInteger.ZERO) {
			throw new Exception("The denominator cannot be zero");
		}

		this.numerator = num;
		this.denominator = denom;
		this.simplify();
	}// Fraction(BigInt, BigInt)

	/**
	 * Fraction(BigInteger)
	 * 
	 * @param num
	 *            , a BigInteger
	 */
	public Fraction(BigInteger num) {
		this.numerator = num;
		this.denominator = BigInteger.ONE;
	}// Fraction(BigInt)

	/**
	 * Fraction(long, long)
	 * 
	 * @param num
	 *            , a long
	 * @param denom
	 *            , a non zero long
	 * @throws Exception
	 *             when denom = 0
	 */
	public Fraction(long num, long denom) throws Exception {
		if (denom == 0) {
			throw new Exception("The denominator cannot be zero");
		}
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.valueOf(denom);
		this.simplify();
	}// Fraction(long, long)

	/**
	 * Fraction(long)
	 * 
	 * @param num
	 *            , a long
	 */
	public Fraction(long num) {
		this.numerator = BigInteger.valueOf(num);
		this.denominator = BigInteger.ONE;
	}// Fraction(long)

	/**
	 * Fraction(double)
	 * 
	 * @param num
	 *            , a double
	 */
	public Fraction(double val) {
		String valStr = String.valueOf(val);
		int dotIndex = valStr.indexOf('.');
		int len = valStr.length();
		if (dotIndex < 0) { // if val doesn't have a decimal part, ie val = 5
			this.numerator = BigInteger.valueOf((long) val);
			this.denominator = BigInteger.ONE;
		} else if (dotIndex > 0) {
			BigInteger wholePart = new BigInteger(valStr.substring(0, dotIndex));
			BigInteger decPart = new BigInteger(valStr.substring(dotIndex + 1,
					len));
			int decPlaces = len - (dotIndex + 1);

			this.denominator = BigInteger.TEN.pow(decPlaces);
			this.numerator = decPart.add(wholePart.multiply(this.denominator));
			this.simplify();
		} else {
			this.numerator = new BigInteger(valStr.substring(1, len));
			this.denominator = BigInteger.TEN.multiply(BigInteger
					.valueOf(len - 1));
		}
	}// Fraction(double)
	
	/**
	 * Fraction(string)
	 * @param val
	 * 		, a string in one of the following formats:
	 * 		"##", "#/#", "#.#", ".##" (where # is any numeral)
	 * @throws Exception 
	 * 		when the string is in the format "#/0"
	 */
	public Fraction(String val) throws Exception {
		int len = val.length();
		int slashIndex = val.indexOf('/');
		// Case where the string is in the format "#/#"
		if (slashIndex > 0) {
			this.numerator = new BigInteger(val.substring(0, slashIndex));
			this.denominator = new BigInteger(
					val.substring(slashIndex + 1, len));
			if (this.denominator == BigInteger.ZERO) {
				throw new Exception("The denominator cannot be zero");
			}// Check for denominator = 0
			this.simplify();
		} else {
			// Case where the string is in the format "#.#"
			int dotIndex = val.indexOf('.');
			if (dotIndex >= 0) {
				if (dotIndex == 0) {
					this.numerator = new BigInteger(val.substring(1, len));
					this.denominator = BigInteger.TEN.multiply(BigInteger
							.valueOf(len - 1));
				} else {
					BigInteger wholePart = new BigInteger(val.substring(0,
							dotIndex));
					BigInteger decPart = new BigInteger(val.substring(
							dotIndex + 1, len));

					int decPlaces = len - (dotIndex + 1);
					this.denominator = BigInteger.TEN.pow(decPlaces);
					this.numerator = decPart.add(wholePart
							.multiply(this.denominator));
					this.simplify();
				}
			} else {
				// Else assume the string is in the format "##" (just a
				// numerator)
				this.numerator = new BigInteger(val);
				this.denominator = BigInteger.ONE;
			}
		}// else
	}// Fraction (String)

	/***************************************************************
	 * -----------------------Private Methods-----------------------*
	 ***************************************************************/

	private void simplify() {
		BigInteger gcd = numerator.gcd(denominator);
		denominator = denominator.divide(gcd);
		numerator = numerator.divide(gcd);
		this.cleanup();
	}// simplify()

	private void cleanup() {
		if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
			this.denominator = this.denominator.negate();
			this.numerator = this.numerator.negate();
		}// if
	}// cleanup

	/***************************************************************
	 * -----------------------Public Methods------------------------*
	 ***************************************************************/
	// OPERATIONS

	/**
	 * add(Fraction)
	 * @param other
	 * 		, a fraction
	 * @return sum
	 * 		, the sum of the current fraction and other
	 */
	public Fraction add(Fraction other) {

		BigInteger oldDenominator = denominator;
		denominator = denominator.multiply(other.denominator);
		numerator = other.denominator.multiply(numerator);
		BigInteger toAdd = other.numerator.multiply(oldDenominator);
		numerator = numerator.add(toAdd);
		this.simplify();
		return null;
	}// add(Fraction)

	/**
	 * subtract(Fraction)
	 * @param other
	 * 		, a Fraction
	 * @return diff
	 * 		, the difference of the current fraction and other (this - other)
	 */
	public Fraction subtract(Fraction other) {
		BigInteger oldDenominator = denominator;
		denominator = denominator.multiply(other.denominator);
		numerator = other.denominator.multiply(numerator);
		BigInteger toAdd = other.numerator.multiply(oldDenominator);
		numerator = numerator.subtract(toAdd);
		this.simplify();
		return null;
	}// subtract(Fraction)

	/**
	 * multiply(Fraction)
	 * @param other
	 * 		, a Fraction
	 * @return product
	 * 		, the product of the current fraction and other
	 */
	public Fraction multiply(Fraction other) {
		numerator = numerator.multiply(other.numerator);
		denominator = denominator.multiply(other.denominator);
		this.simplify();
		return null;
	}// add(Fraction)

	/**
	 * divide(Fraction)
	 * @param other
	 * 		, a fraction
	 * @return quotient
	 * 		, the quotient of the current fraction and other (this / other)
	 */
	public Fraction divide(Fraction other) {
		numerator = denominator.multiply(other.numerator);
		denominator = numerator.multiply(other.denominator);
		this.simplify();
		return null;
	}// add(Fraction)

	public Fraction pow(Fraction other) {
		// STUB
		return null;
	}// add(Fraction)

	// OBSERVERS

	public double doubleValue() {
		return this.numerator.doubleValue() / this.denominator.doubleValue();
	}// doubleValue()

	public BigDecimal BigDecimalValue() {
		return BigDecimal.valueOf(this.numerator.longValue()).divide(
				BigDecimal.valueOf(this.denominator.longValue()));
	}// BigDecimalValue()

	public Fraction reciprocal() throws Exception {
		if (this.numerator == BigInteger.valueOf(0)) {
			throw new Exception(
					"reciprocal failed: Cannot take the reciprocal of 0");
		} else {
			return new Fraction(this.denominator, this.numerator);
		} // if else to handle Exception
	}// reciprocal()

	public Fraction negate() throws Exception {
		return new Fraction(this.numerator.multiply(BigInteger.valueOf(-1)),
				this.denominator);
	} // negate()

	public BigInteger numerator() {
		return this.numerator;
	}// numerator()

	public BigInteger denominator() {
		return this.denominator;
	}// denominator()

	public Fraction fractionalPart() throws Exception {
		return new Fraction(this.numerator.mod(this.denominator),
				this.denominator);
	}// fractionalPart()

	public BigInteger wholePart() {
		return this.numerator.divide(this.denominator);
	}// wholePart()

	/***************************************************************
	 * ---------------------Standard Methods------------------------*
	 ***************************************************************/

	public String toString() {
		return this.numerator + "/" + this.denominator;
	}// toString()

	public Fraction clone() {
		// We're using a try catch block because clone yells at us if we say
		// throws Exception, but our constructor yells at us if we don't
		try {
			return new Fraction(this.numerator, this.denominator);
		} catch (Exception e) {
		}

		return null;
	}// clone()

	public int compareTo(Fraction other) {
	    	
		return this.subtract(other).numerator.signum();
	}// compareTo(Fraction)

	
	// Added equals(Object other) to make the testing be able to compare fractions.
	//Written by Sam Rebelsky while assisting Daniel Nanetti-Palacios
	public boolean equals(Object other) {
		return (other instanceof Fraction) && (this.equals((Fraction) other));
	} // equals

	public boolean equals(Fraction other) {
		// this should work, because Fractions are simplified upon construction
		// and immutable
		return (this.numerator.equals(other.numerator) && this.denominator
				.equals(other.denominator));
	} // equals

	/**
	 * hashCode
	 * 
	 * @author Sam Rebelsky (Implementation copied from the 9/20/13 eBoard)
	 */
	public int hashCode() {
		return numerator.hashCode() * denominator.hashCode();
	}
}// Fraction
