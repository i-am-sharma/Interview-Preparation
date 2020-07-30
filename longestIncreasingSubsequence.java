/* find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.*/

// Code by @shivshar
import java.util.*;

public class longestIncreasingSubsequence {
    
    public static int LIS (int[] arr, int N){
        // DP approach
        int max = Integer.MIN_VALUE;
        int dp[] = new int [N];

        // Initializing DP array by default value:
        for (int i=0; i<N; i++){
            dp[i] = 1;
        }

        for (int j=1; j<N; j++){
            for (int i=0; i<j; i++){
                if(arr[j] > arr[i]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            // Tracing the maximum length:
            if (dp[j] > max) max = dp[j];
        }

        return max;
    }
    
    public static void main (String[] args) {
        //testcases
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            //array size
            int N = sc.nextInt();
            int[] arr = new int [N];

            for (int j = 0; j<N; j++){
                arr[j] = sc.nextInt();
            }

            System.out.println("Longest Increasing Subsequence is " + LIS(arr, N));
        }
        
        sc.close();

    }
}

// Time complexity - O(N^2)
// Space complexity - O(N)