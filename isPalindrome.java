/* Given a string str, the task is to find whether the string is a palindrome or not in Java 
without using library methods. */

// Code by @shivshar
import java.util.*;
public class isPalindrome {
    public static boolean checkPalindrome (String str, int s, int e){
        while (s < e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s = s+1;
            e = e-1;
        }
        return true;
    }

    public static boolean checkPalindromeRecusrive (String str, int s, int e){
        if (s == e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        if (s < e) return checkPalindromeRecusrive (str, s+1, e-1);
        return true;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        String str = sc.next();
        
        if(str.length() == 0) System.out.println("Empty String");
        else{
            System.out.println("Iterative approach: " + checkPalindrome(str, 0 , str.length()-1));
            System.out.println("Recusrive approach: " + checkPalindromeRecusrive(str, 0, str.length()-1));
        }
        
        sc.close();
    }
}

// Time Complexity - O(N) where N is String length
// Space complexity - O(1) if ignored stack calls in recurion