import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This program counts and shows the factor of a given number.
 * 
 * @Title Factorization
 * @author Azady Bayu, ID : 1406543675
 * @version 1.0
 * @since 14/10/2015
 */

public class Tugas_1 {

	/**
	 * Main method to run the program.
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> listOfFactors; 
		
		ArrayList<String> factorGenerator;
		
		ArrayList<String> results = new ArrayList<String>();
		
		String forLoop = input.nextLine();
		
		int loopLimit = Integer.parseInt(forLoop);	
		
		/**
		 *  The first line of input is to determine how much number will be given by the user.
		 *  The results will be shown after the user inputs all number. 
		 */
		for(int loop = 0; loop < loopLimit; loop++) {
		
			listOfFactors = new ArrayList<Integer>();
			
			factorGenerator = new ArrayList<String>();
		
			String input2 = input.nextLine();
		
			int number = Integer.parseInt(input2);
		
			isPrime(number, listOfFactors);
					
			if(listOfFactors.size() <= 1) {
				
				results.add("Prima");
				
			}
		
			else {
				
				generateFactor(listOfFactors, factorGenerator);
				
				collectResults(factorGenerator, results);
				
			}
		}
		
		for(int z = 0; z < results.size(); z++) {
			System.out.println(results.get(z));
		}
		
	}

	
	/**
	 * This method finds and collects the factor's of a given number by using modulo operation into the number
	 * with integer number from 2 to its root. A number is considered a factor of another number if the result
	 * of the modulo operation is zero.
	 * 
	 * @param number 		Is the number which we want to find its factors are.
	 * @param listOfFactors	ADT to store the number's factors
	 */
	private static void isPrime(int number, ArrayList<Integer> listOfFactors) {
		
		int root = (int) Math.sqrt(number);
		
		int checkedNumber = number;
		
		for(int i = 2; i <= root;) {
			if(checkedNumber % i == 0) {
				listOfFactors.add(i);
				checkedNumber = checkedNumber / i;
			}
			else {
				i++;
			}
		}
		
		if(checkedNumber != 1)
			listOfFactors.add(checkedNumber);
	}
	
	/**
	 * This method counts the power of the factor of a number, and changes it to power form in case there are some same 
	 * number acting as a factor.
	 * 
	 * Example : 20 has 2, 2 and 5
	 * This method changes said number into 2^2 and 5
	 * 
	 * @param listOfFactors		Collected factors of a number
	 * @param factorGenerator	ADT to store the "new version" of the factors
	 */
	private static void generateFactor(ArrayList<Integer> listOfFactors, ArrayList<String> factorGenerator) {
		int power = 0;
		
		int currentNumber;
		
		for(int i = 0; i < listOfFactors.size();) {
			
			currentNumber = listOfFactors.get(i);
			
			for(int a = 0; a < listOfFactors.size(); a++) {
				
				if(currentNumber == listOfFactors.get(a)) {
					power++;
				}
				
			}
			
			if(power == 1) {
				factorGenerator.add(currentNumber + "");
				i++;
			}
			else {
				factorGenerator.add(currentNumber + "^" + power);
				i = i + power;
			}
			
			power = 0;
			
		}
	}
	
	/**
	 * 
	 * This method changes the modified factors of the number into String form
	 * 
	 * Example : 20 has 2^2, and 5 as its factors
	 * 
	 * This method changes it into 2^2 x 5 into String form.
	 * 
	 * @param factorGenerator	Modified, power form of the factors
	 * @param results			The Prime Factorization of a number in String form	
	 */
	private static void collectResults(ArrayList<String> factorGenerator, ArrayList<String> results) {
		
		String temp = "";
		
		for(int j = 0; j < factorGenerator.size(); j++) {
			
			if(j == 0) {
				temp = temp + factorGenerator.get(j);
			} else {
				temp = temp + " * " + factorGenerator.get(j);
			}
		
		}
		
		results.add(temp);
		
	}
	
}

