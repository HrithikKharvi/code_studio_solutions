import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] memo = new int[n];
        for(int i=0; i< n; i++){
            memo[i] = -1;
        }
        return jump(n-1, heights, memo);
    }
    
    public static int jump(int n, int heights[], int[] memo){
        if(memo[n] != -1)return memo[n];
        
        if(n == 0) return 0;
        
        int left = jump(n-1, heights,memo) + Math.abs(heights[n] - heights[n-1]);
        int right = 0;
        if(n > 1){
            right = jump(n-2, heights, memo) + Math.abs(heights[n] - heights[n-2]);
        }else{
            memo[n] = left;
            return left;
        }
        memo[n] = Math.min(left, right);
        return memo[n];
    }
    
}
