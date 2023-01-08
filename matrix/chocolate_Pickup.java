import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] memo = new int[r][c][c];
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
		return findMax(grid, 0, 0, c-1, memo);
	}
    
    public static int findMax(int[][] grid, int i, int j1, int j2, int[][][] memo){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2 >= grid[0].length)return Integer.MIN_VALUE;
        if(memo[i][j1][j2] != -1)return memo[i][j1][j2];

        if(i == grid.length-1){
            if(j1 == j2)return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for(int d1=j1-1; d1 <= j1+1; d1++){
            for(int d2=j2-1; d2<=j2+1; d2++){
                if(j1 == j2)max = Math.max(max, grid[i][j1] + findMax(grid, i+1, d1, d2, memo));
                else{
                    int currentValue = grid[i][j1] + grid[i][j2] + findMax(grid, i+1, d1, d2, memo);
                    max = Math.max(max, currentValue);
                }
            }
        }
        memo[i][j1][j2] = max;     
        return max;
    }
    
}
