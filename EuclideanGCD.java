import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			int[] result = { 0, 1, 0, 0, 0 };
			
			result = euclidR(source, target, result);
			
			System.out.println("GCD :" + result[0]);

			System.out.println("LCM :" + (source * target / result[0]));

			int inverse = result[1] * result[3] + result[2];
			// System.out.println("cont1 :" + result[1]);
			// System.out.println("cont2 :" + result[2]);
			// System.out.println("last quotient :" + result[3]);
			// System.out.println("number of steps :" + result[4]);
			System.out.println("Inverse : +/-" + inverse);
		}
	}

	public static int[] euclidR(int source, int target, int[] result) {
		int quotient = source / target;
		int remainder = source % target;
		int[] container = result;
		if (remainder == 0) {
			container[0] = target;
			container[3] = quotient;
			return container;
		}
		container = euclidR(target, remainder, result);

		container[4] += 1;

		if (container[4] < 2) {
			container[3] = quotient;
			return container;
		}
		int temp = container[1];
		container[1] = container[1] * container[3] + container[2];
		container[2] = temp;
		container[3] = quotient;
		return container;
	}
}
