import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] memo = new int[n][4];
        for(int[] i : memo)
            Arrays.fill(i, -1);

        return findMax(points, n-1, 3, memo);
    }
    
    public static int findMax(int[][] points, int index, int prev, int[][] memo){
        if(index == 0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(prev != i){
                    if(max < points[index][i])max = points[index][i];
                }
            }
            return max;
        }
        if(memo[index][prev] != -1)return memo[index][prev];
        
        int max = 0;
        for(int i=0; i<3; i++){
            if(i != prev){
                int currentMax = points[index][i] + findMax(points, index-1, i, memo);
                if(currentMax > max) max = currentMax;
            }
        }
        
        memo[index][prev] = max;
        return max;
    }

}
