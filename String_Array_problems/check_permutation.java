import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        int[] alphs = new int[26];
        if(str1.length() != str2.length())return false;
        for(int i=0; i<str1.length(); i++){
            alphs[str1.charAt(i) - 'a']++;
        }

        for(int i=0; i< str2.length(); i++){
            alphs[str2.charAt(i) - 'a']--;
            if(alphs[str2.charAt(i) - 'a'] < 0)return false;
        }

        return true;
    }
}
