/* Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]. 
We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain. */

import java.util.*;

public class matrixChainMultiplication {

    public static int[][] ans;
    public static int mtxChainMultiplication (int[] arr, int i, int j){
        // Base Condition
        if (i >= j) return 0;

        if(ans[i][j] != -1) return ans[i][j];

        int min = Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){
            int num = mtxChainMultiplication (arr, i, k) + mtxChainMultiplication (arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
            if (num < min) min = num;
        }
        return ans[i][j] = min;
    }
	public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        
        // testcases
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            // array size
            int N = sc.nextInt();
            
            // declare ans array
            ans = new int[N+1][N+1];

            // fill this 2D array with -1
            for(int k=0; k<=N; k++){
                for(int j=0; j<=N; j++){
                    ans[k][j] = -1;
                }
            }

            int[] arr = new int [N];
            for(int j=0; j<N; j++){
                arr[j] = sc.nextInt();
            }

            int start = 1;
            int end = N-1;
            System.out.println (mtxChainMultiplication(arr, start, end));

        }

        sc.close();

	}
}
