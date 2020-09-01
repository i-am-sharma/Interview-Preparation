package Sorting;
import java.util.*;

public class mergeSort {

public static void merge(int[] arr, int[] left, int l_size, int[] right, int r_size){
    int i = 0;
    int j = 0;
    int k = 0;

    while (i<l_size && j<r_size){
        if (left[i] < right[j]){
            arr[k] = left[i];
            i = i+1;
        }
        else{
            arr[k] = right[j];
            j = j+1;
        }
        k = k + 1;
    }

    while (i<l_size){
        arr[k] = left[i];
        i = i + 1;
        k = k + 1;
    }

    while (j<r_size){
        arr[k] = right[j];
        j = j + 1;
        k = k + 1;
    }
}

public static void sort (int[] arr, int size){
    if (size <= 1) return;
    int mid = size/2;
    int[] left = new int[mid];
    int[] right = new int[size - mid];

    for (int i=0; i<mid; i++){
        left[i] = arr[i];
    }

    for (int i=mid; i<size; i++){
        right[i-mid] = arr[i];
    }

    sort(left, mid);
    sort(right, size-mid);
    merge(arr, left, mid, right, size-mid);
}
    

 public static void main (String[] args){
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
    }

    sort (arr, n);

    for (int i=0; i<n; i++){
        System.out.print(arr[i] + " ");
    }
    
    sc.close();
 }   
}