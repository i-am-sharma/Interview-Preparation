/* Given a grid of numbers, find maximum length Snake sequence and print it. If multiple snake sequences exists with the maximum 
length, print any one of them.

A snake sequence is made up of adjacent numbers in the grid such that for each number, the number on the right or the number 
below it is +1 or -1 its value. For example, if you are at location (x, y) in the grid, you can either move right i.e. (x, y+1) 
if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.*/

// Code by @shivshar
import java.util.*;
public class maximumLengthSnakeSequence {
    
    public static int  maxLengthSnakeSequence (int[][] arr, int n, int m){
        int[][] dp = new int [n][m];
        // fill zero in dp array
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                dp[i][j] = 0;
            }
        }

        int max_inner = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (i-1 >=0 && (Math.abs(arr[i][j] - arr[i-1][j]) == 1)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
                }
                if (j-1 >= 0 && (Math.abs(arr[i][j] - arr[i][j-1]) == 1)){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
                }
                if (dp[i][j] > max_inner) max_inner = dp[i][j];
            }
        }
        return max_inner;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int [n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximum Length of Snake sequence is " + maxLengthSnakeSequence(arr, n, m));
        sc.close();
    }    
}

// Time Complexity - O(NM);
// Space Complexity - O(NM);
// We can reduce the space to O(N) also;
// Use backtracking to also print the sequence;

