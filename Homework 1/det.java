import java.util.Scanner;

public class det {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if (n >= 1 && n <= 10){
        double[][] matrix = new double[n][n];
        int flag = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = scn.nextDouble();
                if (matrix[i][j] < -100 || matrix[i][j] > 100){
                    flag = 1;
                }
            }
        }
        
        if (flag == 0){
            System.out.printf("%.2f", determinent(matrix, n));
        }
        
        }
    }
    public static double determinent(double[][] matrix, int n){
        
       
        if (n == 1){
            return matrix[0][0];
        }
        
        if (n == 2){
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }

        else{
            double det = 0;
            double[][] detmatrix = new double[n-1][n-1];
            for (int i=0; i<n; i++){
                for (int j=1; j<n; j++){
                    int detmatrixcolumn = 0;
                    for (int k=0; k<n; k++){
                        if (k != i){
                            detmatrix[j-1][detmatrixcolumn] = matrix[j][k];
                            detmatrixcolumn += 1;
                        }

                    }
                }

            det += matrix[0][i]*determinent(detmatrix, n-1)*Math.pow(-1, i);

                
                
            }
            return det;
        }


        }
}
