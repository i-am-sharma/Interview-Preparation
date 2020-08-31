package Sorting;
import java.util.*;
public class bubbleSort {
    public static int[] sorting (int[] arr, int n){
        // Two key point in bubble sort -
        // 1. We compare adjacent elements
        // 2. bigger number will resulted in last in each iteration

        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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

// Time Complexity - O(n^2)