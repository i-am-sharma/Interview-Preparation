/* Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
such that the integers in the subsequence are sorted in increasing order. */

// Code by @shivshar
import java.util.*;

public class maximumSumIncreasingSubsequence {

    public static int maxSumIncreasingSubsequence (int[] arr, int N){
        int[] dp = new int [N];
        
        
        for (int i=0; i<N; i++){
            dp[i] = arr[i];
        }

        int max = dp[0];

        for (int j=1; j<N; j++){
            for (int i=0; i<j; i++){
                if (arr[j] > arr[i]){
                    dp[j] = Math.max(dp[j], arr[j] + dp[i]);
                }
            }
            if(max < dp[j]) max = dp[j];
        }
        return max;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        //testcases;
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int arr[] = new int [N];

            for (int j=0; j<N; j++){
                arr[j] = sc.nextInt();
            }

            System.out.println(maxSumIncreasingSubsequence (arr, N));
        }
        sc.close();
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)


