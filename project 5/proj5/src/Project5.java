

public class Project5 {

	public static void main(String[] args) {
		makechart("TAAGGTCA", "AACAGTTACC");

	}

	private static void makechart (String one, String two) {
		int maxrow = two.length() + 1;
		int maxcolum = one.length() + 1;
		
		int[][] chart = new int[maxrow][maxcolum];

		//filling the chart backwards
		for (int i = two.length(); i >= 0; i --)  {
			for(int j = one.length(); j >= 0; j --) {

				if (i == two.length()) {
					if (j == one.length()) {

						chart[i][j] = 0;

					}
					else {
						chart[i][j] = chart[i][j + 1] + 2;
					}
				}
				
			}
		}
		for (int i = 0; i <= two.length(); i++) {
			System.out.printf("%4S%-3d","row", i);

			for (int j = 0; j <= one.length(); j++) {
				System.out.printf("%-4d", chart[i][j]);
			}
			System.out.println();
		}
	}

}
