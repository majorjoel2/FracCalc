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
    
    public static int GCF(int num, int den) {
    	while (den > 0)
        {
            int temp = den;
            den = num % den;
            num = temp;
        }
        return num;
    }
    
    public static int[] reduceFraction(int num, int den){
        int gcf = GCF(num, den); //greatest common factor
        int[] rf = {num/gcf, den/gcf};
        return rf;
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
        if(response[1].equals("/")) {
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
        
/*        System.out.println(num1i);
        System.out.println(top1i);
        System.out.println(bottom1i);
        System.out.println(is1Neg);
        System.out.println(num2i);
        System.out.println(top2i);
        System.out.println(bottom2i);
        System.out.println(is2Neg);*/
        
        numOut = 0;
        topOut = 0;
        bottomOut = 0;
        if(function == 0) {
        	//addition
        	if((top1i != 0 && top2i != 0) || (top1i == 0 && top2i == 0) || num1i == 0 || num2i == 0) {
        		numOut = num1i + num2i;
        	} else {
        		numOut = 0;
        		if(is1Neg == false) {
        			top1i = num1i*bottom1i - top1i;
        		} else {
        			top1i += num1i*bottom1i;
        		}
        		if(is1Neg == false) {
        			top2i = num2i*bottom2i - top2i;
        		} else {
        			top2i += num2i*bottom2i;
        		}
        	}
        	boolean omit1 = false;
        	if(bottom1i == 1 && bottom2i != 1) {
        		top1i = top1i*bottom2i;
        		bottom1i = bottom2i;
        		omit1 = true;
        	} else {
	        	if(bottom1i != 1 && bottom2i == 1) {
	        		top2i = top2i*bottom1i;
	        		bottom2i = bottom1i;
	        		omit1 = true;
	        	}
        	}
        	if(bottom1i == bottom2i) {
        		if(omit1 == false && is1Neg == true && (top1.contains("-") == false)) {
        			top1i -= top1i*2;
        		}
        		if(omit1 == false && is2Neg == true && (top2.contains("-") == false)) {
        			top2i -= top2i*2;
        		}
        		topOut = top1i + top2i;
        		bottomOut = bottom1i;
        	}
        	if(bottom1i != bottom2i) {
        		top1i = top1i*bottom2i;
        		top2i = top2i*bottom1i;
        		bottomOut = bottom1i*bottom2i;
        		if(omit1 == false && is1Neg == true && (top1.contains("-") == false)) {
        			top1i -= top1i*2;
        		}
        		if(omit1 == false && is2Neg == true && (top2.contains("-") == false)) {
        			top2i -= top2i*2;
        		}
        		topOut = top1i + top2i;
        	}
        	
        	while(topOut <= -bottomOut) {
        		topOut += bottomOut;
        		numOut--;
        	}
        	if(topOut < 0) {
        		topOut -= topOut*2;
        	}
        	while(topOut >= bottomOut) {
        		topOut -= bottomOut;
        		numOut++;
        	}
        }
        
        if(function == 1) {
        	//subtraction
        	if((top1i != 0 && top2i != 0) || (top1i == 0 && top2i == 0) || num1i == 0 || num2i == 0) {
        		numOut = num1i - num2i;
        	} else {
        		numOut = 0;
        		if(is1Neg == false) {
        			top1i = num1i*bottom1i - top1i;
        		} else {
        			top1i += num1i*bottom1i;
        		}
        		if(is1Neg == false) {
        			top2i = num2i*bottom2i - top2i;
        		} else {
        			top2i += num2i*bottom2i;
        		}
        	}
        	boolean omit1 = false;
        	if(bottom1i == 1 && bottom2i != 1) {
        		top1i = top1i*bottom2i;
        		bottom1i = bottom2i;
        		omit1 = true;
        	} else {
	        	if(bottom1i != 1 && bottom2i == 1) {
	        		top2i = top2i*bottom1i;
	        		bottom2i = bottom1i;
	        		omit1 = true;
	        	}
        	}
        	if(bottom1i == bottom2i) {
        		if(omit1 == false && is1Neg == true && (top1.contains("-") == false)) {
        			top1i -= top1i*2;
        		}
        		if(omit1 == false && is2Neg == true && (top2.contains("-") == false)) {
        			top2i -= top2i*2;
        		}
        		topOut = top1i - top2i;
        		bottomOut = bottom1i;
        	}
        	if(bottom1i != bottom2i) {
        		top1i = top1i*bottom2i;
        		top2i = top2i*bottom1i;
        		bottomOut = bottom1i*bottom2i;
        		if(omit1 == false && is1Neg == true && (top1.contains("-") == false)) {
        			top1i -= top1i*2;
        		}
        		if(omit1 == false && is2Neg == true && (top2.contains("-") == false)) {
        			top2i -= top2i*2;
        		}
        		topOut = top1i - top2i;
        	}
        	
        	if(topOut > 0 && numOut < 0) {
        		numOut++;
        		topOut = Math.abs(topOut);
        		topOut -= bottomOut;
        	}
        	while(topOut <= -bottomOut) {
        		topOut += bottomOut;
        		numOut--;
        	}
        	if(topOut < 0 && numOut != 0) {
        		topOut = Math.abs(topOut);
        	}
        	while(topOut >= bottomOut) {
        		topOut -= bottomOut;
        		numOut++;
        	}
        }
        
        if(function == 2) {
        	//multiplication
        	if(is1Neg == false) {
        		top1i = num1i * bottom1i + top1i;
        	}
        	if(is1Neg == true) {
        		top1i = num1i * bottom1i - Math.abs(top1i);
        	}
        	if(is2Neg == false) {
        		top2i = num2i * bottom2i + top2i;
        	}
        	if(is2Neg == true) {
        		top2i = num2i * bottom2i - Math.abs(top2i);
        	}
        	numOut = 0;
        	topOut = top1i * top2i;
        	bottomOut = bottom1i * bottom2i;
        	
        	while(topOut <= -bottomOut) {
        		topOut += bottomOut;
        		numOut--;
        	}
        	if(topOut < 0) {
        		topOut -= topOut*2;
        	}
        	while(topOut >= bottomOut) {
        		topOut -= bottomOut;
        		numOut++;
        	}
        }
        
        if(function == 3) {
        	//division
        	if(is1Neg == false) {
        		top1i = num1i * bottom1i + top1i;
        	}
        	if(is1Neg == true) {
        		top1i = num1i * bottom1i - Math.abs(top1i);
        	}
        	if(is2Neg == false) {
        		top2i = num2i * bottom2i + top2i;
        	}
        	if(is2Neg == true) {
        		top2i = num2i * bottom2i - Math.abs(top2i);
        	}
        	numOut = 0;
        	topOut = top1i * bottom2i;
        	bottomOut = bottom1i * top2i;
    
        	if(Math.abs(topOut) == 0 || Math.abs(bottomOut) == 0) {
        		numOut = 0;
        		topOut = 0;
        		bottomOut = 1;
        	}
        	
        	if(topOut < 0 && bottomOut < 0) {
        		topOut = Math.abs(topOut);
        		bottomOut = Math.abs(bottomOut);
        	}
        	if(bottomOut < 0 && topOut > 0) {
        		topOut -= topOut * 2;
        		bottomOut = Math.abs(bottomOut);
        	}
        	
        	while(topOut <= -bottomOut) {
        		topOut += bottomOut;
        		numOut--;
        	}
        	if(topOut < 0 && numOut != 0) {
        		topOut = Math.abs(topOut);
        	}
        	while(topOut >= bottomOut) {
        		topOut -= bottomOut;
        		numOut++;
        	}
        }
        
        //reduce
        boolean isNeg = false;
        if(topOut < 0) {
        	isNeg = true;
        }
        int[] fraction = new int[2];
        fraction = reduceFraction(Math.abs(topOut), bottomOut);
        if(isNeg == false) {
        	topOut = fraction[0];
        } else {
        	topOut = -fraction[0];
        }
        bottomOut = fraction[1];
        
        if(returntype == 3) {
        	if(numOut == 0 && topOut != 0) {
        		return topOut + "/" + bottomOut;
        	}
        	if(numOut != 0) {
        		if(topOut == 0) {
        			return "" + numOut;
        		} else {
        			return numOut + "_" + topOut + "/" + bottomOut;
        		}
        	}
        	return "" + numOut;
        }
        
        //end of function reached fail safe
        return "FAILED";
    }
    // TODO: Fill in the space below with any helper methods that you think you will need   
}
