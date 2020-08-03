
// Code by @shivshar
import java.util.*;
public class longestCommonSubstring {
    // Recurive approach
    public static int Recurive_LCS (String s1, String s2, int n, int m, int count){
        if (n == 0 || m == 0) return count;

        if (s1.charAt(n-1) == s2. charAt(m-1)){
            return Recurive_LCS (s1, s2, n-1, m-1, count + 1);
        }
        return Math.max (count, Math.max(Recurive_LCS(s1, s2, n-1, m, 0), Recurive_LCS(s1, s2, n, m-1, 0)));
    }
    // Tabular approach
    public static int LCS (String s1, String s2, int n, int m){
        int[][] dp = new int [n+1][m+1];
        for (int i=0; i<=m; i++){
            dp[0][i] = 0;
        }
        for (int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        int max = 0;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else dp[i][j] = 0;

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            String s1 = sc.next();
            String s2 = sc.next();

            int n = s1.length();
            int m = s2.length();

            System.out.println("Length of Longest Common Substring is: " + Recurive_LCS (s1, s2, n, m, 0));
            System.out.println("Length of Longest Common Substring is: " + LCS (s1, s2, n, m));

        }
        sc.close();
    }
}