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

		ArrayList<Integer> answer = new ArrayList<Integer>();
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

		printer();

	}
	
    @SuppressWarnings("unchecked")
	public static void partition(int n, int start, ArrayList<Integer> answer) {
        if (n == 0) {
            //System.out.println("hi " + answer);
           
            results.add((ArrayList<Integer>)answer.clone());
            //System.out.println("Bye: " + results);
            answer.clear();
            return;
        }
  
        for (int i = Math.min(n, start); i > 0; i--) {
        	answer.add(i);
        	
        	int sum = 0;
        	
        	for (int j = 0; j < answer.size(); j++) {
        		if (!(sum == start) || (sum + answer.get(j) <= start)) {
        			sum += answer.get(j);
        		}
        		
        	}
        	
            partition(n - i, i, answer);
        }
        //System.out.println("LOL: " + results);
    }

	/**
	 * clean printer method
	 * @param result - the gathered result list from the provided input
	 */
	public static void printer() {
		int length = 0;

		length = results.size();

		System.out.println("the results are:");

		for (int i = 0; i < length; i++) {
			System.out.print(i + ". ");

			System.out.println(results.get(i));
		}

	}

}
