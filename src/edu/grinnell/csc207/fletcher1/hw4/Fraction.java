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
	if (denom == 0){
	    throw new Exception("The denominator cannot be zero");
	}
	this.numerator = BigInteger.valueOf(num);
	this.denominator = BigInteger.valueOf(denom);
	
	this.cleanup();
	this.simplify();
    }//Fraction(int, int)
    
    public Fraction (int num){
	this.numerator = BigInteger.valueOf(num);
	this.denominator = BigInteger.ONE;
    }//Fraction(int)
    
    public Fraction (BigInteger num, BigInteger denom) throws Exception{
	if (denom == BigInteger.ZERO){
		throw new Exception("The denominator cannot be zero");
	    }
	
	this.numerator = num;
	this.denominator = denom;
	this.simplify();
    }//Fraction(BigInt, BigInt)
    
    public Fraction (BigInteger num){
	this.numerator = num;
	this.denominator = BigInteger.ONE;
    }//Fraction(BigInt)
    
    public Fraction (long num, long denom) throws Exception{
	if (denom == 0){
	    throw new Exception("The denominator cannot be zero");
	}
	this.numerator = BigInteger.valueOf(num);
	this.denominator = BigInteger.valueOf(denom);
    }//Fraction(long, long)
    
    public Fraction (long num){
	this.numerator = BigInteger.valueOf(num);
	this.denominator = BigInteger.ONE;
    }//Fraction(long)

    public Fraction (double val){
	
    }//Fraction(double)
    
    public Fraction (String val) throws Exception{
	int len  = val.length();
	int slashIndex = val.indexOf('/');
	//Case where the string is in the format "#/#"
	if(slashIndex > 0){
	    this.numerator = new BigInteger(val.substring(0, slashIndex));
	    this.denominator = new BigInteger(val.substring(slashIndex + 1, len));
	    if (this.denominator == BigInteger.ZERO){
		throw new Exception("The denominator cannot be zero");
	    }
	}else {
	//Case where the string is in the format "#.#"
	    int dotIndex = val.indexOf('.');
	    if(dotIndex >= 0){
		//STUB
	    } else {
	    //Else assume the string is in the format "##" (just a numerator)
		this.numerator = new BigInteger(val);
		this.denominator = BigInteger.ONE;
	    }
	}//else	
    }//Fraction (String)
    
    /***************************************************************
     *-----------------------Private Methods-----------------------*
     ***************************************************************/
    
    private void simplify(){
	//STUB
    }//simplify()
    
    private void cleanup(){
	if (this.denominator.compareTo(BigInteger.ZERO) < 0){
	    this.denominator = this.denominator.negate();
	    this.numerator = this.numerator.negate();
	}//if
    }//cleanup
    /***************************************************************
     *-----------------------Public Methods------------------------*
     ***************************************************************/
    //OPERATIONS
    
    public Fraction add(Fraction other){
	//STUB
	return null;
    }//add(Fraction)    
    
    public Fraction subtract(Fraction other){
   	//STUB
   	return null;
       }//add(Fraction)
    
    public Fraction multiply(Fraction other){
   	//STUB
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
    
    public Fraction clone() {
	//We're using a try catch block because clone yells at us if we say 
	//throws Exception, but our constructor yells at us if we don't
	try {
	    return new Fraction (this.numerator, this.denominator);
	} catch (Exception e){}
	
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
