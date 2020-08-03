/* Given a sequence, find the length of the longest palindromic subsequence in it. Also print the sequence */

// Code by @shivshar
import java.util.*;
public class longestPalindromicSubsequence {
    public static int LPS (String s1, String s2, int n){
         // create dp array
        int[][] dp = new int [n+1][n+1];

        // fill 1st row and col with zero
        for (int i=0; i<=n; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        String s1 = sc.next();
        // variant of LCS. Second string will be reverse of s1
        String s2 = "";
        int n = s1.length();
        for (int i=n-1; i>=0; i--){
            s2 = s2 + s1.charAt(i);
        }

        System.out.println(LPS(s1, s2, n));
        sc.close();
    }
}