/* Given a 32-bit signed integer, reverse digits of an integer. */

// Code by @shivshar
import java.util.*;
public class reverseInteger {

    public static int reverse (int input){
        int res;
        String s = "";
        if (input == 0) return 0;

        else if (input < 0){
            input = -1 * input;
            while (input > 0){
                s = s + String.valueOf(input % 10);
                input = input / 10;
            }
            try{
                return res = -1 * Integer.parseInt(s);
            }catch (Exception e){
                return 0;
            }
        }
        else {
            while (input > 0){
                s = s + String.valueOf(input % 10);
                input = input / 10;
            }
            try{
                return res = Integer.parseInt(s);
            }catch (Exception e){
                return 0;
            }
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int input = sc.nextInt();
        System.out.println("Reverse of integer is: " + reverse(input));
        sc.close();
    }
}

// Time Complexity - log(x)
// Space complexity - O(1)

