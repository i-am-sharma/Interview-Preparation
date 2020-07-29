/* Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) 
required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost. */

import java.util.*;

 class Solution {

    public static int editDistance (String s1, String s2){
        // Solving by only using 1D array
        int m = s1.length();
        int n = s2.length();

        int dp[] = new int [n+1];

        for(int i=0; i<=n; i++){
            dp[i] = i;
        }

        for (int i=1; i<=m; i++){
            int pre = dp[0];
            dp[0] = i;
            for (int j=1; j<=n; j++){
                int temp = dp[j];
                
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = pre;
                }
                else{
                    dp[j] = 1 + Math.min(pre, Math.min(dp[j], dp[j-1]));
                }
                
                pre = temp;
            }
        }

        return dp[n];
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);

        String s1, s2;

        s1 = sc.next();
        s2 = sc.next();

        System.out.println("Minimum number of operations need to perform is " + editDistance(s1,s2));

        sc.close();
    }
}

// Time Complexity - O(MN);
// Space Complexity - O(N);

// More approaches to solve -
// Recusrion Naive - will reach time limit
// Recusrion with adding memoization - Top Down approach
// Bottom - up approach using 2D array - Space complexity will be O(MN)