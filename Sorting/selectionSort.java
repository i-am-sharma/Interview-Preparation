package Sorting;
import java.util.*;
public class selectionSort {
    public static int[] sorting (int[] arr, int n){
        // 1. First find the min element  index
        // 2. Swap it
        for (int i=0; i<n-1; i++){
            int min_index = i;
            for (int j=i+1; j<n; j++){
                if (arr[min_index] > arr[j]) min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        return arr;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] res = sorting(arr, n);
        for (int i=0; i<n; i++){
            System.out.print(res[i] + " ");
        }
        sc.close();
    }
}

// Time Complexity = O(n^2)