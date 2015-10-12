import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Galuh Estya A.
 * @npm 1406559036
 * @ver 1.0
 *
 */
public class EuclideanGCD {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int iterator = Integer.parseInt(reader.readLine());
		int source = 0;
		int target = 0;
		String[] input = null;
		
		/*
		 * Looping input
		 */
		for (int i = 0; i < iterator; i++) {
			input = reader.readLine().split(" ");
			source = Integer.parseInt(input[0]);
			target = Integer.parseInt(input[1]);

			/*
			 * If one of the input is Zero, terminate the program
			 */
			if (source == 0 || target == 0) {
				System.out.println("One of the input is Zero.");
				System.out.println("Terminating Program.");
				System.exit(0);
			}

			/*
			 * Swap position if first number is smaller than second number
			 */
			if (source < target) {
				int cont = source;
				source = target;
				target = cont;
			}

			/*
			 * Index 0 stores GCD 
			 * Index 1 stores prev Y 
			 * index 2 stores before-prev Y 
			 * Index 3 stores prev quotient 
			 * Index 4 stores number of steps needed to compute the GCD
			 */
			int result = 0;
			
			result = euclidR(source, target, result);
			int lcm = (source * target / result);
			System.out.println(result + " " + lcm);


		}
	}

	/**
	 * 
	 * @param source first number (must be bigger than target)
	 * @param target second number
	 * @param result GCD
	 * @return GCD
	 */
	public static int euclidR(int source, int target, int result) {
		int quotient = source / target;
		int remainder = source % target;
		if (remainder == 0) {
			return target;
		}
		return euclidR(target,remainder,result);
	}
}
