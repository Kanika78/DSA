import java.util.*;
class Solution {
    public static boolean isPalindrome(int x) {
        int r;
        int rev = 0;
        int n = x;
        if(n<0){
            return false;
        }
        while(n!=0){
            r = n%10;
            rev = (rev*10) +r;
            n = n/10;
        }
        if(rev==x){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int x = sc.nextInt();
        isPalindrome(x);
    }
}