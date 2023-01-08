import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
            int max = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        
        for(int[] i : memo)Arrays.fill(i, -1);
        
        for(int i=0; i< matrix[0].length; i++){
            int currentMax = findMax(matrix,n-1, i, memo);
            if(currentMax > max)max = currentMax;
        }
        
        return max;
	}
    
    public static int findMax(int[][] matrix, int index, int col, int[][] memo){
        if(col < 0 || col >= matrix[0].length)return Integer.MIN_VALUE;
        if(index == 0)return matrix[index][col];
        if(memo[index][col] != -1) return memo[index][col];
        int left = findMax(matrix, index-1, col-1, memo);
        int right = findMax(matrix, index-1, col+1, memo);
        int top = findMax(matrix, index-1, col, memo);
         
        int max = Math.max(left, right);
        max = Math.max(top, max);
        
        memo[index][col] = max + matrix[index][col];
        return memo[index][col];
    }
}
