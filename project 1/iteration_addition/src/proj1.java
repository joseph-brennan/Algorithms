import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project one
 * @author Joey Brennan
 *
 */
public class proj1 {
	static List<ArrayList<Integer>> results;// = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = 0;

		String answer = "";
		results = new ArrayList<ArrayList<Integer>>();
		
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

		partition(n, n, answer);

	}
	// I don't quite understand why this works using min while mine grabs extra using the same logic
	// the ideas was given to me in the cs lab
	// which seems to work for baced on the first half of my orginal attempt
	public static void partition(int n, int start, String answer) {
		if (n == 0) {           
			System.out.println(answer);

            return;
        }
  
        for (int i = Math.min(start, n); i >= 1; i--) {
        	
            partition(n - i, i, answer + " " + i);
        }
    }
/*
	public static void partition(int working, int start, String answer) {
		if (working == 0) {           
			System.out.println(answer);

            return;
        }
  
        for (int i = working; i >= 1; i--) {
        	if (working < i + working) {
        		partition(working - i, i, answer + " " + i);
        	} else {
        		partiton(working, i, answer);
        	}
        }
	}
*/

}
