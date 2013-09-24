package edu.grinnell.csc207.fletcher1.hw4;

import java.math.BigInteger;
import java.util.Scanner;

public class UserInterface {

	public static void main(String [ ] args){
		Scanner reader = new Scanner(System.in);
		String input;
		BigInteger output;
		Calculator calculator = new Calculator();
		while (true){
			input = reader.nextLine();
			if (input.equals("exit")){
				break;
			}
			else{

				try{
					output = calculator.evaluate(input);
					System.out.println(output);
				}
				catch(NumberFormatException ex)
				{
					System.err.println("not valid input");
				}
			}


		}
	}
}
