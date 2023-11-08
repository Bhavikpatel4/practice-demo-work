package demo.dsa;

public class NumberPatternDemo {
	
	public static void main(String[] args) {
		numberProblem1(5);
	}
	
	
//	print 100 in column of nth
//	ex : n=5
//	output:1 2 3 4 5
//		   10 9 8 7 6
//		   11 12 13 14 15
//		   ...100
	public static void numberProblem1(int n) {
		int[][] matrix = new int[100/n][n];
        int num = 1;

        for (int i = 0; i < 100/n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = num;
                    num++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[i][j] = num;
                    num++;
                }
            }
        }

        for (int i = 0; i < 100/n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
	}
}
