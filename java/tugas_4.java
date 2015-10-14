import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This program counts and shows the result of Modular Exponentiation.
 * 
 * @Title Modular Exponentiation
 * @author Azady Bayu, ID : 1406543675
 * @version 1.2
 * @since 14/10/2015
 */

public class tugas_4 {
	
	/**
	 * Main method to run the program.
	 */
	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		
		String forLoop = input.nextLine();
		
		int loopLimit = Integer.parseInt(forLoop);
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		/**
		 *  The first line of input is to determine how much number will be given by the user.
		 *  The results will be shown after the user inputs all number. 
		 */
		for(int i = 0; i < loopLimit; i++) {
			
			String data = input.nextLine();
			
			String[] data2 = data.split(" ");
			
			int number = Integer.parseInt(data2[0]);
			
			int power = Integer.parseInt(data2[1]);
			
			int modular = Integer.parseInt(data2[2]);
			
			int result = exponentialModular(number, power, modular);
			
			results.add(result);
			
		}
		
		for(int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
		
	}

	/**
	 * 
	 * Finds the powered number value, and modulo it.
	 * 
	 * @param number 		The base number
	 * @param basePower		The number's power
	 * @param modular		The number for modulo operation
	 * @return The powered number after modulo operation
	 */
	private static int exponentialModular(int number, int basePower, int modular) {

		double result = 1;
		
		int poweredNumber = number;
		
		while(basePower > 0) {
			
			if(basePower % 2 == 1) {
				result = ((result % modular) * poweredNumber) % modular;
			}
			
			poweredNumber = ((int) Math.pow(poweredNumber, 2) % modular);
			
			basePower = basePower/2;
			
		}
		
		return (int) result;

	}

}

