/* Problem Statement - Given an array that contains both positive and negative integers, find the product of the maximum product subarray. 
Expected Time complexity is O(n) and only O(1) extra space can be used. */

// Code by @shivshar
import java.util.*;

public class maximumProductSubarray {

    public static int maxProduct(int[] arr, int N){
        if (N == 0) return 0;

        int maxVal = arr[0];
        int minVal = arr[0];
        int globalMax = arr[0];

        for (int i=1; i<N; i++){
            //swap min/max if value is negative
            if(arr[i] < 0){
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(maxVal * arr[i], arr[i]);
            minVal = Math.min(minVal * arr[i], arr[i]);

            globalMax = Math.max(globalMax, maxVal);
        }
        return globalMax;
    }
    public static void main (String [] args){
        
        Scanner sc = new Scanner (System.in);
        // Testcases;
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            //input array size
            int N = sc.nextInt();
            int[] arr = new int [N];

            for (int j=0; j<N; j++){
                arr[j] = sc.nextInt();
            }
            // calling maxProduct function:
            System.out.println(maxProduct(arr, N));
        }
        sc.close();
    }
} 
