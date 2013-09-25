package edu.grinnell.csc207.fletcher1.hw4;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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
		assertEquals(BigInteger.valueOf(5), test2.numerator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(1), test2.denominator); // Fraction(int
																// num) test
		assertEquals(BigInteger.valueOf(3), test3.numerator);
		assertEquals(BigInteger.valueOf(2), test3.denominator);
		assertEquals(BigInteger.valueOf(3), test5.numerator); // Fraction(double
																// val) test
		assertEquals(BigInteger.valueOf(4), test5.denominator); // Fraction(double
																// val) test
		// assertEquals("The denominator cannot be zero", new Fraction (3, 0));
		assertEquals(true, test0.equals(test1)); // 6/8 = 3/4
		assertEquals(true, test2.equals(test4));
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
	
	@Test
	public void testMultiply() throws Exception {
		Fraction zero = new Fraction(0);
		Fraction one = new Fraction(1);
		Fraction negaone = new Fraction(-1);
		Fraction multi1 = new Fraction(1, 2);
		Fraction multi2 = new Fraction(-1, 2);
		Fraction multi3 = new Fraction(-1, 4);
		Fraction multi4 = new Fraction(2, 1);
		
		assertEquals("Multiply two positive fractions", 
				multi1, multi1.multiply(one));
		assertEquals("Multiply two negative fractions", 
				multi1, multi2.multiply(negaone));
		assertEquals("Multiply 1 negative and 1 positive fractions", 
				multi3, multi1.multiply(multi2));
		assertEquals("Multiply positive fraction by zero", 
				zero, multi1.multiply(zero));
		assertEquals("Multiply negative fraction by zero", 
				zero, multi2.multiply(zero));
		assertEquals("Multiply inverse", one, multi1.multiply(multi4));
	}
	
	@Test
	public void testDivide() throws Exception {
		Fraction zero = new Fraction(0);
		Fraction one = new Fraction(1);
		Fraction negaone = new Fraction(-1);
		Fraction div1 = new Fraction(1, 4);
		Fraction div2 = new Fraction(-1, 4);
		
		assertEquals("Divide two positive fractions", 
				one, div1.divide(div1));
		assertEquals("Divide two negative fractions", 
				div1, div2.divide(negaone));
		assertEquals("Divide 1 negative and 1 positive fractions", 
				negaone, div1.divide(div2));
		try {
	        div1.divide(zero);
	        fail("Cannot divide by 0");
	    } catch (Exception e) {
	    }
		
	}
	
	@Test
	public void testPow() throws Exception {
		Fraction one = new Fraction(1);
		Fraction pow1 = new Fraction(2, 4);
		Fraction pow2 = new Fraction(-2, 4);
		Fraction pow3 = new Fraction(4, 16);
		
		assertEquals("Positive Fraction", pow3, pow1.pow(2));
		assertEquals("Negative Fraction", pow3, pow2.pow(2));
		assertEquals("Power of 0", one, pow3.pow(0));
	}

	@Test
	public void testdoubleVal() throws Exception{
		Fraction dub1 = new Fraction(1, 2);
		Fraction dub2 = new Fraction(5);
		Fraction dub3 = new Fraction(-1, 2);
		Fraction dub4 = new Fraction(3, 2);
		Fraction dub5 = new Fraction(1, 3);
		
		assertEquals(0.5, dub1.doubleValue(), 0.001);
		assertEquals(5.0, dub2.doubleValue(), 0.001);
		assertEquals(-0.5, dub3.doubleValue(), 0.001);
		assertEquals(1.5, dub4.doubleValue(), 0.001);
		assertEquals(0.333, dub5.doubleValue(), 0.001);
	}
	
	@Test
	public void testBigDecimalValue() throws Exception{
		Fraction bigdub1 = new Fraction(1, 2);
		Fraction bigdub2 = new Fraction(5);
		Fraction bigdub3 = new Fraction(-1, 2);
		Fraction bigdub4 = new Fraction(3, 2);
		
		assertEquals("Positive Fraction < 1", 
				BigDecimal.valueOf(0.5), bigdub1.BigDecimalValue());
		assertEquals("Positive Fraction > 1", 
				BigDecimal.valueOf(5), bigdub2.BigDecimalValue());
		assertEquals("Negative Fraction > -1", 
				BigDecimal.valueOf(-0.5), bigdub3.BigDecimalValue());
		assertEquals("Positive Fraction > 1",
				BigDecimal.valueOf(1.5), bigdub4.BigDecimalValue());
	}
	
	@Test
	public void testreciprocal() throws Exception{
		Fraction rec1 = new Fraction(3, 7);
		Fraction rec2 = new Fraction(7, 3);
		Fraction rec3 = new Fraction(-3, 7);
		Fraction rec4 = new Fraction(-7, 3);
		Fraction rec0 = new Fraction(0, 1);
		
		assertEquals("Positive Fraction", rec2, rec1.reciprocal());
		assertEquals("Negative Fraction", rec4, rec3.reciprocal());
		try {
	        rec0.reciprocal();
	        fail("Cannot have 0 as the denominator");
	    } catch (Exception e) {
	    }
	}
	
	@Test
	public void testnegate() throws Exception{
		Fraction neg1 = new Fraction(4, 9);
		Fraction neg2 = new Fraction(-4, 9);
		
		assertEquals("Positive Fraction", neg2, neg1.negate());
		assertEquals("Negative Fraction", neg1, neg2.negate());
	}
	
	@Test
	public void testfractionalPart() throws Exception{
		Fraction frac1 = new Fraction(7, 2);
		Fraction frac2 = new Fraction(-7, 2);
		Fraction frac = new Fraction(1, 2);
		
		assertEquals("Positive Fraction", frac, frac1.fractionalPart());
		assertEquals("Positive Fraction", frac, frac2.fractionalPart());	
	}
	
	@Test
	public void testwholePart() throws Exception{
		Fraction whole1 = new Fraction(6, 2);
		Fraction whole2 = new Fraction(-6, 2);
		Fraction whole3 = new Fraction(7, 2);
		Fraction whole4 = new Fraction(-7, 2);
		
		assertEquals("Positive Fraction with no Fractional",
				BigInteger.valueOf(3), whole1.wholePart());
		assertEquals("Negative Fraction with no Fractional",
				BigInteger.valueOf(-3), whole2.wholePart());
		assertEquals("Positive Fraction with Fractional",
				BigInteger.valueOf(3), whole3.wholePart());
		assertEquals("Negative Fraction with Fractional",
				BigInteger.valueOf(-3), whole4.wholePart());
	}
	
	
	@Test
	public void testtoString() throws Exception{
		Fraction str1 = new Fraction(1, 2);
		Fraction str2 = new Fraction(-1, 2);
		Fraction str3 = new Fraction(25, 24);
		
		assertEquals("Positive Fraction", "1/2", str1.toString());
		assertEquals("Negative Fraction", "-1/2", str2.toString());
		assertEquals("Fraction with multiple digits in numerator and denominator",
				"25/24", str3.toString());
	}
	
	@Test
	public void testclone() throws Exception{
		Fraction original = new Fraction(1, 2);
		Fraction clone = new Fraction(1, 2);
		
		assertEquals("Cloning", clone, original.clone());
	}
	
	@Test
	public void testcompareTo() throws Exception{
		Fraction less = new Fraction(1, 4);
		Fraction more = new Fraction(1, 2);
		
		assertEquals("Fractions are the same", 0, less.compareTo(less));
		assertEquals("Fraction is less than", -1, less.compareTo(more));
		assertEquals("Fraction is more than", 1, more.compareTo(less));
	}
	
	@Test
	public void testHashCode() throws Exception{
		Fraction a = new Fraction(-3, 10);
		Fraction b = new Fraction(330, 100);
		Fraction c = new Fraction(-6, -72);
		//We realize that this is somewhat redundant, but it seemed wrong to 
		//not test hashCode, and we couldn't think of any other way to do so
		
		assertEquals("Test a", (a.numerator.hashCode() * a.denominator.hashCode()),
				a.hashCode());
		assertEquals("Test b", (b.numerator.hashCode() * b.denominator.hashCode()),
				b.hashCode());
		assertEquals("Test c", (c.numerator.hashCode() * c.denominator.hashCode()),
				c.hashCode());
	}
}


