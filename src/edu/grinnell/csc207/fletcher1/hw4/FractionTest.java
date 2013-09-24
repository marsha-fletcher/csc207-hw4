package edu.grinnell.csc207.fletcher1.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void Fractiontest() throws Exception {
		Fraction test0 = new Fraction(3, 4);
		Fraction test1 = new Fraction(6, 8);
		Fraction test2 = new Fraction(5);
		Fraction test3 = new Fraction(BigInteger.valueOf(3),
				BigInteger.valueOf(2));
		Fraction test4 = new Fraction(0.75);
		Fraction test5 = new Fraction((long) 5);
		Fraction test6 = new Fraction((long) 12, (long) 16);
		Fraction test7 = new Fraction("3/4");
		Fraction test8 = new Fraction("450/2");
		Fraction test9 = new Fraction("5/100");
		assertEquals(BigInteger.valueOf(3), test0.numerator);
		assertEquals(BigInteger.valueOf(4), test0.denominator);
		assertEquals(BigInteger.valueOf(3), test1.numerator); // Simplify test
		assertEquals(BigInteger.valueOf(4), test1.denominator); // Simplify test
		// assertEquals(test1, new Fraction(3, 4));
		assertEquals(BigInteger.valueOf(5), test2.numerator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(1), test2.denominator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(3), test4.numerator); // Fraction(double
																// val) test
		assertEquals(BigInteger.valueOf(4), test4.denominator); // Fraction(double
																// val) test
		// assertEquals("The denominator cannot be zero", new Fraction (3, 0));
		
		assertEquals(test0, test1);
		assertEquals(true, test0.equals(test1));
		assertEquals(test2, test5);
		assertEquals(test0, test6);
		assertEquals(test0, test7);
		assertEquals(BigInteger.valueOf(225), test8.numerator);
		assertEquals(BigInteger.valueOf(1), test8.denominator);
		assertEquals(BigInteger.valueOf(1), test9.numerator);
		assertEquals(BigInteger.valueOf(20), test9.denominator);
		// Zero Exception Tests
		try {
	        Fraction f = new Fraction(1,0);
	        fail("The denominator cannot be zero");
	    } catch (Exception e) {
	    }
		try {
	        Fraction f = new Fraction(BigInteger.ONE, BigInteger.ZERO);
	        fail("The denominator cannot be zero");
	    } catch (Exception e) {
	    }
		try {
	        Fraction f = new Fraction((long) 1,(long) 0);
	        fail("The denominator cannot be zero");
	    } catch (Exception e) {
	    }
		try {
	        Fraction f = new Fraction("1/0");
	        fail("The denominator cannot be zero");
	    } catch (Exception e) {
	    }
	}

}
