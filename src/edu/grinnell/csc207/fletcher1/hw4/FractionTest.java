package edu.grinnell.csc207.fletcher1.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void Fractiontest() throws Exception {
		Fraction test0 = new Fraction(3, 4); //Fraction(int, int)
		Fraction test1 = new Fraction(6, 8); //Fraction(int, int)
		Fraction test2 = new Fraction(5); //Fraction(int)
		Fraction test3 = new Fraction(BigInteger.valueOf(3),
				BigInteger.valueOf(2)); //Fraction(BigInteger, BigInteger)
		Fraction test4 = new Fraction(BigInteger.valueOf(5)); //Fraction(BigInteger)
		Fraction test5 = new Fraction(0.75); //Fraction(double)
		Fraction test6 = new Fraction(5.0); //Fraction(double)
		Fraction test7 = new Fraction((long) 5); //Fraction(long)
		Fraction test8 = new Fraction((long) 12, (long) 16); //Fraction(long, long)
		Fraction test9 = new Fraction("3/4"); //Fraction(String)
		Fraction test10 = new Fraction("450/2"); //Fraction(String)
		Fraction test11 = new Fraction("5/100"); //Fraction(String)
		assertEquals(BigInteger.valueOf(3), test0.numerator);
		assertEquals(BigInteger.valueOf(4), test0.denominator);
		assertEquals(BigInteger.valueOf(3), test1.numerator); // Simplify test
		assertEquals(BigInteger.valueOf(4), test1.denominator); // Simplify test
		// assertEquals(test1, new Fraction(3, 4));
		assertEquals(BigInteger.valueOf(5), test2.numerator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(1), test2.denominator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(3), test5.numerator); // Fraction(double
																// val) test
		assertEquals(BigInteger.valueOf(4), test5.denominator); // Fraction(double
																// val) test
		// assertEquals("The denominator cannot be zero", new Fraction (3, 0));
		assertEquals(true, test0.equals(test1)); // 6/8 = 3/4
		assertEquals(true, test2.equals(test6)); 
		assertEquals(true, test2.equals(test7));
		assertEquals(true, test0.equals(test8));
		assertEquals(true, test0.equals(test9)); // String test
		assertEquals(BigInteger.valueOf(225), test10.numerator); // String test
		assertEquals(BigInteger.valueOf(1), test10.denominator); // String test
		assertEquals(BigInteger.valueOf(1), test11.numerator); // String test
		assertEquals(BigInteger.valueOf(20), test11.denominator); // String test
		
		// Zero Numerator Tests
		Fraction test12 = new Fraction(0, 1);
		Fraction test13 = new Fraction(0);
		Fraction test14 = new Fraction(0.0);
		Fraction test15 = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		Fraction test16 = new Fraction(BigInteger.ZERO);
		Fraction test17 = new Fraction((long) 0, (long) 1);
		Fraction test18 = new Fraction((long) 0);
		Fraction test19 = new Fraction("0/1");
		
		assertEquals(BigInteger.ZERO, test12.numerator);
		assertEquals(true, test12.equals(test13));
		assertEquals(true, test12.equals(test14));
		assertEquals(true, test12.equals(test15));
		assertEquals(true, test12.equals(test16));
		assertEquals(true, test12.equals(test17));
		assertEquals(true, test12.equals(test18));
		assertEquals(true, test12.equals(test19));
		
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
		
		//Negative Tests
		Fraction test20 = new Fraction(-1, 2);
		Fraction test21 = new Fraction(1, -2);
		Fraction test22 = new Fraction(-1);
		Fraction test23 = new Fraction(BigInteger.valueOf(-1), BigInteger.valueOf(2));
		Fraction test24 = new Fraction(BigInteger.valueOf(-1));
		Fraction test25 = new Fraction(-1.0);
		Fraction test26 = new Fraction((long) -1, (long) 2);
		Fraction test27 = new Fraction((long) -1);
		Fraction test28 = new Fraction("-1/2");
		Fraction test29 = new Fraction("1/-2");
		
		assertEquals(BigInteger.valueOf(-1), test20.numerator);
		assertEquals(BigInteger.valueOf(2), test21.denominator); // cleanup test
		assertEquals(BigInteger.valueOf(-1), test22.numerator);
		assertEquals(true, test20.equals(test23));
		assertEquals(true, test22.equals(test24));
		assertEquals(true, test22.equals(test25));
		assertEquals(true, test20.equals(test26));
		assertEquals(true, test22.equals(test27));
		assertEquals(true, test20.equals(test28));
		assertEquals(true, test21.equals(test29));
	}// Constructor Tests
	
	@Test
	public void addtest() throws Exception {
		Fraction zero = new Fraction (0);
		Fraction add1 = new Fraction(1, 4);
		Fraction add2 = new Fraction(1, 2);
		Fraction add3 = new Fraction(-1, 4);
		Fraction add4 = new Fraction(-1, 2);
		
		Fraction add5 = new Fraction(5, 4);
		Fraction add6 = new Fraction(-5, 4);
		
		assertEquals("Add two positive proper fractions", add2, add1.add(add1));
		assertEquals("Add two negative proper fractions", add4, add3.add(add3));
		assertEquals("Add negative proper fraction to positive proper fraction, sum = 0", 
				zero, add1.add(add3));
		assertEquals("Add negative proper fraction to positive proper fraction, sum > 0",
				add1, add2.add(add3));
		assertEquals("Add positive proper fraction to negative proper fraction, sum < 0",
				add3, add4.add(add1));
		assertEquals("Add positive proper fraction to negative proper fraction, sum > 0",
				add1, add3.add(add2));
		
		assertEquals("Add three positive fractions, sum is an improper fraction",
				add5, add2.add(add2.add(add1)));
		assertEquals("Add three negative fractions, sum is an improper fraction",
				add6, add4.add(add4.add(add3)));
		
	}//addTest
	
	@Test
	public void testSubtract() throws Exception {
		Fraction zero = new Fraction (0);
		Fraction add1 = new Fraction(1, 4);
		Fraction add2 = new Fraction(1, 2);
		Fraction add3 = new Fraction(-1, 4);
		Fraction add4 = new Fraction(-1, 2);
		
		Fraction add5 = new Fraction(-3, 2);
		
		assertEquals("Subtract two positive fractions, diff = 0",
				zero, add1.subtract(add1));
		assertEquals("Subtract two positive fractions, diff > 0",
				add1, add2.subtract(add1));
		assertEquals("Subtract two positive fractions, diff < 0",
				add3, add1.subtract(add2));
		
		assertEquals("Subtract two negative fractions, diff = 0",
				zero, add3.subtract(add3));
		assertEquals("Subtract two negative fractions, diff > 0",
				add1, add3.subtract(add4));
		assertEquals("Subtract two negative fractions, diff < 0",
				add3, add4.subtract(add3));
	}//testSubtract

}
