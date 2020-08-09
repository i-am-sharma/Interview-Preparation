/*  Given an array of integers nums sorted in ascending order, find the starting and ending position 
of a given target value. */

// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].

// Code by @shivshar
import java.util.*;
public class findTarget {
    public static int[] searchRange (int[] nums, int target){
        // Following Binary Search Algorithm
        int n = nums.length;   // Input Size
        int s = 0;    //starting index
        int e = n-1;     // ending index
        int start = -1;    //start position of target
        int end = -1;    // end position of target
        
        // Finding Start Position of target
        while (s <= e) {
            // mid index
            int mid = (s+e)/2;
            if (nums[mid] == target){
                if (mid == 0 || (mid - 1 >= 0 && nums[mid] > nums[mid-1])) {
                    start = mid;
                    break;
                }
                e = mid - 1;
            }
            else if (target > nums[mid]) s = mid + 1;
            else e = mid - 1;
        }
        
        // Finding Last Position of target
        s = 0;
        e = n-1;
        while (s <= e) {
            // mid
            int mid = (s+e)/2;
            if (nums[mid] == target){
                if (mid == n-1 || (mid + 1 < n && nums[mid] < nums[mid+1])) {
                    end = mid;
                    break;
                }
                s = mid + 1;
            }
            else if (target < nums[mid]) e = mid - 1;
            else s = mid + 1;
        }
        
        int [] ans = new int [2];
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        int[] nums = new int [6];
        for (int i=0; i<6; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] res = searchRange (nums, target);
        for (int i=0; i<2; i++){
            System.out.println(res[i]);
        }
        sc.close();
    }
}