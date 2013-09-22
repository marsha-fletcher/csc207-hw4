package edu.grinnell.csc207.fletcher1.hw4;

import java.math.*;

/**
 * 
 * @author Marsha Fletcher
 * @author Daniel Nanetti-Palacios
 *
 */

public class Fraction {
    BigInteger numerator;
    BigInteger denominator;
    /***************************************************************
     *------------------------Constructors-------------------------*
     ***************************************************************/
    public Fraction(int num, int denom) throws Exception{
	//STUB
    }//Fraction(int, int)
    
    public Fraction (int num){
	//STUB
    }//Fraction(int)
    
    public Fraction (BigInteger num, BigInteger denom) throws Exception{
	//STUB
    }//Fraction(BigInt, BigInt)
    
    public Fraction (BigInteger num){
	//STUB
    }//Fraction(BigInt)
    
    public Fraction (long num, long denom) throws Exception{
	//STUB
    }//Fraction(long, long)
    
    public Fraction (long num){
	//STUB
    }//Fraction(long)

    public Fraction (double val){
	//STUB
    }//Fraction(double)
    
    public Fraction (String val) throws Exception{
	//STUB
    }//Fraction (String)
    
    /***************************************************************
     *-----------------------Private Methods-----------------------*
     ***************************************************************/
    
    private void simplify(){
	BigInteger gcd = numerator.gcd(denominator);
	denominator = denominator.divide(gcd);
	numerator = numerator.divide(gcd);
	this.cleanup();
    }//simplify()
    
    private void cleanup(){
    }//cleanup
    /***************************************************************
     *-----------------------Public Methods------------------------*
     ***************************************************************/
    //OPERATIONS
    
    public Fraction add(Fraction other){
	
	BigInteger oldDenominator = denominator;
	denominator = denominator.multiply(other.denominator);
	numerator = other.denominator.multiply(numerator);
	BigInteger toAdd = other.numerator.multiply(oldDenominator);
	numerator = numerator.add(toAdd);
	this.simplify();
	return null;
    }//add(Fraction)    
    
    public Fraction subtract(Fraction other){
   	//STUB
   	return null;
       }//add(Fraction)
    
    public Fraction multiply(Fraction other){
	numerator = numerator.multiply(other.numerator);
	denominator = denominator.multiply(other.denominator);
	this.simplify();
   	return null;
       }//add(Fraction)
    
    public Fraction divide(Fraction other){
   	//STUB
   	return null;
       }//add(Fraction)
    
    public Fraction pow(Fraction other){
   	//STUB
   	return null;
       }//add(Fraction)

    //OBSERVERS
    
    public double doubleValue(){
	return this.numerator.doubleValue() / this.denominator.doubleValue();
    }// doubleValue()
    
    public BigDecimal BigDecimalValue(){
	return BigDecimal.valueOf(this.numerator.longValue()).divide(
		BigDecimal.valueOf(this.denominator.longValue()));
    }//BigDecimalValue()
    
    public Fraction reciprocal() throws Exception{
	if (this.numerator == BigInteger.valueOf(0)){
	    throw new Exception ("reciprocal failed: Cannot take the reciprocal of 0");
	} else {
	return new Fraction(this.denominator, this.numerator);
	} //if else to handle Exception
    }//reciprocal()
    
    public Fraction negate()throws Exception{
	return new Fraction(this.numerator.multiply(BigInteger.valueOf(-1)), this.denominator);
    } //negate()
    
    public BigInteger numerator(){
	return this.numerator;
    }//numerator()
    
    public BigInteger denominator(){
	return this.denominator;
    }//denominator()
    
    public Fraction fractionalPart() throws Exception{
	return new Fraction (this.numerator.mod(this.denominator), this.denominator);
    }//fractionalPart()
    
    public BigInteger wholePart(){
	return this.numerator.divide(this.denominator);
    }//wholePart()
    /***************************************************************
     *---------------------Standard Methods------------------------*
     ***************************************************************/
    
    public String toString(){
	return this.numerator + "/" + this.denominator;
    }//toString()
    
    public Fraction clone(){
	//Standard method clone does not throw exceptions. Our constructor does.
	//return new Fraction(this.numerator, this.denominator);
	return null;
    }//clone()
    
    public int compareTo(Fraction other){
	//STUB
	return 0;
    }//compareTo(Fraction)
    
    public boolean equals(Fraction other){
	//this should work, because Fractions are simplified upon construction and immutable
	return (this.numerator.equals(other.numerator) &&
		this.denominator.equals(other.denominator));
    }//equals
    
    /**
     * hashCode
     * @author Sam Rebelsky 
     * 	(Implementation copied from the 9/20/13 eBoard)
     */
    public int hashCode(){
	return numerator.hashCode() * denominator.hashCode();
    }
}//Fraction
