package fracCalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner keybrd = new Scanner(System.in);
    	System.out.println("Fractions to calculate: ");
    	String userInput = keybrd.nextLine();
    	System.out.println(produceAnswer(userInput));
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String part1 = "";
    	String part2 = "";
    	int function = 4; //0 = +; 1 = -; 2 = *; 3 = /;
    	int returntype = 2;
        String num1 = "";
        int num1i;
        String top1 = "";
        int top1i;
        String bottom1 = "";
        int bottom1i;
        String num2 = "";
        int num2i;
        String top2 = "";
        int top2i;
        String bottom2 = "";
        int bottom2i;
        
        String output = "";
        
        //split into parts
        String[] response = input.split(" ");
        part1 = response[0];
        part2 = response[2];
        
        //remove because it is clunky and stupid
        /*if(input.contains("+")) {
    	    //addition
    	    part1 = input.substring(0, (input.indexOf("+") - 1));
    	    part2 = input.substring(input.indexOf("+") + 2);
    	    function = 0;
        } else {
 	       if(input.contains("-")) {
 	    	   //subtraction
 	    	   part1 = input.substring(0, (input.lastIndexOf("-") - 1));
 	    	   part2 = input.substring(input.lastIndexOf("-") + 2);
 	    	   function = 1;
 	       } else {
 		       if(input.contains("*")) {
 		    	   //multiplication
 		    	   part1 = input.substring(0, (input.indexOf("*") - 1));
 		    	   part2 = input.substring(input.indexOf("*") + 2);
 		    	   function = 2;
 		       } else {
 			       if(input.contains("/")) {
 			    	   //division
 			       }
 		       }
 	       }
        }*/
        
        if(returntype == 1) {
        	return part2;
        }
        
        //split into each number
        if(part1.contains("_")) {
        	num1 = part1.substring(0, part1.indexOf("_"));
        	top1 = part1.substring(part1.indexOf("_") + 1, part1.indexOf("/"));
        	bottom1 = part1.substring(part1.indexOf("/") + 1);
        } else {
        	if(part1.contains("/")) {
	        	num1 = "0";
	        	top1 = part1.substring(0, part1.indexOf("/"));
	        	bottom1 = part1.substring(part1.indexOf("/") +1);
        	} else {
        		num1 = part1;
        		top1 = "0";
        		bottom1 = "1";
        	}
        }
        if(part2.contains("_")) {
        	num2 = part2.substring(0, part2.indexOf("_"));
        	top2 = part2.substring(part2.indexOf("_") + 1, part2.indexOf("/"));
        	bottom2 = part2.substring(part2.indexOf("/") + 1);
        } else {
        	if(part2.contains("/")) {
	        	num2 = "0";
	        	top2 = part2.substring(0, part2.indexOf("/"));
	        	bottom2 = part2.substring(part2.indexOf("/") +1);
        	} else {
        		num2 = part2;
        		top2 = "0";
        		bottom2 = "1";
        	}
        }
        
        if(returntype == 2) {
        	return "whole:" + num2 + " numerator:" + top2 + " denominator:" + bottom2;
        }
        
        //get function type
        if(response[1].equals("+")) {
        	function = 0;
        }
        if(response[1].equals("-")) {
        	function = 1;
        }
        if(response[1].equals("*")) {
        	function = 2;
        }
        if(response[1].equals("-")) {
        	function = 3;
        }
        if(function == 4) {
        	//fail safe
        	return "FAILED";
        }
        
        //convert string to integer
        num1i = Integer.parseInt(num1);
        top1i = Integer.parseInt(top1);
        bottom1i = Integer.parseInt(bottom1);
        num2i = Integer.parseInt(num2);
        top2i = Integer.parseInt(top2);
        bottom2i = Integer.parseInt(bottom2);
        
        //end of function reached fail safe
        return "FAILED";
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
