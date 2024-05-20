package uk.co.ageas;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Requirement :
 * 1. Input is a string: "6521714069616518831033" (provided)
 * 2. Split the string into smaller 2 character strings i.e. ["65", "21", "71", "40", "69", "61", "65", "18", "83", "10", "33"]
 * 3. Remove every second element and convert the remaining elements to integer i.e. [65, 71, 69, 65, 83, 33]
 * 4. Convert integers to ascii character and return as a single string i.e. "AGEAS!"
 * <p>
 * Ensure that input string only contains digits from 0 to 9, throw exception if this is not the case
 * <p>
 * ====================================================
 * Please use Java 8 functional style where applicable
 */

public class Exercise1 {

    protected static String result(String input) {

        System.out.println("Input/Step1-->" + input);

        String result = "";

        // write your logic here...

        List<String> inputList = splitString(input, 2);
        result = simplifyList(inputList);
        return result;
    }

    private static String simplifyList(List<String> inputList) {
    	StringBuilder sb = new StringBuilder("");
    	
    	IntStream.range(0, inputList.size())
    	.filter(i -> i % 2 == 0)
        .mapToObj(inputList::get)
        .map(Integer::parseInt)
        .map(a -> (char) a.intValue())
        .forEach(t -> sb.append(t));
    	return sb.toString();
	}

	public static String input(String input){
        return result(input);
    }
    
    static List<String> splitString(String input, int num){
    	List<String> list = new LinkedList<String>();
    	if (input.matches("^[0-9]+$")) {
    		for (int i = 0 ; i < input.length(); i+=num) {
        		if (i+num > input.length()) {
        			list.add(input.substring(i, input.length()));
        		} else {
        			list.add(input.substring(i, i+num));
        		}
        	}
    	} else {
    		throw new InvalidParameterException("Only digits are allowed");
    	}
    	
    	return list;
    }
}