package Sorting;
import java.util.*;

public class insertionSort {

    public static int[] sorting (int[] arr, int n){
        for (int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
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

// Worst Case time complexity - O(n^2)
// Best case time complexity - O(n)
// Space complexity - O(1)