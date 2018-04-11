import java.util.Scanner;

/**
 * Project 4
 * @author Joey Brennan
 *
 */
public class Floyd {
	private static int[][] currentPath;
	private static int totalVertices;

	// Hard-coded table for testing
	private static int[][] distanceTable;
	//      = {
	// 		{0, 1, -1, 1, 5},
	// 		{9, 0, 3, 2, -1},
	// 		{-1, -1, 0, 4, -1},
	// 		{-1, -1, 2, 0, 3},
	// 		{3, -1, -1, -1, 0}};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many vertices are there? ");
		
		totalVertices = scan.nextInt();
		
//		totalVertices = 5;
		currentPath = new int[totalVertices][totalVertices];
		
		distanceTable = new int[totalVertices][totalVertices];
		
		for (int i = 0; i < totalVertices; i++) {
			
			System.out.println("Input the row weights seperate by spaces: ");
			
			for(int j = 0; j < totalVertices; j++) {
				
				distanceTable[i][j] = scan.nextInt();
			}
		}
		
		floydsSolution();
		
		scan.close();
	}

	/**
	 * Floyds' Algorithm
	 */
	private static void floydsSolution() {
		// Print initial table
		System.out.printf(
				"---------------------------- D(0) ----------------------------\n");
		print();
		System.out.printf(
				"--------------------------------------------------------------\n");

		/**
		 * k = iteration i = row j = column
		 */
		for (int k = 0; k < totalVertices; k++) {
			for (int i = 0; i < totalVertices; i++) {
				for (int j = 0; j < totalVertices; j++) {

					if ((distanceTable[i][j] > (distanceTable[i][k] + distanceTable[k][j])
							|| distanceTable[i][j] < 0)
							&& distanceTable[k][j] > 0
							&& distanceTable[i][k] > 0) {

						distanceTable[i][j] = distanceTable[i][k] + distanceTable[k][j];

						currentPath[i][j] = k + 1;
					}
				}
			}
			System.out.print(
					"\n---------------------------- D(" + (k + 1)
					+ ") ----------------------------\n");
			print();
			System.out.print(
					"--------------------------------------------------------------\n");
		}
	}

	/**
	 * Output the current iteration except for K = 0
	 */
	private static void print() {

		for (int i = 0; i < distanceTable.length
					 && i < currentPath.length; i++) {

			System.out.print("||  ");

			for (int k = 0; k < distanceTable[i].length
					     && k < currentPath[i].length; k++) {

				if (distanceTable[i][k] == -1) {

					System.out.printf("-  (%d)", currentPath[i][k]);
				}

				else {

					System.out.printf("%-3d(%d)", distanceTable[i][k], currentPath[i][k]);
				}

				System.out.print("  ||  ");
			}

			System.out.println();
		}
	}

}
