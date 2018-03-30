

public class Project5 {

	public static void main(String[] args) {
		makechart("TAAGGTCA", "AACAGTTACC");

	}
	
	/**
	 * makechart builds the chart and direction then class the printer
	 * @param one - the first string of AGTC
	 * @param two - the second string of AGTC
	 */
	private static void makechart (String one, String two) {
		int maxrow = two.length() + 1;
		int maxcolum = one.length() + 1;
		int diagnal, right, down;

		String[][] direction = new String[maxrow][maxcolum];
		int[][] chart = new int[maxrow][maxcolum];
		
		for(int i = 0; i < maxrow; i++) {
			for(int j = 0; j < maxcolum; j++) {
				direction[i][j] = "";
			}
		}

		for(int j = one.length(); j >= 0; j--) {
			if (j == one.length()) {
				direction[two.length()][j] = " ";
				chart[two.length()][j] = 0;
			}
			else {
				direction[two.length()][j] = " ";
				chart[two.length()][j] = chart[two.length()][j + 1] + 2;
			}
		}

		for (int i = two.length(); i >= 0; i--) {
			if (i == two.length()) {
				continue;
			}
			else {
				direction[i][one.length()] = " ";
				chart[i][one.length()] = chart[i + 1][one.length()] + 2;
			}
		}

		//filling the chart backwards
		for (int i = two.length() - 1; i >= 0; i--)  {
			for(int j = one.length() - 1; j >= 0; j--) {
				right = chart[i][j + 1];
				down = chart[i + 1][j];
				diagnal = chart[i + 1][j + 1];

				int result = Math.min(Math.min(right,  down), diagnal);

				if(result == diagnal) {
					direction[i][j] += "\\";
				}

				if (result == down) {
					direction[i][j] += "|";
				}

				if (result == right) {
					direction[i][j] += ">";
				}

				if (one.charAt(j) == two.charAt(i)) {
					chart[i][j] = result;
				}
				else {
					chart[i][j] = result + 1;
				}
			}
		}
		output(chart, direction, one, two);
	}

	/**
	 * takes the solved table and prints it out into an organized chart
	 * @param chart - the weights of each move
	 * @param direction - a optimal direction to turn
	 * @param one - the original first string
	 * @param two - the original second string
	 */
	private static void output(int[][] chart, String[][] direction, String one, String two) {
		for (int i = 0; i < one.length(); i++) {
			System.out.printf("%6C", one.charAt(i));
		}
		System.out.printf("%6C\n", '-');

		for (int i = 0; i <= two.length(); i++) {
			if (i == two.length()) {
				System.out.printf("%-2C", '-');
			}
			else {
				System.out.printf("%-2C", two.charAt(i));
			}

			for (int j = 0; j <= one.length(); j++) {
				System.out.printf("%4d", chart[i][j]);
				System.out.printf("%3S", direction[i][j]);
			}
			System.out.println();
		}
	}
}
