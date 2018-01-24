import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project one
 * @author Joey Brennan
 *
 */
public class proj1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = 0;

		ArrayList<String> result = new ArrayList<String>();
		
		//No command input ask for input
		if (args.length == 0) {
			System.out.println("Input an n value: ");

			while (!scan.hasNextInt()) {
				System.out.println("Incorret, please enter an integer.");

				scan.next();
			}

			n = scan.nextInt();
		
		  //Command input perform check
		} else if (args.length > 0) {

			try {

				n = Integer.parseInt(args[0]);

			} catch (NumberFormatException e) {

				System.out.println("Read input is not an integer.");

				System.exit(1);
			}
			
		  //Shouldn't ever get here
		} else {
			System.out.println("How did it get here?");

			System.exit(1);
		}

		result = algorithm(n, n, 0, result);

		printer(result);

	}
	
	/**
	 * Algorithm method first attempt using recursion.
	 * @param start - input value from user
	 * @param half_count - should only need to check half the numbers to get complete result list
	 * @param count - starts at zero and is used for the other half
	 * @param result - Array list of results
	 * @return - returns the result or null if failure
	 */
	public static ArrayList<String> algorithm(int start, int half_count, int count, ArrayList<String> result) {
		String solution = "";

		if (half_count == start / 2) {

			return result;

		} else if (half_count == start) {
			solution = Integer.toString(start) + " + " + Integer.toString(count);

			result.add(solution);

			algorithm(start, half_count--, count++, result);
			
		}else {
			if (half_count + count == start) {
				solution = Integer.toString(half_count) + " + " + Integer.toString(count);
			
			} else if () {
				
			}
			
			algorithm(start, half_count--, count++, result);
		}

		return null;
	}
	
	/**
	 * clean printer method
	 * @param result - the gathered result list from the provided input
	 */
	public static void printer(ArrayList<String> result) {
		int length = 0;

		length = result.size();

		System.out.println("the results are:");

		for (int i = 0; i < length; i++) {

			System.out.println(result.get(i));
		}

	}

}
