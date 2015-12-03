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
    
    static String num = "";
    static String top = "";
    static String bottom = "";
    public static String[] splitPart(String part) {
    	String[] output = new String[3];
        if(part.contains("_")) {
        	num = part.substring(0, part.indexOf("_"));
        	top = part.substring(part.indexOf("_") + 1, part.indexOf("/"));
        	bottom = part.substring(part.indexOf("/") + 1);
        } else {
        	if(part.contains("/")) {
	        	num = "0";
	        	top = part.substring(0, part.indexOf("/"));
	        	bottom = part.substring(part.indexOf("/") +1);
        	} else {
        		num = part;
        		top= "0";
        		bottom = "1";
        	}
        }
        output[0] = num;
        output[1] = top;
        output[2] = bottom;
        return output;
    }
    
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String part1 = "";
    	String part2 = "";
    	int function = 4; //0 = +; 1 = -; 2 = *; 3 = /;
    	int returntype = 3;
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
        int numOut;
        int topOut;
        int bottomOut;
        boolean is1Neg;
        boolean is2Neg;
        
        String output = "";
        
        //split into parts
        String[] response = input.split(" ");
        part1 = response[0];
        part2 = response[2];
                
        if(returntype == 1) {
        	return part2;
        }
        
        //split into each number
        String[] partA = splitPart(part1);
        String[] partB = splitPart(part2);
        num1 = partA[0];
        top1 = partA[1];
        bottom1 = partA[2];
        num2 = partB[0];
        top2 = partB[1];
        bottom2 = partB[2];
        
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
        if(num1.contains("-") || top1.contains("-")) {
        	is1Neg = true;
        } else {
        	is1Neg = false;
        }
        if(num2.contains("-") || top2.contains("-")) {
        	is2Neg = true;
        } else {
        	is2Neg = false;
        }
        
        //convert string to integer
        num1i = Integer.parseInt(num1);
        top1i = Integer.parseInt(top1);
        bottom1i = Integer.parseInt(bottom1);
        num2i = Integer.parseInt(num2);
        top2i = Integer.parseInt(top2);
        bottom2i = Integer.parseInt(bottom2);
        
        System.out.println(num1i);
        System.out.println(top1i);
        System.out.println(bottom1i);
        System.out.println(is1Neg);
        System.out.println(num2i);
        System.out.println(top2i);
        System.out.println(bottom2i);
        System.out.println(is2Neg);
        
        numOut = 0;
        topOut = 0;
        bottomOut = 0;
        if(function == 0) {
        	//addition
        	if(num1i != 0 && num2i != 0) {
        		numOut = num1i + num2i;
        	}
        	if(bottom1i == bottom2i && is1Neg == false && is2Neg == false) {
        		topOut = top1i + top2i;
        		bottomOut = bottom1i;
        	}
        }
        
        System.out.println(numOut + "_" + topOut + "/" + bottomOut);
        
        //end of function reached fail safe
        return "FAILED";
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
