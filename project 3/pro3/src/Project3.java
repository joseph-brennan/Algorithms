import java.util.*;

/**
 * Project 3
 * 
 * @author Joey Brennan
 *
 */
public class Project3 {

	public static void main(String[] args) {
		int[] listNumbers = { 3, 1, 7, 5, 8, 4 };
		System.out.println("Max value pick up by player1 " + solve(listNumbers));

	}

	private int optimalSolution(int first, int last) {
		int score = 0;

		return score;
	}

	public static int solve(int[] listNumbers) {
		int[][] maxValue = new int[listNumbers.length][listNumbers.length];

		for (int interval = 0; interval < listNumbers.length; interval++) {
			for (int i = 0, j = interval; j < listNumbers.length; i++, j++) {
				/*
				 * a = maxValue(i+2,j) - player1 chooses i player2 chooses i+1
				 * b = maxValue(i+1,j-1)- player1 chooses i , player2 chooses j OR 
				 *  player1 chooses j , player2 chooses i
				 * c = maxValue(i,j-2)- player1e chooses j , player2 chooses j-1 
				 */

				int a, b, c;
				if (i + 2 <= j)
					a = maxValue[i + 2][j];
				else
					a = 0;
				// *********************************************************
				if (i + 1 <= j - 1)
					b = maxValue[i + 1][j - 1];
				else
					b = 0;
				// ********************************************************
				if (i <= j - 2)
					c = maxValue[i][j - 2];
				else
					c = 0;
				// ********************************************************
				maxValue[i][j] = Math.max(listNumbers[i] + Math.min(a, b), listNumbers[j] + Math.min(b, c));

			}
		}
		for (int i = 0; i < maxValue.length; i++) {
			for (int j = 0; j < maxValue.length; j++) {
				
				if (i == j || i == maxValue.length - 1 || j == 0) {
					
					if (maxValue[i][j] == 0) {
					
						System.out.printf("%4S","XX |");
						
					} else {
						
						System.out.printf("%2d%2S", maxValue[i][j], "F|");
					}

				} else {
					if (maxValue[i][j] == 0) {
						System.out.printf("%4S", "XX |");
						
					} else {
						int scoreToLeft = maxValue[i][j - 1];
						
						int scoreBelow = maxValue[i + 1][j];
						
						if (scoreBelow < scoreToLeft) {
							
							System.out.printf("%2d%2S", maxValue[i][j], "F|");
						
						} else {
							
							System.out.printf("%2d%2S", maxValue[i][j], "L|");
						}
					}
				}

			}
			System.out.println();
		}
		return maxValue[0][listNumbers.length - 1];
	}
}
