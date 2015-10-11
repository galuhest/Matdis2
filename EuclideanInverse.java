import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EuclideanInverse {
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
			 *Menyimpan input yang asli 
			 */
			int Ai = source;
			int Mi = target;
			
			/*
			 * Swap posisi jika Ai lebih kecil dari Mi
			 */
			if (source < target) {
				source = target;
				target = Ai;
			}
			/*
			 * Index 0 stores GCD 
			 * Index 1 stores prev Y 
			 * Index 2 stores before-prev Y 
			 * Index 3 stores prev quotient 
			 * Index 4 stores number of steps needed to compute the GCD 
			 */
			int[] result = { 0, 1, 0, 0, 0 };

			/*
			 * Menggunakan yang telah di swap(jika swap)
			 */
			result = euclidR(source, target, result);

			int inverse = result[1] * result[3] + result[2];
			/*
			 * Menggunakan yang asli
			 */
			if ((inverse * Ai) - (result[1] * Mi) < 0)
				inverse = -inverse;
			System.out.println(inverse);
		}
	}

	/**
	 * 
	 * @param source angka pertama
	 * @param target angka kedua
	 * @param result array input (detail posisi diatas)
	 * @return array hasil
	 */
	public static int[] euclidR(int source, int target, int[] result) {
		/*
		 * Menyimpan data yang dibutuhkan
		 */
		int quotient = source / target;
		int remainder = source % target;
		int[] container = result;
		/*
		 * Jika hasil mod 0, maka sisa sebelumnya adalah GCD
		 */
		if (remainder == 0) {
			container[0] = target;
			container[3] = quotient;
			return container;
		}
		/*
		 * update container
		 */
		container = euclidR(target, remainder, result);
		/*
		 * update steps
		 */
		container[4] += 1;

		/*
		 * jika step belum melebihi 1 (mulai dari 0) maka menggunakan nilai default
		 */
		if (container[4] < 2) {
			container[3] = quotient;
			return container;
		}
		/*
		 * Mengisikan index 1 dengan nilai baru,
		 * index 2 diisi nilai sebelumnya
		 * index 3 diisi hasil pembagian sekarang
		 */
		int temp = container[1];
		container[1] = container[1] * container[3] + container[2];
		container[2] = temp;
		container[3] = quotient;
		return container;
	}
}
