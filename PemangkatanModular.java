import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author user
 *
 */
public class PemangkatanModular {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		int input = Integer.parseInt(read.readLine());
		int base = 0;
		int power = 0;
		int mod = 0;
		for (int i = 0; i < input; i++) {
			StringTokenizer token = new StringTokenizer(read.readLine());
			
			base = Integer.parseInt(token.nextToken());
			power = Integer.parseInt(token.nextToken());
			mod = Integer.parseInt(token.nextToken());
			
			System.out.println(modularExponentiation(base, power, mod));
		}
	}

	/**
	 * 
	 * @param base base number
	 * @param power exponent
	 * @param mod mod value
	 * @return base^power % value
	 */
	public static int modularExponentiation(int base, int power, int mod) {
		int result = 1;
		int new_base = base;
		int exp = power;
		int binary_value = power;
		while (exp > 0) {
			binary_value = exp & 1;
			if(binary_value==1) {
				result = (result*new_base) % mod;
			}
			new_base =(int) Math.pow(new_base, 2) % mod;
			exp = exp / 2;
		}
		return result;
	}
}
