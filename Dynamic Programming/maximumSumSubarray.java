/* An array is given, find length and max-sum-subarray. */

// Code by @shivshar
import java.util.*;
public class maximumSumSubarray {
    public static int[] maxSumSubarray (int[] arr, int n){
        int[] ans = new int[2];

        int global_max = arr[0];
        int curr_max = arr[0];
        int s = 0;
        int e = 0;
        int curr_s = 0;
        int curr_e = 0;

        for (int i=1; i<n; i++){
            if (curr_max + arr[i] >= arr[i]) {
                curr_max = curr_max + arr[i];
                curr_e = curr_e + 1;
            }
            else{
                curr_max = arr[i];
                curr_s = i;
                curr_e = i;
            }

            if (curr_max >= global_max){
                global_max = curr_max;
                s = curr_s;
                e = curr_e;
            }
        }

        ans[0] = global_max;
        ans[1] = e-s+1;
        return ans;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] res = maxSumSubarray(arr, n);
        System.out.println ("Maximum Sum Subarray is: "+ res[0]);
        System.out.println ("Length of sub-array which has maximum sum: "+ res[1]);
        sc.close();
    }
}