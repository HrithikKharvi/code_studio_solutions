import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean palindromeString(String s) {
    	int[] arr = new int[26];
        for(int i=0; i< s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;

        for(int i=0; i<26; i++){
            if(arr[i] % 2 == 1)oddCount++;
            if(oddCount > 1)return false;
        }

        return true;
    }
}
Palindrome Permutation
